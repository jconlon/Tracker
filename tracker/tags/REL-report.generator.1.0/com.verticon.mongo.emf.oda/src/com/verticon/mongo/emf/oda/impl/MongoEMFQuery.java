/*
 *************************************************************************
 * Copyright (c) 2012 <<Your Company Name here>>
 *  
 *************************************************************************
 */

package com.verticon.mongo.emf.oda.impl;

import org.eclipse.datatools.connectivity.oda.IQuery;
import org.eclipse.datatools.connectivity.oda.OdaException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.oda.ecore.impl.Query;

import com.verticon.mongo.emf.api.MongoUtils;

/**
 * Implementation class of IQuery for an ODA ECore Mongo runtime driver.
 * <br>
 */
public class MongoEMFQuery extends Query implements IQuery
{
	public static final String MONGO_COLLECTION_PROPERTY_NAME = "mongocollection"; //$NON-NLS-1$
	public static final String MONGO_QUERY_PROPERTY_NAME = "mongoquery"; //$NON-NLS-1$
    
	private String mongoCollectionName = null;
	
	//String query = "{id : '985152001389613'}";
	private String mongoQuery = null;
	
	
	protected MongoEMFQuery(MongoEMFConnection connection) {
		super(connection);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.oda.ecore.impl.Query#prepare(java.lang.String)
	 */
	@Override
	public void prepare(String queryText) throws OdaException {
		assertSpecified();
		this.mongoQuery = (String)specification.getProperty(MONGO_QUERY_PROPERTY_NAME);
		this.mongoCollectionName = (String)specification.getProperty(MONGO_COLLECTION_PROPERTY_NAME);
		super.prepare(queryText);
		
	}


	@Override
	protected EList<Object> getAllObjectsByType(EList<Object> objects, EClassifier type)
	{
		//First query the results
		EList<EObject> result = MongoUtils.query( 
				connection.getResourceSet(), 
				((MongoEMFConnection)connection).getBaseURI(),  
				mongoCollectionName,  
				mongoQuery);
		
		//Now filter it based on the type
		for (TreeIterator<Object> allContents = EcoreUtil.getAllContents(result, true); allContents.hasNext();)
		{
			Object next = allContents.next();

			if (type.isInstance(next))
			{
				objects.add(next);
			}
		}

		return objects;
	}

}
