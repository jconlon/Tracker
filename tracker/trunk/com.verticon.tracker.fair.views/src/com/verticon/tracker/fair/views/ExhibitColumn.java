package com.verticon.tracker.fair.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;

import com.verticon.tracker.fair.views.PeopleView.PeopleColumn;

/**
	 * Enum on Exhibit Element
	 * @author jconlon
	 *
	 */
	public enum ExhibitColumn {
		NAME("Exhibit",new ColumnWeightData(3, 100, true)), 
		NUMBER("Number",new ColumnWeightData(3, 30, true)), 
		EXHIBITOR("Exhibitor",new ColumnWeightData(2, 150, true)),
		ANIMAL("Animal",new ColumnWeightData(2, 200, true)),
		LOT("Lot",new ColumnWeightData(2, 150, true)),
		CLASS("Class",new ColumnWeightData(2, 150, true)),
		DEPARTMENT("Department",new ColumnWeightData(2, 150, true)),
		DIVISION("Division",new ColumnWeightData(2, 150, true)),
		COMMENTS("Comments",new ColumnWeightData(2, 120, true));

		ColumnLayoutData layoutData;
		String text;
		static List<String> columnNames;
		static String[] colNames;
		

		ExhibitColumn(String text, ColumnLayoutData layoutData) {
			this.text = text;
			this.layoutData = layoutData;
		}
		
		static {
			columnNames = new ArrayList<String>();
			for (PeopleColumn col : PeopleColumn.values()) {
				columnNames.add(col.name());
			}

			colNames = new String[columnNames.size()];
			columnNames.toArray(colNames);
		}

	}