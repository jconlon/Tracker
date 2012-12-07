package com.verticon.birt.report.engine.emiiter.kml;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verticon.birt.report.engine.emitter.kml.KMLReportEmitter;

public class KMLReportEmitterTest {

	private static final String ARTIFACTS_DIR = "kml_artifacts";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.verticon.birt.report.engine.emitter.kml.KMLReportEmitter#createKMZ(java.io.File, java.io.OutputStream, java.lang.String)}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCreateKMZ() throws IOException {
		File artifactsDirectory = new File(ARTIFACTS_DIR);
		assertTrue(artifactsDirectory.isDirectory());
		File kmz = new File(System.getProperty("java.io.tmpdir"), "test.kmz");
		String kml = readFile("testData/HelloEarth.kml");
		FileOutputStream out = new FileOutputStream(kmz);
		KMLReportEmitter.createKMZ(artifactsDirectory, out, kml);
		assertTrue(kmz.isFile());
	}

	private String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		return stringBuilder.toString();
	}

}
