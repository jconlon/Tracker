/*******************************************************************************
 * Copyright (c) 2008 Trevor S. Kaufman.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Trevor S. Kaufman - initial API and implementation
 ******************************************************************************/
package com.verticon.tracker.editor.util;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class TableColumnPatternFilter extends ViewerFilter {

	private String patternString = "";
	private int columnIndex;

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (patternString == null) {
			return true;
		}
		
		String text = null;
		IBaseLabelProvider baseLabelProvider = ((TableViewer)viewer).getLabelProvider();
		if (baseLabelProvider instanceof ITableLabelProvider) {
			ITableLabelProvider tableLabelProvider = (ITableLabelProvider)baseLabelProvider;
			text = tableLabelProvider.getColumnText(element, columnIndex);
		} else if (baseLabelProvider instanceof ILabelProvider) {
			ILabelProvider labelProvider = (ILabelProvider)baseLabelProvider;
			text = labelProvider.getText(element);
		} else {
			text = element.toString();
		}
		
		if (text == null) return false;
		
		return text.startsWith(patternString);
	}

	public void setPattern(String text) {
		patternString = text;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

}
