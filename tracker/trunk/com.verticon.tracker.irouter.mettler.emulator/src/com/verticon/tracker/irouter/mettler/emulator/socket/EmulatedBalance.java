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
package com.verticon.tracker.irouter.mettler.emulator.socket;
	
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;
	 
	public class EmulatedBalance {
	 
	  public final static int defaultPort = 2345;
	 
	  public static void main(String[] args) {
	    Date startDate = new Date();
	    int port = defaultPort;
	    
	    try {
	      port = Integer.parseInt(args[0]);
	    }
	    catch (Exception e) {}
	    if (port <= 0 || port >= 65536) port = defaultPort;
	    
	    try {
	      ServerSocket ss = new ServerSocket(port);
	      while (true) {
	        try {
	          Socket s = ss.accept();
	          s.setKeepAlive(true);
	          Date connectDate = new Date();
	          long mills = connectDate.getTime() - startDate.getTime();
	          System.out.println(connectDate+
	        		  " Connected to "+ s.getInetAddress()+':'+ s.getPort()+" in "+mills/1000+" seconds.");
	          OutputStream out = s.getOutputStream();
	          emulate(out);
	          System.out.println(new Date()+" Closing "+ s.getInetAddress()+':'+ s.getPort());
	          s.close();
	        }
	        catch (IOException e) {
	        	System.out.println(e);
	        }
	      }
	    }
	    catch (IOException e) {System.err.println(e);}
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

