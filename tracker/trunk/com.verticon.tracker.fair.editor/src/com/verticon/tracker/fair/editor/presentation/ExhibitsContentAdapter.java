package com.verticon.tracker.fair.editor.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;

import com.verticon.tracker.fair.Department;
import com.verticon.tracker.fair.Division;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairPackage;
import com.verticon.tracker.fair.Lot;

public class ExhibitsContentAdapter extends AdapterFactoryContentProvider {
	
	public ExhibitsContentAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		return ((Fair) object).exhibits().toArray();
	}

	/**
	 * Exhibits table shows the hierarchy elements of the Exhibit. These
	 * elements are shown in the table columns through ItemProviders so
	 * they by default adapt to a string based on the name of these elements.
	 * 
	 * Detecting changes to these hierarchy element names will be used to trigger 
	 * viewer.refresh.
	 * 
	 * Additions and deletions are handled more discreetly 
	 * with NotifyChangedToViewerRefresh.
	 * 
	 */
	@Override
	public void notifyChanged(Notification n) {
		super.notifyChanged(n);
		Object notifier = n.getNotifier();
		// find out the type of the notifier which could be either 'Log'
		// or 'Exhibit'

		if (notifier instanceof Lot) {
			handleLotNotification(n);
		} else if (notifier instanceof com.verticon.tracker.fair.Class) {
			handleClassNotification(n);
		}else if (notifier instanceof Department) {
			handleDepartmentNotification(n);
		}else if (notifier instanceof Division) {
			handleDivisionNotification(n);
		}

	}
	
	// output a message about changes to the Class Name
	private void handleDepartmentNotification(Notification n) {
		int featureID = n.getFeatureID(Lot.class);
		if (featureID == FairPackage.DEPARTMENT__NAME) {
			((TableViewer)viewer).refresh();
			//Updating the table does nothing since the modeled objects do not change
			//The hierarchy changes
//			Department department = 
//				(Department)n.getNotifier();
//			EList<Exhibit> changedExhibits = new BasicEList<Exhibit>();
//			for (com.verticon.tracker.fair.Class clss : department.getClasses()) {
//					for (Lot lot : clss.getLots()) {
//						changedExhibits.addAll(lot.getExhibits());
//					}
//			}
//			logger.debug("Department name {} changed to {}, {} exhibits updated", 
//					 new Object[] {
//						n.getOldStringValue(),
//						n.getNewStringValue(),
//						changedExhibits.size()
//						});
		}
		
	}
	
	// output a message about changes to the Class Name
	private void handleDivisionNotification(Notification n) {
		int featureID = n.getFeatureID(Lot.class);
		if (featureID == FairPackage.DIVISION__NAME) {
			((TableViewer)viewer).refresh();
		
//			Division div = 
//				(Division)n.getNotifier();
//			EList<Exhibit> changedExhibits = new BasicEList<Exhibit>();
//			for (Department department : div.getDepartments()) {
//				for (com.verticon.tracker.fair.Class clss : department.getClasses()) {
//					for (Lot lot : clss.getLots()) {
//						changedExhibits.addAll(lot.getExhibits());
//					}
//				}
//				
//			}
//			logger.debug("Division name {} changed to {}, {} exhibits updated", 
//					 new Object[] {
//						n.getOldStringValue(),
//						n.getNewStringValue(),
//						changedExhibits.size()
//						});
		}
	}
	

	// output a message about changes to the Class Name
	private void handleClassNotification(Notification n) {
		int featureID = n.getFeatureID(Lot.class);
		if (featureID == FairPackage.CLASS__NAME) {
			((TableViewer)viewer).refresh();
//			com.verticon.tracker.fair.Class clss = 
//				(com.verticon.tracker.fair.Class)n.getNotifier();
//			EList<Exhibit> changedExhibits = new BasicEList<Exhibit>();
//			for (Lot lot : clss.getLots()) {
//				changedExhibits.addAll(lot.getExhibits());
//			}
//			tableViewer.update(changedExhibits, null);
//			logger.debug("Class name {} changed to {}, {} exhibits updated", 
//					 new Object[] {
//						n.getOldStringValue(),
//						n.getNewStringValue(),
//						changedExhibits.size()
//						});
		}
	}

	// output a message about new exhibits
	private void handleLotNotification(Notification n) {
		int featureID = n.getFeatureID(Lot.class);
		if (featureID == FairPackage.LOT__NAME) {
			((TableViewer)viewer).refresh();
//			Lot lot = (Lot) n.getNotifier();
//			EList<Exhibit> changedExhibits = lot.getExhibits();
//			tableViewer.update(changedExhibits, null); does nothing
//			logger.debug("Lot name {} changed to {}, {} exhibits updated", 
//					 new Object[] {
//						n.getOldStringValue(),
//						n.getNewStringValue(),
//						changedExhibits.size()
//						});
		}
	}


}
