package com.verticon.tracker.irouter.trutest.dev;

import java.util.Map;

import com.verticon.tracker.irouter.dev.IDeviceListener;

public interface ITruTestIndicator extends IDeviceListener{

	
	void setWeight(Double weight) throws InterruptedException;
	Double getWeight();
   
    void readEIDTag(long eid) throws InterruptedException;
    long getEID();
    
    /**
     * Models the press of the record key
     * @throws InterruptedException 
     */
    void pressRecordKey() throws InterruptedException;
    
    /**
     * TruTest Indicator accepts commands and data for setting its 
     * 8 lifedata fields (fields 0-7) and 2 file data fields (fields 8-9).
     * 
     * The TruTest Indicator has a beeper that can be turned on and off via
     * a command.
     * 
     * Emulation of the device for testing purposes requires a way to validate 
     * which commands have been previously received by the device.  
     * 
     * @return cache of previously received commands
     */
    Map<String,String> getValues();
    
    void beep(int msecs);
    
}
