package com.verticon.tracker.views.propertyTester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.verticon.tracker.MovedIn;
import com.verticon.tracker.MovedOut;
import com.verticon.tracker.editor.util.TrackerView;
import com.verticon.tracker.views.EventsView;

public class TrackerViewTester extends PropertyTester {

	private static final String IS_MOVEDOUT = "isMovedOut";
	private static final String IS_MOVEDIN = "isMovedIn";

	@Override
	/**
	 * @return true if Active Editor is managing a Premises and is non-transactional.
	 */
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {

		boolean passedTest = false;
		if (IS_MOVEDIN.equals(property)) {
			if (validateIsEventsView()) {
				StructuredSelection sel = getSelection();
				if (sel.size() == 1) {
					passedTest = sel.getFirstElement() instanceof MovedIn;

				}
			}
		} else if (IS_MOVEDOUT.equals(property)) {
			if (validateIsEventsView()) {
				StructuredSelection sel = getSelection();
				if (sel.size() == 1) {
					passedTest = sel.getFirstElement() instanceof MovedOut;
				}
			}
		}

		return passedTest;
	}

	private StructuredSelection getSelection() {
		TrackerView view = (TrackerView) getPart();
		StructuredSelection sel = (StructuredSelection) view
				.getMasterFilteredTable().getViewer().getSelection();
		return sel;
	}

	private boolean validateIsEventsView() {
		IWorkbenchPart part = getPart();
		return part != null ? part instanceof EventsView : false;
	}

	private IWorkbenchPart getPart() {
		IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) {
			return null;
		}
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		if (win == null) {
			return null;
		}
		IWorkbenchPage page = win.getActivePage();
		if (page == null) {
			return null;
		}

		return page.getActivePart();

	}
}
