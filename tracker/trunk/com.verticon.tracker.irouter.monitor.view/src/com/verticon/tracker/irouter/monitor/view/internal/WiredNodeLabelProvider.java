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

import static com.google.common.base.Preconditions.checkArgument;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_CONSUMER_PID;
import static org.osgi.service.wireadmin.WireConstants.WIREADMIN_PRODUCER_PID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.osgi.service.wireadmin.Wire;

/**
 * Supports 5 different colors for nodes based on the name of the wiregroup.
 * 
 * @author jconlon
 * 
 */
public class WiredNodeLabelProvider extends LabelProvider implements
		IEntityStyleProvider {
    private static final String ROOT = "platform:/plugin/com.verticon.tracker.irouter.monitor.view/icons/";
    
    enum NODE{
    	PRODUCER("producer.gif"), 
    	CONSUMER("consumer.gif"),
    	GATEWAY("gateway.gif"), 
    	SENSOR("sensor.gif"), 
    	ACTUATOR("actuator.gif");
    	final String imagePath;

    	NODE(String imagePath){
    		this.imagePath=ROOT+imagePath;
    	}
    	
    	Image getImage(){
    		if(!images.containsKey(this)){
    			URL url;
				try {
					url = new URL(imagePath);
					Image image= ImageDescriptor.createFromURL(url).createImage();
					images.put(this, image);
				} catch (MalformedURLException e) {
					
				}
    		}
			Image result = images.get(this);
			checkArgument(!result.isDisposed(), "The image was disposed.");
			return result;
    	}
    }
    private final Map<String, Color> nodeColors = new HashMap<String, Color>();
	private boolean showWireLables = true;
	private static Map<NODE, Image> images = new HashMap<NODE, Image>();
	
	
	/**
	 * @param showWireLables
	 *            the showWireLables to set
	 */
    void setShowWireLabels(boolean showWireLables) {
		this.showWireLables = showWireLables;
	}


	
	@Override
	public String getText(Object element) {
		
		if (element instanceof ProducerWiredNode) {
			AbstractNode node = (AbstractNode) element;
			return node.getParent() != null ? "Producer" : node.label;
		}

		if (element instanceof ConsumerWiredNode) {
			AbstractNode node = (AbstractNode) element;
			return node.getParent() != null ? "Consumer" : node.label;
		}

		if (element instanceof AbstractNode) {
			return ((AbstractNode) element).label;
		}

		if (element instanceof EntityConnectionData) {
			if (!showWireLables) {
				return null;
			}
			EntityConnectionData connection = (EntityConnectionData) element;
			return getConnectionLabel(connection);
		}
		
		if (element instanceof ComponentServices) {
			return ((ComponentServices) element).getText();
		}
		
		return super.getText(element);

	}

	static String getConnectionLabel(EntityConnectionData connection) {
		INode source = (INode) connection.source;
		String producerPid = source.getPid();

		INode dest = (INode) connection.dest;
		if(dest instanceof IExternalNode){
			return ((IExternalNode)dest).getConnectionURI();
		}
		String consumerPid = dest.getPid();

		Wire[] wires = Component.INSTANCE.getWires();
		String results ="unknown connection";
		if(wires!=null){
			for (Wire wire : wires) {
				String wireProducerPid = (String) wire.getProperties().get(
						WIREADMIN_PRODUCER_PID);
				if (producerPid.equals(wireProducerPid)) {
					String wireConsumerPid = (String) wire.getProperties().get(
							WIREADMIN_CONSUMER_PID);

					if (consumerPid.equals(wireConsumerPid)) {
						results = Arrays.toString(wire.getScope());
						results = results.substring(1, results.length() - 1);
						break;
					}
				}
			}
		}
		return results;
	}

	@Override
	public Image getImage(Object element) {
		if (element.getClass() == EntityConnectionData.class) {
			return null;
		}
		if (element instanceof ConsumerWiredNode) {
			return NODE.CONSUMER.getImage();
		}
		if (element instanceof ProducerWiredNode) {
			return NODE.PRODUCER.getImage();
		}
		
		if (element instanceof SensorNode) {
			return NODE.SENSOR.getImage();
		}
		
		if (element instanceof ActuatorNode) {
			return NODE.ACTUATOR.getImage();
		}
		
		if (element instanceof GatewayNode) {
			return NODE.GATEWAY.getImage();
		}
		return super.getImage(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		for (Image image : images.values()) {
				image.dispose();

		}
		images.clear();
	}

	@Override
	public Color getNodeHighlightColor(Object entity) {
		return null;
	}

	@Override
	public Color getBorderColor(Object entity) {
		if (entity instanceof IExternalNode) {
			return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
		}

		return null;
	}

	@Override
	public Color getBorderHighlightColor(Object entity) {
		return null;
	}

	@Override
	public int getBorderWidth(Object entity) {
		if (entity instanceof IExternalNode) {
			return 0;
		}
		return 10;
	}

	@Override
	public Color getBackgroundColour(Object entity) {
		if (entity instanceof WiredNode) {
			INode wiredNode = (INode) entity;
			String key = wiredNode.getGroup();
			if (!nodeColors.containsKey(key)) {
				addColor(key);
			}
			return nodeColors.get(key);

		}
		if (entity instanceof IExternalNode) {
			return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
		}

		return null;
	}

	@Override
	public Color getForegroundColour(Object entity) {
		if (entity instanceof WiredNode) {
			return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
		}
		if (entity instanceof IExternalNode) {
			return Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
		}
		return null;
	}

	
	@Override
	public IFigure getTooltip(Object entity) {
		if (entity instanceof IExternalNode) {
			return new Label(((IExternalNode)entity).getDescription());
		}
		if (entity instanceof INode) {
			String[] tokens = entity.toString().split(",");

			StringBuilder builder = new StringBuilder();
			// To aid readability insert a break after every comma.
			for (String string : tokens) {
				builder.append(string).append('\n');
			}
			return new Label(builder.toString());
		}
		
		return null;
	}

	@Override
	public boolean fisheyeNode(Object entity) {
		if (entity instanceof WiredNode) {
			return true;
		}
		if (entity instanceof IExternalNode) {
			return true;
		}
		return false;
	}

	private void addColor(String key) {
		switch (nodeColors.size() % 5) {
		case 0:
			nodeColors.put(key,
					Display.getDefault().getSystemColor(SWT.COLOR_BLUE));
			break;

		case 1:
			nodeColors.put(key,
					Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
			break;

		case 2:
			nodeColors.put(key,
					Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
			break;

		case 3:
			nodeColors.put(key,
					Display.getDefault().getSystemColor(SWT.COLOR_RED));
			break;

		case 4:
			nodeColors.put(key,
					Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
			break;

		}
	}
}
