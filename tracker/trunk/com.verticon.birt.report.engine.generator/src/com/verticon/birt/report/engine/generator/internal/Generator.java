package com.verticon.birt.report.engine.generator.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLCompleteImageHandler;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IDataExtractionTask;
import org.eclipse.birt.report.engine.api.IDataIterator;
import org.eclipse.birt.report.engine.api.IExtractionResults;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IResultMetaData;
import org.eclipse.birt.report.engine.api.IResultSetItem;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.IScalarParameterDefn;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.engine.api.ReportParameterConverter;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.google.common.collect.ImmutableMap;
import com.verticon.birt.report.engine.generator.EmitterType;
import com.verticon.birt.report.engine.generator.IGenerator;

public class Generator implements IGenerator {

	private static final String REPORTS_OUTPUT_DIRECTORY = "reports.output.directory";
	private String outputDirectory;
	private IReportEngine engine;
	private final MyImageHandler myImageHandler = new MyImageHandler();

	@Override
	public void generate(File parametersReportDesign, File reportsDirectory,
			boolean clearDestinationBeforeGeneration,
			File destinationDirectory, EmitterType emitterType,
			IProgressMonitor monitor)
			throws Exception {
		if (!destinationDirectory.exists()) {
			destinationDirectory.mkdir();
		}
		if (!destinationDirectory.isDirectory()) {
			throw new IllegalStateException("DestinationDirectory: "
					+ destinationDirectory + " is a file not a directory.");
		}
		List<Map<String, String>> parameterMaps = generateReportParameterMaps(parametersReportDesign);

		// Clear directories
		File outputDirectoryFile = new File(outputDirectory);
		boolean removed = removeDirectory(outputDirectoryFile);
		if (!removed) {
			throw new IllegalStateException(
					"Did not remove the output directory: " + outputDirectory);
		}

		if (clearDestinationBeforeGeneration) {
			removed = removeDirectory(destinationDirectory);
			if (!removed) {
				throw new IllegalStateException(
						"Did not clear the destination directory: "
								+ destinationDirectory);
			}
		}

		// Generate the reports
		generate(reportsDirectory, parameterMaps, emitterType, monitor);

		// Copy the reports from the output to the destination
		copyFolder(outputDirectoryFile, destinationDirectory);
	}

	@Override
	public void generate(File reportsDirectory,
			List<Map<String, String>> parameterMaps, EmitterType emitterType,
			IProgressMonitor monitor)
			throws EngineException {
		if (!reportsDirectory.isDirectory()) {
			throw new IllegalStateException(
					"Input parameter reportsDirectory is not a directory.");
		}

		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File directory, String fileName) {
				return fileName.endsWith(".rptdesign");
			}
		};
		File[] reports = reportsDirectory.listFiles(filter);
		if (monitor != null) {
			if (parameterMaps.isEmpty()) {
				monitor.beginTask("Generating Reports", reports.length);
			} else {
				monitor.beginTask("Generating Reports", reports.length
						* parameterMaps.size());
			}

		}

		for (File report : reports) {

			if (parameterMaps.isEmpty()) {
				// generate a single report for every rptdesign
				Map<String, String> map = Collections.emptyMap();
				generate(report, map, emitterType);
				if (monitor != null) {
					monitor.worked(1);
				}
			} else {
				// generate a multiple reports for every rptdesign
				for (Map<String, String> map : parameterMaps) {
					generate(report, map, emitterType);
					if (monitor != null) {
						monitor.worked(1);
					}
				}
			}
		}


	}

	@Override
	public void generate(File report, Map<String, String> parameterMapEntry,
			EmitterType emitterType)
			throws EngineException {

		if (!report.isFile()) {
			throw new IllegalStateException("Input parameter report " + report
					+ " is not a file.");
		}
		insureEngineIsStarted();
		IReportRunnable design = engine.openReportDesign(report
				.getAbsolutePath());

		String baseFileName = report.getName();
		baseFileName = baseFileName.substring(0, baseFileName.lastIndexOf('.'));
//		baseFileName = baseFileName.concat(".html");
		FileNameAndParams fNameAndParms = setParameters(design,
				parameterMapEntry, baseFileName);

		IRunAndRenderTask task = engine.createRunAndRenderTask(design);
		task.setParameterValues(fNameAndParms.getParameterValues());

		RenderOption options = null;
		switch (emitterType) {
		case PDF:
			System.out.println("Generating PDF for "
					+ fNameAndParms.getFileName());
			options = setUpPDFRenderOptions(fNameAndParms);
			break;

		case HTML_EMBEDDABLE:
			System.out
.println("Setting up HTML_EMBEDDABLE for "
					+ fNameAndParms.getFileName());
			options = setUpHTMLRenderOptions(fNameAndParms, true);
			break;

		case HTML:
		default:
			System.out.println("Setting up HTML for "
					+ fNameAndParms.getFileName());
			options = setUpHTMLRenderOptions(fNameAndParms, false);
			break;
		}

		task.setRenderOption(options);
		task.run();
		task.close();

	}
	
	private RenderOption setUpPDFRenderOptions(
			FileNameAndParams fNameAndParms) {
		PDFRenderOption options = new PDFRenderOption();
		
		// options.setOption( IPDFRenderOption.FIT_TO_PAGE, new Boolean(true) );
		// options.setOption( IPDFRenderOption.PAGEBREAK_PAGINATION_ONLY, new
		// Boolean(true) );

		options.setOutputFormat("pdf");
		String outputFileName = fNameAndParms.getFileName().concat(".pdf");
		options.setOutputFileName(outputDirectory + File.separator
				+ outputFileName);
		return options;
	}

	private RenderOption setUpHTMLRenderOptions(
			FileNameAndParams fNameAndParms,
			boolean embeddable) {
		HTMLRenderOption options = new HTMLRenderOption();
		options.setOutputFormat("html");
		if (embeddable) {
			options.setEmbeddable(true);
		}
		options.setImageDirectory("images");
		String outputFileName = fNameAndParms.getFileName();
		myImageHandler.setId(outputFileName);
		options.setImageHandler(myImageHandler);
		outputFileName = fNameAndParms.getFileName().concat(".html");
		options.setOutputFileName(outputDirectory + File.separator
				+ outputFileName);
		return options;
	}

	@Override
	public List<Map<String, String>> generateReportParameterMaps(File report)
			throws EngineException,
			SemanticException {
		if (!report.isFile()) {
			throw new IllegalStateException(
"Input parameter report " + report
					+ " is not a file.");
		}
		insureEngineIsStarted();
		IReportRunnable design = engine.openReportDesign(report
				.getAbsolutePath());

		String reportDocName = report.getName().replace(".rptdesign",
				".rptdocument");

		IRunTask task = engine.createRunTask(design);

		task.run(reportDocName);
		return extractReportParamFromResult(reportDocName);

	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void activate(Map<String, Object> dsconfig) {
		Object o = dsconfig.get(REPORTS_OUTPUT_DIRECTORY);
		checkNotNull(o, "ReportsOutputDirectory cannot be null.");
		if (o != null) {
			outputDirectory = (String) o;
		}

		EngineConfig engineConfig = new EngineConfig();
		// Create the report engine
		IReportEngineFactory factory = (IReportEngineFactory) org.eclipse.birt.core.framework.Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		engine = factory.createReportEngine(engineConfig);
	}

	/**
	 * Declaratives Services activation of instance.
	 * 
	 * @param config
	 *            contains properties for this instance.
	 */
	void deactivate() {
		if (engine != null) {
			engine.destroy();
		}
	}

	private void insureEngineIsStarted() {
		if (engine == null) {

			ImmutableMap<String, Object> map = ImmutableMap.of(
					REPORTS_OUTPUT_DIRECTORY, (Object) new String(
							"renderedReports"));
			activate(map);
		}
	}

	@SuppressWarnings("unchecked")
	private final FileNameAndParams setParameters(IReportRunnable design,
			Map<String, String> inputValues, String baseName) {
		String name = null;

		IGetParameterDefinitionTask task = engine
				.createGetParameterDefinitionTask(design);
		Collection<IScalarParameterDefn> params = task.getParameterDefns(false);
		Map<String, Object> parameterValues = task.getDefaultValues();

		ReportParameterConverter cfgConverter = new ReportParameterConverter(
				"", Locale.getDefault());

		for (IScalarParameterDefn param : params) {
			String value = inputValues.get(param.getName());
			if (value != null) {
				if (name == null) {
					name = value;
				}
				parameterValues.put(param.getName(),
						cfgConverter.parse(value, param.getDataType()));
			}
		}

		// task.setParameterValues(parameterValues);

		task.close();
		if (name == null) {
			name = baseName;
		} else {
			name = name + baseName;
		}

		return new FileNameAndParams(name, parameterValues);
	}

	private List<Map<String, String>> extractReportParamFromResult(
			String rptdocument) throws EngineException {

		IReportDocument iReportDocument = engine
				.openReportDocument(rptdocument);

		// Setup data extraction task
		IDataExtractionTask task = engine
				.createDataExtractionTask(iReportDocument);


		@SuppressWarnings("unchecked")
		List<IResultSetItem> resultSetList = task.getResultSetList();
		if (resultSetList.isEmpty()) {
			throw new IllegalStateException("No resultSets in "
					+ rptdocument.replace(".rptdocument", ".rptdesign"));
		}

		List<Map<String, String>> results = newArrayList();

		for (IResultSetItem resultItem : resultSetList) {
			System.out.println("ResultSetName ====> "
					+ resultItem.getResultSetName());
		}
		// Just get the first result set


		IResultSetItem resultItem = resultSetList.get(0);
		String dispName = resultItem.getResultSetName();
		// Name Tables for ease
		task.selectResultSet(dispName);

		IExtractionResults iExtractResults = task.extract();

		IDataIterator iData = null;
		try {
			if (iExtractResults != null) {

				iData = iExtractResults.nextResultIterator();
				// Get metadata on retrieved results
				IResultMetaData irmd = iData.getResultMetaData();

				if (iData != null) {
					int colCount = irmd.getColumnCount();
					System.out.println("Column Count =" + colCount);
					List<String> columnNames = newArrayList();
					for (int j = 0; j < colCount; j++) {
						System.out.println("Column Name ="
								+ irmd.getColumnName(j));
						System.out.println("Column Type ="
								+ irmd.getColumnTypeName(j));
						columnNames.add(irmd.getColumnName(j));
					}
					// Go through the rows
					while (iData.next()) {
						Map<String, String> map = newHashMap();
						for (String key : columnNames) {
							map.put(key, iData.getValue(key).toString());
							System.out.println("key: " + key + ", value: "
									+ iData.getValue(key));
						}
						results.add(map);

					}
					iData.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		task.close();

		return results;
	}


	private final void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
				System.out.println("Directory copied from " + src + "  to "
						+ dest);
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			// System.out.println("File copied from " + src + " to " + dest);
		}
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


	class FileNameAndParams {
		private final String fileName;
		private final Map<String, Object> parameterValues;

		FileNameAndParams(String fileName, Map<String, Object> parameterValues) {
			super();
			this.fileName = fileName;
			this.parameterValues = parameterValues;
			// System.out.println("For fileName: " + fileName);
			// for (Entry<String, Object> entry : parameterValues.entrySet()) {
			// System.out.println("Setting : " + entry.getKey() + " to "
			// + entry.getValue());
			// }
		}

		public String getFileName() {
			return fileName;
		}

		public Map<String, Object> getParameterValues() {
			return parameterValues;
		}

	}



	class MyImageHandler extends HTMLCompleteImageHandler {
		private String id = null;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.birt.report.engine.api.HTMLCompleteImageHandler#
		 * createUniqueFile(java.lang.String, java.lang.String,
		 * java.lang.String)
		 */
		@Override
		protected File createUniqueFile(String imageDir, String prefix,
				String postfix) {

			File result = createMyUniqueFile(imageDir, id + '-', postfix);
			System.out.println("For " + id + " creating image: "
					+ result.getName());
			return result;
		}

		protected File createMyUniqueFile(String imageDir, String prefix,
				String postfix) {
			assert prefix != null;
			if (postfix == null) {
				postfix = "";
			}

			File file = null;
			int count = 0;
			do {
				count++;
				file = new File(imageDir + "/" + prefix + count + postfix); //$NON-NLS-1$
			} while (file.exists());

			return new File(imageDir, prefix + count + postfix); //$NON-NLS-1$
		}

	}
}
