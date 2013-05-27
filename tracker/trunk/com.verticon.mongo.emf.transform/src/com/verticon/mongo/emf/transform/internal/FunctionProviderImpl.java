package com.verticon.mongo.emf.transform.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Function;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.verticon.mongo.emf.transform.IFunctionProvider;

public class FunctionProviderImpl implements IFunctionProvider {

	// set by DS
	private final TrackerDBObjectBuilder dbObjectBuilder;
	private final TrackerEObjectBuilder eObjectBuilder;


	public FunctionProviderImpl(TrackerDBObjectBuilder dbObjectBuilder,
			TrackerEObjectBuilder eObjectBuilder) {
		super();
		this.dbObjectBuilder = dbObjectBuilder;
		this.eObjectBuilder = eObjectBuilder;

	}

	@Override
	public Function<EObject, DBObject> getEObjectToDBObjectFunction() {
		Function<EObject, DBObject> eObjectToDBObjectFunction = new Function<EObject, DBObject>() {

				@Override
				public DBObject apply(EObject eObject) {
					return dbObjectBuilder.buildDBObject(eObject);
				}
			};

		return eObjectToDBObjectFunction;
	}

	@Override
	public Function<DBObject, EObject> getDBObjectToEObjectFunction(
			final DBCollection collection, final Resource resource) {

		Function<DBObject, EObject> dBObjectToEObjectFunction = new Function<DBObject,EObject>(){


			@Override
			public EObject apply(DBObject dbObject) {
				EObject result = eObjectBuilder.buildEObject(collection,
						dbObject, resource,
							false);
				resource.getContents().add(result);
				return result;
			}
		};
		return dBObjectToEObjectFunction;
		
	}

}
