package com.verticon.tracker.irouter.mettler.emulator.comm;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class EmulatedCommPortBalance {

  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("Usage: java PortTyper portName");
      return;
    }

    try {    
      CommPortIdentifier com = CommPortIdentifier.getPortIdentifier(args[0]);
      CommPort thePort  = com.open("PortOpener", 10);
      emulate(thePort.getOutputStream());
    }
    catch (Exception ex) {System.out.println(ex);}
  }
  private static void emulate(OutputStream out) throws IOException{
	  double grams = 1.1;
	  int count = 0;
	  while(true){
		  grams = grams + 3.4;
		  String message = String.format("S D %10.2f g\r\n", grams);
		  out.write(message.getBytes());
		  out.flush();
		  try {
			if(grams > 999){
				  grams = .1;
				  count = 0;
				  System.out.println("Sleeping");
				  TimeUnit.MINUTES.sleep(2);
				  System.out.println("Waking up...");
			  }else{
				  count ++;
				  if(count % 80 == 0){
					  System.out.println("."); 
				  }else{
					  System.out.print("."); 
				  }
				  TimeUnit.MILLISECONDS.sleep(200);
			  }
		} catch (InterruptedException e) {
			break;
		}
	  }
  }
}


