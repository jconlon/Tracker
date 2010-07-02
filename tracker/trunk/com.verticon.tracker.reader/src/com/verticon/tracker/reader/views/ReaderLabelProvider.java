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

package com.verticon.tracker.reader.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITableLabelProvider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.verticon.tracker.reader.IReader;



/**
 * Label provider for the ReaderViewer
 * 
 * @see org.eclipse.jface.viewers.LabelProvider 
 */
class ReaderLabelProvider 
	extends LabelProvider
	implements ITableLabelProvider {

	// Names of images used to represent checkboxes
	private static final String CHECKED_IMAGE 	= "checked";
	private static final String UNCHECKED_IMAGE  = "unchecked";

	// For the checkbox images
	private static ImageRegistry imageRegistry = new ImageRegistry();

	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 
	static {
		String iconPath = "icons/"; 
		imageRegistry.put(CHECKED_IMAGE, ImageDescriptor.createFromFile(
				ReaderViewer.class, 
				iconPath + CHECKED_IMAGE + ".gif"
				)
			);
		imageRegistry.put(UNCHECKED_IMAGE, ImageDescriptor.createFromFile(
				ReaderViewer.class, 
				iconPath + UNCHECKED_IMAGE + ".gif"
				)
			);	
	}
	
	/**
	 * Returns the image with the given key, or <code>null</code> if not found.
	 */
	private Image getImage(boolean isSelected) {
		String key = isSelected ? CHECKED_IMAGE : UNCHECKED_IMAGE;
		return  imageRegistry.get(key);
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		IReader reader = (IReader) element;
		switch (columnIndex) {
			case 0:  // COMPLETED_COLUMN
				break;
			case 1 :
				result = reader.getName();
				break;
			case 2 :
				result = reader.getType();
				break;
			case 3 :
				result = reader.getTemplate() ;
				break;
			case 4 :
				result = reader.getTarget().toString() ;
				break;
			default :
				break; 	
		}
		return result;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return (columnIndex == 0) ?   // COMPLETED_COLUMN?
			getImage(((IReader) element).isStarted()) :
			null;
	}

}
