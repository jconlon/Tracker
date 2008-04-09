/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.ui.provider.NotifyChangedToViewerRefresh;
import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.EventsTableViewerNotifier;
import com.verticon.tracker.fair.FairPackage;

/**
 * @author jconlon
 * 
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

		// FairPackage.LOT__EXHIBITS
		if (notification.getFeature() == FairPackage.eINSTANCE
				.getLot_Exhibits()) {
			logger.debug(
					"Calling NotifiedChangedToViewerRefresh for Lot_Exhibits, from a {}",
					notification.getNotifier().getClass());
			
			NotifyChangedToViewerRefresh.handleNotifyChanged(
					exhibitsTableViewer, notification.getNotifier(),
					notification.getEventType(), notification.getFeature(),
					notification.getOldValue(), notification.getNewValue(),
					notification.getPosition());

		}
		// FairPackage.LOT__NAME
		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getLot_Name()) {
			logger.debug(
					"Calling Refreshing eventsTable for Lot_Name, from a {}",
					notification.getNotifier().getClass());

			// Instead of figuring out the specifics just refresh
			exhibitsTableViewer.refresh();
		}
		
//		FairPackage.CLASS__NAME
		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getClass_Name()) {
			logger.debug(
					"Calling Refreshing eventsTable for Class_Name, from a {}",
					notification.getNotifier().getClass());

			// Instead of figuring out the specifics just refresh
			exhibitsTableViewer.refresh();
		}
//		FairPackage.DIVISION__NAME
		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getDivision_Name()) {
			logger.debug(
					"Calling Refreshing eventsTable for Division_Name, from a {}",
					notification.getNotifier().getClass());

			// Instead of figuring out the specifics just refresh
			exhibitsTableViewer.refresh();
		}
//		FairPackage.DEPARTMENT__NAME
		else if (notification.getFeature() == FairPackage.eINSTANCE
				.getDepartment_Name()) {
			logger.debug(
					"Calling Refreshing eventsTable for Department_Name, from a {}",
					notification.getNotifier().getClass());

			// Instead of figuring out the specifics just refresh
			exhibitsTableViewer.refresh();
		}

	}

}
