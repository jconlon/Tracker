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
package com.verticon.tracker.export.wlic.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.TrackerEditorUtils;
import com.verticon.tracker.export.wlic.Utils;
import com.verticon.tracker.util.FilterCriteria;

/**
 * The only page of the ExportWlicWizard, displays message and a potential
 * error message to the user.
 * 
 * Because of the semi complex logic this pages uses the GoF State Pattern.
 */
class SelectExportDateRangeWizardPage extends WizardPage {

	/**
	 * Funky date format to make dates look like the funky dateTime control.
	 */
	private static final SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy - h:m:s a");
	 
	// These values are initialized and will not change
	private IFile premisesFile;
	private Premises premises;
	private Calendar calendarOfEarliestEvent;
	private Calendar calendarOfLastReport = null;
	private IFile lastReport = null;

	// Controls
	private Button documentFirstEventUseAsButton;
	private Button reportHistoryEventUseAsButton;
	private DateTime startDateOfReport;
	private DateTime startTimeOfReport;

	// Widgets that change values based on updates
	private Text eventsToReportText;

	// Values that change with update
	private int eventsToReport = 0;

	// States
	State documentHasNoEvents = new DocumentHasNoEventsState();
	State validReportDefinition = new ValidReportDefinitionState();
	State invalidReportDefinition = new InvalidReportDefinitionState();
	State hasLastReport = new HasLastReportState();
	State noLastReport = new NoLastReportState();
	
	State currentState = new StartState();

	public SelectExportDateRangeWizardPage() {
		super("selectFilePath");
		setTitle("Export WLIC Report");
		setDescription("Export the WLIC Report to the exports directory.");
	}

	/**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			updateState();
		}
		super.setVisible(visible);
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
		Composite composite = new Composite(parent, SWT.NULL);
		// create the desired layout for this wizard page
		GridLayout gridLayout = new GridLayout();
		int ncol = 2;
		gridLayout.numColumns = ncol;
		composite.setLayout(gridLayout);

		// create the widgets and their grid data objects

		// Document group
		Group documentGroup = new Group(composite, SWT.SHADOW_IN);
		documentGroup.setText("Premises Document Information");
		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		documentGroup.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		documentGroup.setLayoutData(gridData);

		new Label(documentGroup, SWT.NULL).setText("File Name:");
		Text premisesFileNameText = new Text(documentGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		premisesFileNameText.setText(premisesFile.getName());
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		premisesFileNameText.setLayoutData(gridData);
		
		if(getPremisesEvents().isEmpty()){
			new Label(documentGroup, SWT.NULL).setText("This document has no events!");
			setControl(composite);
			return;
		}else if(premises.getPremisesId()==null){
			new Label(documentGroup, SWT.NULL).setText("This document has no Premises Id!");
			setControl(composite);
			return;
		}

		new Label(documentGroup, SWT.NULL).setText("Premises Id Number:");
		Text premisesInNumberText = new Text(documentGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		premisesInNumberText.setText(premises.getPremisesId());
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		premisesInNumberText.setLayoutData(gridData);

		new Label(documentGroup, SWT.NULL).setText("Date of First Event:");
		Text premisesFirstEventText = new Text(documentGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		premisesFirstEventText.setText(df.format(calendarOfEarliestEvent.getTime()));
		premisesFirstEventText.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));

		documentFirstEventUseAsButton = new Button(documentGroup, SWT.PUSH);
		documentFirstEventUseAsButton
				.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						setStartTimeOfReportToCalendarOfEarliestEvent();

						updateState();
					}
				});
		documentFirstEventUseAsButton.setText("Use As Start Date & Time");
		if (calendarOfEarliestEvent == null) {
			documentFirstEventUseAsButton.setEnabled(false);
		}

		new Label(documentGroup, SWT.NULL).setText("Date of Last Event:");
		Text premisesLastEventText = new Text(documentGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		premisesLastEventText.setText(
				df.format(
						Utils.getLatestWlicEventDate(getPremisesEvents())
				)
		);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		premisesLastEventText.setLayoutData(gridData);

		new Label(documentGroup, SWT.NULL).setText("Number of Events:");
		Text premisesNumberOfEventsText = new Text(documentGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		premisesNumberOfEventsText.setText(Integer
				.toString(getNumberOfValidEventsInDocument()));
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		premisesNumberOfEventsText.setLayoutData(gridData);

		// Report History group
		Group reportHistoryGroup = new Group(composite, SWT.SHADOW_IN);
		reportHistoryGroup.setText("Last Premises Report");
		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		reportHistoryGroup.setLayout(gridLayout);
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		reportHistoryGroup.setLayoutData(gridData);

		new Label(reportHistoryGroup, SWT.NULL).setText("File Name:");
		Text reportFileNameText = new Text(reportHistoryGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		reportFileNameText.setText(lastReport == null ? "" : lastReport
				.getName());
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		reportFileNameText.setLayoutData(gridData);

		new Label(reportHistoryGroup, SWT.NULL).setText("Date:");
		Text lastReportText = new Text(reportHistoryGroup, SWT.SINGLE
				| SWT.BORDER | SWT.READ_ONLY);
		lastReportText.setText(calendarOfLastReport == null ? ""
				:df.format(
					calendarOfLastReport.getTime()
				  )
		);
		lastReportText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		reportHistoryEventUseAsButton = new Button(reportHistoryGroup, SWT.PUSH);
		reportHistoryEventUseAsButton
				.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						setStartTimeOfReportToCalendarOfLastReport();

						updateState();
					}
				});
		reportHistoryEventUseAsButton.setText("Use As Start Date & Time");
		if (calendarOfLastReport == null) {
			reportHistoryEventUseAsButton.setEnabled(false);
		}

		new Label(composite, SWT.NULL).setText("Start Date of This Report:");
		startDateOfReport = new DateTime(composite, SWT.DATE);
		startDateOfReport.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateState();
			}
		});

		new Label(composite, SWT.NULL).setText("Start Time of This Report:");
		startTimeOfReport = new DateTime(composite, SWT.TIME);
		startTimeOfReport.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateState();
			}
		});

		//
		Label label_2 = new Label(composite, SWT.NULL);
		label_2.setText("Number of Events that will be Reported:");
		gridData = new GridData();
		label_2.setLayoutData(gridData);

		eventsToReportText = new Text(composite, SWT.SINGLE | SWT.BORDER
				| SWT.READ_ONLY);

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		eventsToReportText.setLayoutData(gridData);

		setControl(composite);
		updateState();
	}

	/**
	 * Called by the wizard to initialize the receiver's cached selection.
	 * 
	 * @param selection
	 *            the selection or <code>null</code> if none
	 * @throws IOException
	 */
	void init(IFile premisesFile) {
		this.premisesFile = premisesFile;
		try {
			this.premises = TrackerEditorUtils.getPremises(premisesFile);
			if (premises == null) {
				throw new Exception("a Premises could NOT be created from the file.");
			}
			if(getPremisesEvents().isEmpty()){
				throw new Exception("the Premises document contains no Events.");
			}
			if(premises.getPremisesId()==null){
				throw new Exception("the Premises document has no Premises Id value.");
			}
			calendarOfEarliestEvent = Calendar.getInstance();
			calendarOfEarliestEvent.setTime(Utils.getEarliestWlicEventDate(getPremisesEvents()));
			lastReport = findLastExportedReport(premises.getPremisesId());
			calendarOfLastReport = calculateCalendarOfLastReport(lastReport);
			//The initial state is start 
			currentState.update(this);
			
			
		} catch (Exception e) {
			currentState = new InitializationErrorState(e);
		}
	}

	/**
	 * 
	 */
	void setStartTimeOfReportToCalendarOfEarliestEvent() {
		startTimeOfReport.setSeconds(calendarOfEarliestEvent
				.get(Calendar.SECOND));
		startTimeOfReport.setMinutes(calendarOfEarliestEvent
				.get(Calendar.MINUTE));
		startTimeOfReport.setHours(calendarOfEarliestEvent
				.get(Calendar.HOUR_OF_DAY));
		startDateOfReport.setDay(calendarOfEarliestEvent
				.get(Calendar.DAY_OF_MONTH));
		startDateOfReport.setMonth(calendarOfEarliestEvent
				.get(Calendar.MONTH));
		startDateOfReport.setYear(calendarOfEarliestEvent
				.get(Calendar.YEAR));
	}

	/**
	 * 
	 */
	void setStartTimeOfReportToCalendarOfLastReport() {
		startTimeOfReport.setSeconds(calendarOfLastReport
				.get(Calendar.SECOND));
		startTimeOfReport.setMinutes(calendarOfLastReport
				.get(Calendar.MINUTE));
		startTimeOfReport.setHours(calendarOfLastReport
				.get(Calendar.HOUR_OF_DAY));
		startDateOfReport.setDay(calendarOfLastReport
				.get(Calendar.DAY_OF_MONTH));
		startDateOfReport.setMonth(calendarOfLastReport
				.get(Calendar.MONTH));
		startDateOfReport.setYear(calendarOfLastReport
				.get(Calendar.YEAR));
	}

	/**
	 * Goal of this class is to provide a Date to the Wizard. This date is used
	 * as a Start date for the query - all events after this date will be
	 * included in the report, all before will ignored.
	 * 
	 * Called by the Wizard to determine if it can enable the finish button.
	 * 
	 * @return Date to use to filter Events in report.
	 */
	Date getQueryFromDate() {
		if (currentState.isPageComplete()) {
			return Utils.getCalendarFromDateTimeWiget(startDateOfReport,
					startTimeOfReport).getTime();
		}

		return null;
	}

	/**
	 * Called by State
	 */
	int getEventsToReport() {
		return eventsToReport;
	}

	/**
	 * Called by State
	 */
	void disableReportHistory() {
		if(reportHistoryEventUseAsButton!=null){
			reportHistoryEventUseAsButton.setEnabled(false);
		}
	}

	/**
	 * Called by State
	 */
	void disableDocument() {
		if(documentFirstEventUseAsButton !=null){
			documentFirstEventUseAsButton.setEnabled(false);
		}
	}

	/**
	 * Called by State
	 */
	void disableDateTimeControls() {
		if(startDateOfReport!=null){
			startDateOfReport.setEnabled(false);
		}
		if(startTimeOfReport!=null){
			startTimeOfReport.setEnabled(false);
		}
	}

	/**
	 * Called by State
	 * 
	 * @return
	 */
	boolean hasLastReport() {
		return lastReport != null;
	}

	/**
	 * 
	 * Called by State
	 * 
	 * @return
	 */
	int getNumberOfValidEventsInDocument() {
		return Utils.getNumberOfValidWlicEvents(getPremisesEvents());
	}

	/**
	 * Updates the widget associated with showing the numberOf events to report.
	 */
	private void updateWidgets() {
		eventsToReportText.setText(Integer.toString(getEventsToReport()));
	}


	/**
	 * Recalculates the eventsToReport value after a user changed the startDate 
	 * of the report.
	 */
	private void calculateEventsToReportValue() {
		// based on the filterDate
		
		Calendar cal = Utils.getCalendarFromDateTimeWiget(startDateOfReport,
				startTimeOfReport);
		
		
		final Date filterDate = cal.getTime();
		
		//Create a filterCriteria based on the Date
		FilterCriteria<Event> datedFilterCriteria = new FilterCriteria<Event>() {
			public boolean passes(Event e) {
				
				return  e.getDateTime().after(filterDate);
			}};
			
	    eventsToReport = Utils.getNumberOfFilteredValidWlicEvents(
	    		getPremisesEvents(),datedFilterCriteria);
	}

	/**
	 * @return event list
	 */
     private EList<Event> getPremisesEvents() {
		return premises.eventHistory()==null?new BasicEList<Event>(): premises.eventHistory();
	}

	/**
	 * Finds the lastReport based on the premisesID
	 */
	private IFile findLastExportedReport(String premisesId) {

		IFolder exportsFolder = Utils.getExportsFolder( premisesFile);
		if(!exportsFolder.exists()){
			return null;	
		}
		IResource[] members = null;
		try {
			members = exportsFolder.members();
			if(members.length==0){
				return null;
			}
		} catch (CoreException e) {
			return null;
		}
		List<IFile> candidateFiles = new ArrayList<IFile>();
		for (IResource resource : members) {
			if(resource instanceof IFile){
				if(resource.getName().startsWith(premisesId)){
					candidateFiles.add((IFile)resource);
				}
			}
		}
		
		if(candidateFiles.isEmpty()){
			return null;
		}else if(candidateFiles.size()==1){
			return candidateFiles.get(0);
		}
		
		//There are multiple reports get the lastest
		Comparator<IFile> dc = new Comparator<IFile>() {
			public int compare(IFile a, IFile b) {
				String d1 = a.getName();
				String d2 = b.getName();
				return d1.compareTo(d2);
			}
		};

		
	    return Collections.max(candidateFiles, dc);
	}
	
	 private Calendar calculateCalendarOfLastReport(IFile lastReport){
		 if(lastReport==null){
			 return null;
		 }
		 try {
			Date date = Utils.parseWlicFileName(lastReport.getName());
			Calendar result = Calendar.getInstance();
			result.setTime(date);
			return result ;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	 }
	/**
	 * Update the current page complete state based on the state.
	 * 
	 * Called on control completion, visualization and user changes.
	 */
	private void updateState() {
		setPageComplete(false);
		if(!(currentState instanceof InitializationErrorState)){
			calculateEventsToReportValue();
			updateWidgets();
		}
		currentState.update(this);
		setPageComplete(currentState.isPageComplete());
		setMessage(currentState.getMessage());
		setErrorMessage(currentState.getErrorMessage());
	}
	
}
