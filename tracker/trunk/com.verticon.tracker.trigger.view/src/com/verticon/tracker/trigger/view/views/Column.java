/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

import com.verticon.tracker.trigger.view.ITriggerEntry;
import com.verticon.tracker.trigger.view.TriggerEntryFactory;
import com.verticon.tracker.trigger.view.TriggerViewPlugin;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;

/**
 * 
 * @author jconlon
 * 
 */
enum Column {
	NAME("name", "Name", 210, 12), //
	COMMENTS("comments", "Comments", 80, 13), //
	STATUS("status", "Status", 400, 15), //
	FILE("file", "File", 70, 10), //
	PRINTER("printer", "Printer", 70, 5), //
	LOT("lot", "Lot", 70, 10), //
	VALUES("values", "Values", 70, 10), //
	REQUIRE_LOT("requireLot", " Require Lot", 20, 5), //
	REQUIRE_VALUES("requireValues", "Required Values", 20, 20);

	final String property;
	final int width;
	final String text;
	final int weight;

	static List<String> columnNames;
	static String[] colNames;
	private static Image CHECKED = TriggerViewPlugin.getImageDescriptor(
			"icons/checked.gif").createImage();
	private static Image UNCHECKED = TriggerViewPlugin.getImageDescriptor(
			"icons/unchecked.gif").createImage();

	private Column(String property, String text, int width, int weight) {
		this.property = property;
		this.width = width;
		this.text = text;
		this.weight = weight;
	}

	static {
		columnNames = new ArrayList<String>();
		for (Column col : Column.values()) {
			columnNames.add(col.property);
		}

		colNames = new String[columnNames.size()];
		columnNames.toArray(colNames);
	}

	static Column get(int ordinal) {
		for (Column column : values()) {
			if (column.ordinal() == ordinal) {
				return column;
			}
		}
		throw new IllegalArgumentException("Unknown ordinal: " + ordinal);
	}

	/**
	 * Load the entry in the Memento
	 * 
	 * @param child
	 * @return
	 */
	static ITriggerEntry load(IMemento child) {
		ITriggerEntry entry = TriggerEntryFactory.create();

		for (Column column : values()) {
			switch (column) {
			case NAME:
				entry.setName(child.getString(column.property));
				break;
			case COMMENTS:
				entry.setComments(child.getString(column.property));
				break;
			case LOT:
				entry.setLot(child.getString(column.property));
				break;
			case VALUES:
				entry.setValues(child.getString(column.property));
				break;
			case PRINTER:
				entry.setPrinter(child.getString(column.property));
				break;
			case FILE:
				String fs = child.getString(column.property);
				entry.setFile(fs != null ? new File(fs) : null);
				break;
			case STATUS:
				// dont load or save status
				break;
			case REQUIRE_LOT:
				entry.setRequireLot(child.getBoolean(column.property));
				break;
			case REQUIRE_VALUES:
				entry.setRequireValues(child.getString(column.property));
				break;
			default:
				throw new UnsupportedOperationException(column
						+ " load not implemented.");
			}
		}
		return entry;
	}

	/**
	 * Save the entry in the Memento
	 * 
	 * @param child
	 * @param entry
	 */
	static void save(IMemento child, ITriggerEntry entry) {
		for (Column column : values()) {
			switch (column) {
			case NAME:
				child.putString(column.property, entry.getName());
				break;
			case COMMENTS:
				child.putString(column.property, entry.getComments());
				break;
			case LOT:
				child.putString(column.property, entry.getLot());
				break;
			case VALUES:
				child.putString(column.property, entry.getValues());
				break;
			case PRINTER:
				child.putString(column.property, entry.getPrinter());
				break;
			case FILE:
				child.putString(column.property,
						entry.getFile() != null ? entry.getFile().toString()
								: null);
				break;
			case STATUS:
				// dont load or save status
				break;
			case REQUIRE_LOT:
				child.putBoolean(column.property, entry.isRequireLot());
				break;
			case REQUIRE_VALUES:
				child.putString(column.property, entry.getRequireValues());
				break;
			default:
				throw new UnsupportedOperationException(column
						+ " load not implemented.");
			}
		}

	}

	/**
	 * Current way to create a TableViewerColumn
	 * 
	 * @param menu
	 * @param viewer
	 * @param tableColumnLayout
	 */
	static void createTableViewerColumns(Menu menu, final TableViewer viewer,
			TableColumnLayout tableColumnLayout) {
		checkNotNull(viewer);
		for (Column column : values()) {
			TableViewerColumn col = createTableViewerColumn(column, viewer);
			createMenuItem(menu, col.getColumn());
			tableColumnLayout.setColumnData(col.getColumn(),
					new ColumnWeightData(column.weight));
			switch (column) {
			case PRINTER:
			case NAME:
			case COMMENTS:
			case VALUES:
			case LOT:
			case REQUIRE_VALUES:
			case FILE:
				final Column a = Column.get(column.ordinal());

				col.setLabelProvider(new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						ITriggerEntry entry = (ITriggerEntry) element;
						return a.getText(entry);
					}
				});

				col.setEditingSupport(new EditingSupport(viewer) {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#getCellEditor
					 * (java.lang.Object)
					 */
					@Override
					protected CellEditor getCellEditor(Object element) {
						return a.createCellEditor(viewer.getTable(), element);
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#canEdit(java
					 * .lang.Object)
					 */
					@Override
					protected boolean canEdit(Object element) {
						return true;
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#getValue(java
					 * .lang.Object)
					 */
					@Override
					protected Object getValue(Object element) {
						return a.getValue((ITriggerEntry) element);
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#setValue(java
					 * .lang.Object, java.lang.Object)
					 */
					@Override
					protected void setValue(Object element, Object value) {
						a.setValue((ITriggerEntry) element, value);
						viewer.update(element, null);
					}
				});

				break;
			case STATUS:

				col.setLabelProvider(new ColumnLabelProvider() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.ColumnLabelProvider#getForeground
					 * (java.lang.Object)
					 */
					@Override
					public Color getForeground(Object element) {
						ITriggerEntry entry = (ITriggerEntry) element;
						int status = entry.validateEntry().getSeverity();
						switch (status) {
						case IStatus.ERROR:
							return Display.getCurrent().getSystemColor(
									SWT.COLOR_RED);

						case IStatus.WARNING:
							return Display.getCurrent().getSystemColor(
									SWT.COLOR_YELLOW);

						case IStatus.OK:
							return Display.getCurrent().getSystemColor(
									SWT.COLOR_DARK_GREEN);
						default:
							break;
						}
						return super.getForeground(element);
					}

					@Override
					public String getText(Object element) {
						ITriggerEntry entry = (ITriggerEntry) element;
						return STATUS.getText(entry);
					}
				});

				break;
			case REQUIRE_LOT:
				col.setLabelProvider(new ColumnLabelProvider() {
					@Override
					public String getText(Object element) {
						return null;
					}

					@Override
					public Image getImage(Object element) {
						if (((ITriggerEntry) element).isRequireLot()) {
							return CHECKED;
						}
						return UNCHECKED;
					}
				});
				col.setEditingSupport(new EditingSupport(viewer) {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#getCellEditor
					 * (java.lang.Object)
					 */
					@Override
					protected CellEditor getCellEditor(Object element) {
						return REQUIRE_LOT.createCellEditor(viewer.getTable(),
								null);
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#canEdit(java
					 * .lang.Object)
					 */
					@Override
					protected boolean canEdit(Object element) {
						return true;
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#getValue(java
					 * .lang.Object)
					 */
					@Override
					protected Object getValue(Object element) {
						return REQUIRE_LOT.getValue((ITriggerEntry) element);
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.jface.viewers.EditingSupport#setValue(java
					 * .lang.Object, java.lang.Object)
					 */
					@Override
					protected void setValue(Object element, Object value) {
						REQUIRE_LOT.setValue((ITriggerEntry) element, value);
						viewer.update(element, null);
					}
				});
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Used by the cell modifier
	 * 
	 * @param entry
	 * @return value in this entry column
	 */
	private Object getValue(ITriggerEntry entry) {
		Object result = null;
		switch (this) {
		case NAME:
			result = entry.getName();
			break;
		case COMMENTS:
			result = entry.getComments();
			break;
		case STATUS:
			result = entry.validateEntry();
			break;
		case FILE:
			result = entry.getFile();
			break;
		case PRINTER:
			result = entry.getPrinter();
			break;
		case LOT:
			result = entry.getLot();
			break;
		case VALUES:
			result = entry.getValues();
			break;
		case REQUIRE_LOT:
			result = entry.isRequireLot();
			break;
		case REQUIRE_VALUES:
			result = entry.getRequireValues() + "";
			break;
		default:
			break;
		}

		return result;
	}

	// private String cleanUpMessage(MultiStatus status) {
	//
	// }
	/**
	 * Used by the label provider
	 * 
	 * @param entry
	 * @return text in this entry column
	 */
	private String getText(ITriggerEntry entry) {
		String result = "";

		switch (this) {
		case FILE:
			File file = entry.getFile();
			if (file == null) {
				result = "";
			} else {
				IPreferenceStore store = TriggerViewPlugin.getDefault()
						.getPreferenceStore();
				boolean showPath = store
						.getBoolean(PreferenceConstants.P_SHOW_LABEL_PATH_BOOLEAN);

				result = showPath ? file.toString() : file.getName();
			}

			break;
		case STATUS:
			IStatus status = entry.validateEntry();
			if(status.isMultiStatus()){
				result = status.isOK() ? "OK" : status.getMessage();
			}else{
				result = status.matches(IStatus.OK) ? "" : status.getMessage();
			}

			
			break;
		case REQUIRE_LOT:
			// result = null;// entry.isRequireLot() ? "true" : "false";
			break;
		case REQUIRE_VALUES:
			result = entry.getRequireValues() + "";
			break;
		case NAME:

		case COMMENTS:

		case PRINTER:

		case LOT:

		case VALUES:

		default:
			result = (String) getValue(entry);
			break;
		}

		return result;
	}

	/**
	 * Used by the Cell Modifier
	 * 
	 * @param entry
	 * @param value
	 */
	private void setValue(ITriggerEntry entry, Object value) {
		String valueString;
		switch (this) {
		case NAME:
			valueString = ((String) value).trim();
			entry.setName(valueString);
			break;
		case COMMENTS:
			// String valueString = viewer.types()[((Integer)
			// value).intValue()]
			// .trim();
			// if (!entry.getComments().equals(valueString)) {
			// entry.setComments(valueString);
			// }
			valueString = ((String) value).trim();
			entry.setComments(valueString);
			break;
		case STATUS:
			valueString = ((String) value).trim();
			entry.setStatus(valueString);
			break;
		case FILE:
			// if the value is null or empty save as a null
			if (value != null) {
				if (value instanceof File) {
					entry.setFile((File) value);

				} else {
					valueString = ((String) value).trim();
					if (isNullOrEmpty(valueString)) {
						entry.setFile(null);
					} else {
						entry.setFile(new File(valueString));
					}
				}
				break;
			}
			entry.setFile(null);

			break;
		case PRINTER:
			valueString = ((String) value).trim();
			entry.setPrinter(valueString);
			break;
		case LOT:
			valueString = ((String) value).trim();
			entry.setLot(valueString);
			break;
		case VALUES:
			valueString = ((String) value).trim();
			entry.setValues(valueString);
			break;
		case REQUIRE_LOT:
			entry.setRequireLot((Boolean) value);
			break;
		case REQUIRE_VALUES:
			// if (value instanceof Integer) {
			// entry.setRequireValues((Integer) value);
			// } else if (value instanceof String) {
			// valueString = ((String) value).trim();
			// if (valueString.length() == 0)
			// valueString = "0";
			// entry.setRequireValues(Integer.parseInt(valueString));
			// }
			valueString = ((String) value).trim();
			entry.setRequireValues(valueString);
			break;
		default:
			break;
		}

	}

	private CellEditor createCellEditor(Table table, Object element) {
		switch (this) {
		case COMMENTS:
		case NAME:
		case VALUES:
		case LOT:
			return new TextCellEditor(table);
		case REQUIRE_VALUES:
			return new RequiredValuesDialogCellEditor(
					table,
					"Required Values",
					"Create a comma seperated list of names that are the Required Values for this trigger.",
					(ITriggerEntry) element);
		case FILE:
			return new FileDialogCellEditor(table, "Choose a label"// dialogText
			);
		case PRINTER:
			return new PrinterDialogCellEditor(table, "Printers",
					"Choose a Printer");
		case REQUIRE_LOT:
			return new CheckboxCellEditor(table);
			// case REQUIRE_VALUES:
			//
			// TextCellEditor tce = new TextCellEditor(table);
			// tce = new TextCellEditor(table);
			// ((Text) tce.getControl()).addVerifyListener(
			//
			// new VerifyListener() {
			// @Override
			// public void verifyText(VerifyEvent e) {
			// // Here, we could use a RegExp such as the following
			// // if using JRE1.4 such as e.doit =
			// // e.text.matches("[\\-0-9]*");
			// e.doit = "0123456789".indexOf(e.text) >= 0;
			// }
			// });
			// return tce;
		default:
			break;
		}

		return null;

	}

	// The createMenuItem method add per column a
	// new MenuItem to the menu
	private static void createMenuItem(Menu parent, final TableColumn column) {
		final MenuItem itemName = new MenuItem(parent, SWT.CHECK);
		itemName.setText(column.getText());
		itemName.setSelection(column.getResizable());
		itemName.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (itemName.getSelection()) {
					column.setWidth(150);
					column.setResizable(true);
				} else {
					column.setWidth(0);
					column.setResizable(false);
				}
			}
		});
	}

	private static TableViewerColumn createTableViewerColumn(Column col,
			TableViewer viewer) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn tableColumn = viewerColumn.getColumn();
		tableColumn.setText(col.text);
		tableColumn.setWidth(col.width);
		tableColumn.setResizable(true);
		tableColumn.setMoveable(true);
		tableColumn.addSelectionListener(getSelectionAdapter(tableColumn,
				col.ordinal(), viewer));
		return viewerColumn;
	}

	private static SelectionAdapter getSelectionAdapter(
			final TableColumn column, final int index, final TableViewer viewer) {

		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TriggerComparator comparator = (TriggerComparator) viewer
						.getComparator();
				comparator.setColumn(index);
				int dir = comparator.getDirection();
				viewer.getTable().setSortDirection(dir);
				viewer.getTable().setSortColumn(column);
				viewer.refresh();
			}
		};
		return selectionAdapter;
	}

}