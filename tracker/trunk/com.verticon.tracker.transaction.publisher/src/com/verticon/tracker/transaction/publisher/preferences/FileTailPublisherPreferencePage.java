package com.verticon.tracker.transaction.publisher.preferences;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.verticon.tracker.editor.dialogs.TemplateViewerFilter;
import com.verticon.tracker.editor.dialogs.WSFileFieldEditor;
import com.verticon.tracker.transaction.publisher.TrackerFileTailPublisherPlugin;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class FileTailPublisherPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	private WSFileFieldEditor captureFile;
	private WSFileFieldEditor templateFile;

	public FileTailPublisherPreferencePage() {
		super(GRID);
		setPreferenceStore(TrackerFileTailPublisherPlugin.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		captureFile = new WSFileFieldEditor(
						PreferenceConstants.P_CAPTURE_FILE,
						"&Capture file preference:",
						true,
				 		getFieldEditorParent());
		
	    ViewerFilter viewerFilter = new ViewerFilter(){
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				 IResource resource = null;
			        if (element instanceof IResource) {
			            resource = (IResource) element;
			        } else if (element instanceof IAdaptable) {
			            IAdaptable adaptable = (IAdaptable) element;
			            resource = (IResource) adaptable.getAdapter(IResource.class);
			        }
			        if (resource != null && !resource.isDerived()) {
			        	   if (resource.getType() != IResource.FILE) {
			        		   return true;
			        	   }
			        	   
			            String extension = resource.getFileExtension();
			            if (!extension.equalsIgnoreCase("Tags")) {
			            	return false;
			            }
			        }
			        return true;
			}};
	    captureFile.setViewerFilter(viewerFilter);
		addField(captureFile);	
		
		templateFile = new WSFileFieldEditor(
						PreferenceConstants.P_TEMPLATE_FILE,
						"&Template file preference:",
						true,
				 		getFieldEditorParent());
		templateFile.setViewerFilter(new TemplateViewerFilter());
		addField(templateFile);	
		
		ScaleFieldEditor readInterval = new ScaleFieldEditor(
				PreferenceConstants.P_READ_INTERVAL,
				"Capture File Read &Interval 1 to 60 seconds:",
		 		getFieldEditorParent(),1,60,1, 5);
		
		addField(readInterval);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void checkState() {
		super.checkState();
		if (!isValid()){
			return;
		}
		if ((captureFile.getStringValue().length() <4 || templateFile.getStringValue().length() <4)){
			setErrorMessage("Must select both a capture file and a template file.");
			setValid(false);
		}else{
			setErrorMessage(null);
			setValid(true);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if(event.getProperty().equals(FieldEditor.VALUE)){
			if (event.getSource() == captureFile
					|| event.getSource() == templateFile){
				checkState();
			}
		}
	}
	
	
	
}