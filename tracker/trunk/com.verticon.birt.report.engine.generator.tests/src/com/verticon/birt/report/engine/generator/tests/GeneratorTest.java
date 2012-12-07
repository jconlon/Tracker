package com.verticon.birt.report.engine.generator.tests;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.verticon.birt.report.engine.generator.EmitterType;
import com.verticon.birt.report.engine.generator.GeneratorFactory;
import com.verticon.birt.report.engine.generator.IGenerator;

/**
 * Some of these tests utilize the Derby VSN water quality db. This database is
 * an embedded db and needs to be started before these tests are run. Open a
 * Tracker and open the project:
 * /opt/Verticon/tracker_0.7.0-1/tracker/workspace/VSN-Kickapoo-Reports-01 and
 * start the server by selecting the project and invoking the start network
 * server within the Apache menu item.
 * 
 * Had problems accessing the derby driver even though it is set in the class.
 * So added it to:
 * "/home/jconlon/Workspaces/tracker_dev-01/.metadata/.plugins/org.eclipse.pde.core/.bundle_pool/plugins/org.eclipse.birt.report.data.oda.jdbc_3.7.2.v20120213/drivers"
 * ;
 * 
 * @author jconlon
 * 
 */
public class GeneratorTest {

	private static final File REPORTS_DIRECTORY = new File("reports");

	private static final File TEST_STATIONS_FILE = new File(
			"testData/ThreeSitesForGoogleEarth.csv");

	private static final File PARAMETERS_REPORT_DESIGN = new File(
			REPORTS_DIRECTORY, "reportParameters/TestRP.rptdesign");


	private static final File REPORT_MODELS = new File(
			"testData/TopNPercent.rptdesign");

	private static final File REPORT_TEMP = new File(REPORTS_DIRECTORY,
			"Temperature.rptdesign");

	private static final File BASE_DESTINATION_DIRECTORY = new File(
			"renderedReports");

	private static final File DESTINATION_HTML_EMBEDDABLE_REPORTS_DIRECTORY = new File(
			"output/embeddableHTML");

	@SuppressWarnings("unused")
	private static final File DESTINATION_HTML_REPORTS_DIRECTORY = new File(
			"output/HTML");

	private static final File DESTINATION_PDF_REPORTS_DIRECTORY = new File(
			"output/pdf");

	private static final String REPORT_PARM_STATIONID = "Station ID";

	private IGenerator instance;
	private IProgressMonitor monitor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		removeDirectory(BASE_DESTINATION_DIRECTORY);
		BASE_DESTINATION_DIRECTORY.mkdir();
	}

	@Before
	public void setUp() throws Exception {
		instance = GeneratorFactory.getGenerator();
		monitor = createMock(IProgressMonitor.class);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		monitor = null;
	}

	@Test
	public final void testGetGenerator() {
		assertNotNull("IGenerator instance from factory should not be null!",
				instance);
	}

	@Test
	public final void testReportModelResourceExists() {
		assertTrue("Test resources " + REPORT_MODELS + " does not exist.",
				REPORT_MODELS.isFile());
	}



	@Test
	public final void testGenerateHTMLModelsReport() throws Exception {
		instance.generate(REPORT_MODELS,
				Collections.<String, String> emptyMap(), EmitterType.HTML);
		assertEquals(2, BASE_DESTINATION_DIRECTORY.list().length);
	}

	@Test
	public final void testGenerateHTMLEmbeddableTemperatureReport()
			throws Exception {
		Map<String, String> map = newHashMap();
		// map.put(REPORT_TEMP_PARM_WBIC, "118850");
		map.put(REPORT_PARM_STATIONID, "10013791");
		instance.generate(REPORT_TEMP, map, EmitterType.HTML_EMBEDDABLE);
		assertEquals(3, BASE_DESTINATION_DIRECTORY.list().length);
	}

	@Test
	public final void testGenerateHTMLTemperatureReportsWithList()
			throws Exception {
		// Map<String, String> map = newHashMap();
		// // map.put(REPORT_TEMP_PARM_WBIC, "118850");
		// map.put(REPORT_PARM_STATIONID, "10013791");
		List<Map<String, String>> parameterMapList = getParameters(
				TEST_STATIONS_FILE, ImmutableList.of(REPORT_PARM_STATIONID));
		// Setup the mock monitor
		monitor.beginTask("Generating Reports", 3);
		monitor.worked(1);
		expectLastCall().times(3);
		replay(monitor);

		// Do it
		instance.generate(REPORTS_DIRECTORY, parameterMapList,
				EmitterType.HTML, monitor);
		// Verify
		verify(monitor);
		assertEquals(5, BASE_DESTINATION_DIRECTORY.list().length);
	}

	// @Test
	// public final void testGeneratePDFSummary() throws Exception {
	// Map<String, String> map = newHashMap();
	// // Error POS to Double type
	// map.put(REPORT_PARM_STATIONID, "10013791");
	//
	// // No Data
	// // map.put(REPORT_PARM_STATIONID, "118850");
	//
	// // Can not convert the value of < 0.07 to BigDecimal type. (Element
	// // ID:12)
	// // map.put(REPORT_PARM_STATIONID, "423093");
	//
	// // Can not convert the value of < 0.07 to BigDecimal type. (Element
	// // ID:12)
	// // map.put(REPORT_PARM_STATIONID, "10033423");
	//
	// // Can not convert the value of < 0.07 to BigDecimal type. (Element
	// // ID:12)
	// // map.put(REPORT_PARM_STATIONID, "10020620");
	//
	// // map.put(REPORT_PARM_STATIONID, "10012463"); // works
	// instance.generate(REPORT_SUMMARY, map, EmitterType.PDF);
	// assertEquals(4, BASE_DESTINATION_DIRECTORY.list().length);
	// }

	@Test
	public final void testGenerateMap() throws Exception {
		List<Map<String, String>> result = instance
				.generateReportParameterMaps(PARAMETERS_REPORT_DESIGN);

		assertEquals(3, result.size());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testGeneratePDFReports() throws Exception {
		// Setup the mock monitor
		monitor.beginTask("Generating Reports", 3);
		monitor.worked(1);
		expectLastCall().times(3);
		replay(monitor);

		instance.generate(PARAMETERS_REPORT_DESIGN, REPORTS_DIRECTORY, true,
				DESTINATION_PDF_REPORTS_DIRECTORY, EmitterType.PDF, monitor);

		verify(monitor);
		assertEquals(3, BASE_DESTINATION_DIRECTORY.list().length);
		assertEquals(3, DESTINATION_PDF_REPORTS_DIRECTORY.list().length);
	}


	@Test
	public final void testGenerateHTMLEmbeddableReports() throws Exception {
		monitor.beginTask("Generating Reports", 3);
		monitor.worked(1);
		expectLastCall().times(3);
		replay(monitor);

		instance.generate(PARAMETERS_REPORT_DESIGN, REPORTS_DIRECTORY, true,
				DESTINATION_HTML_EMBEDDABLE_REPORTS_DIRECTORY,
				EmitterType.HTML_EMBEDDABLE, monitor);
		verify(monitor);
		assertEquals(4, BASE_DESTINATION_DIRECTORY.list().length);
		assertEquals(4,
				DESTINATION_HTML_EMBEDDABLE_REPORTS_DIRECTORY.list().length);
	}

	private final static boolean removeDirectory(File directory) {
		// System.out.println("removeDirectory " + BASE_DESTINATION_DIRECTORY);

		if (directory == null)
			return false;
		if (!directory.exists())
			return true;
		if (!directory.isDirectory())
			return false;

		String[] list = directory.list();

		// Some JVMs return null for File.list() when the
		// BASE_DESTINATION_DIRECTORY is empty.
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				File entry = new File(directory, list[i]);

				// System.out.println("\tremoving entry " + entry);

				if (entry.isDirectory()) {
					if (!removeDirectory(entry))
						return false;
				} else {
					if (!entry.delete())
						return false;
				}
			}
		}

		return directory.delete();
	}

	private static final Splitter MY_SPLITTER = Splitter.on(',').trimResults()
			.omitEmptyStrings();

	private final static List<Map<String, String>> getParameters(
			File inputFile, List<String> parameterNames) {
		List<Map<String, String>> listOfMaps = newArrayList();
		List<String> lines = readFileLineByLine(inputFile);
		for (String string : lines) {
			Map<String, String> map = newHashMap();
			// parse the string
			int paramNameIndex = 0;
			Iterator<String> it = MY_SPLITTER.split(string).iterator();
			while (it.hasNext() && paramNameIndex < parameterNames.size()) {
				map.put(parameterNames.get(paramNameIndex), it.next());

				paramNameIndex++;
			}
			listOfMaps.add(map);
		}

		return listOfMaps;
	}

	private final static List<String> readFileLineByLine(File inputFile) {
		List<String> lines = newArrayList();

		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new FileReader(inputFile));
			String line = buffReader.readLine();
			while (line != null) {
				lines.add(line);
				line = buffReader.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				buffReader.close();
			} catch (IOException ioe1) {
				// Leave It
			}
		}
		return lines;
	}

}
