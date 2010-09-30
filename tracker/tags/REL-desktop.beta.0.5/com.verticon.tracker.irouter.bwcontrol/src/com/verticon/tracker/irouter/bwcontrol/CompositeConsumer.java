/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.irouter.bwcontrol;

import static com.verticon.tracker.irouter.bwcontrol.ComponentFactory.bundleMarker;
import static com.verticon.tracker.irouter.bwcontrol.Constants.ACT_BW_ID;
import static com.verticon.tracker.irouter.bwcontrol.Constants.ANIMAL_WEIGHT_MEASUREMENT;
import static com.verticon.tracker.irouter.bwcontrol.Constants.BEEP_COMMAND;
import static com.verticon.tracker.irouter.bwcontrol.Constants.BW_ALARM_SECONDS;
import static com.verticon.tracker.irouter.bwcontrol.Constants.BW_ALARM_TRIGGER;
import static com.verticon.tracker.irouter.bwcontrol.Constants.BW_MULT;
import static com.verticon.tracker.irouter.bwcontrol.Constants.CALCULATION_THRESHOLD;
import static com.verticon.tracker.irouter.bwcontrol.Constants.CAL_BW_ID;
import static com.verticon.tracker.irouter.bwcontrol.Constants.CONSUMER_SCOPE;
import static com.verticon.tracker.irouter.bwcontrol.Constants.DISABLE_PRODUCTION_AFTER_RECORD;
import static com.verticon.tracker.irouter.bwcontrol.Constants.DISPLAY_UNITS;
import static com.verticon.tracker.irouter.bwcontrol.Constants.DISPLAY_UNITS_GRAMS;
import static com.verticon.tracker.irouter.bwcontrol.Constants.METTLER_WEIGHT_MEASUREMENT;
import static com.verticon.tracker.irouter.bwcontrol.Constants.TRANSACTION_STATE;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.Unit;
import org.slf4j.Marker;

import com.verticon.tracker.irouter.common.AbstractConsumer;
import com.verticon.tracker.irouter.common.IContext;
import com.verticon.tracker.irouter.common.Utils;

/**
 * WireAdmin Consumer that consumes AnimalWeight, RecordState, EID, and MettlerWeight
 * scoped envelopes for conversion, production and logging.
 * 
 * @see CommandProducer
 * @author jconlon
 *
 */
class CompositeConsumer extends AbstractConsumer implements Monitorable{
	
	@Override
	protected Marker bundleMarker() {
		return bundleMarker;
	}

	private static final String WIRES_COUNT = "consumer.Connected_Producers";
	private static final String LAST_BLOOD_WEIGHT = "consumer.Last_Blood_Weight";
	private static final String LAST_ANIMAL_WEIGHT = "consumer.Last_Animal_Weight";
	
	private final SendBeepCommand pollingTask = new SendBeepCommand();
	private final String calBWID;
	private final String actBWID;
	private final String beepCommand;
	private final double bwMult;
	private final long alarmSeconds;
	private final double alarmTrigger;
	private final double calculationThreashold;
	private final boolean displayGrams;
	private final BlockingQueue<String> commandQueue;
	private final boolean disableProductionAfterRecord;
	private Float lastAnimalWeight = new Float(0);
	private Float lastBloodWeight = new Float(0);
	
	private volatile boolean enableProduction = true;
	
	private volatile ScheduledFuture<?> beeping = null;
	
	private Measurement calcBW;
	private Measurement actBW;
	

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
		disableProductionAfterRecord = context.getConfigurationBoolean(DISABLE_PRODUCTION_AFTER_RECORD);

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
				displayCalcBW(envelope);
			}else if(scope.equals(CONSUMER_SCOPE[METTLER_WEIGHT_MEASUREMENT])){
				Measurement bloodWeight = (Measurement)envelope.getValue();
				lastBloodWeight = new Float(bloodWeight.getValue());
				if(enableProduction){
					saveAndDisplayMettlerWeightMeasurement(envelope);
				}
			}else if(scope.equals(CONSUMER_SCOPE[TRANSACTION_STATE])){
				actBW = null;
				stopBeeping();
				if(disableProductionAfterRecord){
					enableProduction=false;
				}
			}else{
				logUnknownScopeError( wire, envelope );
			}
		}else{
			logError( wire, in );
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.bwcontrol.AbstractConsumer#stop()
	 */
	@Override
	public void stop() {
		stopBeeping();
		super.stop();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.verticon.tracker.irouter.common.AbstractConsumer#getScope()
	 */
	@Override
	public String[] getScope() {
		return CONSUMER_SCOPE;
	}
	
	void saveAndDisplayMettlerWeightMeasurement(Envelope envelope){
		if(envelope.getValue() instanceof Measurement){
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
		determineBeepState();
	}



	private void determineBeepState() {
		if(shouldBeep(actBW,calcBW, alarmTrigger)){
			startBeeping();
		}else{
			stopBeeping();
		}
	}
	

	
	private static boolean shouldBeep(Measurement actualBW, Measurement calculatedBW, double trigger){
		return 	calculatedBW!=null && actualBW!=null && shouldBeep( actualBW.getValue(),  calculatedBW.getValue(),  trigger);
	}
	
	private static boolean shouldBeep(double actualBW, double calculatedBW, double trigger){
		return 	 calculatedBW !=0 && (actualBW > (calculatedBW * trigger));
	}
	
	void displayCalcBW(Envelope envelope){
		if(!(envelope.getValue()instanceof Measurement)){
			log.error(String.format("%s: Unknown object=%s in envelop",
					this,envelope.getValue()));
			return;
		}
		Measurement animalWeight = (Measurement)envelope.getValue();
		lastAnimalWeight = new Float(animalWeight.getValue());
		
		if(animalWeight.getValue() < calculationThreashold){
			calcBW = animalWeight.sub(animalWeight.getValue());
			log.debug("{}: Zeroed CalBW={}, and Sending Animal Weight={} and bwMult={}",
					new Object[]{this,calcBW, animalWeight, bwMult});
			enableProduction=true;
		}else{
			calcBW = animalWeight.mul( bwMult);
				log.debug("{}: Sending CalcBW ={} displayAsGrams={}",
						new Object[]{this,calcBW,displayGrams});
			
		}
		//"{SXD28}\r\n{SXC26}\r\n333.11\r\n";
		sendDisplayCommandsToProducer(calBWID,calcBW);
		determineBeepState();
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
			log.debug("{}: Stop beeper",this);
			beeping.cancel(true);
			beeping = null;
		}
	}
	
	private void startBeeping(){
		if(beeping !=null){
			return;
		}
		log.debug("{}: Starting beeper", this);
		beeping = context.getScheduler().scheduleWithFixedDelay(
				pollingTask, 1, alarmSeconds, TimeUnit.SECONDS);
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

	@Override
	public String[] getStatusVariableNames() {
		return new String[]{WIRES_COUNT,LAST_ANIMAL_WEIGHT,LAST_BLOOD_WEIGHT};
	}

	@Override
	public StatusVariable getStatusVariable(String name)
	throws IllegalArgumentException {
		
		if (WIRES_COUNT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_GAUGE,
					wiresConnected.get()
					);
		}if (LAST_ANIMAL_WEIGHT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_DER,
					lastAnimalWeight
					);
		}if (LAST_BLOOD_WEIGHT.equals(name)){
			return
			new StatusVariable(name,
					StatusVariable.CM_DER,
					lastBloodWeight
					);
		}else{
			throw new IllegalArgumentException(
					"Invalid Status Variable name " + name);
		}
	}
	
	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {

		return false;
	}

	@Override
	public String getDescription(String name) throws IllegalArgumentException {	
		if (WIRES_COUNT.equals(name)){
			return
			"The number of connected producers.";
		}if (LAST_ANIMAL_WEIGHT.equals(name)){
			return "Last animal weight received from the scalehead";
		}if (LAST_BLOOD_WEIGHT.equals(name)){
			return "Last blood weight received from the balance";
		}
		return null;
	}

	
}