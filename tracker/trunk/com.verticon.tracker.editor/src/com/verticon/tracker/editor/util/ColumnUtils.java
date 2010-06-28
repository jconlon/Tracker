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

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

public class ColumnUtils {
	private static final String TAG_COLUMN_TEXT = "tagColumnText";
	private static final String TAG_COLUMN_VISIBLE = "tagColumnVisible";
	private static final String TAG_TYPE = "ColumnInfo";
	
	
	private ColumnUtils() {
		throw new AssertionError();
	}
	
	public static boolean isColumnVisible(IMemento memento, String columnText){
		if(memento==null){
			return true;
		}
		for (IMemento iMemento : memento.getChildren(TAG_TYPE)) {
			String tagColumnText = iMemento.getString(TAG_COLUMN_TEXT);
			if (tagColumnText == null || !tagColumnText.equals(getUIMessage(columnText))){
				continue;
			}
			Boolean visible = iMemento.getBoolean(TAG_COLUMN_VISIBLE);
			if(visible == null){
				return true;
			}
			return visible;
		}
		return true;
	}
	
    public static void createMenuItem( List<Action> actions, final TableColumn column, final int defaultSize,boolean visible) {
		Action action = new Action(getUIMessage(column.getText()),Action.AS_CHECK_BOX){
			@Override
			public void run() {
				if (isChecked()) {
					column.setWidth(defaultSize);
					column.setResizable(true);
				} else {
					column.setWidth(0);
					column.setResizable(false);
				}
			}
		};
		action.setChecked(visible);
		action.setToolTipText("Show Column");
		actions.add(action);
	}

   protected static void saveState(IMemento memento, List<Action> actions) {
		for (Action action : actions) {
			IMemento mem = memento.createChild(TAG_TYPE);
			mem.putString(TAG_COLUMN_TEXT, action.getText());
			mem.putBoolean(TAG_COLUMN_VISIBLE, action.isChecked());
		}
	}
    

	private static String getUIMessage(String columnText) {
		return "Show "+ columnText+" Column";
	}
}
