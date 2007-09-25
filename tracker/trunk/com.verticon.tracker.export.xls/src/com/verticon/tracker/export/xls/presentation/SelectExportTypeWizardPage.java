/**
 * 
 */
package com.verticon.tracker.export.xls.presentation;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.verticon.tracker.export.xls.presentation.ExportXlsWizard.ExportType;

/**
 * SelectExportTypeWizardPage is the first page of the ExportXlsWizard 
 * that allows the user to specify
 * the data export type.
 * 
 * @see  SelectExportFilePathWizardPage
 * @see ExportXlsWizard
 * @author jconlon
 * 
 */
public class SelectExportTypeWizardPage extends WizardPage {
	
	
	private ExportXlsWizard wizard;
	private Button[] radios;


	/**
	 * @param pageName
	 */
	public SelectExportTypeWizardPage() {
		super("Select Type");
		setTitle("Select Type of Export");
		setDescription("Select the type of Export Report - Raw, Details, or Summary");

	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public SelectExportTypeWizardPage(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);

	}

	/**
	 * Creates the top level control for this dialog page under the given parent
	 * composite, then calls <code>setControl</code> so that the created
	 * control can be accessed via <code>getControl</code>
	 * 
	 * @param parent
	 *            the parent composite
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns=1;
		container.setLayout(layout);
		setControl(container);
		Listener radioGroup = new Listener () {
		    public void handleEvent (Event event) {
		      Button button = (Button) event.widget;
//		      button.setSelection (true);
		      for (ExportType type : ExportType.values()) {
					if (type.name().equals(button.getText())){
						wizard.setTypeToExport(type);
					}
				}
		    }
		  };
		

		radios = new Button[3];
		radios[0] = new Button(container, SWT.RADIO);
	    radios[0].setSelection(true);
	    radios[0].setText(ExportType.RAW.name());
	    radios[0].setData(ExportType.RAW);
	    radios[0].addListener(SWT.Selection, radioGroup);
	    

	    radios[1] = new Button(container, SWT.RADIO);
	    radios[1].setText(ExportType.SUMMARY.name());
	    radios[1].setData(ExportType.SUMMARY);
	    radios[1].setSelection(true);
	    radios[1].addListener(SWT.Selection, radioGroup);

	    radios[2] = new Button(container, SWT.RADIO);
	    radios[2].setText(ExportType.DETAIL.name());
	    radios[2].setData(ExportType.DETAIL);
	    radios[2].setSelection(false);
	    radios[2].addListener(SWT.Selection, radioGroup);

	}
	
	
	 /**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			wizard = (ExportXlsWizard) getWizard();
			for (Button button : radios) {
				if(button.getData()==wizard.getTypeToExport()){
					button.setSelection(true);
				}else{
					button.setSelection(false);
				}
			}
			
		}
		super.setVisible(visible);
	}

}
