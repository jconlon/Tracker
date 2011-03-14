/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.verticon.google.kmlgx.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.verticon.google.kmlgx.KmlgxPackage;
import com.verticon.google.kmlgx.Track;
import com.verticon.opengis.kml.ExtendedData;
import com.verticon.opengis.kml.Model;
import com.verticon.opengis.kml.impl.GeometryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Track</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#isExtrude <em>Extrude</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#isTessellate <em>Tessellate</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getAltitudeModeGroupGroup <em>Altitude Mode Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getAltitudeModeGroup <em>Altitude Mode Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getWhen <em>When</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getCoord <em>Coord</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getAngles <em>Angles</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getAbstractTrackSimpleExtensionGroupGroup <em>Abstract Track Simple Extension Group Group</em>}</li>
 *   <li>{@link com.verticon.google.kmlgx.impl.TrackImpl#getAbstractTrackSimpleExtensionGroup <em>Abstract Track Simple Extension Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrackImpl extends GeometryImpl implements Track {
	/**
	 * The default value of the '{@link #isExtrude() <em>Extrude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtrude()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTRUDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtrude() <em>Extrude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtrude()
	 * @generated
	 * @ordered
	 */
	protected boolean extrude = EXTRUDE_EDEFAULT;

	/**
	 * This is true if the Extrude attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean extrudeESet;

	/**
	 * The default value of the '{@link #isTessellate() <em>Tessellate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTessellate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TESSELLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTessellate() <em>Tessellate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTessellate()
	 * @generated
	 * @ordered
	 */
	protected boolean tessellate = TESSELLATE_EDEFAULT;

	/**
	 * This is true if the Tessellate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean tessellateESet;

	/**
	 * The cached value of the '{@link #getAltitudeModeGroupGroup() <em>Altitude Mode Group Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitudeModeGroupGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap altitudeModeGroupGroup;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected EList<XMLGregorianCalendar> when;

	/**
	 * The cached value of the '{@link #getCoord() <em>Coord</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoord()
	 * @generated
	 * @ordered
	 */
	protected EList<String> coord;

	/**
	 * The cached value of the '{@link #getAngles() <em>Angles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> angles;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Model model;

	/**
	 * The cached value of the '{@link #getExtendedData() <em>Extended Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedData()
	 * @generated
	 * @ordered
	 */
	protected ExtendedData extendedData;

	/**
	 * The cached value of the '{@link #getAbstractTrackSimpleExtensionGroupGroup() <em>Abstract Track Simple Extension Group Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractTrackSimpleExtensionGroupGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap abstractTrackSimpleExtensionGroupGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KmlgxPackage.Literals.TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtrude() {
		return extrude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtrude(boolean newExtrude) {
		boolean oldExtrude = extrude;
		extrude = newExtrude;
		boolean oldExtrudeESet = extrudeESet;
		extrudeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.TRACK__EXTRUDE, oldExtrude, extrude, !oldExtrudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExtrude() {
		boolean oldExtrude = extrude;
		boolean oldExtrudeESet = extrudeESet;
		extrude = EXTRUDE_EDEFAULT;
		extrudeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.TRACK__EXTRUDE, oldExtrude, EXTRUDE_EDEFAULT, oldExtrudeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExtrude() {
		return extrudeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTessellate() {
		return tessellate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTessellate(boolean newTessellate) {
		boolean oldTessellate = tessellate;
		tessellate = newTessellate;
		boolean oldTessellateESet = tessellateESet;
		tessellateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.TRACK__TESSELLATE, oldTessellate, tessellate, !oldTessellateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTessellate() {
		boolean oldTessellate = tessellate;
		boolean oldTessellateESet = tessellateESet;
		tessellate = TESSELLATE_EDEFAULT;
		tessellateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, KmlgxPackage.TRACK__TESSELLATE, oldTessellate, TESSELLATE_EDEFAULT, oldTessellateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTessellate() {
		return tessellateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAltitudeModeGroupGroup() {
		if (altitudeModeGroupGroup == null) {
			altitudeModeGroupGroup = new BasicFeatureMap(this, KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP_GROUP);
		}
		return altitudeModeGroupGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getAltitudeModeGroup() {
		return (EObject)getAltitudeModeGroupGroup().get(KmlgxPackage.Literals.TRACK__ALTITUDE_MODE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAltitudeModeGroup(EObject newAltitudeModeGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal)getAltitudeModeGroupGroup()).basicAdd(KmlgxPackage.Literals.TRACK__ALTITUDE_MODE_GROUP, newAltitudeModeGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMLGregorianCalendar> getWhen() {
		if (when == null) {
			when = new EDataTypeEList<XMLGregorianCalendar>(XMLGregorianCalendar.class, this, KmlgxPackage.TRACK__WHEN);
		}
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCoord() {
		if (coord == null) {
			coord = new EDataTypeEList<String>(String.class, this, KmlgxPackage.TRACK__COORD);
		}
		return coord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAngles() {
		if (angles == null) {
			angles = new EDataTypeEList<String>(String.class, this, KmlgxPackage.TRACK__ANGLES);
		}
		return angles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(Model newModel, NotificationChain msgs) {
		Model oldModel = model;
		model = newModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmlgxPackage.TRACK__MODEL, oldModel, newModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Model newModel) {
		if (newModel != model) {
			NotificationChain msgs = null;
			if (model != null)
				msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.TRACK__MODEL, null, msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.TRACK__MODEL, null, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.TRACK__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedData getExtendedData() {
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendedData(ExtendedData newExtendedData, NotificationChain msgs) {
		ExtendedData oldExtendedData = extendedData;
		extendedData = newExtendedData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmlgxPackage.TRACK__EXTENDED_DATA, oldExtendedData, newExtendedData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedData(ExtendedData newExtendedData) {
		if (newExtendedData != extendedData) {
			NotificationChain msgs = null;
			if (extendedData != null)
				msgs = ((InternalEObject)extendedData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.TRACK__EXTENDED_DATA, null, msgs);
			if (newExtendedData != null)
				msgs = ((InternalEObject)newExtendedData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmlgxPackage.TRACK__EXTENDED_DATA, null, msgs);
			msgs = basicSetExtendedData(newExtendedData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmlgxPackage.TRACK__EXTENDED_DATA, newExtendedData, newExtendedData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAbstractTrackSimpleExtensionGroupGroup() {
		if (abstractTrackSimpleExtensionGroupGroup == null) {
			abstractTrackSimpleExtensionGroupGroup = new BasicFeatureMap(this, KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP);
		}
		return abstractTrackSimpleExtensionGroupGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getAbstractTrackSimpleExtensionGroup() {
		return getAbstractTrackSimpleExtensionGroupGroup().list(KmlgxPackage.Literals.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP_GROUP:
				return ((InternalEList<?>)getAltitudeModeGroupGroup()).basicRemove(otherEnd, msgs);
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP:
				return basicSetAltitudeModeGroup(null, msgs);
			case KmlgxPackage.TRACK__MODEL:
				return basicSetModel(null, msgs);
			case KmlgxPackage.TRACK__EXTENDED_DATA:
				return basicSetExtendedData(null, msgs);
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP:
				return ((InternalEList<?>)getAbstractTrackSimpleExtensionGroupGroup()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmlgxPackage.TRACK__EXTRUDE:
				return isExtrude();
			case KmlgxPackage.TRACK__TESSELLATE:
				return isTessellate();
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP_GROUP:
				if (coreType) return getAltitudeModeGroupGroup();
				return ((FeatureMap.Internal)getAltitudeModeGroupGroup()).getWrapper();
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP:
				return getAltitudeModeGroup();
			case KmlgxPackage.TRACK__WHEN:
				return getWhen();
			case KmlgxPackage.TRACK__COORD:
				return getCoord();
			case KmlgxPackage.TRACK__ANGLES:
				return getAngles();
			case KmlgxPackage.TRACK__MODEL:
				return getModel();
			case KmlgxPackage.TRACK__EXTENDED_DATA:
				return getExtendedData();
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP:
				if (coreType) return getAbstractTrackSimpleExtensionGroupGroup();
				return ((FeatureMap.Internal)getAbstractTrackSimpleExtensionGroupGroup()).getWrapper();
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP:
				return getAbstractTrackSimpleExtensionGroup();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmlgxPackage.TRACK__EXTRUDE:
				setExtrude((Boolean)newValue);
				return;
			case KmlgxPackage.TRACK__TESSELLATE:
				setTessellate((Boolean)newValue);
				return;
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP_GROUP:
				((FeatureMap.Internal)getAltitudeModeGroupGroup()).set(newValue);
				return;
			case KmlgxPackage.TRACK__WHEN:
				getWhen().clear();
				getWhen().addAll((Collection<? extends XMLGregorianCalendar>)newValue);
				return;
			case KmlgxPackage.TRACK__COORD:
				getCoord().clear();
				getCoord().addAll((Collection<? extends String>)newValue);
				return;
			case KmlgxPackage.TRACK__ANGLES:
				getAngles().clear();
				getAngles().addAll((Collection<? extends String>)newValue);
				return;
			case KmlgxPackage.TRACK__MODEL:
				setModel((Model)newValue);
				return;
			case KmlgxPackage.TRACK__EXTENDED_DATA:
				setExtendedData((ExtendedData)newValue);
				return;
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP:
				((FeatureMap.Internal)getAbstractTrackSimpleExtensionGroupGroup()).set(newValue);
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
			case KmlgxPackage.TRACK__EXTRUDE:
				unsetExtrude();
				return;
			case KmlgxPackage.TRACK__TESSELLATE:
				unsetTessellate();
				return;
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP_GROUP:
				getAltitudeModeGroupGroup().clear();
				return;
			case KmlgxPackage.TRACK__WHEN:
				getWhen().clear();
				return;
			case KmlgxPackage.TRACK__COORD:
				getCoord().clear();
				return;
			case KmlgxPackage.TRACK__ANGLES:
				getAngles().clear();
				return;
			case KmlgxPackage.TRACK__MODEL:
				setModel((Model)null);
				return;
			case KmlgxPackage.TRACK__EXTENDED_DATA:
				setExtendedData((ExtendedData)null);
				return;
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP:
				getAbstractTrackSimpleExtensionGroupGroup().clear();
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
			case KmlgxPackage.TRACK__EXTRUDE:
				return isSetExtrude();
			case KmlgxPackage.TRACK__TESSELLATE:
				return isSetTessellate();
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP_GROUP:
				return altitudeModeGroupGroup != null && !altitudeModeGroupGroup.isEmpty();
			case KmlgxPackage.TRACK__ALTITUDE_MODE_GROUP:
				return getAltitudeModeGroup() != null;
			case KmlgxPackage.TRACK__WHEN:
				return when != null && !when.isEmpty();
			case KmlgxPackage.TRACK__COORD:
				return coord != null && !coord.isEmpty();
			case KmlgxPackage.TRACK__ANGLES:
				return angles != null && !angles.isEmpty();
			case KmlgxPackage.TRACK__MODEL:
				return model != null;
			case KmlgxPackage.TRACK__EXTENDED_DATA:
				return extendedData != null;
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP_GROUP:
				return abstractTrackSimpleExtensionGroupGroup != null && !abstractTrackSimpleExtensionGroupGroup.isEmpty();
			case KmlgxPackage.TRACK__ABSTRACT_TRACK_SIMPLE_EXTENSION_GROUP:
				return !getAbstractTrackSimpleExtensionGroup().isEmpty();
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
		result.append(" (extrude: ");
		if (extrudeESet) result.append(extrude); else result.append("<unset>");
		result.append(", tessellate: ");
		if (tessellateESet) result.append(tessellate); else result.append("<unset>");
		result.append(", altitudeModeGroupGroup: ");
		result.append(altitudeModeGroupGroup);
		result.append(", when: ");
		result.append(when);
		result.append(", coord: ");
		result.append(coord);
		result.append(", angles: ");
		result.append(angles);
		result.append(", abstractTrackSimpleExtensionGroupGroup: ");
		result.append(abstractTrackSimpleExtensionGroupGroup);
		result.append(')');
		return result.toString();
	}

} //TrackImpl
