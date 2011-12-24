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

import static com.verticon.tracker.irouter.monitor.view.internal.Component.bundleMarker;

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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.osgi.service.monitor.MonitorAdmin;
import org.osgi.service.monitor.StatusVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jconlon
 *
 */
public class StatusMonitor {

	private final Logger logger = LoggerFactory.getLogger(StatusMonitor.class);
	private final INode node;
	private Map<String,WritableValue> model = new HashMap<String, WritableValue>();	
	private final BooleanToString booleanToString = new BooleanToString();
	private final StringToBoolean stringToBoolean = new StringToBoolean();
	
	
    StatusMonitor(INode wiredNode) {
		super();
		this.node = wiredNode;
		
	}
	
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StatusMonitor [node=" + node + "]";
	}


	void initialize(Composite sectionClient, FormToolkit toolkit, IManagedForm mform, Control controlToTagWithMessages){
		
		DataBindingContext dbc = new DataBindingContext();
		Text text;
		Label l;
		if(controlToTagWithMessages!=null){
			model.put("updateCount", new WritableValue(Integer.valueOf(0),Integer.class));
			l = toolkit.createLabel(sectionClient, "Update Counter:");
			l.setToolTipText("Number of times the Status Variables have been updated.");
			text = toolkit.createText(sectionClient, "", SWT.BORDER);
			text.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2,
					1));
			dbc.bindValue(
					SWTObservables.observeText(text, SWT.Modify), 
					model.get("updateCount"), 
					//UI To model
					new UpdateValueStrategy().setConverter(StringToNumberConverter.toInteger(false)), 
					//Model to UI
					new UpdateValueStrategy().setConverter(NumberToStringConverter.fromInteger(false)));

		}else{
			controlToTagWithMessages=sectionClient;
		}
		
		MonitorAdmin monitorAdmin = Component.INSTANCE.getMonitorAdmin();
		if(monitorAdmin==null){
			logger.warn(bundleMarker, "{} failed to find the MonitorAdmin Service.",this);
			mform.getMessageManager().addMessage(
					"status", //key
					"Failed to find the MonitorAdmin Service", //message
					null,//data
					IMessageProvider.ERROR, //int
					controlToTagWithMessages);//Control
			return;
		}else{
			StatusVariable[] variables = null;
			try {
				variables = monitorAdmin.getStatusVariables(node.getPid());
				if(variables == null || variables.length==0){
				    logger.warn(bundleMarker, "{} failed to find any Monitorable Services.",this);
					mform.getMessageManager().addMessage(
							"status", //key
							"Failed to find any statusVariables for "+node, //message
							null,//data
							IMessageProvider.WARNING, //int
							controlToTagWithMessages);//Control
					return;
				}
			} catch (Exception e) {
				logger.error(bundleMarker, this+" failed to load Monitorable Services.",e);
				mform.getMessageManager().addMessage(
						"status", //key
						node.getPid()+" failed to load Monitorable Services, see log for details.", //message
						null,//data
						IMessageProvider.ERROR, //int
						controlToTagWithMessages);//Control
				return;
			}
			
			
			
			for (StatusVariable statusVariable : variables) {
				String id = statusVariable.getID();
				String name = trim(id);
				if(name==null){
					continue;
				}
				l = toolkit.createLabel(sectionClient, name+":");
				l.setToolTipText(monitorAdmin.getDescription(node.getPid()+'/'+id));
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
			for (StatusVariable statusVariable : monitorAdmin.getStatusVariables(node.getPid())) {
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
		if(node instanceof ProducerWiredNode){
			return  id.substring("producer.".length()).replace('_', ' ');
		}
		
		if(node instanceof ConsumerWiredNode) {
			return id.substring("consumer.".length()).replace('_', ' ');
		}
		
		return id.substring("external.".length()).replace('_', ' ');
		
	}

	private boolean isAppropriate(String id){
		if(node instanceof ProducerWiredNode){
			return id.toLowerCase().startsWith("producer.");
		}
		
		if(node instanceof ConsumerWiredNode){
			return id.toLowerCase().startsWith("consumer.");
		}
	
		if(node instanceof IExternalNode){
			return id.toLowerCase().startsWith("external.");
		}
		return false;
	}
	
	private static class BooleanToString extends Converter{

		public BooleanToString() {
			super(Boolean.class, String.class);
		}

		@Override
		public Object convert(Object fromObject) {
			Boolean is = (Boolean)fromObject;
			return Boolean.toString(is);
		}
		
	}
	
	private static class StringToBoolean extends Converter{

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
