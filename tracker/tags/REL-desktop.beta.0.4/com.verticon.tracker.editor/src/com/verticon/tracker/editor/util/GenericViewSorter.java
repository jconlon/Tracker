package com.verticon.tracker.editor.util;

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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMemento;

/**
 * A viewer sorter is used by a structured viewer to reorder the elements
 * provided by its content provider. In our case, the
 * <code>GenericViewSorter</code> delegates sorting to the comparators. In
 * addition, the GenericViewSorter listens for mouse clicks in the column
 * headers and resorts the table content based on the column that was selected.
 * Clicking on a column a second time toggles the sort order.
 */
public class GenericViewSorter extends ViewerSorter
{
   private static final String TAG_DESCENDING = "descending";
   private static final String TAG_COLUMN_INDEX = "columnIndex";
   private static final String TAG_COLUMN_TEXT = "columnText";
   private static final String TAG_TYPE = "SortInfo";
   private static final String TAG_TRUE = "true";

   // Simple data structure for grouping
   // sort information by column.
   private static class SortInfo
   {
      int columnIndex;
      Comparator<Object> comparator;
      boolean descending;
      String text;
   }

   private TableViewer viewer;
   private SortInfo[] infos;

   public GenericViewSorter(TableViewer viewer,
         TableColumn[] columns, Comparator<Object>[] comparators) {
      this.viewer = viewer;
      infos = new SortInfo[columns.length];
      for (int i = 0; i < columns.length; i++) {
    	 infos[i] = new SortInfo();
         infos[i].columnIndex = i;
         infos[i].comparator = comparators[i];
         infos[i].descending = false;
         infos[i].text = columns[i].getText();//Needed for setting initial sort Column
         createSelectionListener(columns[i], infos[i]);
//         System.out.println(
//        		 "Creating SortInfo for column "+infos[i].text
//        		 +" index #"+columns[i]);
         
      }
   }

   public int compare(Viewer viewer, Object favorite1,
         Object favorite2) {
	  
      for (int i = 0; i < infos.length; i++) {
         int result =
               infos[i].comparator.compare(favorite1, favorite2);
         if (result != 0) {
//        	 System.out.println("Comparing column "+infos[i].text);
        	if (infos[i].descending)
               return -result;
            return result;
         }
      }
      return 0;
   }

   /**
    * Associate a SortInfo with each
    * @param column
    * @param info
    */
   private void createSelectionListener(final TableColumn column,
         final SortInfo info) {
      column.addSelectionListener(new SelectionAdapter() {
         public void widgetSelected(SelectionEvent e) {
        	 TableColumn col = (TableColumn) e.getSource();
             viewer.getTable().setSortColumn(col);
        	 sortUsing(info);
            
         }
      });
   }

  
   /**
    * Called from a columnSelectionListener. 
    * @param info assocated with the column
    */
   protected void sortUsing(SortInfo info) {
      if (info == infos[0]){
         info.descending = !info.descending;
      } else {
         for (int i = 0; i < infos.length; i++) {
        	//Find the info for this column in the array
            if (info == infos[i]) {
            	//copy 
               System.arraycopy(infos, 0, infos, 1, i);
               infos[0] = info;
               info.descending = false;
               break;
            }
         }
      }
      
      if(info.descending){
      	  viewer.getTable().setSortDirection(SWT.DOWN);
      }else{
    	  viewer.getTable().setSortDirection(SWT.UP);
      }
      viewer.refresh();
   }

   protected void saveState(IMemento memento) {
      for (int i = 0; i < infos.length; i++) {
         SortInfo info = infos[i];
         IMemento mem = memento.createChild(TAG_TYPE);
         //Save the column Index
         mem.putInteger(TAG_COLUMN_INDEX, info.columnIndex);
         //Save the column sort direction
         if (info.descending){
            mem.putString(TAG_DESCENDING, TAG_TRUE);
         }
         mem.putString(TAG_COLUMN_TEXT, info.text);
//         System.out.println("Saving memento child #"+i+" columnIndex "+
//        		 info.columnIndex+" text "+info.text);
      }
   }

   public void init(IMemento memento) {
      List<SortInfo> newInfos = new ArrayList<SortInfo>(infos.length);
      IMemento[] mems = memento.getChildren(TAG_TYPE);
      for (int i = 0; i < mems.length; i++) {
         IMemento mem = mems[i];
         Integer value = mem.getInteger(TAG_COLUMN_INDEX);
         if (value == null){
            continue;
         }
         int index = value.intValue();
         if (index < 0 || index >= infos.length){
            continue;
         }
         SortInfo info = infos[index];
         if (newInfos.contains(info)){
            continue;
         }
         info.descending =
               TAG_TRUE.equals(mem.getString(TAG_DESCENDING));
         info.text = mem.getString(TAG_COLUMN_TEXT);
         newInfos.add(info);
//         System.out.println("Memento Added New SortInfo at index "+index+ 
//        		 " descending "+info.descending+ " text:"+info.text);
         
      }
      for (int i = 0; i < infos.length; i++){
         if (!newInfos.contains(infos[i])){
            newInfos.add(infos[i]);
         }
      }
      infos = newInfos.toArray(new SortInfo[newInfos.size()]);
      SortInfo primaryInfo = infos[0];
      
      Table table = viewer.getTable();
      for (TableColumn tableColumn : table.getColumns()) {
		if(primaryInfo.text.equals(tableColumn.getText())){
		      table.setSortColumn(tableColumn);
		      if(primaryInfo.descending){
		        	table.setSortDirection(SWT.DOWN);
		        }else{
		      	    table.setSortDirection(SWT.UP);
		        }
		}
      }
      
   }
}