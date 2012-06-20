/**
 * <copyright>
 * </copyright>
 *
 */
package org.json.mongoQuery.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.json.mongoQuery.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MongoQueryFactoryImpl extends EFactoryImpl implements MongoQueryFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MongoQueryFactory init()
  {
    try
    {
      MongoQueryFactory theMongoQueryFactory = (MongoQueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.json.org/MongoQuery"); 
      if (theMongoQueryFactory != null)
      {
        return theMongoQueryFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MongoQueryFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoQueryFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MongoQueryPackage.SELECTOR: return createSelector();
      case MongoQueryPackage.SELECTION: return createSelection();
      case MongoQueryPackage.FIELD_SELECTION: return createFieldSelection();
      case MongoQueryPackage.QUERY: return createQuery();
      case MongoQueryPackage.ARRAY: return createArray();
      case MongoQueryPackage.JSON_DATE: return createJsonDate();
      case MongoQueryPackage.QUERY_OBJECT: return createQueryObject();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selector createSelector()
  {
    SelectorImpl selector = new SelectorImpl();
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selection createSelection()
  {
    SelectionImpl selection = new SelectionImpl();
    return selection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldSelection createFieldSelection()
  {
    FieldSelectionImpl fieldSelection = new FieldSelectionImpl();
    return fieldSelection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Query createQuery()
  {
    QueryImpl query = new QueryImpl();
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Array createArray()
  {
    ArrayImpl array = new ArrayImpl();
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JsonDate createJsonDate()
  {
    JsonDateImpl jsonDate = new JsonDateImpl();
    return jsonDate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryObject createQueryObject()
  {
    QueryObjectImpl queryObject = new QueryObjectImpl();
    return queryObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoQueryPackage getMongoQueryPackage()
  {
    return (MongoQueryPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MongoQueryPackage getPackage()
  {
    return MongoQueryPackage.eINSTANCE;
  }

} //MongoQueryFactoryImpl
