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
package com.verticon.tracker.export.wlic.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Premises;
import com.verticon.tracker.ReplacedTag;
import com.verticon.tracker.editor.util.PremisesProcessor;
import com.verticon.tracker.export.wlic.Utils;
import com.verticon.tracker.util.FilterCriteria;

/**
 * @author jconlon
 *
 */
public class WlicPremisesProcessor implements PremisesProcessor {
	
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
	private static final SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
	
	private String nonProducerPid;
	private StringBuffer buffer;
	private Collection<Event> validWlicEvents ;
	private String fileName;
	
	private final Date queryFromDate;
	
	public WlicPremisesProcessor(Date queryFromDate) {
		this.queryFromDate = queryFromDate;
	}

	/**
	 * 
	 * @param premises
	 * @param trackerFile
	 * @param monitor
	 * @throws IOException
	 * @throws CoreException
	 */
	public void process(Premises premises, IFile trackerFile,
			IProgressMonitor monitor) throws IOException, CoreException {
		
		IFolder exportsFolder = Utils.getExportsFolder(trackerFile);
		if(!exportsFolder.exists()){
			exportsFolder.create(true, true, monitor);	
		}
		buffer = new StringBuffer(); 
		validWlicEvents= fillValidEvents(premises);
		createHeader(premises);
		fileName = createWlicFileName(nonProducerPid);
		for (Event event : validWlicEvents) {
			createRow(event);
		}
		InputStream is = new ByteArrayInputStream(buffer.toString().getBytes("UTF-8"));
		IFile outputFile = exportsFolder.getFile(fileName);
		outputFile.create(is, true, monitor);
		
	}

	
	private void createRow(Event event){
		for (int i = 1; i < 19; i++) {
			buffer.append(getRowField(i,  event));
		}
		buffer.append('\n');
	}
	
	private String getRowField(int key, Event event){
		
		String out = null;
		Animal animal = ((Animal)event.getTag().eContainer());
		switch (key) {
		case 1:
			out=Integer.toString(event.getEventCode())+',';
			break;
		case 2:
			out = nonProducerPid==null?",":nonProducerPid+',';
			break;
		case 3: //Source/DestinationPin
			switch (event.getEventCode()) {
			case 3:
				out = ((MovedIn)event).getSourcePin()==null?"," :((MovedIn)event).getSourcePin()+',';
				break;
			case 4:
				out = ((MovedOut)event).getDestinationPin()==null?",":((MovedOut)event).getDestinationPin()+',';
				break;
			default:
				out = ",";
				break;
			}
			break;
		case 4://EventDateTime
			out = df.format(event.getDateTime())+',';
			break;
		case 5://USAIN Used
			out = event.getTag().isUsainNumberUsed()?"1,":"0,";
			break;
		case 6://ID number
			out = event.getId()+",";
			break;
		case 7://Species
			out = animal.getSpeciesCode()+',';
			break;
		case 8://IDElectronicallyRead
			out = event.isElectronicallyRead()?"1,":"0,";
			break;
		case 9://AnimalDateOfBirth
			out = animal.getBirthDate()==null?",":df2.format(animal.getBirthDate())+',';
			break;
		case 10://Age
			out = animal.getAge()==null?",":animal.getAge().toRoundedString()+',';
			break;
		case 11://Sex
			out = stringIsNullOrUnspecified(animal.getSexCode())?",":animal.getSexCode()+',';
			break;
		case 12://Breed
			out = stringIsNullOrUnspecified(animal.getBreed())?",":animal.getBreed()+',';
			break;
		case 13://Remarks
			String comments = event.getComments();
			if(comments!=null){
				if(comments.length()>50){
					comments = comments.substring(0,50);
				}
				comments = comments.replace('"', ' ');
				comments = comments.replace('\'', ' ');
				out = comments.contains(",")?'"'+comments+'"'+',': comments+',';
			}else{
				out = ",";
			}
			break;
		case 14://Status
			out = event.isCorrection()?"C,":",";
			break;
		case 15://AnimalID 1
			out = ",";//NOT USED
			break;
		case 16://AnimalID 1 type use this if a replace Tag event is used
			switch (event.getEventCode()) {
				case 6:
					out = ((ReplacedTag)event).getOldId()==null?"," :((ReplacedTag)event).getOldId()+',';
					break;
				default:
					out = ",";
					break;
			}
			break;
		case 17://AnimalID 2
			out = ",";
			break;
		case 18://AnimalID 2 type
			out = "";
			break;
		}
		
		return out;
	}

	/**
	 * @param s
	 * @return
	 */
	private boolean stringIsNullOrUnspecified(String s) {
		return s==null || s.equals("Unspecified");
	}
	private void createHeader(Premises premises){
		for (int i = 1; i < 5; i++) {
			buffer.append(getHeaderField(i,  premises));
		}
		buffer.append('\n');
		
	}
	
	
	private String getHeaderField(int key, Premises premises){
		String out = null;
		switch (key) {
		case 1:
			this.nonProducerPid = premises.getPremisesId();
			out=this.nonProducerPid+',';
			break;
		case 2:
			out = df.format(new Date())+',';
			break;
		case 3:
			
			out = Integer.toString(validWlicEvents.size())+',';
			break;
		case 4:
			out = premises.getEmailContact();
			break;
		}
		
		return out;
	}

	/**
	 * @param premises
	 */
	private Collection <Event> fillValidEvents(Premises premises) {
		//Create a filterCriteria based on the Date
		FilterCriteria<Event> datedFilterCriteria = new FilterCriteria<Event>() {
			public boolean passes(Event e) {
				
				return  e.getDateTime().after(queryFromDate);
			}};
		
		Collection <Event> result = Utils.getFilteredAndSortedValidWlicEvents(
				premises.eventHistory(), datedFilterCriteria);

		return result;
	}

	/**
	 * Create a fileName like 003ALKM20070925190543.IND
	 * @param nonProducerPid
	 * @return filename
	 */
	private static final String createWlicFileName(String nonProducerPid){
		String date = Utils.FILE_NAME_DATE_FORMAT.format(new Date());
		return nonProducerPid+date+".IND";
	}
	
	public String getCompletionMessage() {
		return "Tracker model exported to the WLIC file "+fileName;
	}

	public String getFailureTitle() {
		return "Failed to export a tracker model to a WLIC file.";
	}

	

	

	
}
