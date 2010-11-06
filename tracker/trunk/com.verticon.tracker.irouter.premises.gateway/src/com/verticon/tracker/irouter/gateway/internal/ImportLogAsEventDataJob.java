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
package com.verticon.tracker.irouter.gateway.internal;
import static com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin.bundleMarker;
import static com.verticon.tracker.irouter.gateway.internal.MeasurementTransactionUtils.canBeIn;
import static com.verticon.tracker.irouter.gateway.internal.MeasurementTransactionUtils.createEvent;
import static com.verticon.tracker.irouter.gateway.internal.MeasurementTransactionUtils.newInstance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.CancellationException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.wireadmin.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.TrackerReportEditorPlugin;

public class ImportLogAsEventDataJob extends Job {

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(ImportLogAsEventDataJob.class);

	private final Premises premises;
	private final File file;
	private final EditingDomain editingDomain;
	private final CompoundCommand compoundCommand = new CompoundCommand();
	private final Display display;
	private IStatus status;
	private int affectedObjects;
	private int lineNumber;
	private int defered;


	public ImportLogAsEventDataJob(Premises premises, File file,
			EditingDomain editingDomain, Display display) {
		super("Import Log as Event Data Job");
		this.premises = premises;
		this.file = file;
		this.editingDomain = editingDomain;
		this.display = display;
	}


	@Override
	protected IStatus run(IProgressMonitor monitor) {
		 long bytesInFile = file.length();
		 final int ticks = (int) (bytesInFile/500);//
	     monitor.beginTask("Importing Log Events", ticks);
         try {
			createCommand( monitor);
			int events=compoundCommand.getCommandList().size();
			monitor.subTask("Adding" + events+" events to the Premises");
			logger.warn(bundleMarker,"{} :Adding {} events to the Premises",this,events);
			display.syncExec(
					  new Runnable() {
					    public void run(){
					    	editingDomain.getCommandStack().execute(compoundCommand);
					    }
			});
			affectedObjects = compoundCommand.getAffectedObjects().size();
			monitor.subTask("Added" + affectedObjects+" events to the Premises");
			logger.warn(bundleMarker,"{} :Added {} events to the Premises",this,affectedObjects);
			monitor.done();
			status= Status.OK_STATUS;
		} catch (IOException e) {
			status = new Status(IStatus.ERROR, TrackerReportEditorPlugin.ID,"Failed to import event data.", e);
			
		} catch (CancellationException e){
			status= Status.CANCEL_STATUS;
		}
		
		return status;
	}

	void createCommand(IProgressMonitor monitor) throws IOException {
		BufferedReader bufferedReader = null;
		try {
			// open file
			FileReader logFileReader = new FileReader(file);
			bufferedReader = new BufferedReader(logFileReader);
			String logEntry = "";
			lineNumber = 1;
			// go through lines
			while ((logEntry = bufferedReader.readLine()) != null) {
				if (monitor.isCanceled()){
					   bufferedReader.close();
					   throw new CancellationException();
		               
				}
		        monitor.subTask("Processing line #" + lineNumber);
		        logger.warn(bundleMarker,"{} :Processing line #{}",this,lineNumber);
				try {
					processLine(logEntry, lineNumber, monitor);
				} catch (ParseException e) {
					monitor.subTask(e.getMessage()+" While processing lineNumber #" + lineNumber);
					 logger.error(bundleMarker,"{} :{} While processing line #{}",new Object[]{this,e.getMessage(),lineNumber});
				} catch (EventCreationException e) {
					logger.error(bundleMarker,"{} :{} While processing line #{}",new Object[]{this,e.getMessage(),lineNumber});
				}
				// increment line number
				lineNumber++;
				if (monitor != null) {
					monitor.worked(1);
				}
			}
		} finally {
			// close file
			bufferedReader.close();
		}
	}

	public synchronized int getAffectedObjects() {
		return affectedObjects;
	}


	public synchronized int getLineNumber() {
		return lineNumber;
	}

	public synchronized int getDefered() {
		return defered;
	}

	/**
	 * Process a line of csv data from the importing file.
	 * 
	 * @param line
	 * @param lineNumber
	 * @param index
	 * @throws IOException
	 * @throws ParseException 
	 * @throws EventCreationException 
	 */
	private void processLine(String line, int lineNumber, IProgressMonitor monitor)
			throws IOException, ParseException, EventCreationException {
		
		Envelope measurement = newInstance(line);
		// Only add an entry if the animal all ready exists
		Animal animal = premises.findAnimal((String)measurement.getIdentification());
		
		String message = null;
		if(animal==null){
			message = "Deferred adding "+measurement+" at lineNumber# "+lineNumber+" because there is no animal with that ID in the premises.";
			monitor.subTask(message);
			logger.error(bundleMarker,"{} :"+message,this);
			defered++;
			return;
		}
		Tag tag = animal.activeTag()!=null?animal.activeTag():animal.getTags().get(0);
		
		if(!canBeIn(tag,measurement)){
			message = "Deferred adding "+measurement+" at lineNumber# "+lineNumber+" because there is a policy prevent event inclusion.";
			monitor.subTask(message);
			logger.error(bundleMarker,"{} :"+message,this);
			defered++;
			return;
		}
		
		Event event = createEvent(tag,measurement);
		addEvent(lineNumber, monitor, measurement, tag,event);
		
	}

	private void addEvent(int lineNumber, IProgressMonitor monitor,
			Envelope measurement, Tag tag, Event event) {
		compoundCommand.append(AddCommand.create(editingDomain, tag,
				TrackerPackage.Literals.TAG__EVENTS, event));
		String message = "Appended command to add "+event+" , from "+measurement+" #"+lineNumber+" of "+compoundCommand.getCommandList().size();
		monitor.subTask(message);
		logger.warn(bundleMarker,"{} :{}",this,message);
	}


	public IStatus getStatus() {
		return status;
	}
	
}
