package com.verticon.tracker.editor.dialogs;


import java.io.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

	/**
	 * A field editor for a file path type preference. A standard file 
	 * dialog appears when the user presses the change button.
	 */
	public class WSFileFieldEditor extends StringButtonFieldEditor {
		
		private ViewerFilter viewerFilter = new ViewerFilter(){
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return true;
			}};



	    /**
	     * Creates a new file field editor 
	     */
	    protected WSFileFieldEditor() {
	    }

	    /**
	     * Creates a file field editor.
	     * 
	     * @param name the name of the preference this field editor works on
	     * @param labelText the label text of the field editor
	     * @param parent the parent of the field editor's control
	     */
	    public WSFileFieldEditor(String name, String labelText, Composite parent) {
	        this(name, labelText, false, parent);
	    }

	    /**
	     * Creates a file field editor.
	     * 
	     * @param name the name of the preference this field editor works on
	     * @param labelText the label text of the field editor
	     * @param enforceAbsolute <code>true</code> if the file path
	     *  must be absolute, and <code>false</code> otherwise
	     * @param parent the parent of the field editor's control
	     */
	    public WSFileFieldEditor(String name, String labelText,
	            boolean enforceAbsolute, Composite parent) {
	        init(name, labelText);
	        setErrorMessage(JFaceResources
	                .getString("FileFieldEditor.errorMessage"));//$NON-NLS-1$
	        setChangeButtonText(JFaceResources.getString("openBrowse"));//$NON-NLS-1$
	        setValidateStrategy(VALIDATE_ON_FOCUS_LOST);
	        createControl(parent);
	    }

	    /* (non-Javadoc)
	     * Method declared on StringButtonFieldEditor.
	     * Opens the file chooser dialog and returns the selected file.
	     */
	    protected String changePressed() {
	        File f = new File(getTextControl().getText());
	        if (!f.exists()) {
				f = null;
			}
	        File d = getFile(f);
	        if (d == null) {
				return null;
			}

	        return d.getAbsolutePath();
	    }

	    /* (non-Javadoc)
	     * Method declared on StringFieldEditor.
	     * Checks whether the text input field specifies an existing file.
	     */
	    protected boolean checkState() {

	        String msg = null;

	        String path = getTextControl().getText();
	        if (path != null) {
				path = path.trim();
			} else {
				path = "";//$NON-NLS-1$
			}
	        if (path.length() == 0) {
	            if (!isEmptyStringAllowed()) {
					msg = getErrorMessage();
				}
	        } else {
	        	Path ipath = new Path(path);
	        	IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(ipath);
	        	
	            
	            if (ifile.isAccessible()) {
	                
	            } else {
	            	setErrorMessage("IFile is not accessible");//$NON-NLS-1$
	                msg = getErrorMessage();
	            }
	        }

	        if (msg != null) { // error
	            showErrorMessage(msg);
	            return false;
	        }

	        // OK!
	        clearErrorMessage();
	        return true;
	    }

	    /**
	     * Helper to open the file chooser dialog.
	     * @param startingDirectory the directory to open the dialog on.
	     * @return File The File the user selected or <code>null</code> if they
	     * do not.
	     */
	    private File getFile(File startingDirectory) {
	    	WSFileDialog dialog = new WSFileDialog(getShell(), 
	    			SWT.SINGLE, 
	    			"Select a Resource",
	    			ResourcesPlugin.getWorkspace().getRoot(),
	    			true,
	    			null,
	    			null
	    	
	    	);
	    	dialog.setPatternFilter(viewerFilter);

			if (dialog.open() == Window.CANCEL) {
				return null;
			}

		    IResource resource = dialog.getSingleResult();
			if (resource == null) {
				return null;
			}

			return ((IFile)resource).getFullPath().toFile();
	    }


		public ViewerFilter getViewerFilter() {
			return viewerFilter;
		}

		public void setViewerFilter(ViewerFilter viewerFilter) {
			this.viewerFilter = viewerFilter;
		}
	}
