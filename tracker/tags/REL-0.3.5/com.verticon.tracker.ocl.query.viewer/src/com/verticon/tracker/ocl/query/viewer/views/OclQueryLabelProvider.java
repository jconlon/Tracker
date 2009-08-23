package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * 
 * Label provider for the QueryViewer
 * 
 * @see org.eclipse.jface.viewers.LabelProvider
 */
class OclQueryLabelProvider extends LabelProvider implements
		ITableLabelProvider {
	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object,
	 *      int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		IOclQuery publisher = (IOclQuery) element;
		switch (columnIndex) {
		case 0:
			result = publisher.getName();
			break;
		case 1:
			result = publisher.getType();
			break;
		case 2:
			result = publisher.getQuery();
			break;
		case 3:
			result = publisher.getErrorSyntax();
			break;
		default:
			break;
		}
		return result;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object,
	 *      int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return (columnIndex == 0) ? null : null;
	}

}
