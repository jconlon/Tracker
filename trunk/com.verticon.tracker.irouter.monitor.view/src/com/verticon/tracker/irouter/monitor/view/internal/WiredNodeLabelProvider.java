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
package com.verticon.tracker.irouter.monitor.view.internal;

import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.osgi.service.wireadmin.Wire;

public class WiredNodeLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof WiredNode){ 
			return ((WiredNode) element).nodeText();	
		}
		
		if (element instanceof EntityConnectionData){
			EntityConnectionData connection = (EntityConnectionData)element;
			WiredNode source = (WiredNode)connection.source;
			String producerPid = source.getPid();
			
			WiredNode dest = (WiredNode)connection.dest;
			String consumerPid = dest.getPid();
			
			Wire[] wires = Component.INSTANCE.getWires();
			
			for (Wire wire : wires) {
				String wireProducerPid = (String) wire.getProperties()
				.get(WIREADMIN_PRODUCER_PID);
				if(producerPid.equals(wireProducerPid)){
					String wireConsumerPid = (String) wire.getProperties()
					.get(WIREADMIN_CONSUMER_PID);
					
					if(consumerPid.equals(wireConsumerPid)){
						String results = Arrays.toString(wire.getScope());
						
						return results;
					}
				}
			}
			return "unknown connection";
		}
		throw new RuntimeException("Wrong type: " + element.getClass().toString() );

	}

	
	

	@Override
	public Image getImage(Object element) {
		if (element.getClass() == EntityConnectionData.class) {
			return null;
		}
//		if(element instanceof ServiceReference){
//			ServiceReference sr = (ServiceReference)element;
//			String[] objectClass = (String[]) sr.getProperty("objectClass");
//			
//			if(objectClass[0].equals(Producer.class.getName())){
//				
//				return Display.getDefault().getSystemImage(SWT.ICON_WARNING); 
//			}
//		}
		return super.getImage(element);
	}
    
}
