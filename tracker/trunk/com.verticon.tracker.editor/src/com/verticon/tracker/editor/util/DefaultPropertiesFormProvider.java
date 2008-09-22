package com.verticon.tracker.editor.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates databinding based forms for a selection of EObjects. 
 * @author jconlon
 *
 */
public class DefaultPropertiesFormProvider implements IPropertiesFormProvider {
	/**
	 * slf4j Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(DefaultPropertiesFormProvider.class);
	
	public DefaultPropertiesFormProvider() {
		super();
		logger.debug("Constructed");
	}

	private CTabItem item1;
	private WizardPage wizardPage=null;
	
	public void fillProperties(ISelection selection, 
			AdapterFactory adapterFactory,CTabFolder cTabFolder, String nameOfTab){
		logger.debug("filling properties");
		if (item1 != null) {
			logger.debug("Desposing of CTabItem");
			item1.dispose();
			item1 = null;
		}
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			
			item1 = new CTabItem(cTabFolder, SWT.NONE);
			item1.setText(nameOfTab);
			// Create a composite with a two column layout
			Composite composite1 = new Composite(cTabFolder, SWT.NONE);
			composite1.setForeground(cTabFolder.getDisplay().getSystemColor(
					SWT.COLOR_BLUE));
			composite1.setBackground(cTabFolder.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			item1.setControl(composite1);
			{
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				data.horizontalAlignment = SWT.END;
				composite1.setLayoutData(data);

				GridLayout layout = new GridLayout();
				data.horizontalAlignment = SWT.FILL;
				layout.numColumns = 2;
				composite1.setLayout(layout);
			}
			handleSelection(structuredSelection, adapterFactory, composite1);
			cTabFolder.setSelection(item1);
		}else{
			createEmptyCTabItem(cTabFolder, nameOfTab);
		}
	}
	

	/**
	 * @param cTabFolder
	 * @param nameOfTab TODO
	 */
	protected Composite createEmptyCTabItem(CTabFolder cTabFolder, String nameOfTab) {
		
		item1 = new CTabItem(cTabFolder, SWT.NONE);
		item1.setText(nameOfTab);
		//Create a composite with a two column layout
		Composite composite1 = new Composite(cTabFolder, SWT.NONE);
		composite1.setForeground(cTabFolder.getDisplay().getSystemColor(
				SWT.COLOR_BLACK));
		composite1.setBackground(cTabFolder.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		item1.setControl(composite1);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.END;
			composite1.setLayoutData(data);

			GridLayout layout = new GridLayout();
			// GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalAlignment = SWT.FILL;
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 2;
			composite1.setLayout(layout);
		}

		cTabFolder.setSelection(item1);
		return composite1;
	}

	/**
	 * Default only handles the first object selected.
	 * @param structuredSelection
	 * @param adapterFactory
	 * @param composite1
	 */
	protected void handleSelection(IStructuredSelection structuredSelection,
			AdapterFactory adapterFactory, Composite composite1) {
		//Only deal with an IStructuredSelection
		if (structuredSelection.size() == 1) {
			Object object = structuredSelection.getFirstElement();
			createForm(composite1, object, adapterFactory);
		}
	}
	
	/**
	 * @param parent
	 * @param object
	 */
	protected void createForm(Composite parent, Object object, 
			AdapterFactory adapterFactory){
		Map<String, Group> mp = new HashMap<String, Group>();
		
		IItemPropertySource itemPropertySource = 
			(IItemPropertySource)adapterFactory.adapt(object, 
					IItemPropertySource.class);
		//Create the databinding context
		DataBindingContext dataBindingContext = new EMFDataBindingContext();
		if(wizardPage!=null){
			WizardPageSupport.create(wizardPage, dataBindingContext);
		}

		
		//IItemProperySource is already set
		//get all the IItemPropertyDescriptor for the object
		for (IItemPropertyDescriptor propertyDescriptor : 
			       itemPropertySource.getPropertyDescriptors(object)) {
			//Create a label with the name of the property
			logger.debug("Creating label for property {}",
					propertyDescriptor.getDisplayName(object));
			String categoryName = propertyDescriptor.getCategory(object);
			if(categoryName==null){
				categoryName=propertyDescriptor.getDescription(object);
			}
			if(!mp.containsKey(categoryName)){
				Group group = new Group(parent, SWT.BORDER);
				group.setText(categoryName);
				GridLayout layout = new GridLayout();
				layout.marginHeight = 0;
				layout.marginWidth = 0;
				layout.numColumns = 2;
				group.setLayout(layout);
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				group.setLayoutData(data);
				
				mp.put(categoryName, group);
			}
			
			Label label = new Label(
					mp.get(categoryName), 
					SWT.NONE);
			label.setForeground(parent.getDisplay().getSystemColor(
					SWT.COLOR_BLUE));
			label.setBackground(parent.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			label.setText(propertyDescriptor.getDisplayName(object));
			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				label.setLayoutData(gridData);
			}

			Object feature = propertyDescriptor.getFeature(object);
			
			if (feature instanceof EStructuralFeature) {
				visualizeEStructuralFeature(object, mp, dataBindingContext,
						propertyDescriptor, categoryName,
						(EStructuralFeature) feature);
			} else {
				//Not a EStructuralFeature
				logger
						.error(
								"Setting up a text widget for a non EStruturalFeature {}",
								feature);
				Text text = new Text(mp.get(propertyDescriptor.getCategory(object)), SWT.NONE);
				{
					GridData gridData = new GridData();
					gridData.verticalAlignment = SWT.FILL;
					gridData.horizontalAlignment = SWT.FILL;
					text.setLayoutData(gridData);
				}
				
				text.setText("Can not visualize a Non EStructuralFeature");
				text.setForeground(mp.get(categoryName).getDisplay()
						.getSystemColor(SWT.COLOR_RED));
			}

		}
	}


	/**
	 * @param object
	 * @param mp
	 * @param dataBindingContext
	 * @param propertyDescriptor
	 * @param categoryName
	 * @param feature
	 */
	private void visualizeEStructuralFeature(Object object,
			Map<String, Group> mp, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor propertyDescriptor, String categoryName,
			EStructuralFeature eStructuralFeature) {
		
		if (eStructuralFeature instanceof EReference) {
			visualizeEReference(object, mp, dataBindingContext,
					propertyDescriptor, categoryName,
					(EReference) eStructuralFeature);
			
		} else if (eStructuralFeature instanceof EAttribute) {
			visualizeEAttribute(object, mp, dataBindingContext,
					propertyDescriptor, categoryName,
					(EAttribute) eStructuralFeature);
		
		} else {
			// Not an EDataType
			logger
					.error("Could Not VISUALIZE EStructuralFeature {}",
							eStructuralFeature);

			Text text = new Text(mp.get(categoryName), SWT.NONE);
			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				text.setLayoutData(gridData);
			}
			text.setText("Could Not VISUALIZE for a Non EDataType");
			text.setForeground(mp.get(categoryName).getDisplay()
					.getSystemColor(SWT.COLOR_RED));

		}
	}

	/**
	 * TODO Implement Binding for an EReference
	 * 
	 * @param mp
	 * @param categoryName
	 * @param feature
	 */
	private void visualizeEReference(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor propertyDescriptor, String categoryName,
			EReference eReference) {
		// Not an EDataType
		logger.error("Visualizing EReference {}", eReference);

		Combo combo = new Combo(mp.get(categoryName), SWT.DROP_DOWN);
		// Text text = new Text(mp.get(categoryName), SWT.NONE);
		// {
		// GridData gridData = new GridData();
		// gridData.verticalAlignment = SWT.FILL;
		// gridData.horizontalAlignment = SWT.FILL;
		// text.setLayoutData(gridData);
		// }

		combo.add("Test");
		combo.setBackground(mp.get(categoryName).getDisplay().getSystemColor(
				SWT.COLOR_RED));
		
		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);

		bind(dataBindingContext, eReference, combo, eObject);
	}

	/**
	 * @param object
	 * @param mp
	 * @param dataBindingContext
	 * @param propertyDescriptor
	 * @param categoryName
	 * @param feature
	 * @param eAttribute
	 */
	private void visualizeEAttribute(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor propertyDescriptor, String categoryName,
			EAttribute eAttribute) {
		if (!eAttribute.isMany()) {
			logger
					.debug(
							"Using a text widget for unary attribute {} because it is NOT an isMany EDataType",
							eAttribute);

			boolean canSetProperty = propertyDescriptor.canSetProperty(object);
			Text text = null;
			EDataType type = eAttribute.getEAttributeType();
			
			if (canSetProperty && type == EcorePackage.Literals.EBOOLEAN) {
				Button button = new Button(mp.get(categoryName), SWT.CHECK);
				// Combo combo = new Combo(mp.get(categoryName), SWT.DROP_DOWN);
				// combo.add("true");
				// combo.add("false");
				EObject eObject = (EObject) AdapterFactoryEditingDomain
						.unwrap(object);

				bind(dataBindingContext, eAttribute, button, eObject);
				return;

			} else if (canSetProperty && (type instanceof EEnum)) {
				Combo combo = new Combo(mp.get(categoryName), SWT.DROP_DOWN);
				
				EEnum enummer = (EEnum) type;
				for (EEnumLiteral lit : enummer.getELiterals()) {
					combo.add(lit.getLiteral());
				}
				
				EObject eObject = (EObject) AdapterFactoryEditingDomain
						.unwrap(object);

				bind(dataBindingContext, eAttribute, combo, eObject);
				return;
			} else if (canSetProperty && !eAttribute.isDerived()) {
				text = new Text(mp.get(categoryName), SWT.BORDER | SWT.None);
			} else {
				text = new Text(mp.get(categoryName), SWT.BORDER
						| SWT.READ_ONLY);
				text.setEnabled(false);
			}

			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				gridData.grabExcessHorizontalSpace = true;
				text.setLayoutData(gridData);
			}

			EObject eObject = (EObject) AdapterFactoryEditingDomain
					.unwrap(object);

			bind(dataBindingContext, eAttribute, text, eObject);

		} else {
			// EDataType
			logger
					.error(
							"Setting up a blank text widget for {} because it is an isMany EDataType",
							eAttribute);

			Text text = new Text(mp.get(categoryName), SWT.NONE);
			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				text.setLayoutData(gridData);
			}
			text.setText("Could Not VISUALIZE MULTIVALUE");
			text.setForeground(mp.get(categoryName).getDisplay()
					.getSystemColor(SWT.COLOR_RED));
		}
	}

	 /**
	 * @param dataBindingContext
	 * @param eStructuralFeature
	 * @param text
	 * @param eObject
	 */
	protected void bind(DataBindingContext dataBindingContext,
			EStructuralFeature eStructuralFeature, Text text, EObject eObject) {
		logger.debug("Binding {} feature {} to a text widget", eObject
				.getClass().getSimpleName(), eStructuralFeature.getName());
		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eStructuralFeature);
		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eStructuralFeature);
		// Certain features cannot be updated
		dataBindingContext.bindValue(SWTObservables.observeText(text,
				SWT.Modify), EMFEditObservables.observeValue(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject),
				eObject, eStructuralFeature), tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget
	}

	// /**
	// * @param dataBindingContext
	// * @param eStructuralFeature
	// * @param combo
	// * @param eObject
	// */
	// protected void bind(DataBindingContext dataBindingContext,
	// EStructuralFeature eStructuralFeature, Combo combo, EObject eObject) {
	// logger.debug("Binding {} feature {} to a combo widget", eObject
	// .getClass().getSimpleName(), eStructuralFeature.getName());
	//		
	// UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
	// .getTargetToModelStrategy(eStructuralFeature);
	//		
	// UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
	// .getModelToTargetStrategy(eStructuralFeature);
	//
	// // Certain features cannot be updated
	// dataBindingContext.bindValue(SWTObservables.observeSelection(combo),
	// EMFEditObservables.observeValue(
	// AdapterFactoryEditingDomain.getEditingDomainFor(eObject),
	// eObject, eStructuralFeature), tToMStrategy, // TargetToModel
	// mToTStrategy);// ModelToTarget
	// }

	/**
	 * @param dataBindingContext
	 * @param eStructuralFeature
	 * @param button
	 * @param eObject
	 */
	protected void bind(DataBindingContext dataBindingContext,
			EStructuralFeature eStructuralFeature, Control control,
			EObject eObject) {
		logger.debug("Binding {} feature {} to a combo widget", eObject
				.getClass().getSimpleName(), eStructuralFeature.getName());
		
		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eStructuralFeature);
		
		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eStructuralFeature);

		// Certain features cannot be updated
		dataBindingContext.bindValue(SWTObservables.observeSelection(control),
				EMFEditObservables.observeValue(
				AdapterFactoryEditingDomain.getEditingDomainFor(eObject),
				eObject, eStructuralFeature), tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget
	}
	


	public WizardPage getWizardPage() {
		return wizardPage;
	}

	public void setWizardPage(WizardPage wizardPage) {
		this.wizardPage = wizardPage;
	}
}
