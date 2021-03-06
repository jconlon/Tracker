package com.verticon.tracker.fair.edit.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.FairPackage;

/**
 * Non-model based YouthClubs node in the Tree View
 * Created for Ticket 240 
 * See EMF Modeling book 14.2.3
 * @author jconlon
 *
 */
public class YouthClubsItemProvider extends TransientFairItemProvider {

	public YouthClubsItemProvider(AdapterFactory adapterFactory, Fair fair) {
		super(adapterFactory, fair);
	}

	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		
		newChildDescriptors.add
			(createChildParameter
				(FairPackage.Literals.FAIR__YOUTH_CLUBS,
				 FairFactory.eINSTANCE.createYouthClub()));
	}

	
	@SuppressWarnings("deprecation")
	@Override
	protected Collection<? extends EReference> getChildrenReferences(
			Object object) {
		if(childrenReferences == null){
			super.getChildrenReferences(object);
			childrenReferences.add(FairPackage.eINSTANCE.getFair_YouthClubs());
		}
		return super.getChildrenReferences(object);
	}
	
	

	@Override
	public String getText(Object object) {
		return "Youth Clubs";
	}

	@Override
	public void notifyChanged(Notification notification) {
		switch (notification.getFeatureID(Fair.class)){
		case FairPackage.FAIR__YOUTH_CLUBS:
			fireNotifyChanged(new NotificationWrapper(this, notification));
			return;
		}
	}
	
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				FairEditPlugin.INSTANCE.getImage("full/obj16/YouthClub"));
	}
	

	 @Override
    protected Command createDragAndDropCommand(
      EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection)
    {
      if (new AddCommand(domain, (EObject)owner, FairPackage.eINSTANCE.getFair_YouthClubs(), collection).canExecute())
        return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
      else
        return UnexecutableCommand.INSTANCE;
    }
  

}
