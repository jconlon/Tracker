package com.verticon.tracker.fair.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.verticon.tracker.fair.Award;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Lot;

public class OnlyOneChampionConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		// In the case of batch mode.

		if (eType == EMFEventType.NULL) {

			if (eObj instanceof Exhibit) {
				Exhibit exhibit = (Exhibit) eObj;
				Award award = exhibit.getAward();
				
				switch (award.getValue()) {
				case Award.GRAND_CHAMPION_VALUE:
				case Award.RESERVE_CHAMPION_VALUE:
					if(classHasDuplicateAward(exhibit)){
						return ctx.createFailureStatus(new Object[] { eObj.eClass()
								.getName() });
					}
					break;
				default:
					break;
				}
			}
		} else {
			Award award = (Award) ctx.getFeatureNewValue();

			switch (award.getValue()) {
			case Award.GRAND_CHAMPION_VALUE:
			case Award.RESERVE_CHAMPION_VALUE:
				if(classHasDuplicateAward((Exhibit) eObj)){
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName() });
				}
				break;
			default:
				break;
			}
		}

		return ctx.createSuccessStatus();

	}
	
	boolean classHasDuplicateAward(Exhibit exhibit){
		com.verticon.tracker.fair.Class clazz = (com.verticon.tracker.fair.Class)exhibit.getLot().getClass_();
		for (Lot lot : clazz.getLots()) {
			for (Exhibit exhibitToCheck : lot.getExhibits()) {
				if(exhibitToCheck!=exhibit && exhibitToCheck.getAward().equals(exhibit.getAward()) ){
					return true;
				}
			}
		}
		return false;
	}

}
