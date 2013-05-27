package com.verticon.mongo.emf.transform;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Function;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public interface IFunctionProvider {

	Function<EObject, DBObject> getEObjectToDBObjectFunction();

	Function<DBObject, EObject> getDBObjectToEObjectFunction(
			DBCollection collection, Resource resource);
}
