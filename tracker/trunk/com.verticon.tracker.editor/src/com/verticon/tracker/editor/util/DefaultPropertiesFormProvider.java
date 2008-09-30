package com.verticon.tracker.editor.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
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
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
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
	
	private IObservableValue statusMessageObservable;

	

	public void setStatusMessageObservable(
			IObservableValue statusMessageObservable) {
		this.statusMessageObservable = statusMessageObservable;
	}

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
			AdapterFactory adapterFactory) {
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
		// get all the IItemPropertyDescriptors for the object
		for (IItemPropertyDescriptor itemPropertyDescriptor : 
			       itemPropertySource.getPropertyDescriptors(object)) {
			//Create a label with the name of the property
			logger.debug("Creating label for property {}",
					itemPropertyDescriptor.getDisplayName(object));
			String categoryName = itemPropertyDescriptor.getCategory(object);
			if(categoryName==null){
				categoryName=itemPropertyDescriptor.getDescription(object);
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
			label.setText(itemPropertyDescriptor.getDisplayName(object));
			{
				GridData gridData = new GridData();
				gridData.verticalAlignment = SWT.FILL;
				gridData.horizontalAlignment = SWT.FILL;
				label.setLayoutData(gridData);
				label.setToolTipText(itemPropertyDescriptor.getDescription(object));
			}

			visualize(object, mp, dataBindingContext, itemPropertyDescriptor,
					categoryName, adapterFactory);

		}
		
		if (statusMessageObservable != null) {
			dataBindingContext
					.bindValue(statusMessageObservable,
							new AggregateValidationStatus(dataBindingContext
									.getBindings(),
									AggregateValidationStatus.MAX_SEVERITY),
							null, null);
		}
		
	}

	/**
	 * @param object
	 * @param mp
	 * @param dataBindingContext
	 * @param itemPropertyDescriptor
	 * @param categoryName
	 */
	private void visualize(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor itemPropertyDescriptor,
			String categoryName, AdapterFactory adapterFactory) {
		
		ControlBuilder builder = ControlBuilderFactory.getInstance(object,
				itemPropertyDescriptor);
		builder.createControl(object, mp.get(categoryName),
				itemPropertyDescriptor, adapterFactory, dataBindingContext);
		
		// Object genericFeature = itemPropertyDescriptor.getFeature(object);

		// if (isSingleValueEReference(object, itemPropertyDescriptor)) {
		//
		// } else
		// if (genericFeature instanceof EStructuralFeature) {
		// visualizeEStructuralFeature(object, mp, dataBindingContext,
		// itemPropertyDescriptor, categoryName,
		// (EStructuralFeature) genericFeature, adapterFactory);
		// }
		// else {
		// // Not a EStructuralFeature
		// logger.error(
		// "Setting up a text widget for a non EStruturalFeature {}",
		// genericFeature);
		// Text text = new Text(mp.get(itemPropertyDescriptor
		// .getCategory(object)), SWT.NONE);
		// {
		// GridData gridData = new GridData();
		// gridData.verticalAlignment = SWT.FILL;
		// gridData.horizontalAlignment = SWT.FILL;
		// text.setLayoutData(gridData);
		// }
		//
		// text.setText("Can not visualize a Non EStructuralFeature");
		// text.setForeground(mp.get(categoryName).getDisplay()
		// .getSystemColor(SWT.COLOR_RED));
		// }
	}

	// /**
	// * This returns the cell editor that will be used to edit the value of
	// this property.
	// * This default implementation determines the type of cell editor from the
	// nature of the structural feature.
	// */
	// public void visualize2(Object object, Map<String, Group> mp,
	// DataBindingContext dataBindingContext,
	// IItemPropertyDescriptor itemPropertyDescriptor, String categoryName)
	// {
	// if (!itemPropertyDescriptor.canSetProperty(object))
	// {
	// // return null;
	// }
	//
	//
	//
	// Object genericFeature = itemPropertyDescriptor.getFeature(object);
	// if (genericFeature instanceof EReference[])
	// {
	// // result = new ExtendedComboBoxCellEditor(
	// // composite,
	// new
	// ArrayList<Object>(itemPropertyDescriptor.getChoiceOfValues(object)),
	// // getEditLabelProvider(),
	// // itemPropertyDescriptor.isSortChoices(object));
	//			
	// visualizeEReference( object, mp,
	// dataBindingContext,
	// itemPropertyDescriptor, categoryName,
	// eReference)
	// }
	// else if (genericFeature instanceof EStructuralFeature)
	// {
	// final EStructuralFeature feature = (EStructuralFeature)genericFeature;
	// final EClassifier eType = feature.getEType();
	// final Collection<?> choiceOfValues =
	// itemPropertyDescriptor.getChoiceOfValues(object);
	// if (choiceOfValues != null)
	// {
	// if (itemPropertyDescriptor.isMany(object))
	// {
	// boolean valid = true;
	// for (Object choice : choiceOfValues)
	// {
	// if (!eType.isInstance(choice))
	// {
	// valid = false;
	// break;
	// }
	// }
	//
	// if (valid)
	// {
	// // final ILabelProvider editLabelProvider = getEditLabelProvider();
	// // result =
	// // new ExtendedDialogCellEditor(composite, editLabelProvider)
	// // {
	// // @Override
	// // protected Object openDialogBox(Control cellEditorWindow)
	// // {
	// // FeatureEditorDialog dialog = new FeatureEditorDialog(
	// // cellEditorWindow.getShell(),
	// // editLabelProvider,
	// // object,
	// // feature.getEType(),
	// // (List<?>)doGetValue(),
	// // getDisplayName(),
	// // new ArrayList<Object>(choiceOfValues),
	// // false,
	// // itemPropertyDescriptor.isSortChoices(object));
	// // dialog.open();
	// // return dialog.getResult();
	// // }
	// // };
	// }
	// }
	//
	// if (result == null)
	// {
	// result =
	// new ExtendedComboBoxCellEditor
	// (composite, new ArrayList<Object>(choiceOfValues),
	// getEditLabelProvider(), itemPropertyDescriptor.isSortChoices(object));
	// }
	// }
	// else if (eType instanceof EDataType)
	// {
	// EDataType eDataType = (EDataType)eType;
	// if (eDataType.isSerializable())
	// {
	// if (itemPropertyDescriptor.isMany(object))
	// {
	// final ILabelProvider editLabelProvider = getEditLabelProvider();
	// result =
	// new ExtendedDialogCellEditor(composite, editLabelProvider)
	// {
	// @Override
	// protected Object openDialogBox(Control cellEditorWindow)
	// {
	// FeatureEditorDialog dialog = new FeatureEditorDialog(
	// cellEditorWindow.getShell(),
	// editLabelProvider,
	// object,
	// feature.getEType(),
	// (List<?>)doGetValue(),
	// getDisplayName(),
	// null,
	// itemPropertyDescriptor.isMultiLine(object),
	// false);
	// dialog.open();
	// return dialog.getResult();
	// }
	// };
	// }
	// else if (eDataType.getInstanceClass() == Boolean.class ||
	// eDataType.getInstanceClass() == Boolean.TYPE)
	// {
	// // result = new ExtendedComboBoxCellEditor(
	// // composite,
	// // Arrays.asList(new Object []{ Boolean.FALSE, Boolean.TRUE }),
	// // getEditLabelProvider(),
	// // itemPropertyDescriptor.isSortChoices(object));
	// }
	// else
	// {
	// // result = createEDataTypeCellEditor(eDataType, composite);
	// }
	// }
	// }
	// }
	//
	// // return result;
	// }

	/**
	 * @param object
	 * @param mp
	 * @param dataBindingContext
	 * @param propertyDescriptor
	 * @param categoryName
	 * @param feature
	 * @deprecated
	 */
	@Deprecated
	private void visualizeEStructuralFeature(Object object,
			Map<String, Group> mp, DataBindingContext dataBindingContext,
			IItemPropertyDescriptor propertyDescriptor, String categoryName,
			EStructuralFeature eStructuralFeature, AdapterFactory adapterFactory) {

		// if (eStructuralFeature instanceof EReference) {
		// visualizeEReferenceArrays(object, mp, dataBindingContext,
		// propertyDescriptor, categoryName,
		// (EReference) eStructuralFeature, adapterFactory);
		//			
		// } else
			
		if (eStructuralFeature instanceof EAttribute) {
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
	 * @deprecated
	 */
	@Deprecated
	private void visualizeEReferenceBase(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor propertyDescriptor, String categoryName,
			EReference eReference, AdapterFactory adapterFactory) {
		// Not an EDataType
		logger.error("Visualizing EReference {}", eReference);
		
		
		
		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		logger.error("For EObject {}", eObject);
		ComboViewer comboViewer = new ComboViewer(mp.get(categoryName),
				SWT.DROP_DOWN);

		// Getting choices may or may not include a null.
		List<Object> choices = new ArrayList<Object>(propertyDescriptor
				.getChoiceOfValues(object));

		// for (Object o : propertyDescriptor.getChoiceOfValues(object)) {
		// if (o != null) {
		// choices.add(o);
		// }
		// }
		//
		// if (choices.isEmpty()) {
		// return;
		// }
		// Object[] choiceArray = choices.toArray();
		

		logger.error("Trying to Visualize PropertyDescription choices {}",
				choices);
		comboViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		// new ArrayContentProvider());
		comboViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		// comboViewer.setInput(choiceArray);

		// ObservableListContentProvider cp = new
		// ObservableListContentProvider();
		//		
		// IObservableMap map = EMFObservables.observeMap(cp.getKnownElements(),
		// eReference.getEOpposite());

		// ObservableMapLabelProvider lp = new ObservableMapLabelProvider(map);

		// comboViewer.setContentProvider(cp);
		// comboViewer.setLabelProvider(lp);
		
		
//		Combo combo = new Combo(mp.get(categoryName), SWT.DROP_DOWN);

		// IObservableList olist = EMFObservables.observeList(eObject,
		// eStructuralFeature)
		
		

		// if (eObject == null)
		// return;
		// ObservableList input = new EObjectObservableList(eObject, eReference
		// .getEOpposite());
		// comboViewer.setInput(input);

		// bind(dataBindingContext, eReference, combo, eObject);

		// logger.debug("Binding {} feature {} to a combo", eObject.getClass()
		// .getSimpleName(), eStructuralFeature.getName());
		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eReference);
		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eReference);
		// // Certain features cannot be updated

		dataBindingContext.bindValue(ViewersObservables
				.observeSingleSelection(comboViewer), EMFEditObservables
				.observeValue(AdapterFactoryEditingDomain
						.getEditingDomainFor(eObject), eObject, eReference),
				tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget
		// IObservableValue validationStatus = new AggregateValidationStatus(
		// dataBindingContext.getBindings(),
		// AggregateValidationStatus.MAX_SEVERITY);
	}

	// private void visualizeEReference(Object object, Map<String, Group> mp,
	// DataBindingContext dataBindingContext,
	// IItemPropertyDescriptor propertyDescriptor, String categoryName,
	// EReference eReference, AdapterFactory adapterFactory) {
	// // Not an EDataType
	// logger.error("Visualizing EReference {}", eReference);
	//		
	// EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
	// logger.error("For EObject {}", eObject);
	// ComboViewer comboViewer = new ComboViewer(mp.get(categoryName),
	// SWT.DROP_DOWN);
	//
	// // IObservableList choices = EMFEditObservables.observeList(
	// // AdapterFactoryEditingDomain.getEditingDomainFor(object),
	// // eObject, eReference.getEOpposite());
	//
	// // logger.error("Trying to Visualize PropertyDescription choices {}",
	// // choices);
	//
	// // // Bind the catalog's lodgings to the combo
	// // 063: IObservableList lodgings = BeansObservables.observeList(Realm
	// // 064: .getDefault(), catalog, "lodgings");
	// // 065: ObservableListContentProvider contentProvider = new
	// // ObservableListContentProvider();
	// // 066:
	// // 067: IObservableMap[] attributeMaps = BeansObservables.observeMaps(
	// // 068: contentProvider.getKnownElements(), Lodging.class,
	// // 069: new String[] { "name" });
	// // 070: listViewer.setContentProvider(contentProvider);
	// // 071: listViewer.setLabelProvider(new ObservableMapLabelProvider(
	// // 072: attributeMaps));
	// // 073: listViewer.setInput(lodgings);
	//
	// List<Object> rawchoices = new ArrayList<Object>();
	// for (Object object2 : propertyDescriptor.getChoiceOfValues(object)) {
	// if (object2 != null) {
	// rawchoices.add(object2);
	// }
	// }
	//
	// if (rawchoices.isEmpty()) {
	// return;
	// }
	//
	// IObservableList comboViewerChoices = Observables
	// .staticObservableList(rawchoices);
	// ObservableListContentProvider contentProvider = new
	// ObservableListContentProvider();
	//
	// IObservableMap[] attributeMaps = EMFObservables.observeMaps(
	// contentProvider.getKnownElements(),
	// new EStructuralFeature[] { eReference.getEOpposite() });
	// comboViewer.setContentProvider(contentProvider);
	// comboViewer.setLabelProvider(new ObservableMapLabelProvider(
	// attributeMaps));
	// comboViewer.setInput(comboViewerChoices);
	//
	//
	// UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
	// .getTargetToModelStrategy(eReference);
	// UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
	// .getModelToTargetStrategy(eReference);
	//		
	// dataBindingContext.bindValue(ViewersObservables
	// .observeSingleSelection(comboViewer), EMFEditObservables
	// .observeValue(AdapterFactoryEditingDomain
	// .getEditingDomainFor(eObject), eObject, eReference),
	// tToMStrategy, // TargetToModel
	// mToTStrategy);// ModelToTarget
	// }

	// Hardcoded with Arrays.
	
	/**
	 * @deprecated
	 */
	@Deprecated
	private void visualizeEReferenceArrays(Object object, Map<String, Group> mp,
			DataBindingContext dataBindingContext,
			IItemPropertyDescriptor propertyDescriptor, String categoryName,
			EReference eReference, AdapterFactory adapterFactory) {
		// Not an EDataType
		logger.error("Visualizing EReference {}", eReference);

		EObject eObject = (EObject) AdapterFactoryEditingDomain.unwrap(object);
		logger.error("For EObject {}", eObject);
		ComboViewer comboViewer = new ComboViewer(mp.get(categoryName),
				SWT.DROP_DOWN);

		// Getting choices may or may not include a null.
		List<Object> choices = new ArrayList<Object>();

		for (Object object2 : propertyDescriptor.getChoiceOfValues(object)) {
			if (object2 != null) {
				choices.add(object2);
			}
		}

		if (choices.isEmpty()) {
			return;
		}
		// Nulls in choices will cause an error

		logger.error("Trying to Visualize PropertyDescription choices {}",
				choices);
		comboViewer.setContentProvider(new ArrayContentProvider());
		// new AdapterFactoryContentProvider(
		// adapterFactory));
		// new ArrayContentProvider());
		comboViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		comboViewer.setInput(choices.toArray());

		UpdateValueStrategy tToMStrategy = UpdateStrategies.INSTANCE
				.getTargetToModelStrategy(eReference);
		UpdateValueStrategy mToTStrategy = UpdateStrategies.INSTANCE
				.getModelToTargetStrategy(eReference);
		// // Certain features cannot be updated

		dataBindingContext.bindValue(ViewersObservables
				.observeSingleSelection(comboViewer), EMFEditObservables
				.observeValue(AdapterFactoryEditingDomain
						.getEditingDomainFor(eObject), eObject, eReference),
				tToMStrategy, // TargetToModel
				mToTStrategy);// ModelToTarget

	}

	/**
	 * @param object
	 * @param mp
	 * @param dataBindingContext
	 * @param propertyDescriptor
	 * @param categoryName
	 * @param feature
	 * @param eAttribute
	 * @deprecated
	 */
	@Deprecated
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
	 * @deprecated
	 */
	@Deprecated
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
		IObservableValue validationStatus = new AggregateValidationStatus(
				dataBindingContext.getBindings(),
				AggregateValidationStatus.MAX_SEVERITY);
		
		
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
	 * @deprecated
	 */
	@Deprecated
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
