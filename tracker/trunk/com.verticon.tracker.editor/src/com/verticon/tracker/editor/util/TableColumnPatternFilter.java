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
package com.verticon.tracker.editor.util;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import at.bestsolution.dataforms.util.viewers.GenericObservableMapCellLabelProvider;

class TableColumnPatternFilter extends ViewerFilter {

	private String patternString = "";
	private int columnIndex;

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (patternString == null) {
			return true;
		}
		String text = null;
		// If the viewer has a
		if (viewer instanceof ColumnViewer) {
			CellLabelProvider cellLabelProvider = ((ColumnViewer) viewer)
					.getLabelProvider(columnIndex);
			if (cellLabelProvider instanceof GenericObservableMapCellLabelProvider) {
				text = ((GenericObservableMapCellLabelProvider) cellLabelProvider)
						.getText(element);
			}
		}
		if (text == null) {
			IBaseLabelProvider baseLabelProvider = ((TableViewer) viewer)
					.getLabelProvider();
			if (baseLabelProvider instanceof ITableLabelProvider) {
				ITableLabelProvider tableLabelProvider = (ITableLabelProvider) baseLabelProvider;
				text = tableLabelProvider.getColumnText(element, columnIndex);
			} else if (baseLabelProvider instanceof ILabelProvider) {
				ILabelProvider labelProvider = (ILabelProvider) baseLabelProvider;
				text = labelProvider.getText(element);
			} else {
				
				text = element.toString();
			}
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
