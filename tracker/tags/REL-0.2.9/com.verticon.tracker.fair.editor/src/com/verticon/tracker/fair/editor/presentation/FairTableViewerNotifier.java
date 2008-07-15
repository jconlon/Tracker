/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.editor.presentation.EventsTableViewerNotifier;
import com.verticon.tracker.fair.FairPackage;

/**
 * @author jconlon
 * @deprecated use EventHistoryContentProvider. 
 */
public class FairTableViewerNotifier extends EventsTableViewerNotifier {

	/**
	 * ExhibitsTable to notify
	 */
	private final TableViewer exhibitsTableViewer;

	/**
	 * @param eventsTableViewer
	 */
	public FairTableViewerNotifier(TableViewer eventsTableViewer,
			TableViewer exhibitsTableViewer) {
		super(eventsTableViewer);
		this.exhibitsTableViewer = exhibitsTableViewer;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (exhibitsTableViewer == null) {
			logger.error("ExhibitsTableViewer is null.");
			return;
		}
		
		if (exhibitsTableViewer.getControl() == null) {
			logger.error("ExhibitsTableViewer getControl is null.");
			return;
		}
		
		if (exhibitsTableViewer.getControl().isDisposed()) {
//			logger.error("ExhibitsTableViewer getControl is Disposed.");
			return;
		}

		if (notification.getFeature() == FairPackage.eINSTANCE
				.getLot_Exhibits()) {
			logger.debug(
					"Calling NotifiedChangedToViewerRefresh for Lot_Exhibits, from a {}",
					notification.getNotifier().getClass());
			
			refreshViewer(exhibitsTableViewer);

		}

		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getLot_Name()) {
			logger.debug(
					"Refreshing eventsTable for Lot_Name");
			refreshViewer(exhibitsTableViewer);
		}
		
		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getClass_Name()) {
			logger.debug(
					"Refreshing eventsTable for Class_Name");
			refreshViewer(exhibitsTableViewer);
		}

		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getDivision_Name()) {
			logger.debug(
					"Refreshing eventsTable for Division_Name");
			refreshViewer(exhibitsTableViewer);
		}

		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getDepartment_Name()) {
			logger.debug(
					"Refreshing eventsTable for Department_Name");
			refreshViewer(exhibitsTableViewer);
		}

	}

}
