package com.verticon.birt.report.engine.generator.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.verticon.birt.report.engine.generator.EmitterType;
import com.verticon.birt.report.engine.generator.GeneratorFactory;
import com.verticon.birt.report.engine.generator.IGenerator;

/**
 * Had problem accessing the derby driver even though it is set in the class. So
 * added it to:
 * "/home/jconlon/Workspaces/tracker_dev-01/.metadata/.plugins/org.eclipse.pde.core/.bundle_pool/plugins/org.eclipse.birt.report.data.oda.jdbc_3.7.2.v20120213/drivers"
 * ;
 * 
 * @author jconlon
 * 
 */
public class ProductionGeneratorTest {



	private static final File TRACKER_REPORTS_DIRECTORY = new File(
			"/opt/Verticon/tracker_0.7.0-1/tracker/workspace/VSN-Kickapoo-Reports-01/reports");

	private static final File TRACKER_REPORTS_CURRENT_TARGETS_DIRECTORY = new File(
			TRACKER_REPORTS_DIRECTORY, "currentTargets");

	private static final File PARAMETERS_REPORT_DESIGN = new File(
			TRACKER_REPORTS_CURRENT_TARGETS_DIRECTORY,
			"reportParameters/googleEarthStationsRP.rptdesign");

	private static final File DESTINATION_DIRECTORY = new File(
			"renderedReports");

	private static final File TRACKER_DESTINATION_REPORTS_DIRECTORY = new File(
			TRACKER_REPORTS_DIRECTORY,
			"KmlReports/kml_artifacts/renderedReports");

	private static final File TRACKER_DESTINATION_PDF_REPORTS_DIRECTORY = new File(
			TRACKER_REPORTS_DIRECTORY, "KmlReports/kml_artifacts/pdf");

	private IGenerator instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		removeDirectory(DESTINATION_DIRECTORY);
		DESTINATION_DIRECTORY.mkdir();
	}

	@Before
	public void setUp() throws Exception {
		instance = GeneratorFactory.getGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testParametersReportDesignDocument() throws Exception {
		List<Map<String, String>> result = instance
				.generateReportParameterMaps(PARAMETERS_REPORT_DESIGN);
		assertEquals(57, result.size());
	}

	@Test
	public final void generateAllPDFReports() throws Exception {
		instance.generate(PARAMETERS_REPORT_DESIGN,
				TRACKER_REPORTS_CURRENT_TARGETS_DIRECTORY, true,
				TRACKER_DESTINATION_PDF_REPORTS_DIRECTORY, EmitterType.PDF,
				null);

		assertEquals(114, DESTINATION_DIRECTORY.list().length);// 2 reports x 57
																// stations
		assertEquals(114,
				TRACKER_DESTINATION_PDF_REPORTS_DIRECTORY.list().length);
	}


	@Test
	public final void generateAllHTMLReports() throws Exception {
		instance.generate(PARAMETERS_REPORT_DESIGN,
				TRACKER_REPORTS_CURRENT_TARGETS_DIRECTORY, true,
				TRACKER_DESTINATION_REPORTS_DIRECTORY,
 EmitterType.HTML, null);

		assertEquals(115, DESTINATION_DIRECTORY.list().length);// 2 reports x 57
																// stations +
																// image
																// directory
		assertEquals(115, TRACKER_DESTINATION_REPORTS_DIRECTORY.list().length);
	}

	private final static boolean removeDirectory(File directory) {

		// System.out.println("removeDirectory " + DESTINATION_DIRECTORY);

		if (directory == null)
			return false;
		if (!directory.exists())
			return true;
		if (!directory.isDirectory())
			return false;

		String[] list = directory.list();

		// Some JVMs return null for File.list() when the
		// DESTINATION_DIRECTORY is empty.
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

}
