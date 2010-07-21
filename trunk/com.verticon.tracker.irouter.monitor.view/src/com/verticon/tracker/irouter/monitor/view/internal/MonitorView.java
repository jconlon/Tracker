package com.verticon.tracker.irouter.monitor.view.internal;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

public class MonitorView extends ViewPart {

	private FormToolkit toolKit = null;
	private ScrolledForm form = null;
	private ManagedForm managedForm = null;
	private final MonitorMasterDetailsBlock block;
	
	public MonitorView() {
		super();
		block = new MonitorMasterDetailsBlock();
	}
	
	

	@Override
	public void createPartControl(Composite parent) {
		toolKit = new FormToolkit(parent.getDisplay());
		form = this.toolKit.createScrolledForm(parent);
		managedForm = new ManagedForm(this.toolKit, this.form);
		
		form.setText("iRouter Monitor");
//		form.setBackgroundImage(ExamplesPlugin.getDefault().getImage(
//				ExamplesPlugin.IMG_FORM_BG));
		block.createContent(managedForm);

	}



	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}



//	@Override
//	public void updated() {
//		this.getSite().getShell().getDisplay().syncExec(
//				  new Runnable() {
//					    public void run(){
//					      viewer.;
//					    }
//					  });
//	}

	

}
