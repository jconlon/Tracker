package com.verticon.osgi.metatype.core.model.editor.internal.forms;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.verticon.osgi.metatype.Designate;
import com.verticon.osgi.metatype.MetatypePackage;


public class DesignateDetailsPage implements IDetailsPage {

	private static final String DEFAULT_DESCRIPTION = "Properties of the selected Factory.";
	protected IManagedForm mform;
	protected DataBindingContext ctx;
	protected final IObservableValue masterDesignate;
	protected final EditingDomain editingDomain;
	protected final IObservableValue masterOCD;
	protected Section section;
	

	 DesignateDetailsPage(IObservableValue masterDesignate,IObservableValue masterOCD, EditingDomain editingDomain) {
		super();
		this.masterDesignate = masterDesignate;
		this.editingDomain = editingDomain;
		this.masterOCD = masterOCD;
	}

	static DesignateDetailsPage instance(IObservableValue masterDesignate, IObservableValue masterOCD, EditingDomain editingDomain) {
		return new DesignateDetailsPage(masterDesignate, masterOCD, editingDomain);
	}

	
	@Override
	public void initialize(IManagedForm form) {
		this.mform = form;
	}

	@Override
	public void createContents(Composite parent) {
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		layout.numColumns = 1;
		parent.setLayout(layout);
		
		// To handle EMF conversion strategies
		ctx = new EMFDataBindingContext();
		// Fix for bug 278301
		Utils.masterDetailFixup(ctx, masterDesignate);
		FormToolkit toolkit = mform.getToolkit();
		
		section = toolkit.createSection(parent,Section.DESCRIPTION|Section.TITLE_BAR|Section.TWISTIE|Section.EXPANDED);
		Composite sectionClient = createFactoryPropertiesSection(toolkit,
				section);
		section.setClient(sectionClient);
		
	}

	protected String getNameOfForm() {
		return "Factory Properties";
	}
	
	protected boolean showFactoryPid(){
		return false;
	}
	
	private Composite createFactoryPropertiesSection(FormToolkit toolkit,
			Section section) {
		section.marginWidth = 10;
		TableWrapData td = new TableWrapData(TableWrapData.FILL,
							TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);
	    section.setText(getNameOfForm());
	    section.setDescription(DEFAULT_DESCRIPTION);
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout(3, false));
		
		//Name
		IEMFValueProperty nameProp = EMFEditProperties.value(editingDomain,
				MetatypePackage.Literals.OCD__NAME);
		toolkit.createLabel(sectionClient, "Name:");
		Text tName = toolkit.createText(sectionClient, "", SWT.READ_ONLY);
		tName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		ctx.bindValue(SWTObservables.observeText(tName), nameProp
				.observeDetail(masterOCD));
		
		 // ID
		IEMFValueProperty idProp = EMFEditProperties.value(
				editingDomain, MetatypePackage.Literals.OCD__ID);
		Label id = toolkit.createLabel(sectionClient, "ID:");
		id.setToolTipText("ID of the ObjectClassDefinition");
		Text tId = toolkit.createText(sectionClient, "", SWT.READ_ONLY);
		tId.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		ctx.bindValue(SWTObservables.observeText(tId), idProp
				.observeDetail(masterOCD));
		
		//Pid
		IEMFValueProperty pidProp = EMFEditProperties.value(editingDomain,
				MetatypePackage.Literals.DESIGNATE__PID);
		Label pid = toolkit.createLabel(sectionClient, "PID:");
		pid.setToolTipText("Process ID");
		Text tPid = toolkit.createText(sectionClient, "", SWT.READ_ONLY);
		tPid.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		ctx.bindValue(SWTObservables.observeText(tPid), pidProp
				.observeDetail(masterDesignate));
		
		if(showFactoryPid()){
			//FPid
			IEMFValueProperty fpidProp = EMFEditProperties.value(editingDomain,
					MetatypePackage.Literals.DESIGNATE__FACTORY_PID);
			Label fpid = toolkit.createLabel(sectionClient, "Factory PID:");
			fpid.setToolTipText("Process ID of the Factory that created this component");
			Text tfPid = toolkit.createText(sectionClient, "", SWT.READ_ONLY);
			tfPid.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
					1));
			ctx.bindValue(SWTObservables.observeText(tfPid), fpidProp
					.observeDetail(masterDesignate));
		}
		 // Location
		IEMFValueProperty bundleProp = EMFEditProperties.value(
				editingDomain, MetatypePackage.Literals.DESIGNATE__BUNDLE);
		Label location = toolkit.createLabel(sectionClient, "Bundle Location:");
		location.setToolTipText("Location of the configuration data");
		Text tBundle = toolkit.createText(sectionClient, "", SWT.READ_ONLY);
		tBundle.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
		1));
		ctx.bindValue(SWTObservables.observeText(tBundle), bundleProp
				.observeDetail(masterDesignate));
	
		 // Merge
		IEMFValueProperty mergeProp = EMFEditProperties.value(
				editingDomain, MetatypePackage.Literals.DESIGNATE__MERGE);
		Label merge = toolkit.createLabel(sectionClient, "Merge:");
		merge.setToolTipText("Whether configuration properties should be merged.");
		Text tMerge = toolkit.createText(sectionClient, "", SWT.READ_ONLY);
		tMerge.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		ctx.bindValue(SWTObservables.observeText(tMerge), mergeProp
				.observeDetail(masterDesignate));
		return sectionClient;
	}

	
	
	

	
	@Override
	public void commit(boolean onSave) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		ctx.dispose();
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStale() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh() {
		// update();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setFormInput(Object input) {
		return false;
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		StructuredSelection select = (StructuredSelection)selection;
		Designate designate = (Designate) select.getFirstElement();
		String description;
		try {
			description = Utils.getDescription(designate, Utils.getMetaData(editingDomain));
		} catch (ConfigurationException e) {
			description="Configuration Problem: "+e.getMessage();
		}
		section.setDescription(description);
	}

}
