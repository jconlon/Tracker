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
/**
 * 
 */
package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.verticon.tracker.trigger.view.views.Column.COMMENTS;
import static com.verticon.tracker.trigger.view.views.Column.FILE;
import static com.verticon.tracker.trigger.view.views.Column.LOT;
import static com.verticon.tracker.trigger.view.views.Column.NAME;
import static com.verticon.tracker.trigger.view.views.Column.PRINTER;
import static com.verticon.tracker.trigger.view.views.Column.REQUIRE_LOT;
import static com.verticon.tracker.trigger.view.views.Column.REQUIRE_VALUES;
import static com.verticon.tracker.trigger.view.views.Column.STATUS;
import static com.verticon.tracker.trigger.view.views.Column.VALUES;

import java.io.File;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.handlers.AddTriggerAction;
import com.verticon.tracker.trigger.view.handlers.CreateTriggerFileAction;
import com.verticon.tracker.trigger.view.handlers.RemoveTriggerAction;
import com.verticon.tracker.trigger.view.handlers.SetTriggerAction;

/**
 * View that allows an administrator to manage and an user to utilize multiple
 * alternative ways to specify Trigger file output values.
 * 
 * This view presents a table of Trigger file configurations that can be set on
 * active iRouter Measurement Trigger File services.
 * 
 * This is a user facing way to configure the iRouter Measurement Trigger File
 * Measurement Value Format attribute.
 * 
 * @author jconlon
 * 
 */
public class TriggerViewPart extends ViewPart {

	private static final String TRIGGER_CONFIGURATION_FORM_NAME_FORMAT = "%s Trigger Configuration Form";
	private static final String PRINT_A_TRIGGER_FILE = "Print a Trigger File";
	private static final String PRINT = "Print";
	private static final String SET_ENTRY_BUTTON = "Set Trigger";
	static final String SET_SELECTED_ENTRY_TOOLTIP = "Set Trigger on the iRouter Measurement Service";
	private static ImageDescriptor PRINTER_IMG = TriggerViewPlugin
			.getImageDescriptor(
"icons/printview_tsk.gif");

	private TriggerViewer triggerViewer;
	private RemoveTriggerAction removeTriggerAction;
	private AddTriggerAction addTriggerAction;
	private SetTriggerAction setTriggerAction;
	private CreateTriggerFileAction createTriggerFileAction;
	private FormToolkit toolkit;
	private Form form;
	private ISelectionChangedListener listener = null;
	private Text searchText;
	private final WritableValue selectedTrigger = new WritableValue();
	private final DataBindingContext ctx = new DataBindingContext();
	private Button setTriggerButton;
	private Button createTriggerFileButton;

	public TriggerViewPart() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {

		createControls(parent);

		createActions();

		createToolbarButtons();

		hookGlobalActions();

		// Get the validation status provides
		IObservableList bindings = ctx.getValidationStatusProviders();

		IChangeListener changeValidator = new IChangeListener() {

			@Override
			public void handleChange(ChangeEvent event) {
				validate();
			}
		};

		// Register the listener to all bindings
		for (Object o : bindings) {
			Binding b = (Binding) o;
			// For persisting changes
			b.getTarget().addChangeListener(triggerViewer.getViewModel());
			// For validating changes
			b.getTarget().addChangeListener(changeValidator);
		}

	}

	private Control createMasterPartControl(final SashForm parent) {
		final Composite master = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(3, false);
		master.setLayout(layout);

		Label searchLabel = new Label(master, SWT.NONE);
		searchLabel.setText("Search: ");
		searchText = new Text(master, SWT.BORDER | SWT.SEARCH);

		GridData gd = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = 2;
		searchText.setLayoutData(gd);

		final TriggerFilter filter = new TriggerFilter();

		triggerViewer = new TriggerViewer(master);
		// New to support the search
		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(searchText.getText());
				triggerViewer.refresh();
			}

		});

		triggerViewer.setFilter(filter);
		return master;

	}

	private void writeFormTitle(Object name) {
		form.setText(String.format(TRIGGER_CONFIGURATION_FORM_NAME_FORMAT,
				name == null ? "" : name));
	}

	private Control createFormPartControl(Composite parent) {

		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createForm(parent);
		writeFormTitle(null);

		toolkit.decorateFormHeading(form);
		// form.setHeadClient(toolkit.createButton(form.getHead(),
		// "This is the head client", SWT.PUSH)); // NEW LINE
		// form.getToolBarManager().add(new Action("This is the toolbar") {
		// });
		form.getToolBarManager().update(true);
		form.setToolBarVerticalAlignment(SWT.BOTTOM);

		// form.addMessageHyperlinkListener(new HyperlinkAdapter());
		// form.setMessage("This is an error message", IMessageProvider.ERROR);

		// form.getMenuManager().add(new Action("This is the menu") {
		// });

		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = 4;
		form.getBody().setLayout(layout);

		TableWrapData td;

		// link.setLayoutData(td);

		// NAME in the Form Title
		IObservableValue model = BeanProperties.value(NAME.property)
				.observeDetail(selectedTrigger);

		// DETAILS SECTION
		final Section detailSection = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.TWISTIE);
		detailSection.setVisible(false);// initally invisible

		model.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				writeFormTitle(event.getObservableValue().getValue());
				detailSection.setVisible(true);
			}
		});

		td = new TableWrapData(TableWrapData.FILL);
		td.colspan = 4;
		detailSection.setLayoutData(td);
		detailSection.setText("Details");
		GridLayout glayout = new GridLayout();
		glayout.numColumns = 1;
		glayout.marginWidth = 2;
		glayout.marginHeight = 2;
		detailSection.setLayout(glayout);

		Composite client = toolkit.createComposite(detailSection, SWT.WRAP);
		layout = new TableWrapLayout();
		layout.numColumns = 4;
		client.setLayout(layout);

		toolkit.createLabel(client, "File:");
		Text fileText = toolkit
				.createText(client, "", SWT.NULL | SWT.READ_ONLY);
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 3;
		fileText.setLayoutData(td);
		IObservableValue fileTarget = WidgetProperties.text(SWT.Modify)
				.observe(fileText);
		model = BeanProperties.value(FILE.property).observeDetail(
				selectedTrigger);

		UpdateValueStrategy modelToTarget = new UpdateValueStrategy();
		modelToTarget.setConverter(new Converter(File.class, String.class) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.core.databinding.conversion.IConverter#convert(java
			 * .lang.Object)
			 */
			@Override
			public Object convert(Object fromObject) {
				if (fromObject != null && fromObject instanceof File) {
					File b = (File) fromObject;
					return b.toString();
				}

				return null;
			}
		});

		ctx.bindValue(fileTarget, model,//
				null,// targetToModel
				modelToTarget);

		// Printer
		toolkit.createLabel(client, "Printer:");
		Text printerText = toolkit.createText(client, "", SWT.NULL
				| SWT.READ_ONLY);
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 3;
		printerText.setLayoutData(td);
		IObservableValue printerTarget = WidgetProperties.text(SWT.Modify)
				.observe(printerText);
		model = BeanProperties.value(PRINTER.property).observeDetail(
				selectedTrigger);
		ctx.bindValue(printerTarget, model);

		// Comments
		toolkit.createLabel(client, "Comments:");
		Text commentsText = toolkit.createText(client, "", SWT.NULL
				| SWT.READ_ONLY);
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 3;
		commentsText.setLayoutData(td);
		IObservableValue commentsTarget = WidgetProperties.text(SWT.Modify)
				.observe(commentsText);
		model = BeanProperties.value(COMMENTS.property).observeDetail(
				selectedTrigger);
		ctx.bindValue(commentsTarget, model);

		detailSection.setClient(client);// END

		// Required Lot - this is invisible but necessary to trigger persistence
		// @HACK
		Text requiredLot = toolkit.createText(form.getBody(), "", SWT.NULL
				| SWT.READ_ONLY);
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 4;
		requiredLot.setLayoutData(td);
		IObservableValue requiredLotTarget = WidgetProperties.text(SWT.Modify)
				.observe(requiredLot);
		IObservableValue requireLotModel = BeanProperties.value(
				REQUIRE_LOT.property).observeDetail(selectedTrigger);
		modelToTarget = new UpdateValueStrategy();
		modelToTarget.setConverter(new Converter(Boolean.class, String.class) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.core.databinding.conversion.IConverter#convert(java
			 * .lang.Object)
			 */
			@Override
			public Object convert(Object fromObject) {
				if (fromObject != null && fromObject instanceof Boolean) {
					Boolean b = (Boolean) fromObject;
					if (b) {
						return "";
					}
					// return "A Lot is not required for this trigger.";
					return "";
				}

				return null;
			}
		});

		ctx.bindValue(requiredLotTarget, requireLotModel, null, modelToTarget);

		// Section LOT
		HyperlinkGroup group = new HyperlinkGroup(parent.getDisplay());

		final Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR);// | Section.TWISTIE);
		section.setVisible(false);// initally invisible
		td = new TableWrapData(TableWrapData.FILL);
		td.colspan = 4;
		section.setLayoutData(td);
		section.setText("Lot");
		section.setDescription("Specify the Lot number here.");
		glayout = new GridLayout();
		glayout.numColumns = 1;
		glayout.marginWidth = 2;
		glayout.marginHeight = 2;
		section.setLayout(glayout);

		client = toolkit.createComposite(section, SWT.WRAP);
		layout = new TableWrapLayout();
		layout.numColumns = 4;
		client.setLayout(layout);
		// Lot
		final Hyperlink lotLink = new Hyperlink(client, SWT.NONE);
		lotLink.setBackground(form.getBackground());
		lotLink.setText("Change Lot");
		final Text lotText = toolkit.createText(client, "", SWT.BORDER
				| SWT.READ_ONLY);
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 2;
		lotText.setLayoutData(td);
		toolkit.createLabel(client, "");// blank label to fill

		group.add(lotLink);
		section.setClient(client);

		// td = new TableWrapData(TableWrapData.FILL);
		// td.grabHorizontal = true;
		// td.colspan = 4;
		// lotLink.setLayoutData(td);
		lotLink.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				WizardDialog dialog = new WizardDialog(lotLink.getShell(),
						new LotWizard(lotText));
				dialog.open();
				triggerViewer.refresh();
			}
		});

		IObservableValue lotTarget = WidgetProperties.text(SWT.Modify).observe(
				lotText);
		model = BeanProperties.value(LOT.property).observeDetail(
				selectedTrigger);
		ctx.bindValue(lotTarget, model);

		// Hide or show Lot based on requireLot
		requireLotModel.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				Boolean visible = (Boolean) event.getObservableValue()
						.getValue();
				section.setVisible(visible);

			}
		});

		// SECTION VALUES
		final Section valuesSection = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR);// | Section.TWISTIE);
		valuesSection.setVisible(false);
		td = new TableWrapData(TableWrapData.FILL);
		td.colspan = 4;
		valuesSection.setLayoutData(td);
		valuesSection.setText("Required Values");
		valuesSection.setDescription("Specify the Required Values here.");
		glayout = new GridLayout();
		glayout.numColumns = 1;
		glayout.marginWidth = 2;
		glayout.marginHeight = 2;
		valuesSection.setLayout(glayout);

		client = toolkit.createComposite(valuesSection, SWT.WRAP);
		layout = new TableWrapLayout();
		layout.numColumns = 4;
		client.setLayout(layout);
		// Required Values
		toolkit.createLabel(client, "Required Values:");

		final Text requiredValuesText = toolkit.createText(client, "",
				SWT.BORDER | SWT.READ_ONLY);
		requiredValuesText
				.setToolTipText("These are the names of the required values.");
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 3;
		requiredValuesText.setLayoutData(td);
		IObservableValue requiredValuesTarget = WidgetProperties.text(
				SWT.Modify).observe(requiredValuesText);
		IObservableValue requiredValuesmodel = BeanProperties.value(
				REQUIRE_VALUES.property).observeDetail(selectedTrigger);
		ctx.bindValue(requiredValuesTarget, requiredValuesmodel);

		// Values
		final Hyperlink valuesLink = new Hyperlink(client, SWT.NONE);
		valuesLink.setBackground(form.getBackground());
		valuesLink.setText("Change Values");
		final Text valuesText = toolkit.createText(client, "", SWT.BORDER
				| SWT.READ_ONLY);
		td = new TableWrapData(TableWrapData.FILL);
		td.grabHorizontal = true;
		td.colspan = 3;
		valuesText.setLayoutData(td);

		valuesLink.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				ITriggerEntry entry = (ITriggerEntry) ((IStructuredSelection) triggerViewer
						.getSelection()).getFirstElement();
				ValuesDialog dialog = new ValuesDialog(form.getShell(), entry);
				dialog.create();
				if (dialog.open() == Window.OK) {
					valuesText.setText(dialog.getValues());
					triggerViewer.refresh();

				}
			}
		});
		group.add(valuesLink);
		IObservableValue valuesTarget = WidgetProperties.text(SWT.Modify)
				.observe(valuesText);
		model = BeanProperties.value(VALUES.property).observeDetail(
				selectedTrigger);
		ctx.bindValue(valuesTarget, model);

		// Hide or show Values based on requireValues
		model = BeanProperties.value(REQUIRE_VALUES.property).observeDetail(
				selectedTrigger);

		requiredValuesmodel.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				String requiredValues = (String) event.getObservableValue()
						.getValue();
				boolean isRequiredValues = !isNullOrEmpty(requiredValues);
				// requiredValuesLabel.setVisible(isRequiredValues);
				// requiredValuesText.setVisible(isRequiredValues);
				if (isRequiredValues) {
					Iterable<String> split = Splitter.on(',').trimResults()
							.split(requiredValues);
					int count = Iterables.size(split);
					requiredValuesText.setToolTipText(String.format(
							"These are the names of the %s values.", count));
				}

				valuesSection.setVisible(isRequiredValues);
			}
		});
		valuesSection.setClient(client);
		IObservableValue statusmodel = BeanProperties.value(STATUS.property)
				.observeDetail(selectedTrigger);
		statusmodel.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				String status = (String) event.getObservableValue().getValue();
				if (isNullOrEmpty(status)) {

					if (status.contains("OK")) {
						form.setMessage(status, IMessageProvider.INFORMATION);
					} else {
						form.setMessage(status, IMessageProvider.INFORMATION);
					}
				}

			}
		});

		return form;
	}

	private void updateFormMessages() throws AssertionError {

		IStatus status = currentStatus;

		int type;
		switch (status.getSeverity()) {
		case IStatus.OK:
			type = IMessageProvider.NONE;
			break;
		case IStatus.CANCEL:
			type = IMessageProvider.NONE;
			break;
		case IStatus.INFO:
			type = IMessageProvider.INFORMATION;
			break;
		case IStatus.WARNING:
			type = IMessageProvider.WARNING;
			break;
		case IStatus.ERROR:
			type = IMessageProvider.ERROR;
			break;
		default:
			throw new AssertionError("incomplete switch statement"); //$NON-NLS-1$
		}

		form.setMessage(currentStatus.getMessage(), type);
	}

	/**
	 * Creates the main window's contents
	 * 
	 * @param parent
	 *            the parent window
	 */
	private void createControls(Composite parent) {
		// Our layout will have a row of buttons, and
		// then a SashForm below it.
		parent.setLayout(new GridLayout(1, true));
		// parent.setBackground(parent.getDisplay().getSystemColor(
		// SWT.COLOR_DARK_YELLOW));
		// Create the SashForm
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		// sash.setLayoutData(gridData);
		final SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);
		sashForm.setLayoutData(gridData);
		// Change the width of the sashes
		// sashForm.SASH_WIDTH = 20;
		// // Change the color used to paint the sashes
		// sashForm.setBackground(parent.getDisplay().getSystemColor(
		// SWT.COLOR_GREEN));
		sashForm.setOrientation(SWT.VERTICAL);

		final Control adminControl = createMasterPartControl(sashForm);
		final Control formControl = createFormPartControl(sashForm);

		// Set the relative weights for the s
		sashForm.setWeights(new int[] { 1, 2 });

		createBottomButtonBar(parent, sashForm, adminControl, formControl);

		triggerViewer.getTableViewer().addSelectionChangedListener(
				new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						boolean canExecute = canExecuteQuery(event);
						setTriggerButton.setEnabled(canExecute);
						createTriggerFileButton.setEnabled(canExecute);

					}
				});

	}

	private void createBottomButtonBar(Composite parent,
			final SashForm sashForm, final Control adminControl,
			final Control formControl) {
		Composite buttonBar = new Composite(parent, SWT.NONE);
		buttonBar.setLayout(new GridLayout(3, false));
		// buttonBar.setBackground(parent.getDisplay().getSystemColor(
		// SWT.COLOR_BLUE));
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		buttonBar.setLayoutData(gridData);

		createExecutionButtons(buttonBar);
		createWindowsControlButtons(sashForm, adminControl, formControl,
				buttonBar);
	}

	private void createWindowsControlButtons(final SashForm sashForm,
			final Control adminControl, final Control formControl,
			Composite buttonBar) {
		GridData gridData;
		// Windows controls
		Composite widowsControlButtonBar = new Composite(buttonBar,
				SWT.RIGHT_TO_LEFT);
		// widowsControlButtonBar.setBackground(parent.getDisplay()
		// .getSystemColor(SWT.COLOR_GREEN));

		RowLayout layout = new RowLayout();

		// Optionally set layout fields.
		layout.wrap = true;
		widowsControlButtonBar.setLayout(layout);
		// Move it to the left in the parent grid
		gridData = new GridData(GridData.END, GridData.CENTER, false, false);
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;

		widowsControlButtonBar.setLayoutData(gridData);

		Button flip = new Button(widowsControlButtonBar, SWT.PUSH);
		flip.setText("Switch Orientation");
		// Add the Switch Orientation functionality
		flip.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				switch (sashForm.getOrientation()) {
				case SWT.HORIZONTAL:
					sashForm.setOrientation(SWT.VERTICAL);
					break;
				case SWT.VERTICAL:
					sashForm.setOrientation(SWT.HORIZONTAL);
					break;
				}
			}
		});

		Button weights = new Button(widowsControlButtonBar, SWT.PUSH);
		weights.setText("Restore Window Sizes");
		// Add the Restore Weights functionality
		weights.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				sashForm.setWeights(new int[] { 1, 2 });
			}
		});

		Composite composite = new Composite(widowsControlButtonBar, SWT.BORDER);
		composite.setLayout(new RowLayout());

		Button showAdmin = new Button(composite, SWT.RADIO);
		showAdmin.setText("Show Admin");
		showAdmin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				sashForm.setMaximizedControl(adminControl);
			}
		});
		Button showBoth = new Button(composite, SWT.RADIO);
		showBoth.setText("Show Both");
		showBoth.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				sashForm.setMaximizedControl(null);
			}
		});
		Button showForm = new Button(composite, SWT.RADIO);
		showForm.setText("Show Form");
		showForm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				sashForm.setMaximizedControl(formControl);
			}
		});
		showBoth.setSelection(true);
	}

	/**
	 * Add the Set and Test buttons
	 * 
	 * @param executionButtonBar
	 *            the parent composite
	 */
	private void createExecutionButtons(Composite parent) {
		Composite executionButtonBar = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);

		executionButtonBar.setLayoutData(gd);
		RowLayout layout = new RowLayout();
		// Optionally set layout fields.
		layout.wrap = true;
		executionButtonBar.setLayout(layout);
		// executionButtonBar.setBackground(parent.getDisplay().getSystemColor(
		// SWT.COLOR_YELLOW));

		setTriggerButton = new Button(executionButtonBar, SWT.PUSH | SWT.CENTER);

		setTriggerButton.setText(SET_ENTRY_BUTTON);
		setTriggerButton.setToolTipText(SET_SELECTED_ENTRY_TOOLTIP);
		ISharedImages platformImages = PlatformUI.getWorkbench()
				.getSharedImages();
		setTriggerButton.setImage(platformImages.getImageDescriptor(
				ISharedImages.IMG_TOOL_FORWARD).createImage());

		setTriggerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTriggerAction.run();

			}
		});
		setTriggerButton.setEnabled(false);

		createTriggerFileButton = new Button(executionButtonBar, SWT.PUSH
				| SWT.CENTER);

		createTriggerFileButton.setText(PRINT);
		createTriggerFileButton
				.setToolTipText(PRINT_A_TRIGGER_FILE);

		createTriggerFileButton.setImage(PRINTER_IMG.createImage());

		createTriggerFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createTriggerFileAction.run();

			}
		});
		createTriggerFileButton.setEnabled(false);

	}

	/**
	 * Passing the focus request to the triggerViewer's control.
	 */
	@Override
	public void setFocus() {
		triggerViewer.getControl().setFocus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		listener = null;
		ctx.dispose();
		toolkit.dispose();
	}

	public TriggerViewer getViewer() {
		return triggerViewer;
	}

	private IStatus currentStatus;

	private boolean canExecuteQuery(SelectionChangedEvent event) {
		boolean result = false;
		boolean isOnlyOne = ((IStructuredSelection) event.getSelection())
				.size() == 1;
		if (isOnlyOne) {
			ITriggerEntry entry = (ITriggerEntry) ((IStructuredSelection) event
					.getSelection()).getFirstElement();

			validate(entry);

			if (currentStatus.getSeverity() < IStatus.ERROR) {
				result = true;
			}

		}
		return result;
	}

	private void validate(ITriggerEntry entry) {
		currentStatus = entry.validateEntry();
		updateFormMessages();

	}

	private void validate() {
		ITriggerEntry entry = (ITriggerEntry) ((IStructuredSelection) triggerViewer
				.getSelection()).getFirstElement();
		currentStatus = entry.validateEntry();
		updateFormMessages();
	}

	private void updateForm(SelectionChangedEvent event) {

		boolean isOnlyOne = ((IStructuredSelection) event.getSelection())
				.size() == 1;
		if (isOnlyOne) {
			ITriggerEntry entry = (ITriggerEntry) ((IStructuredSelection) event
					.getSelection()).getFirstElement();
			selectedTrigger.setValue(entry);

			validate(entry);
		}

	}

	private void createToolbarButtons() {
		IToolBarManager toolBarMgr = this.getViewSite().getActionBars()
				.getToolBarManager();
		toolBarMgr.add(removeTriggerAction);
		removeTriggerAction.setEnabled(false);

		toolBarMgr.add(addTriggerAction);
		addTriggerAction.setEnabled(true);

		toolBarMgr.add(setTriggerAction);
		setTriggerAction.setEnabled(false);

		toolBarMgr.add(createTriggerFileAction);
		createTriggerFileAction.setEnabled(false);

		if (listener == null) {
			listener = new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					boolean isEmpty = event.getSelection().isEmpty();
					if (isEmpty) {
						removeTriggerAction.setEnabled(false);
						setTriggerAction.setEnabled(false);
						createTriggerFileAction.setEnabled(false);
					} else {
						removeTriggerAction.setEnabled(true);
						boolean canExecute = canExecuteQuery(event);
						setTriggerAction.setEnabled(canExecute);
						createTriggerFileAction.setEnabled(canExecute);

						updateForm(event);
					}

				}
			};
		}
		triggerViewer.addSelectionChangedListener(listener);
	}

	private void createActions() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		ISharedImages platformImages = workbench.getSharedImages();

		addTriggerAction = new AddTriggerAction(triggerViewer, "Add");
		ImageDescriptor plusImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				"org.eclipse.ui", "$nl$/icons/full/obj16/add_obj.gif");

		addTriggerAction.setImageDescriptor(plusImage);
		addTriggerAction.setToolTipText("Add a new Trigger");

		removeTriggerAction = new RemoveTriggerAction(triggerViewer, "Remove");
		removeTriggerAction.setImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		removeTriggerAction.setDisabledImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		removeTriggerAction.setToolTipText("Remove the selected Query items");

		setTriggerAction = new SetTriggerAction(triggerViewer, "Configure");
		setTriggerAction.setImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));
		setTriggerAction.setDisabledImageDescriptor(platformImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD_DISABLED));
		setTriggerAction.setToolTipText(SET_SELECTED_ENTRY_TOOLTIP);

		createTriggerFileAction = new CreateTriggerFileAction(triggerViewer,
				PRINT);
		createTriggerFileAction.setImageDescriptor(PRINTER_IMG);

		createTriggerFileAction
				.setToolTipText(PRINT_A_TRIGGER_FILE);

	}

	private void hookGlobalActions() {
		getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.DELETE.getId(), removeTriggerAction);
	}

}
