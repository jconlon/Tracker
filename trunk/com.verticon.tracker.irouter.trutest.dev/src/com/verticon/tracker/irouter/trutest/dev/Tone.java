package com.verticon.tracker.irouter.trutest.dev;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Tone {
	
	public static void sound(int hz,int msecs) throws LineUnavailableException {
		byte[] buf = new byte[msecs*8];

		for (int i=0; i<buf.length; i++) {
			double angle = i / (8000.0 / hz) * 2.0 * Math.PI;
			buf[i] = (byte)(Math.sin(angle) * 80.0);
		}

		AudioFormat af = new AudioFormat(8000f,8,1,true,false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();
		sdl.write(buf,0,buf.length);
		sdl.drain();
		sdl.close();
	}
}