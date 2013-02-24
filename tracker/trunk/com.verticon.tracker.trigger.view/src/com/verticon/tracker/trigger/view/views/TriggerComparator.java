package com.verticon.tracker.trigger.view.views;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

import com.verticon.tracker.trigger.view.ITriggerEntry;

public class TriggerComparator extends ViewerComparator {
	private int propertyIndex;
	private static final int DESCENDING = 1;
	private int direction = DESCENDING;

	public TriggerComparator() {
		this.propertyIndex = 0;
		direction = DESCENDING;
	}

	public int getDirection() {
		return direction == 1 ? SWT.DOWN : SWT.UP;
	}

	public void setColumn(int column) {
		if (column == this.propertyIndex) {
			// Same column as last sort; toggle the direction
			direction = 1 - direction;
		} else {
			// New column; do an ascending sort
			this.propertyIndex = column;
			direction = DESCENDING;
		}
	}


	/**
	 * Returns a number reflecting the collation order of the given query based
	 * on their Target.
	 * 
	 * @param o1
	 *            the first resource element to be ordered
	 * @param o2
	 *            the second resource element to be ordered
	 * @return a negative number if the first element is less than the second
	 *         element; the value <code>0</code> if the first element is equal
	 *         to the second element; and a positive number if the first element
	 *         is greater than the second element
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		checkNotNull(viewer);
		checkNotNull(o1);
		if (o2 == null) {
			return 1;
		}
		ITriggerEntry entry1 = (ITriggerEntry) o1;
		ITriggerEntry entry2 = (ITriggerEntry) o2;

		Column criteria = Column.get(propertyIndex);

		int rc = 0;
		switch (criteria) {
		case NAME:
			rc = getComparator().compare(entry1.getName(), entry2.getName());
			break;
		case COMMENTS:
			rc = getComparator().compare(entry1.getComments(),
					entry2.getComments());
			break;
		case STATUS:
			rc = getComparator()
					.compare(entry1.getStatus(),
					entry2.getStatus());
			break;
		case FILE:
			rc = getComparator()
					.compare(
							entry1.getFile() != null ? entry1.getFile()
									.toString() : "",
							entry2.getFile() != null ? entry2.getFile()
									.toString() : "");
			break;

		case PRINTER:
			rc = getComparator().compare(entry1.getPrinter(),
					entry2.getPrinter());
			break;
		case LOT:
			rc = getComparator().compare(entry1.getLot(), entry2.getLot());
			break;
		case VALUES:
			rc = getComparator()
					.compare(entry1.getValues(),
					entry2.getValues());
			break;
		case REQUIRE_LOT:
			rc = getComparator().compare(entry1.isRequireLot() + "",
					entry2.isRequireLot() + "");
			break;
		case REQUIRE_VALUES:
			rc = getComparator().compare(entry1.getRequireValues(),
					entry2.getRequireValues());
			break;
		default:

			throw new IllegalArgumentException("Unknow critera: " + criteria);
		}

		// If descending order, flip the direction
		if (direction == DESCENDING) {
			rc = -rc;
		}
		return rc;

	}
}
