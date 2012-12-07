/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.editor.handlers;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.handlers.HandlerUtil;

import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.Premises;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.TrackerPlugin;

/**
 * When animals are movedIn or are movedOut, keeping track of Premises uri keys
 * and pins is tedious and error prone.
 * 
 * Once a location service has this recorded there is no need to remember them
 * again. Just query the Location Service and provide a Dialog box with a table
 * of premises URI keys and name values.
 * 
 * If pulled down on the MovedOut or the MovedIn it will then add the uri and if
 * appropriate add the Pin. Then it will resolve the geo location on the animal.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class GetAssociateNamesHandler extends AbstractHandler {

	private static final String URN_PIN = "urn:pin:";

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sselection = (IStructuredSelection) selection;
			if (sselection.getFirstElement() instanceof Event) {
				handle(event, (Event) sselection.getFirstElement());
			}
		}
		return null;

	}

	private void handle(ExecutionEvent executionEvent, Event event)
			throws ExecutionException {
		if (TrackerPlugin.getDefault().hasLocationService()
				&& event.getTag() != null) {
			if (event.getTag().getAnimal() != null) {
				if (event.getTag().getAnimal().eContainer() != null) {
					Premises premises = (Premises) event.getTag().getAnimal()
							.eContainer();
					if (premises.getUri() == null) {
						return;
					}
					Map<String, String> associates = TrackerPlugin.getDefault()
							.getAssociates(premises.getUri());
					Entry<String, String> entry = promptUser(executionEvent,
							associates, event);
					if (entry == null) {
						return;
					}
					set(entry, event);
				}
			}
		}

	}

	/**
	 * This will set the uri, the source or destination name and the pin if the
	 * uri begins with the urn:pin: format
	 * 
	 * @param entry
	 * @param event
	 */
	private void set(Entry<String, String> entry, Event event) {
		String uri = entry.getKey();
		AdapterFactoryEditingDomain ed = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(event);
		CompoundCommand cc = new CompoundCommand();
		String pin = parsePin(uri);
		if (event instanceof MovedIn) {
			MovedIn movedIn = (MovedIn) event;
			cc.append(SetCommand.create(ed, movedIn, // owner
					TrackerPackage.Literals.MOVED_IN__URI, uri));

			cc.append(SetCommand.create(ed, movedIn, // owner
					TrackerPackage.Literals.MOVED_IN__SOURCE_PIN, pin));

		} else if (event instanceof MovedOut) {
			MovedOut movedOut = (MovedOut) event;
			cc.append(SetCommand.create(ed, movedOut, // owner
					TrackerPackage.Literals.MOVED_OUT__URI, uri));

			cc.append(SetCommand.create(ed, movedOut, // owner
					TrackerPackage.Literals.MOVED_OUT__DESTINATION_PIN, pin));

		}
		ed.getCommandStack().execute(cc);
	}

	// urn:pin:H89234X
	private static String parsePin(String uri) {
		String result = null;
		if (uri.startsWith(URN_PIN)) {
			result = uri.replace(URN_PIN, "");
		}
		return result;
	}

	/**
	 * TODO Prompt user with a dialog that has a table of the associations
	 * 
	 * @param executionEvent
	 * @param associates
	 * @param event
	 * @return entry or null
	 */
	private Entry<String, String> promptUser(ExecutionEvent executionEvent,
			Map<String, String> associates, Event event) {
		
		//Sort on values
		ValueComparator bvc =  new ValueComparator(associates);
        TreeMap<String,String> sorted_map = new TreeMap<String,String>(bvc);
        sorted_map.putAll(associates);
        //Convert to an array of entries
        Set<Entry<String, String>> entries = sorted_map.entrySet();
		Object[] array = entries.toArray();
		//prompt
		MyTitleAreaDialog dialog = new MyTitleAreaDialog(
				HandlerUtil.getActiveShell(executionEvent), array);
		
		if (dialog.open() != Window.OK) {
			return null; //canceled
		}
		return dialog.getResult();
	}

}
/**
 * Dialog with a table
 * @author jconlon
 *
 */
class MyTitleAreaDialog extends TitleAreaDialog {

	// private Table table;
	private final Object[] elements;
	private TableViewer viewer;
	private Entry<String, String> result = null;

	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public MyTitleAreaDialog(Shell shell, Object[] elements) {
		super(shell);
		this.elements = elements;
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);

		// Set the title
		setTitle("Business Associates");

		// Set the message
		setMessage("Choose the Premises to use to for the Move Event", IMessageProvider.INFORMATION);

		return contents;
	}

	/**
	 * Creates the gray area
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		Table table = new Table(composite, SWT.FULL_SELECTION | SWT.BORDER);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Create two columns and show
		TableColumn one = new TableColumn(table, SWT.LEFT);
		one.setText("Real Name");

		TableColumn two = new TableColumn(table, SWT.LEFT);
		two.setText("Preferred Name");

		table.setHeaderVisible(true);
		viewer = new TableViewer(table);

		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("Premises Name");
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				@SuppressWarnings("unchecked")
				Entry<String, String> entry = (Entry<String, String>) element;
				return entry.getValue();
			}
		});

		col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("URN");
		col.setLabelProvider(new ColumnLabelProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public String getText(Object element) {
				Entry<String, String> entry = (Entry<String, String>) element;
				return entry.getKey();
			}
		});

		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(elements);

		return composite;
	}

	Entry<String, String> getResult() {
		return result;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent
	 *            the parent composite
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				false);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, true);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void okPressed() {
		StructuredSelection selection = (StructuredSelection) viewer
				.getSelection();
		result = selection.getFirstElement() != null ? (Entry<String, String>) selection
				.getFirstElement() : null;
		super.okPressed();
	}
}

class ValueComparator implements Comparator<String> {

    Map<String, String> base;
    public ValueComparator(Map<String, String> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
    	return base.get(a).compareTo(base.get(b));
    }
}