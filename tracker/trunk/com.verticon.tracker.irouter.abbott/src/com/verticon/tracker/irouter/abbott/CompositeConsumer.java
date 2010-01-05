/**
 * 
 */
package com.verticon.tracker.irouter.abbott;

import static com.verticon.tracker.irouter.abbott.Constants.*;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;

import com.verticon.tracker.common.AbstractConsumer;
import com.verticon.tracker.common.IContext;
import com.verticon.tracker.common.Utils;

/**
 * WireAdmin Consumer that consumes AnimalWeight, RecordState, EID, and MettlerWeight
 * scoped envelopes for conversion, production and logging.
 * 
 * @see CommandProducer
 * @author jconlon
 *
 */
class CompositeConsumer extends AbstractConsumer{

	
	private final String calBWID;
	private final String actBWID;
	private final String beepCommand;
	private final double bwMult;
	private final long alarmSeconds;
	private final double alarmTrigger;
	private final double calculationThreashold;
	private final boolean displayGrams;
	private final BlockingQueue<String> commandQueue;
	
	private ScheduledFuture<?> beeping = null;
	
	private Measurement calcBW;
	private Measurement actBW;
//	final ITransactionHandler agLogger;
	

	/**
	 * @param context
	 */
	CompositeConsumer(IContext context, BlockingQueue<String> commandQueue) {
		super(context);
		this.commandQueue=commandQueue;
		calBWID = Utils.fromAscii(context.getConfigurationString(CAL_BW_ID));
		actBWID = Utils.fromAscii(context.getConfigurationString(ACT_BW_ID));
		beepCommand = Utils.fromAscii(context.getConfigurationString(BEEP_COMMAND));
		alarmSeconds = context.getConfigurationLong(BW_ALARM_SECONDS);
		alarmTrigger = context.getConfigurationDouble(BW_ALARM_TRIGGER);
		bwMult = context.getConfigurationDouble(BW_MULT).doubleValue();
		if(context.getConfigurationInteger(DISPLAY_UNITS).equals(DISPLAY_UNITS_GRAMS)){
			displayGrams = true;
		}else{
			displayGrams = false;
		}
		
		calculationThreashold = context.getConfigurationLong(CALCULATION_THRESHOLD);
//		agLogger = new AggregatingTransactionLogger(null);
	}
	
	
	
	@Override
	public String toString() {
		return "CompositeConsumer [pid=" + context.getPid()+", scope=" + Arrays.toString(getScope())
				+ "]";
	}



	/*
	 * (non-Javadoc)
	 * @see org.osgi.service.wireadmin.Consumer#updated(org.osgi.service.wireadmin.Wire, java.lang.Object)
	 */
	@Override
	public void updated(Wire wire, Object in) {
		if ( in instanceof Envelope ){
			Envelope envelope = (Envelope) in ;
			String scope = envelope.getScope();
			if(scope.equals(CONSUMER_SCOPE[ANIMAL_WEIGHT_MEASUREMENT])){
//				agLogger.add(envelope);
				displayCalcBW(envelope);
			}else if(scope.equals(CONSUMER_SCOPE[METTLER_WEIGHT_MEASUREMENT])){
				saveAndDisplayMettlerWeightMeasurement(envelope);
//			}else if(scope.equals(CONSUMER_SCOPE[ANIMAL_TAG_NUMBER_SCOPE])){
//				agLogger.add(envelope);
			}else if(scope.equals(CONSUMER_SCOPE[TRANSACTION_STATE])){
//				agLogger.add(envelope);
				actBW = null;
				stopBeeping();
			}else{
				logUnknownScopeError( wire, envelope );
			}
		}else{
			logError( wire, in );
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.abbott.AbstractConsumer#stop()
	 */
	@Override
	public void stop() {
		stopBeeping();
		super.stop();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.common.AbstractConsumer#getScope()
	 */
	@Override
	public String[] getScope() {
		return CONSUMER_SCOPE;
	}
	
	void saveAndDisplayMettlerWeightMeasurement(Envelope envelope){
		if(envelope.getValue() instanceof Measurement){
//			agLogger.add(envelope);
			actBW=(Measurement)envelope.getValue();
			displayActBW(actBW);
		}else{
			log.error("BloodWeight Envelope unknown value={}",envelope.getValue());
		}
	}
	
	private void displayActBW(Measurement bloodWeight) {
		log.debug("{}: Sending Blood Weight={} kilograms, displayAsGrams={}",
				new Object[]{this,
					bloodWeight,
					displayGrams});
		
		sendDisplayCommandsToProducer(actBWID, bloodWeight);
		if(needToBeep()){
			startBeeping();
		}else{
			stopBeeping();
		}
	}
	
	private boolean needToBeep(){
		return 	calcBW!=null && actBW!=null && calcBW.getValue() !=0 && 
				(actBW.getValue() > 
				(calcBW.getValue() * alarmTrigger));
	}
	
	void displayCalcBW(Envelope envelope){
		if(!(envelope.getValue()instanceof Measurement)){
			log.error(String.format("%s: Unknown object=%s in envelop",
					this,envelope.getValue()));
		}
		Measurement animalWeight = (Measurement)envelope.getValue();
		
		if(animalWeight.getValue() < calculationThreashold){
			calcBW = animalWeight.sub(animalWeight.getValue());
			log.debug("{}: Zeroed CalBW = {}, and Sending Animal Weight={} and bwMult={}",
					new Object[]{this,calcBW, animalWeight, bwMult});
			
		}else{
			calcBW = animalWeight.mul( bwMult);
				log.debug("{}: Sending Calc Blood Weight={} kilograms, displayAsGrams={}",
						new Object[]{this,calcBW,displayGrams});
			
		}
		//"{SXD28}\r\n{SXC26}\r\n333.11\r\n";
		sendDisplayCommandsToProducer(calBWID,calcBW);
	}
	
	private void sendDisplayCommandsToProducer(String fieldID, Measurement measurement) {
		if(measurement.getUnit() != Unit.kg){
			throw new IllegalArgumentException("Measurement must be kilogram units.");
		}
		String commands;
		if(displayGrams){//grams ####.#
			commands = String.format("%s\n%.1f\r\n",
					fieldID,//"{SXD28}\r\n{SXC26}\r
					measurement.getValue() * 1000
			);
		}else{//kilograms #.####
			commands = String.format("%s\n%.4f\r\n",
				fieldID,//"{SXD28}\r\n{SXC26}\r
				measurement.getValue()
			);
		}
		
		try {
			commandQueue.put(commands);
		} catch (InterruptedException e) {
			// Restore the interrupted status
            Thread.currentThread().interrupt();
		}
	}
	
	void stopBeeping() {
		if(beeping !=null) {
			beeping.cancel(true);
			beeping = null;
		}
	}
	
	private void startBeeping(){
		if(beeping !=null){
			return;
		}
		SendBeepCommand pollingTask = new SendBeepCommand();
		beeping = context.getScheduler().scheduleWithFixedDelay(
				pollingTask, alarmSeconds, alarmSeconds, TimeUnit.SECONDS);
	}
	
	/*
	 * To send periodic beeps to a TruTest balance.
	 *
	 */
	private final class SendBeepCommand implements Runnable{
		@Override
		public void run(){
			try {
				commandQueue.put(beepCommand);
			} catch (InterruptedException e) {
				// Restore the interrupted status
	            Thread.currentThread().interrupt();
			}
		}
	}

	
}