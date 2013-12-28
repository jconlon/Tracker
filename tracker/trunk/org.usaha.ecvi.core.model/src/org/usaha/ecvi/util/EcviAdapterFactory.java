/**
 */
package org.usaha.ecvi.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.usaha.ecvi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage
 * @generated
 */
public class EcviAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcviPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcviAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EcviPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcviSwitch<Adapter> modelSwitch =
		new EcviSwitch<Adapter>() {
			@Override
			public Adapter caseAccession(Accession object) {
				return createAccessionAdapter();
			}
			@Override
			public Adapter caseAccessions(Accessions object) {
				return createAccessionsAdapter();
			}
			@Override
			public Adapter caseAddress(Address object) {
				return createAddressAdapter();
			}
			@Override
			public Adapter caseAnimal(Animal object) {
				return createAnimalAdapter();
			}
			@Override
			public Adapter caseAnimalTag(AnimalTag object) {
				return createAnimalTagAdapter();
			}
			@Override
			public Adapter caseAttachement(Attachement object) {
				return createAttachementAdapter();
			}
			@Override
			public Adapter caseContact(Contact object) {
				return createContactAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseEcvi(Ecvi object) {
				return createEcviAdapter();
			}
			@Override
			public Adapter caseGeoPoint(GeoPoint object) {
				return createGeoPointAdapter();
			}
			@Override
			public Adapter caseGroupLot(GroupLot object) {
				return createGroupLotAdapter();
			}
			@Override
			public Adapter caseLaboratory(Laboratory object) {
				return createLaboratoryAdapter();
			}
			@Override
			public Adapter caseMovementPurposes(MovementPurposes object) {
				return createMovementPurposesAdapter();
			}
			@Override
			public Adapter casePerson(Person object) {
				return createPersonAdapter();
			}
			@Override
			public Adapter casePhoneNum(PhoneNum object) {
				return createPhoneNumAdapter();
			}
			@Override
			public Adapter casePremises(Premises object) {
				return createPremisesAdapter();
			}
			@Override
			public Adapter caseProgramStatus(ProgramStatus object) {
				return createProgramStatusAdapter();
			}
			@Override
			public Adapter caseResultValue(ResultValue object) {
				return createResultValueAdapter();
			}
			@Override
			public Adapter caseTest(Test object) {
				return createTestAdapter();
			}
			@Override
			public Adapter caseVeterinarian(Veterinarian object) {
				return createVeterinarianAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Accession <em>Accession</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Accession
	 * @generated
	 */
	public Adapter createAccessionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Accessions <em>Accessions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Accessions
	 * @generated
	 */
	public Adapter createAccessionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Address
	 * @generated
	 */
	public Adapter createAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Animal <em>Animal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Animal
	 * @generated
	 */
	public Adapter createAnimalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.AnimalTag <em>Animal Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.AnimalTag
	 * @generated
	 */
	public Adapter createAnimalTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Attachement <em>Attachement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Attachement
	 * @generated
	 */
	public Adapter createAttachementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Contact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Contact
	 * @generated
	 */
	public Adapter createContactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Ecvi <em>Ecvi</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Ecvi
	 * @generated
	 */
	public Adapter createEcviAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.GeoPoint <em>Geo Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.GeoPoint
	 * @generated
	 */
	public Adapter createGeoPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.GroupLot <em>Group Lot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.GroupLot
	 * @generated
	 */
	public Adapter createGroupLotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Laboratory <em>Laboratory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Laboratory
	 * @generated
	 */
	public Adapter createLaboratoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.MovementPurposes <em>Movement Purposes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.MovementPurposes
	 * @generated
	 */
	public Adapter createMovementPurposesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Person
	 * @generated
	 */
	public Adapter createPersonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.PhoneNum <em>Phone Num</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.PhoneNum
	 * @generated
	 */
	public Adapter createPhoneNumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Premises <em>Premises</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Premises
	 * @generated
	 */
	public Adapter createPremisesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.ProgramStatus <em>Program Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.ProgramStatus
	 * @generated
	 */
	public Adapter createProgramStatusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.ResultValue <em>Result Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.ResultValue
	 * @generated
	 */
	public Adapter createResultValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Test
	 * @generated
	 */
	public Adapter createTestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.usaha.ecvi.Veterinarian <em>Veterinarian</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.usaha.ecvi.Veterinarian
	 * @generated
	 */
	public Adapter createVeterinarianAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EcviAdapterFactory
