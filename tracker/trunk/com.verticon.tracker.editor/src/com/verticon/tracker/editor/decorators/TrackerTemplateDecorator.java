/**
 * 
 */
package com.verticon.tracker.editor.decorators;

import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.swt.graphics.Image;

/**
 * @author jconlon
 *
 */
public class TrackerTemplateDecorator implements ILightweightLabelDecorator {

	private static final String TEMPLATE = " [template] ";

	public void decorate(Object element, IDecoration decoration) {
		decoration.addSuffix(TEMPLATE);
		
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	
}
