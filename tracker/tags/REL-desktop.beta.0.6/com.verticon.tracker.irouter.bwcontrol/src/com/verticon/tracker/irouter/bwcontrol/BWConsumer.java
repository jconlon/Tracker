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

import static com.verticon.tracker.irouter.bwcontrol.Component.bundleMarker;
import static org.osgi.service.wireadmin.WireConstants.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;
import org.osgi.service.wireadmin.Consumer;
import org.osgi.service.wireadmin.Envelope;
import org.osgi.service.wireadmin.Wire;
import org.osgi.util.measurement.Measurement;
import org.osgi.util.measurement.State;
import org.osgi.util.measurement.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.common.Utils;

/**
 * WireAdmin Consumer that consumes AnimalWeight, RecordState, EID, and MettlerWeight
 * scoped envelopes for conversion, production and logging.
 * 
 * @see CommandProducer
 * @author jconlon
 *
 */
class BWConsumer implements Consumer, Monitorable{
	
	private static final String BEEP_COMMAND = "trutest.beepCommand";
	private static final String BW_MULT = "abbott.bwmult";
	private static final String BW_ALARM_TRIGGER = "abbott.bwalarm.trigger";
	private static final String BW_ALARM_SECONDS = "abbott.bwalarm.period";
	private static final String ACT_BW_ID = "trutest.actbw.field";
	private static final String CAL_BW_ID = "trutest.calbw.field";
	private static final String DISPLAY_UNITS = "trutest.field.units";
	private static final String DISABLE_PRODUCTION_AFTER_RECORD ="abbott.stop.production.after.record";
	private static final Integer DISPLAY_UNITS_GRAMS = 0;
	private static final String CALCULATION_THRESHOLD = "abbott.calbw.threashold";
	

	private static final String ANIMAL_WEIGHT_SCOPE = "animal.weight";
	private static final String BLOOD_WEIGHT_SCOPE = "blood.weight";
	
	
	
	private static final String WIRES_COUNT = "consumer.Connected_Producers";
	private static final String LAST_BLOOD_WEIGHT = "consumer.Last_Blood_Weight";
	private static final String LAST_ANIMAL_WEIGHT = "consumer.Last_Animal_Weight";
	
	
	/**
	 * slf4j Logger
	 */
	private final Logger log = LoggerFactory
			.getLogger(BWConsumer.class);


	
	protected final AtomicInteger wiresConnected = new AtomicInteger(0);
	
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
	
	private final Component component;
	
	private volatile boolean enableProduction = true;
	
	private volatile ScheduledFuture<?> beeping = null;
	
	private Measurement calcBW;
	private Measurement actBW;
	

	/**
	 * @param context
	 */
	BWConsumer(Component component) {
		this.component = component;
		this.commandQueue=component.getCommandQueue();
		calBWID = Utils.fromAscii(component.getConfigurationString(CAL_BW_ID));
		actBWID = Utils.fromAscii(component.getConfigurationString(ACT_BW_ID));
		beepCommand = Utils.fromAscii(component.getConfigurationString(BEEP_COMMAND));
		alarmSeconds = component.getConfigurationLong(BW_ALARM_SECONDS);
		alarmTrigger = component.getConfigurationDouble(BW_ALARM_TRIGGER);
		bwMult = component.getConfigurationDouble(BW_MULT).doubleValue();
		if(component.getConfigurationInteger(DISPLAY_UNITS).equals(DISPLAY_UNITS_GRAMS)){
			displayGrams = true;
		}else{
			displayGrams = false;
		}
		
		calculationThreashold = component.getConfigurationLong(CALCULATION_THRESHOLD);
		disableProductionAfterRecord = component.getConfigurationBoolean(
				DISABLE_PRODUCTION_AFTER_RECORD);

	}
	
	
	
	
	@Override
	public String toString() {
		return "BWConsumer [pid="+component.getPid() +"]";
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
			log.debug(bundleMarker,"Handling envelope={} scope={} ",envelope,scope);
			if(scope.equals(component.getConfigurationString(ANIMAL_WEIGHT_SCOPE))){
				displayCalcBW(envelope);
			}else if(scope.equals(component.getConfigurationString(BLOOD_WEIGHT_SCOPE))){
				if(envelope.getValue() instanceof Measurement){
					Measurement bloodWeight = (Measurement)envelope.getValue();
					lastBloodWeight = new Float(bloodWeight.getValue());
					if(enableProduction){
						saveAndDisplayMettlerWeightMeasurement(envelope);
					}
				}else{
					log.error(bundleMarker,"BW envelope value={} scope={}",envelope,scope);
				}
			}else if(envelope.getValue() instanceof State){
				//All other scopes are considered transaction state changes.
				log.debug(bundleMarker,"Transaction state object={} scope={} as transaction",envelope.getValue(),scope);
				actBW = null;
				stopBeeping();
				if(disableProductionAfterRecord){
					enableProduction=false;
				}
			}
		}else{
			log.error(bundleMarker,"Unsupported object={}",in);
		}
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
			log.error(bundleMarker,String.format("%s: Unknown object=%s in envelop",
					this,envelope.getValue()));
			return;
		}
		Measurement animalWeight = (Measurement)envelope.getValue();
		lastAnimalWeight = new Float(animalWeight.getValue());
		
		if(animalWeight.getValue() < calculationThreashold){
			calcBW = animalWeight.sub(animalWeight.getValue());
			log.debug(bundleMarker,"{}: Zeroed CalBW={}, and Sending Animal Weight={} and bwMult={}",
					new Object[]{this,calcBW, animalWeight, bwMult});
			enableProduction=true;
		}else{
			calcBW = animalWeight.mul( bwMult);
			log.debug(bundleMarker,"{}: Sending CalcBW ={} displayAsGrams={}",
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
			log.debug(bundleMarker,"{}: Stop beeper",this);
			beeping.cancel(true);
			beeping = null;
		}
	}
	
	private void startBeeping(){
		if(beeping !=null){
			return;
		}
		log.debug(bundleMarker,"{}: Starting beeper", this);
		beeping = component.getScheduler().scheduleWithFixedDelay(
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



	@Override
	public void producersConnected(Wire[] wires) {
		wiresConnected.set(wires!=null?wires.length:0);
		if(wires == null || wires.length==0){
			log.debug(bundleMarker,"{}: Not connected to any wires.",
					this
			);
		}else{
			
			for (Wire wire : wires) {
				log.debug(bundleMarker,"{}: Connected to {}",
						this, wire.getProperties().get(WIREADMIN_PRODUCER_PID));
			
			}
			
			
		}
	}

	
}