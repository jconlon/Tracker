package com.verticon.tracker.ocl.query.viewer.views;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import com.verticon.tracker.ocl.query.viewer.IOclQuery;

/**
 * ICellModifier for the QueryViewer ICellModifier is called when the user
 * modifies a cell in the QueryViewer
 */

public class OclQueryCellModifier implements ICellModifier {
	private OclQueryViewer queryViewer;

	/**
	 * Constructor
	 * 
	 * @param queryViewer
	 */
	public OclQueryCellModifier(OclQueryViewer queryViewer) {
		super();
		this.queryViewer = queryViewer;
	}

	/**
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object,
	 *      java.lang.String)
	 */
	public Object getValue(Object element, String property) {

		// Find the index of the column
		int columnIndex = queryViewer.getColumnNames().indexOf(property);

		Object result = null;
		IOclQuery query = (IOclQuery) element;

		switch (columnIndex) {
		case 0: // Name
			result = query.getName();
			break;
		case 1: // Type
			String stringValue = query.getType();
			String[] choices = queryViewer.types();
			int i = choices.length - 1;
			while (!stringValue.equals(choices[i]) && i > 0)
				--i;
			result = new Integer(i);
			break;
		case 2: // Query
			result = query.getQuery();
			break;
		case 3: // Errors
			result = query.getErrorSyntax();
			break;
		default:
			result = "";
		}
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 *      java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {

		// Find the index of the column
		int columnIndex = queryViewer.getColumnNames().indexOf(property);

		TableItem item = (TableItem) element;
		IOclQuery query = (IOclQuery) item.getData();
		String valueString;

		switch (columnIndex) {
		case 0: // Name
			valueString = ((String) value).trim();
			query.setName(valueString);
			break;
		case 1: // Type
			valueString = queryViewer.types()[((Integer) value).intValue()]
					.trim();
			if (!query.getType().equals(valueString)) {
				query.setType(valueString);
			}
			break;
		case 2: // Query
			valueString = ((String) value).trim();
			query.setQuery(valueString);
			break;
		case 3: // Errors
			valueString = ((String) value).trim();
			query.setErrorSyntax(valueString);
			break;
		default:
		}
		queryViewer.getViewModel().queryChanged(query);
	}
}
