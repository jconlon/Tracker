/**
 * 
 */
package com.verticon.tracker.export.wlic.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Premises;
import com.verticon.tracker.editor.util.PremisesProcessor;

/**
 * @author jconlon
 *
 */
public class WlicTrackerExporter implements PremisesProcessor {
	
	private SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
	private String nonProducerPid;
	private StringBuffer buffer = new StringBuffer();
	private List<Event> validWlicEvents = new ArrayList<Event>();
	private String fileName;
	
	
	
	/* (non-Javadoc)
	 * @see com.verticon.tracker.export.wlic.actions.TrackerExporter#process(com.verticon.tracker.Premises, java.io.File)
	 */
	public void process(Premises premises, IFile trackerFile, IProgressMonitor monitor) throws IOException, CoreException{
		IProject project = trackerFile.getProject();
		IFolder exportsFolder = project.getFolder(new Path("exports"));
		if(!exportsFolder.exists()){
			exportsFolder.create(true, true, monitor);	
		}
		
		
		createHeader(premises);
		fileName = createFileName(nonProducerPid);
		for (Event event : validWlicEvents) {
			createRow(event);
		}
		InputStream is = new ByteArrayInputStream(buffer.toString().getBytes("UTF-8"));
		IFile outputFile = exportsFolder.getFile(fileName);
		outputFile.create(is, true, monitor);
		
	}
	
	/*
	 * 
	 */
	
	private void createRow(Event event){
		for (int i = 1; i < 19; i++) {
			buffer.append(getRowField(i,  event));
		}
		buffer.append('\n');
	}
	
	private String getRowField(int key, Event event){
		String out = null;
		switch (key) {
		case 1:
			out=Integer.toString(event.getEventCode())+',';
			break;
		case 2:
			out = nonProducerPid+',';
			break;
		case 3: //Source/DestinationPin
			switch (event.getEventCode()) {
			case 3:
				out = ((MovedIn)event).getSourcePin()+',';
				break;
			case 4:
				out = ((MovedOut)event).getDestinationPin()+',';
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
			out = event.getIdNumber()+",";
			break;
		case 7://Species
			out = ((Animal)event.getTag().eContainer()).getSpeciesCode()+',';
			break;
		case 8://IDElectronicallyRead
			out = event.isElectronicallyRead()?"1,":"0,";
			break;
		case 9://TODO AnimalDateOfBirth
			out = ",";
			break;
		case 10://TODO Age
			out = ",";
			break;
		case 11://TODO Sex
			out = ",";
			break;
		case 12://TODO Breed
			out = ",";
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
			out = ",";
			break;
		case 16://AnimalID 1 type
			out = ",";
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
	private void createHeader(Premises premises){
		for (int i = 1; i < 5; i++) {
			buffer.append(getHeaderField(i,  premises));
		}
		buffer.append('\n');
		
	}
	
	
	@SuppressWarnings("unchecked")
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
			EList rawevents = premises.eventHistory();
			for (Object object : rawevents) {
				Event event = (Event)object;
				if(event.getEventCode()<15){
					validWlicEvents.add(event);
				}
			}
			Collections.sort(validWlicEvents, new Comparator(){

				public int compare(Object o1, Object o2) {
					Event event1 = (Event)o1;
					Event event2 = (Event)o2;
					
					return event1.getDateTime().compareTo(event2.getDateTime());
				}});
			out = Integer.toString(validWlicEvents.size())+',';
			break;
		case 4:
			out = premises.getEmailContact();
			break;
		}
		
		return out;
	}

	
	private String createFileName(String nonProducerPid){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = df.format(new Date());
		return nonProducerPid+date+".IND";
	}
	
	public String getCompletionMessage() {
		return "Tracker model exported to the WLIC file "+fileName;
	}

	public String getFailureTitle() {
		return "Failed to export a tracker model to a WLIC file.";
	}

}
