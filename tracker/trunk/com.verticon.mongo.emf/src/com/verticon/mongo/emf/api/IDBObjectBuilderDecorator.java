package com.verticon.mongo.emf.api;

import org.eclipse.emf.ecore.EObject;

import com.mongodb.DBObject;

public interface IDBObjectBuilderDecorator {
	public void decorateDBObject(EObject eObject, DBObject dbObject) ;
}
