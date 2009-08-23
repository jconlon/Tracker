package com.verticon.ant.utilities.xsl;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * XIncluder will read an XML file, that has elements from the XInclude
 * namespace and follows the W3C XInclude specification
 * (http://www.w3.org/TR/xinclude/). It will output a merged file.
 * 
 * @author Lars Vogel
 * 
 */
public class XIncluder {

	/**
	 * extracXMLFile merges the files referenced by xinclude include elements.
	 * 
	 * @param in
	 *            The full path to the input XML file
	 * @param out
	 *            The full path to the merged XML file
	 * @throws Exception
	 */
	public void extractXMLFile(String in, String out) throws Exception {
		Document document = null;
		File file;

		file = new File(in);
		file.getAbsolutePath();
		file.lastModified();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Make sure we are getting a configuration that is XInclude Aware
		dbf.setAttribute("http://apache.org/xml/features/xinclude", true); //$NON-NLS-1$
		dbf.setXIncludeAware(true);
		dbf.setNamespaceAware(true);

		DocumentBuilder dom = dbf.newDocumentBuilder();
		document = dom.parse(file);

		// ---- Use a XSLT transformer for writing the new XML file ----
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();

		DOMSource source = new DOMSource(document);
		FileOutputStream os = new FileOutputStream(new File(out));
		StreamResult result = new StreamResult(os);
		transformer.transform(source, result);
	}
}