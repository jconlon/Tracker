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
package com.verticon.tracker.irouter.monitor.view.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.osgi.service.monitor.MonitorAdmin;
import org.osgi.service.monitor.StatusVariable;

/**
 * @author jconlon
 *
 */
public class StatusMonitor {

	private final WiredNode wiredNode;
	private Map<String,WritableValue> model = new HashMap<String, WritableValue>();	
	private final BooleanToString booleanToString = new BooleanToString();
	private final StringToBoolean stringToBoolean = new StringToBoolean();
	
	
    StatusMonitor(WiredNode wiredNode) {
		super();
		this.wiredNode = wiredNode;
		
	}
	
	void initialize(Composite sectionClient, FormToolkit toolkit, IManagedForm mform){
		DataBindingContext dbc = new DataBindingContext();
		model.put("updateCount", new WritableValue(new Integer(0),Integer.class));
		Label l = toolkit.createLabel(sectionClient, "Update Counter:");
		l.setToolTipText("An example of a status variable");
		Text text = toolkit.createText(sectionClient, "", SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
				1));
		dbc.bindValue(
				SWTObservables.observeText(text, SWT.Modify), 
				model.get("updateCount"), 
				//UI To model
				new UpdateValueStrategy().setConverter(StringToNumberConverter.toInteger(false)), 
				//Model to UI
				new UpdateValueStrategy().setConverter(NumberToStringConverter.fromInteger(false)));

		
		MonitorAdmin monitorAdmin = Component.INSTANCE.getMonitorAdmin();
		if(monitorAdmin==null){
			mform.getMessageManager().addMessage(
					"status", //key
					"Failed to find the MonitorAdmin Service", //message
					null,//data
					IMessageProvider.ERROR, //int
					text);//Control
			return;
		}else{
			StatusVariable[] variables = null;
			try {
				variables = monitorAdmin.getStatusVariables(wiredNode.getPid());
			} catch (IllegalArgumentException e) {
				mform.getMessageManager().addMessage(
						"status", //key
						wiredNode.getPid()+" has no Monitorable Services", //message
						null,//data
						IMessageProvider.WARNING, //int
						text);//Control
				return;
			}
			
			
			
			for (StatusVariable statusVariable : variables) {
				String id = statusVariable.getID();
				String name = trim(id);
				if(name==null){
					continue;
				}
				l = toolkit.createLabel(sectionClient, name+":");
				l.setToolTipText(monitorAdmin.getDescription(wiredNode.getPid()+'/'+id));
				text = toolkit.createText(sectionClient, "", SWT.BORDER);
				text.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
						1));
				
				switch (statusVariable.getType()) {
				case StatusVariable.TYPE_BOOLEAN:
					model.put(id, 
							new WritableValue(statusVariable.getBoolean(),
									Boolean.class));
					dbc.bindValue(
							SWTObservables.observeText(text, SWT.Modify), 
							model.get(id), 
							//UI To model
							new UpdateValueStrategy().setConverter(stringToBoolean), 
							//Model to UI
							new UpdateValueStrategy().setConverter(booleanToString));

					break;

				case StatusVariable.TYPE_FLOAT:
					model.put(id, 
							new WritableValue(statusVariable.getFloat(),
									Float.class));
					dbc.bindValue(
							SWTObservables.observeText(text, SWT.Modify), 
							model.get(id), 
							//UI To model
							new UpdateValueStrategy().setConverter(StringToNumberConverter.toFloat(false)), 
							//Model to UI
							new UpdateValueStrategy().setConverter(NumberToStringConverter.fromFloat(false)));

					break;
				
				case StatusVariable.TYPE_INTEGER:
					model.put(id, 
							new WritableValue(statusVariable.getInteger(),
									Integer.class));
					dbc.bindValue(
							SWTObservables.observeText(text, SWT.Modify), 
							model.get(id), 
							//UI To model
							new UpdateValueStrategy().setConverter(StringToNumberConverter.toInteger(false)), 
							//Model to UI
							new UpdateValueStrategy().setConverter(NumberToStringConverter.fromInteger(false)));

					break;

				default:
					model.put(id, 
							new WritableValue(statusVariable.getString(),
									String.class));
					dbc.bindValue(
							SWTObservables.observeText(text, SWT.Modify), 
							model.get(id), 
							null,null);

					break;
				}
				
			}
			
		}
	}
	
	void update(){
		Integer count = (Integer)model.get("updateCount").getValue();
		count++;
		model.get("updateCount").setValue(count);
		
		MonitorAdmin monitorAdmin = Component.INSTANCE.getMonitorAdmin();
		if(monitorAdmin!=null){
			for (StatusVariable statusVariable : monitorAdmin.getStatusVariables(wiredNode.getPid())) {
				String id = statusVariable.getID();
				if(!isAppropriate( id)){
					continue;
				}
				switch (statusVariable.getType()) {
				case StatusVariable.TYPE_BOOLEAN:
					model.get(id).setValue(statusVariable.getBoolean());
					break;

				case StatusVariable.TYPE_FLOAT:
					model.get(id).setValue(statusVariable.getFloat());
					break;
				
				case StatusVariable.TYPE_INTEGER:
					model.get(id).setValue(statusVariable.getInteger());
					break;

				default:
					model.get(id).setValue(statusVariable.getString());
					break;
				}
				
			}
		}
		
	}
	
	private String trim(String id){
		if(!isAppropriate( id)){
			return null;
		}
		if(wiredNode.isProducer()){
			return  id.substring("producer.".length()).replace('_', ' ');
		}else {
			return id.substring("consumer.".length()).replace('_', ' ');
		}
		
	}

	private boolean isAppropriate(String id){
		if(wiredNode.isProducer()){
			return id.toLowerCase().startsWith("producer.");
		}else{
			return id.toLowerCase().startsWith("consumer.");
		}
		
	}
	
	private class BooleanToString extends Converter{

		public BooleanToString() {
			super(Boolean.class, String.class);
		}

		@Override
		public Object convert(Object fromObject) {
			Boolean is = (Boolean)fromObject;
			return Boolean.toString(is);
		}
		
	}
	
	private class StringToBoolean extends Converter{

		public StringToBoolean() {
			super(String.class, Boolean.class);
		}

		@Override
		public Object convert(Object fromObject) {
			String is = (String)fromObject;
			return Boolean.parseBoolean(is);
		}
		
	}
	
}
