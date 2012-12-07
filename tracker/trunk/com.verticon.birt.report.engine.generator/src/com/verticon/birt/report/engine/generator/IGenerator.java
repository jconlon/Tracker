package com.verticon.birt.report.engine.generator;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IGenerator {
	
	/**
	 * 
	 * @param parametersReportDesign
	 * @param reportsDirectory
	 * @param clearDestinationBeforeGeneration
	 * @param destinationDirectory
	 * @param emmitterType
	 *            type of output
	 * @throws Exception
	 */
	void generate(File parametersReportDesign, File reportsDirectory,
			boolean clearDestinationBeforeGeneration,
			File destinationDirectory, EmitterType emitterType,
			IProgressMonitor monitor)
			throws Exception;

	/**
	 * Generates a BIRT report for every report design and every map in the
	 * parameterMap list. If the parameterMapList is empty, it then generate a
	 * single report for every rptdesign in the reportsDirectory. Report output
	 * destination is implementation specific.
	 * 
	 * @param reportsDirectory
	 *            containing the report designs
	 * @param reportParameterMaps
	 *            list of maps containing report parameters
	 * @param emmitterType
	 *            type of output
	 * @throws Exception
	 *             if an BIRT EngineException occurs on generation
	 */
	void generate(File reportsDirectory,
			List<Map<String, String>> reportParameterMaps,
			EmitterType emitterType, IProgressMonitor monitor) throws Exception;

	/**
	 * Generate the report with the given parameterMap. Report output
	 * destination is implementation specific.
	 * 
	 * @param reportDesign
	 *            a BIRT rptdesign file
	 * @param reportParameterMap
	 *            a map of report parameter names and values
	 * 
	 * @param emmitterType
	 *            type of output
	 * @throws Exception
	 *             if an BIRT EngineException occurs on generation
	 */
	void generate(File reportDesign, Map<String, String> reportParameterMap,
			EmitterType emitterType)
			throws Exception;

	/**
	 * Generate a list of ReportParameterMaps from a report design
	 * 
	 * @param parametersReportDesign
	 *            contains a table where the column names are report parameter
	 *            names and the values are in the rows
	 * @return reportParameterMaps list of maps containing report parameters
	 * @throws Exception
	 */
	List<Map<String, String>> generateReportParameterMaps(
			File parametersReportDesign)
			throws Exception;

}
