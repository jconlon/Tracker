/**
 * 
 */
package com.verticon.tracker.reader;

import org.eclipse.ui.IWorkbenchWizard;

/**
 * Interface for IReader wizards.
 * <p>
 * Clients should implement this interface and include the name of their class
 * in a wizard contributed to the tracker's transaction publisher wizard extension point 
 * (named <code>"com.verticon.tracker.reader.publisherWizards"</code>).
 * For example, the plug-in's XML markup might contain:
 * <pre>
 * &LT;extension point="com.verticon.tracker.reader.publisherWizards"&GT;
 *   &LT;wizard
 *       id="com.example.myplugin.blob"
 *       name="Blob File"
 *       class="com.example.myplugin.BlobFilePublisher"
 *       icon="icons/import_blob_wiz.gif"&GT;
 *     &LT;description&GT;Publish Resources from a BLOB file&LT;/description&GT;
 *   &LT;/wizard&GT;
 * &LT;/extension&GT;
 * </pre>
 * </p>
 *
 * @see org.eclipse.jface.wizard.IWizard
 * @author jconlon
 */
public interface IReaderWizard extends IWorkbenchWizard {

	IReader getReader();
}
