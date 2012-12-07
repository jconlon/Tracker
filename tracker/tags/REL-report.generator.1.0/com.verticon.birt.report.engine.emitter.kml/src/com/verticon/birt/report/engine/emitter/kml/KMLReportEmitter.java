package com.verticon.birt.report.engine.emitter.kml;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.content.IBandContent;
import org.eclipse.birt.report.engine.content.ICellContent;
import org.eclipse.birt.report.engine.content.IDataContent;
import org.eclipse.birt.report.engine.content.IElement;
import org.eclipse.birt.report.engine.content.IForeignContent;
import org.eclipse.birt.report.engine.content.IReportContent;
import org.eclipse.birt.report.engine.content.IRowContent;
import org.eclipse.birt.report.engine.content.ITableContent;
import org.eclipse.birt.report.engine.content.ITextContent;
import org.eclipse.birt.report.engine.emitter.ContentEmitterAdapter;
import org.eclipse.birt.report.engine.emitter.EmitterUtil;
import org.eclipse.birt.report.engine.emitter.IEmitterServices;
import org.eclipse.birt.report.engine.presentation.ContentEmitterVisitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.verticon.opengis.kml.Document;
import com.verticon.opengis.kml.Folder;
import com.verticon.opengis.kml.Kml;
import com.verticon.opengis.kml.KmlFactory;
import com.verticon.opengis.kml.KmlPackage;
import com.verticon.opengis.kml.Placemark;
import com.verticon.opengis.kml.Point;
import com.verticon.opengis.kml.util.KmlResourceFactoryImpl;
import com.verticon.opengis.kml.util.KmlXMLProcessor;

public class KMLReportEmitter extends ContentEmitterAdapter {

	private static final String DOC_KML = "doc.kml";

	/**
	 * the output format
	 */
	public static final String OUTPUT_FORMAT_KMZ = "kmz"; //$NON-NLS-1$

	private static final String ARTIFACTS_DIR_NAME = "kml_artifacts";

	private enum RowType {
		HEADER, FOOTER, GROUP, DETAIL, PAGEHEADER, OTHER
	}

	private enum Tag {
		FOLDER, PLACEMARK, PLACEMARKID, DESCRIPTION, LONGITUDE, LATITUDE, STYLEURL
	}

	private Map<Integer, Tag> columnMap = new HashMap<Integer, Tag>();

	private RowType rowType;

	/**
	 * the default target report file name
	 */
	public static final String REPORT_FILE = "/tmp/report.kmz"; //$NON-NLS-1$

	/**
	 * An Log object that <code>CSVReportEmitter</code> use to log the error,
	 * debug, information messages.
	 */
	protected static Logger logger = Logger.getLogger(KMLReportEmitter.class
			.getName());

	/**
	 * emitter services
	 */
	protected IEmitterServices services;

	/**
	 * content visitor that is used to handle page header/footer
	 */
	protected ContentEmitterVisitor contentVisitor;

	/**
	 * the report content
	 */
	protected IReportContent report;

	/**
	 * the render options
	 */
	protected IRenderOption renderOption;

	/**
	 * should output the page header & footer
	 */
	protected boolean outputMasterPageContent = true;

	/**
	 * Used to indicate nested tables. It increases with each startTable() and
	 * decreases with endTable()
	 */
	protected int tableDepth = 0;

	/**
	 * number of columns in a table element
	 */
	protected int columnNumbers;

	/**
	 * the number of the current processed column
	 */
	protected int currentColumn;

	private KmlXMLProcessor processor = new KmlXMLProcessor();

	private Document document;

	private String placemarkName;

	private String placemarkDescription;

	private String placemarkID;

	private String longitude;

	private String latitude;

	private String styleURL;

	private String folderName;

	private Folder currentFolder;

	/**
	 * the constructor
	 */
	public KMLReportEmitter() {
		contentVisitor = new ContentEmitterVisitor(this);
	}

	public String getOutputFormat() {
		return OUTPUT_FORMAT_KMZ;
	}

	@Override
	public void initialize(IEmitterServices services) throws BirtException {
		this.services = services;
		logger.log(Level.FINE, "Initializing"); //$NON-NLS-1$
	}

	@Override
	public void start(IReportContent report) throws BirtException {
		logger.log(Level.FINE, "Start emitter"); //$NON-NLS-1$
		this.report = report;
		document = KmlFactory.eINSTANCE.createDocument();
		document.setDescription(report.getTitle());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#end(org.eclipse
	 * .birt.report.engine.content.IReportContent)
	 */
	@Override
	public void end(IReportContent report) {
		String reportName = services.getReportName();
		logger.log(Level.FINE, "End reportName: " + reportName); //$NON-NLS-1$
		File artifactsDirctory = null;
		if (reportName != null) {
			File reportFile = new File(reportName);
			File parentDirectory = reportFile.getParentFile();
			artifactsDirctory = new File(parentDirectory, ARTIFACTS_DIR_NAME);

		}
		OutputStream out = null;
		File file = null;

		try {

			// Object value =
			// services.getOption(RenderOption.OUTPUT_STREAM);
			Object value = EmitterUtil.getOuputStream(services, REPORT_FILE);
			if (value != null && value instanceof OutputStream) {
				logger.log(Level.FINE,
						"Will save to renderOption OutputStream."); //$NON-NLS-1$
				out = (OutputStream) value;
			} else {
				try {
					file = new File(REPORT_FILE);
					out = new BufferedOutputStream(new FileOutputStream(file));
				} catch (FileNotFoundException e) {

					logger.log(Level.SEVERE, e.getMessage(), e);
				}
			}

			createKMZ(artifactsDirctory, out, createKml());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		} catch (EngineException e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}

	}

	private String createKml() throws IOException {
		Resource resource = buildResource();
		return processor.saveToString(resource, null);
	}

	public static void createKMZ(File artifactsDirectory, OutputStream out,
			String kml) throws IOException {
		// Create the zip
		ZipOutputStream zipOutputStream = new ZipOutputStream(out);
		zipOutputStream.setLevel(9);
		// Add the kmlFile
		System.out.println("Adding " + DOC_KML);
		ZipEntry entry = new ZipEntry(DOC_KML);
		zipOutputStream.putNextEntry(entry);
		zipOutputStream.write(kml.getBytes("UTF-8"));
		zipOutputStream.closeEntry();
		if (artifactsDirectory != null && artifactsDirectory.isDirectory()) {
			// Add all the other artifacts from the directory
			File[] childArtifacts = artifactsDirectory.listFiles();
			for (File file : childArtifacts) {
				if (file.isFile()) {
					copyFileToZip(file, zipOutputStream);
				} else {
					copyDirectoryToZip(file, zipOutputStream);
				}
			}

		}
		zipOutputStream.close();
	}

	private static void copyDirectoryToZip(File file, ZipOutputStream out)
			throws IOException {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				copyFileToZip(f, out);
			} else {
				copyDirectoryToZip(f, out);
			}
		}
	}

	private static void copyFileToZip(File file, ZipOutputStream out)
			throws IOException {
		String path = file.getPath();
		int index = path.indexOf(ARTIFACTS_DIR_NAME)
				+ ARTIFACTS_DIR_NAME.length() + 1;
		String fileName = path.substring(index);
		System.out.println("Adding " + fileName);
		ZipEntry entry = new ZipEntry(fileName);
		out.putNextEntry(entry);
		FileInputStream in = new FileInputStream(file);
		for (int c = in.read(); c != -1; c = in.read()) {
			out.write(c);
		}
		in.close();
		out.closeEntry();
	}

	private Resource buildResource() {
		// String file = output == null ? REPORT_FILE : output.toString();
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new KmlResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(KmlPackage.eNS_URI,
				KmlPackage.eINSTANCE);

		Resource resource = resourceSet.createResource(URI
				.createFileURI(DOC_KML));

		// Create the root
		// DocumentRoot documentRoot =
		// KmlFactory.eINSTANCE.createDocumentRoot();
		Kml kml = KmlFactory.eINSTANCE.createKml();

		// Add the document to the kml root
		kml.getAbstractFeatureGroupGroup().add(
				KmlPackage.eINSTANCE.getDocumentRoot_Document(), document);
		// kml.setFeature(document);

		// documentRoot.setKml(kml);
		resource.getContents().add(kml);
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#startTable(org
	 * .eclipse.birt.report.engine.content.ITableContent)
	 */
	@Override
	public void startTable(ITableContent table) {
		assert table != null;
		tableDepth++;
		if (tableDepth > 1) {
			logger.log(Level.FINE, "Nested tables are not supported.");
			return;
		}
		columnNumbers = table.getColumnCount();
		logger.log(Level.FINE, "Start table");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#endTable(org.eclipse
	 * .birt.report.engine.content.ITableContent)
	 */
	@Override
	public void endTable(ITableContent table) {
		if (tableDepth < 2) {
			logger.log(Level.FINE, "End table"); //$NON-NLS-1$
		}
		tableDepth--;
		columnMap.clear();
	}

	public void startRow(IRowContent row) {
		assert row != null;

		if (tableDepth > 1) {
			logger.log(Level.FINE, "Nested tables are not supported.");
			return;
		}
		if (isRowInHeaderBand(row)) {
			if (columnMap.isEmpty()) {
				rowType = RowType.HEADER;
				logger.log(Level.FINE, "Header Row.");
			} else {
				rowType = RowType.PAGEHEADER;
			}

		} else if (isRowInFooterBand(row)) {
			rowType = RowType.FOOTER;
		} else if (isRowInDetailBand(row)) {
			rowType = RowType.DETAIL;
			logger.log(Level.FINE, "Detail Row.");
		} else if (isRowInGroupHeaderBand(row)) {
			rowType = RowType.GROUP;
			logger.log(Level.FINE, "Group Header Row.");
		} else {
			rowType = RowType.OTHER;
		}
		currentColumn = 0;
	}

	private boolean isRowInHeaderBand(IRowContent row) {
		IElement parent = row.getParent();
		if (!(parent instanceof IBandContent)) {
			return false;
		}
		IBandContent band = (IBandContent) parent;
		if (band.getBandType() == IBandContent.BAND_HEADER) {
			return true;
		}
		return false;
	}

	private boolean isRowInDetailBand(IRowContent row) {
		IElement parent = row.getParent();
		if (!(parent instanceof IBandContent)) {
			return false;
		}
		IBandContent band = (IBandContent) parent;
		if (band.getBandType() == IBandContent.BAND_DETAIL) {
			return true;
		}
		return false;
	}

	private boolean isRowInGroupHeaderBand(IRowContent row) {
		IElement parent = row.getParent();
		if (!(parent instanceof IBandContent)) {
			return false;
		}
		IBandContent band = (IBandContent) parent;
		if (band.getBandType() == IBandContent.BAND_GROUP_HEADER) {
			return true;
		}
		return false;
	}

	private boolean isRowInFooterBand(IRowContent row) {
		IElement parent = row.getParent();
		if (!(parent instanceof IBandContent)) {
			return false;
		}
		IBandContent band = (IBandContent) parent;
		if (band.getBandType() == IBandContent.BAND_FOOTER) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#endRow(org.eclipse
	 * .birt.report.engine.content.IRowContent)
	 */
	public void endRow(IRowContent row) {
		if (tableDepth > 1) {
			logger.log(Level.FINE, "Nested tables are not supported.");
			return;
		}
		if (rowType == RowType.DETAIL) {
			recordDetailRow();
		}

	}

	private void recordDetailRow() {
		if (placemarkName == null || placemarkName.trim().length() < 1
				|| latitude == null || latitude.trim().length() < 1
				|| longitude == null || longitude.trim().length() < 1) {
			return;
		}

		Placemark placemark = createPlacemark();
		placemark.setName(placemarkName);
		if (placemarkDescription != null) {
			placemark.setDescription(placemarkDescription);
		}
		if (placemarkID != null && placemarkID.trim().length() > 0) {
			placemark.setId(placemarkID);
		}

		Point point = createPoint(placemark);
		List<String> coordinates = new ArrayList<String>();
		String coord = longitude + ',' + latitude;
		coordinates.add(coord);
		point.setCoordinates(coordinates);
		placemarkName = null;
		placemarkDescription = null;
		placemarkID = null;
		latitude = null;
		longitude = null;
		styleURL = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#startCell(org.
	 * eclipse.birt.report.engine.content.ICellContent)
	 */
	public void startCell(ICellContent cell) {
		if (tableDepth > 1) {
			logger.log(Level.FINE, "Nested tables are not supported.");
			return;
		}

		currentColumn = currentColumn + 1;
		logger.log(Level.FINE, "Start cell. " + cell.getChildren()); //$NON-NLS-1$

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#startText(org.
	 * eclipse.birt.report.engine.content.ITextContent)
	 */
	public void startText(ITextContent text) {
		if (tableDepth > 1) {
			logger.log(Level.FINE, "Nested tables are not supported.");
			return;
		}

		String textValue = text.getText();

		logger.log(Level.FINE, "Text: " + textValue);

		if (textValue == null || textValue.trim().length() < 1) {
			logger.log(Level.WARNING, "Start text, but text was null or empty."); //$NON-NLS-1$
			return;
		}

		switch (rowType) {
		case HEADER:
			createColumnMap(textValue);
			break;

		case FOOTER:
			logger.log(Level.FINE, "Footer: " + textValue);
			break;

		case DETAIL:
			handleDetailText(textValue);
			break;

		case GROUP:
			handleGroupText(textValue);
			break;

		case OTHER:
			logger.log(Level.FINE, "Other: " + textValue);
			break;
		}

	}

	@Override
	public void startForeign(IForeignContent foreign) throws BirtException {

		if (!foreign.getRawType().equals(IForeignContent.HTML_TYPE)) {
			logger.log(Level.WARNING,
					"Unknown Foreign Type: " + foreign.getRawType());
			return;
		}
		String textValue = foreign.getRawValue().toString();
		switch (rowType) {

		case DETAIL:
			handleDetailText(textValue);
			break;

		case GROUP:
			handleGroupText(textValue);
			break;

		default:
			logger.log(Level.WARNING,
					"Foreign Content only supported in Detail and Group rows.");
			break;
		}
	}

	private void handleGroupText(String textValue) {
		Tag t = columnMap.get(currentColumn);
		if (t == null) {
			logger.log(Level.FINE, "Unknown Tag, column " + currentColumn
					+ " value=" + textValue);
			return;
		}

		switch (t) {
		case FOLDER:
			logger.log(Level.FINE, "Group Folder: " + textValue);
			createFolder(textValue);
			break;
		case DESCRIPTION:
			logger.log(Level.FINE, "Group Descirption: " + textValue);
			if (currentFolder != null && currentFolder.getDescription() == null) {
				currentFolder.setDescription(textValue);
			}
			break;
		case STYLEURL:
			logger.log(Level.FINE, "Group StyleURL: " + textValue);
			if (currentFolder != null && currentFolder.getStyleUrl() == null) {
				currentFolder.setStyleUrl(textValue);
			}
			break;

		}
	}

	private void createFolder(String textValue) {
		if (folderName == null) {

		} else if (!folderName.equals(textValue)) {
			// done with current folder
		} else {
			return;
		}
		folderName = textValue;
		// create a new folder
		// Add a Folder to the Document
		currentFolder = KmlFactory.eINSTANCE.createFolder();
		currentFolder.setName(folderName);
		// folder.setDescription("The first folder");
		EStructuralFeature f = KmlPackage.eINSTANCE.getDocumentRoot_Folder();
		document.getAbstractFeatureGroupGroup().add(f, currentFolder);
	}

	private void handleDetailText(String textValue) {

		Tag t = columnMap.get(currentColumn);
		if (t == null) {
			logger.log(Level.FINE, "Unknown Tag, column " + currentColumn
					+ " value=" + textValue);
			return;
		}
		switch (t) {
		case PLACEMARK:
			placemarkName = textValue;
			logger.log(Level.FINE, "Placemark, column " + currentColumn
					+ " value=" + textValue);
			break;
		case PLACEMARKID:
			placemarkID = textValue;
			logger.log(Level.FINE, "PlacemarkID, column " + currentColumn
					+ " value=" + textValue);
			break;
		case DESCRIPTION:
			placemarkDescription = textValue;
			logger.log(Level.FINE, "Description, column " + currentColumn
					+ " value=" + textValue);
			break;
		case LONGITUDE:
			longitude = textValue;
			logger.log(Level.FINE, "Longitude, column " + currentColumn
					+ " value=" + textValue);
			break;
		case LATITUDE:
			latitude = textValue;
			logger.log(Level.FINE, "Latitude, column " + currentColumn
					+ " value=" + textValue);
			break;
		case STYLEURL:
			styleURL = textValue;
			logger.log(Level.FINE, "StyleUrl, column " + currentColumn
					+ " value=" + textValue);
			break;

		}

	}

	private void createColumnMap(String textValue) {
		logger.log(Level.FINE, "Header Row Text, column " + currentColumn
				+ " value=" + textValue);
		// Build the columnMapper
		for (Tag t : Tag.values()) {
			if (t.name().equals(textValue.toUpperCase())) {
				columnMap.put(currentColumn, t);
				logger.log(Level.FINE, "Header Column Tag =" + t.name()
						+ ", column " + currentColumn + " value=" + textValue);
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.report.engine.emitter.IContentEmitter#startData(org.
	 * eclipse.birt.report.engine.content.IDataContent)
	 */
	public void startData(IDataContent data) {
		startText(data);
	}

	private Placemark createPlacemark() {
		Placemark placemark = KmlFactory.eINSTANCE.createPlacemark();
		if (styleURL != null) {
			placemark.setStyleUrl(styleURL);
		}
		EStructuralFeature f = KmlPackage.eINSTANCE.getDocumentRoot_Placemark();
		if (currentFolder != null) {
			currentFolder.getAbstractFeatureGroupGroup().add(f, placemark);
		} else {
			document.getAbstractFeatureGroupGroup().add(f, placemark);
		}
		return placemark;
	}

	private Point createPoint(Placemark placemark) {
		EStructuralFeature documentRootPointFeature = KmlPackage.eINSTANCE
				.getDocumentRoot_Point();
		Point point = KmlFactory.eINSTANCE.createPoint();

		EStructuralFeature f = KmlPackage.eINSTANCE
				.getPlacemark_AbstractGeometryGroupGroup();

		placemark.getAbstractGeometryGroupGroup().add(f,
				FeatureMapUtil.createEntry(documentRootPointFeature, point));
		return point;

	}

}
