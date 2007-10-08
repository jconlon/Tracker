

package com.verticon.tracker.transaction.publisher.views;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import com.verticon.tracker.transaction.publisher.IPublisher;


/**
 * ICellModifier for the PublisherViewer
 * ICellModifier is called when the user modifes a cell in the 
 * PublisherViewer
 */

public class PublisherCellModifier implements ICellModifier {
	private PublisherViewer publisherViewer;
	/**
	 * Constructor 
	 * @param publisherViewer
	 */
	public PublisherCellModifier(PublisherViewer publisherViewer) {
		super();
		this.publisherViewer = publisherViewer;
	}

	/**
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}

	/**
	 * Note: Only the first 2 columns are used.
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	public Object getValue(Object element, String property) {

		// Find the index of the column
		int columnIndex = publisherViewer.getColumnNames().indexOf(property);

		Object result = null;
		IPublisher task = (IPublisher) element;

		switch (columnIndex) {
			case 0 : // Started 
				result = new Boolean(task.isStarted());
				break;
			case 1 : // Name 
				result = task.getName();
				break;
			case 2 : // Type 
				result = task.getType();		
				break;
			case 3 : // Template 
				result = task.getTemplate();
				break;
			case 4 : // Target 
				result = task.getTarget();
				break;
			default :
				result = "";
		}
		return result;	
	}

	/**
	 * Note: Only the first 2 columns are used.
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {	

		// Find the index of the column 
		int columnIndex	= publisherViewer.getColumnNames().indexOf(property);
			
		TableItem item = (TableItem) element;
		IPublisher publisher = (IPublisher) item.getData();
		String valueString;

		switch (columnIndex) {
			case 0 : // Started 
			    publisher.setStarted(((Boolean) value).booleanValue());
				break;
			case 1 : // Name 
				valueString = ((String) value).trim();
				publisher.setName(valueString);
				break;
			case 2 : // Type 
				valueString = ((String) value).trim();
				break;
			case 3 : // Template
				valueString = ((String) value).trim();
				publisher.setTemplate(valueString);
				break;
			case 4 : // Target
				valueString = ((String) value).trim();
				publisher.setTarget(valueString);
				break;
			default :
			}
		publisherViewer.getPublisherViewModel().publisherChanged(publisher);
	}
}
