package com.verticon.tracker.export.wlic.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/**
 * The first page of the ExportWlicWizard, displays message and a potential
 * error message to the user.
 */
public class SelectExportDateRangeWizardPage extends WizardPage
{
  
//   private Text destinationFileField;
   private IPath initialSourcePath;

   public SelectExportDateRangeWizardPage() {
      super("selectFilePath");
      setTitle("Export WLIC Report");
      setDescription(
         "Export the WLIC Report to the exports directory.");
   }

   /**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		if (visible) {
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
         "Enter Finish to Export the WLIC Report.");

//      final Label label_4 = new Label(container, SWT.NONE);
//      final GridData gridData_4 = new GridData();
//      gridData_4.horizontalIndent = 20;
//      label_4.setLayoutData(gridData_4);
//      label_4.setText("Destination File:");
//
//      final GridData gridData_5 = new GridData();
//      gridData_5.horizontalAlignment = GridData.FILL;
//      gridData_5.grabExcessHorizontalSpace = true;
//      destinationFileField =
//         new Text(container, SWT.BORDER);
//      destinationFileField.addModifyListener(
//         new ModifyListener() {
//            public void modifyText(ModifyEvent e) {
//               updatePageComplete();
//            }
//         });
//      destinationFileField.setLayoutData(gridData_5);
//
//      final Button button_1 =
//         new Button(container, SWT.NONE);
//      button_1
//         .addSelectionListener(new SelectionAdapter() {
//         public void widgetSelected(SelectionEvent e) {
//            browseForDestinationFile();
//         }
//      });
//      button_1.setText("Browse...");

      initContents();
   }

   /**
    * Called by <code>createControl</code> to initialize the receiver's
    * content based upon the cached selection provided by the wizard.
    */
   private void initContents() {
      if (initialSourcePath == null)
         return;
//      IPath path = initialSourcePath;
//     
//      destinationFileField.setText(
//         path
//            .removeLastSegments(1)
//            .append("export-"+typeToExport.name().toLowerCase()+".xls")
//            .toString());
      updatePageComplete();
      setMessage(null);
      setErrorMessage(null);
   }
   
   /**
    * Called by the wizard to initialize the receiver's cached selection.
    * @param selection the selection or <code>null</code> if none
    */
   public void init(IFile file) {
      initialSourcePath = file.getLocation();
   }

   /**
    * Update the current page complete state
    * based on the field content.
    */
   private void updatePageComplete() {
      setPageComplete(false);

//      IPath destinationLoc = getDestinationLocation();
//      if (destinationLoc == null) {
//         setMessage(null);
//         setErrorMessage(
//            "Please specify a file name for the export.");
//         return;
//      }
//     
//
//      if (!destinationLoc.lastSegment().endsWith(".xls")) {
//         setErrorMessage(null);
//         setMessage(
//            "The destination file is typically"
//               + " named with an .xls extension",
//            WARNING);
//         return;
//      }

      setPageComplete(true);
      setMessage(null);
      setErrorMessage(null);
   }

 
   
 
   
   
}
