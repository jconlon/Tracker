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
package com.verticon.tracker.tests.eclipse;

import junit.framework.TestCase;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * Test created for Tracker Issue 278 and bugzilla 
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=252612
 * @author jconlon
 *
 */
public class EMFDataBindingTest extends TestCase {
	
	private static final String OUT_OF_SYNC_ERROR = "Observed values are out of sync";
	private static final String ROLL_BACK_VALUE = "My broken address";
	private EPackage poPackage;
	private EClass purchaseOrderClass = null;
	private EObject firstObject = null;
	private EAttribute shipToAttribute;
	private DefaultRealm realm;
	private EMFDataBindingContext dbc;
	private WritableValue value1;
	private WritableValue value2;
	
	private Binding binding;
	private IObservableValue iovModelAttribute;
	
	/**
	 * Creates the EClasses for the test case.
	 */
	private void createEClasses() {
		poPackage = EcoreFactory.eINSTANCE.createEPackage();
		purchaseOrderClass = EcoreFactory.eINSTANCE.createEClass();
		purchaseOrderClass.setName("PurchaseOrder");
		poPackage.getEClassifiers().add(purchaseOrderClass);

	}

	/**
	 * Creates the Attributes for the test case.
	 */
	private void createAttributes() {
		shipToAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		shipToAttribute.setName("shipTo");
		shipToAttribute.setEType(EcorePackage.eINSTANCE.getEString());
		purchaseOrderClass.getEStructuralFeatures().add(shipToAttribute);
	}

	/**
	 * Create the data for the test case. This creates 3501 poClasses, 350 item
	 * classes and a single otherClass
	 * 
	 */
	private void createInstanceData() {
		firstObject = EcoreUtil.create(purchaseOrderClass);
	}

	@Override
	protected void setUp() throws Exception {
		createEClasses();
		createAttributes();
		createInstanceData();
		
	}

	/**
	 * 
	 */
	private void createBindings(UpdateValueStrategy updateValueStrategy) {
		realm = new DefaultRealm();

		value1 = WritableValue.withValueType(String.class);
		
		iovModelAttribute = EMFObservables.observeValue(realm,
				firstObject, shipToAttribute);
		
		dbc = new EMFDataBindingContext(realm);

		binding = dbc.bindValue(value1, iovModelAttribute, updateValueStrategy, null);
		
		
	}
	
	/**
	 * 
	 */
	private void createGenericBindings(UpdateValueStrategy updateValueStrategy) {
		realm = new DefaultRealm();

		value1 = WritableValue.withValueType(String.class);
		value2 = WritableValue.withValueType(String.class);
		
		
		dbc = new EMFDataBindingContext(realm);

		binding = dbc.bindValue(value1, value2, updateValueStrategy, null);
		
		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		realm.dispose();
		poPackage = null;
		purchaseOrderClass = null;
		firstObject = null;
		shipToAttribute = null;
		dbc.dispose();
		value1.dispose();
		value1 = null;
	}


	public void testModelToValue() {
		createBindings(null);
		assertNotNull(firstObject);
		firstObject.eSet(shipToAttribute, "My address");
		assertEquals(OUT_OF_SYNC_ERROR, 
				value1.getValue(), firstObject.eGet(shipToAttribute));

	}
	

	public void testValueToModel() {
		createBindings(null);
		assertNotNull(firstObject);
		value1.setValue("My address");
		assertEquals(OUT_OF_SYNC_ERROR, 
				value1.getValue(), firstObject.eGet(shipToAttribute));
		
	}
	
	public void testValueToEMFModelwithSimulatedRollback() {
		createBindings(new SimulatedRollBackStrategy());
		assertNotNull(firstObject);
		value1.setValue("My address");
		assertEquals( ROLL_BACK_VALUE, firstObject.eGet(shipToAttribute));
		assertEquals(OUT_OF_SYNC_ERROR, 
				value1.getValue(), firstObject.eGet(shipToAttribute));
	}
	
	public void testValueToGenericModelwithSimulatedRollback() {
		createGenericBindings(new SimulatedRollBackStrategy());
		assertNotNull(firstObject);
		value1.setValue("My address");
//		assertEquals( ROLL_BACK_VALUE, firstObject.eGet(shipToAttribute));
		assertEquals(OUT_OF_SYNC_ERROR, 
				value1.getValue(), value2.getValue());
	}
	
	public void testValueToModelwithSimulatedRollbackAndWorkaround() {
		createBindings(new SimulatedRollBackStrategy());
		assertNotNull(firstObject);
		value1.setValue("My address");
		assertEquals( ROLL_BACK_VALUE, firstObject.eGet(shipToAttribute));
		binding.updateModelToTarget();
		assertEquals(OUT_OF_SYNC_ERROR, 
				value1.getValue(), firstObject.eGet(shipToAttribute));
	}
	
	public void testMisc() {
		createBindings(new SimulatedRollBackStrategy());
		firstObject.eAdapters().add(new Adapter(){

			public Notifier getTarget() {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean isAdapterForType(Object type) {
				// TODO Auto-generated method stub
				return false;
			}

			public void notifyChanged(Notification notification) {
				System.out.println(notification);
			}

			public void setTarget(Notifier newTarget) {
				// TODO Auto-generated method stub
				
			}});
		
		assertNotNull(firstObject);
		assertNull(firstObject.eGet(shipToAttribute));
		System.out.println("Getting null");
		value1.setValue("My address");
		assertEquals( ROLL_BACK_VALUE, firstObject.eGet(shipToAttribute));
		assertEquals(OUT_OF_SYNC_ERROR, 
				value1.getValue(), firstObject.eGet(shipToAttribute));
	}
	
	
	class SimulatedRollBackStrategy extends UpdateValueStrategy{

		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			IStatus results = super.doSet(observableValue, value);
//			firstObject.eSet(shipToAttribute, ROLL_BACK_VALUE);
			iovModelAttribute.setValue(ROLL_BACK_VALUE);
			return results;
		}
		
	}
	
	class SimulatedGenericRollBackStrategy extends UpdateValueStrategy{

		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			IStatus results = super.doSet(observableValue, value);
			value2.setValue("SomeRolledbackValue");
			return results;
		}
		
	}
	
}




/**
 * Simple realm implementation that will set itself as default when constructed.
 * Invoke {@link #dispose()} to remove the realm from being the default. Does
 * not support asyncExec(...).
 */
class DefaultRealm extends Realm {
	private final Realm previousRealm;

	DefaultRealm() {
		previousRealm = super.setDefault(this);
	}

	/**
	 * @return always returns true
	 */
	@Override
	public boolean isCurrent() {
		return true;
	}

	@Override
	protected void syncExec(Runnable runnable) {
		runnable.run();
	}

	/**
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void asyncExec(Runnable runnable) {
		throw new UnsupportedOperationException("asyncExec is unsupported");
	}

	/**
	 * Removes the realm from being the current and sets the previous realm to
	 * the default.
	 */
	public void dispose() {
		if (getDefault() == this) {
			setDefault(previousRealm);
		}
	}
}
