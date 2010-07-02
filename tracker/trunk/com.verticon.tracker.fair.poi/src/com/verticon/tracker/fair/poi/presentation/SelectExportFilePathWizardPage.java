/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.fair.poi.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.fair.poi.presentation.ExportXlsWizard.ExportType;

/**
 * The second page of the ExportXlsWizard displays Destination File text fields, 
 * with a browse button to the right.
 */
class SelectExportFilePathWizardPage extends WizardPage
{
  
   private Text destinationFileField;
   private IPath initialSourcePath;
   private ExportType typeToExport;

   public SelectExportFilePathWizardPage() {
      super("selectFilePath");
      setTitle("Select Destination File");
      setDescription(
         "Select the destination for the exported spreadsheet");
   }

   /**
	 * Update the content before becoming visible.
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			typeToExport = ((ExportXlsWizard) getWizard()).getTypeToExport();
			initContents();
		}
		super.setVisible(visible);
	}
	
   /**
    * Creates the top level control for this dialog page under the
    * given parent composite, then calls <code>setControl</code> so
    * that the created control can be accessed via
    * <code>getControl</code>
    * 
    * @param parent the parent composite
    */
   public void createControl(Composite parent) {
      Composite container = new Composite(parent, SWT.NULL);
      final GridLayout gridLayout = new GridLayout();
      gridLayout.numColumns = 3;
      container.setLayout(gridLayout);
      setControl(container);

      final Label label_3 = new Label(container, SWT.NONE);
      final GridData gridData_3 = new GridData();
      gridData_3.horizontalSpan = 3;
      label_3.setLayoutData(gridData_3);
      label_3.setText(
         "Select the file " +
         "into which export data will be placed.");

      final Label label_4 = new Label(container, SWT.NONE);
      final GridData gridData_4 = new GridData();
      gridData_4.horizontalIndent = 20;
      label_4.setLayoutData(gridData_4);
      label_4.setText("Destination File:");

      final GridData gridData_5 = new GridData();
      gridData_5.horizontalAlignment = GridData.FILL;
      gridData_5.grabExcessHorizontalSpace = true;
      destinationFileField =
         new Text(container, SWT.BORDER);
      destinationFileField.addModifyListener(
         new ModifyListener() {
            public void modifyText(ModifyEvent e) {
               updatePageComplete();
            }
         });
      destinationFileField.setLayoutData(gridData_5);

      final Button button_1 =
         new Button(container, SWT.NONE);
      button_1
         .addSelectionListener(new SelectionAdapter() {
         @Override
		public void widgetSelected(SelectionEvent e) {
            browseForDestinationFile();
         }
      });
      button_1.setText("Browse...");

      initContents();
   }

   /**
    * Called by <code>createControl</code> to initialize the receiver's
    * content based upon the cached selection provided by the wizard.
    */
   private void initContents() {
      if (initialSourcePath == null)
         return;
      IPath path = initialSourcePath;
     
      destinationFileField.setText(
         path
            .removeLastSegments(1)
            .append("export-"+typeToExport.name().toLowerCase()+".xls")
            .toString());
      updatePageComplete();
      setMessage(null);
      setErrorMessage(null);
   }
   
   /**
    * Initializes WizardPage
    * @param file
    * @param typeToExport
    */
   protected void init(IFile file, ExportType typeToExport) {
      
      this.typeToExport=typeToExport;
     
      initialSourcePath = file.getLocation();
   }

   /**
    * Update the current page complete state
    * based on the field content.
    */
   private void updatePageComplete() {
      setPageComplete(false);

      IPath destinationLoc = getDestinationLocation();
      if (destinationLoc == null) {
         setMessage(null);
         setErrorMessage(
            "Please specify a file name for the export.");
         return;
      }
     

      if (!destinationLoc.lastSegment().endsWith(".xls")) {
         setErrorMessage(null);
         setMessage(
            "The destination file is typically"
               + " named with an .xls extension",
            WARNING);
         return;
      }

      setPageComplete(true);
      setMessage(null);
      setErrorMessage(null);
   }

 
   
   /**
    * Open a file browser dialog to locate a destination file
    */
   protected void browseForDestinationFile() {
      IPath path = browse(getDestinationLocation(), false);
      if (path == null)
         return;
      IPath rootLoc = ResourcesPlugin.getWorkspace()
         .getRoot().getLocation();
      if (rootLoc.isPrefixOf(path))
         path = path
            .setDevice(null)
            .removeFirstSegments(rootLoc.segmentCount());
      destinationFileField.setText(path.toString());
   }

   /**
    * Open a file dialog for selecting a file
    * 
    * @param path the initially selected file
    * @param mustExist <code>true</code> if the selected
    *           file must already exist, else <code>false</code>
    * @return the newly selected file or <code>null</code>
    */
   private IPath browse(IPath path, boolean mustExist) {
      FileDialog dialog = new FileDialog(getShell(),
            mustExist ? SWT.OPEN : SWT.SAVE);
      if (path != null) {
         if (path.segmentCount() > 1)
            dialog.setFilterPath(path.removeLastSegments(1)
                  .toOSString());
         if (path.segmentCount() > 0)
            dialog.setFileName(path.lastSegment());
      }
      String result = dialog.open();
      if (result == null)
         return null;
      return new Path(result);
   }

   /**
    * Answer the destination file location
    * or <code>null</code> if unspecified
    */
   public IPath getDestinationLocation() {
      String text = destinationFileField.getText().trim();
      if (text.length() == 0)
         return null;
      IPath path = new Path(text);
      if (!path.isAbsolute())
         path = ResourcesPlugin.getWorkspace().getRoot().getLocation()
               .append(path);
      return path;
   }
   
   
}
