/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.tracker.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import net.sourceforge.calendardate.CalendarDate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.WeighIn;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.FilterCriteria;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weigh In</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.WeighInImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WeighInImpl#getWeightGainPerDay <em>Weight Gain Per Day</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WeighInImpl extends EventImpl implements WeighIn {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeightGainPerDay() <em>Weight Gain Per Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeightGainPerDay()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_GAIN_PER_DAY_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WeighInImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getEventCode() {
		return EVENT_CODE;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.WEIGH_IN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WEIGH_IN__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getWeightGainPerDay() {
		if(weight==0){
			return 0;
		}
		Collection<Event> weighIns = getLastWeighInEvents();
		
		if(weighIns.isEmpty()){
			return 0;
		}
		WeighIn lastWeighIn = (WeighIn)weighIns.iterator().next();
		CalendarDate myCalendarDate = new CalendarDate(TimeZone.getDefault(), dateTime);
		CalendarDate lastWeighInCalendarDate = 
			new CalendarDate(TimeZone.getDefault(), lastWeighIn.getDateTime());
		
		int daysSinceLastWeighIn = lastWeighInCalendarDate.daysUntil(myCalendarDate);
		int weightGain = weight - lastWeighIn.getWeight();
		return weightGain / daysSinceLastWeighIn;
			
	}
	
	/**
	 * 
	 * @return Collection of previous weighIns
	 */
	private Collection<Event> getLastWeighInEvents() {
		Tag parent = this.getTag();
		if(parent==null){
			return Collections.emptyList();
		}
		Animal animal = (Animal)parent.eContainer();
		if(animal==null){
			return Collections.emptyList();
		}
		EList<Event> events = animal.allEvents();
		if (events.isEmpty()) {
			return Collections.emptyList();
		}
		List<Event> copy = new ArrayList<Event>(events);
		Collections.sort(copy, DATE_COMPARATOR);
		
		CollectionFilter<Event> lastWeighInEvents = new CollectionFilter<Event>();
		lastWeighInEvents.addFilter(weighInFilterCriteria);
		return lastWeighInEvents.filter(copy);
	}
	
	/**
	 * Passes all different weighIn events that have a non zero weight.
	 */
	private final FilterCriteria<Event> weighInFilterCriteria = new FilterCriteria<Event>(){

		public boolean passes(Event o) {
			if(o instanceof WeighIn){
				WeighIn e =(WeighIn)o;
				if(WeighInImpl.this!=e && e.getWeight()!=0){
					return true;
				}
			}
			return false;
		}};
	
	private static final Comparator<Event> DATE_COMPARATOR = new Comparator<Event>() {
		public int compare(Event a, Event b) {
			Date d1 = a.getDateTime();
			Date d2 = b.getDateTime();
			return d1.compareTo(d2);
		}

	};
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.WEIGH_IN__WEIGHT:
				return new Integer(getWeight());
			case TrackerPackage.WEIGH_IN__WEIGHT_GAIN_PER_DAY:
				return new Integer(getWeightGainPerDay());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.WEIGH_IN__WEIGHT:
				setWeight(((Integer)newValue).intValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.WEIGH_IN__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.WEIGH_IN__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case TrackerPackage.WEIGH_IN__WEIGHT_GAIN_PER_DAY:
				return getWeightGainPerDay() != WEIGHT_GAIN_PER_DAY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

} //WeighInImpl