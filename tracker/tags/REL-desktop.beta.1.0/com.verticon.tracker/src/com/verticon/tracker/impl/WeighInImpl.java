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
package com.verticon.tracker.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import com.verticon.tracker.WeightMeasurementUnit;
import com.verticon.tracker.util.CollectionFilter;
import com.verticon.tracker.util.FilterCriteria;
import com.verticon.tracker.util.TrackerUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weigh In</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.tracker.impl.WeighInImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WeighInImpl#getWeightGainPerDay <em>Weight Gain Per Day</em>}</li>
 *   <li>{@link com.verticon.tracker.impl.WeighInImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WeighInImpl extends EventImpl implements WeighIn {
	private static final double INITIAL_AVG_VALUE = Double.MIN_NORMAL;

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
	protected static final Double WEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected Double weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeightGainPerDay() <em>Weight Gain Per Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeightGainPerDay()
	 * @generated
	 * @ordered
	 */
	protected static final Double WEIGHT_GAIN_PER_DAY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final WeightMeasurementUnit UNIT_EDEFAULT = WeightMeasurementUnit.POUND;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected WeightMeasurementUnit unit = UNIT_EDEFAULT;

	/**
	 * Cache of the average daily gain. 
	 * Start out with a known initializing value and calculated it at startup.
	 * 
	 */
	private Double adg = INITIAL_AVG_VALUE;
	
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
	public Double getWeight() {
		return weight;
	}


	/**
	 * <!-- begin-user-doc -->
	 * Send out WeightGainPerDay notifications whenever the value
	 * of weight changes.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setWeight(Double newWeight) {
		Double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WEIGH_IN__WEIGHT, oldWeight, weight));
			WeighIn lastWeighIn = previousWeighIn();
			if(lastWeighIn==null || lastWeighIn.getWeight()==null){
				return;
			}else{
				Double oldValue = adg;
				adg = calculateWeightGain();
				eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WEIGH_IN__WEIGHT_GAIN_PER_DAY, 
						oldValue, adg));
			}
		
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * @return cached calculated average daily weight gain.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Double getWeightGainPerDay() {
		if(adg!=null && adg==INITIAL_AVG_VALUE){
			adg = calculateWeightGain();
		}
		return adg;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeightMeasurementUnit getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(WeightMeasurementUnit newUnit) {
		WeightMeasurementUnit oldUnit = unit;
		unit = newUnit == null ? UNIT_EDEFAULT : newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.WEIGH_IN__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Double calculateWeightGain() {
		if(weight==null || weight==0){
			return null;
		}
		WeighIn lastWeighIn = previousWeighIn();
		
		if(lastWeighIn==null || lastWeighIn.getWeight()==null){
			return null;
		}
		CalendarDate myCalendarDate = new CalendarDate(TimeZone.getDefault(), dateTime);
		CalendarDate lastWeighInCalendarDate = 
			new CalendarDate(TimeZone.getDefault(), lastWeighIn.getDateTime());
		
		double daysSinceLastWeighIn = lastWeighInCalendarDate.daysUntil(myCalendarDate);
		if(daysSinceLastWeighIn==0){
			return null;
		}
		double weightGain = (double) weight -  (double)lastWeighIn.getWeight();
		return weightGain / daysSinceLastWeighIn;
			
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeighIn previousWeighIn() {
		Collection<Event> weighIns = getPreviousWeighInEvents();			
				WeighIn lastWeighIn = getPreviousWeighInEvent(weighIns);
				return lastWeighIn;
	}

	
	/**
	 * @param weighIns
	 * @return
	 */
	private WeighIn getPreviousWeighInEvent(Collection<Event> weighIns) {
		int count = weighIns.size() - 1;
		for (Event event : weighIns) {
			if(count==0){
				return (WeighIn)event;
			}
			count--;
		}
		return null;
	}
	
	/**
	 * 
	 * @return Collection of previous weighIns
	 */
	 public Collection<Event> getPreviousWeighInEvents() {
		Tag parent = this.getTag();
		if(parent==null){
			return Collections.emptyList();
		}
		Animal animal = (Animal)parent.eContainer();
		if(animal==null){
			return Collections.emptyList();
		}
		EList<Event> events = animal.eventHistory();
		if (events.isEmpty()) {
			return Collections.emptyList();
		}
		List<Event> copy = new ArrayList<Event>(events);
		Collections.sort(copy, TrackerUtils.DATE_COMPARATOR);
		
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
				if(notThisEvent(e) && 
						containsAValue(e) && 
						isEarlier(e)){
					return true;
				}
			}
			return false;
		}


		/**
		 * @param e
		 * @return
		 */
		private boolean isEarlier(WeighIn e) {
			return (TrackerUtils.DATE_COMPARATOR.compare(e, WeighInImpl.this) < 0);
		}

		
		/**
		 * @param weighInEvent
		 * @return
		 */
		private boolean containsAValue(WeighIn weighInEvent) {
			if(weighInEvent==null){
				return false;
			}
			
			return weighInEvent.getWeight()!=null && weighInEvent.getWeight()!=0;
		}

		/**
		 * @param e
		 * @return
		 */
		private boolean notThisEvent(WeighIn e) {
			return WeighInImpl.this!=e;
		}};
	
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.WEIGH_IN__WEIGHT:
				return getWeight();
			case TrackerPackage.WEIGH_IN__WEIGHT_GAIN_PER_DAY:
				return getWeightGainPerDay();
			case TrackerPackage.WEIGH_IN__UNIT:
				return getUnit();
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
				setWeight((Double)newValue);
				return;
			case TrackerPackage.WEIGH_IN__UNIT:
				setUnit((WeightMeasurementUnit)newValue);
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
			case TrackerPackage.WEIGH_IN__UNIT:
				setUnit(UNIT_EDEFAULT);
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
				return WEIGHT_EDEFAULT == null ? weight != null : !WEIGHT_EDEFAULT.equals(weight);
			case TrackerPackage.WEIGH_IN__WEIGHT_GAIN_PER_DAY:
				return WEIGHT_GAIN_PER_DAY_EDEFAULT == null ? getWeightGainPerDay() != null : !WEIGHT_GAIN_PER_DAY_EDEFAULT.equals(getWeightGainPerDay());
			case TrackerPackage.WEIGH_IN__UNIT:
				return unit != UNIT_EDEFAULT;
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
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}

} //WeighInImpl