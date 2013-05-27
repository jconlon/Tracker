package com.verticon.mongo.emf.transform.internal;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

/**
 * This EMF URI handler interfaces to MongoDB. This URI handler can handle URIs
 * with the "mongodb" scheme. The URI path must have exactly 3 segments and be
 * of the form /database/collection/{id} where id is optional the first time the
 * EMF object is saved. When building queries, do not specify an id, but make
 * sure path has 3 segments by placing a "/" after the collection.
 * 
 * Note that if the id is not specified when the object is first saved, MongoDB
 * will assign the id and the URI of the EMF Resource will be modified to
 * include the id in the URI. Examples of valid URIs:
 * 
 * mongodb://localhost/data/people/
 * mongodb://localhost/data/people/4d0a3e259095b5b334a59df0
 * 
 * This class is intended to be used with the IResourceSetFactory service. If
 * you are not using the factory service, you will have to supply instances of
 * IMongoLocator, IIntputStreamFActory, and IOutputStreamFactory.
 * 
 * @author bhunt
 * 
 */
public class Constants {

	/**
	 * MongoDB ID field identifier. Not intended to be used by clients.
	 */
	public static final String ID_KEY = "_id";

	/**
	 * MongoDB eClass field identifier. Not intended to be used by clients.
	 */
	public static final String ECLASS_KEY = "_type";

	/**
	 * MongoDB eProxyURI field identifier. Not intended to be used by clients.
	 */
	public static final String PROXY_KEY = "_ref";

	/**
	 * MongoDB Extrensic ID field identifier. Not intended to be used by
	 * clients.
	 */
	public static final String EXTRINSIC_ID_KEY = "_eId";

	/**
	 * MongoDB Timestamp field identifier. Not intended to be used by clients.
	 */
	public static final String TIME_STAMP_KEY = "_timeStamp";

	/**
	 * When you load an object with cross-document references, they will be
	 * proxies. When you access the reference, EMF will resolve the proxy and
	 * you can then access the attributes. This can cause performance problems
	 * for example when expanding a tree where you only need a name attribute to
	 * display the children and then only resolve the next child to be expanded.
	 * Setting this option to Boolean.TRUE will cause the proxy instance to have
	 * its attribute values populated so that you can display the child names in
	 * the tree without resolving the proxy.
	 * 
	 * Value type: Boolean
	 */
	public static final String OPTION_PROXY_ATTRIBUTES = BinaryResourceImpl.OPTION_STYLE_PROXY_ATTRIBUTES;

	/**
	 * This option may be used when you wish to read from a particular server in
	 * a MongoDB replica set that has been tagged. <code>
	 * HashMap<String, String> tags = new HashMap<String, String>(1);
	 * tags.put("locale", "in");
	 * 
	 * resourceSet.getLoadOptions().put(MongoDBURIHandlerImpl.OPTION_TAGGED_READ_PREFERENCE, tags);
	 * </code>
	 * 
	 * Value type: Map<String, String>
	 */
	// FIXME uncomment when MongoDB supports tagged reads
	// public static final String OPTION_TAGGED_READ_PREFERENCE =
	// "TAGGED_READ_PREFERENCE";

	/**
	 * EMF's default serialization is designed to conserve space by not
	 * serializing attributes that are set to their default value. This is a
	 * problem when attempting to query objects by an attributes default value.
	 * By setting this option to Boolean.TRUE, all attribute values will be
	 * stored to MongoDB.
	 * 
	 * Value type: Boolean
	 */
	public static final String OPTION_SERIALIZE_DEFAULT_ATTRIBUTE_VALUES = "SERIALIZE_DEFAULT_ATTRIBUTE_VALUES";

	/**
	 * If it is set to Boolean.TRUE and the ID was not specified in the URI, the
	 * value of the ID attribute will be used as the MongoDB _id if it exists.
	 * 
	 * Value type: Boolean
	 */
	public static final String OPTION_USE_ID_ATTRIBUTE_AS_PRIMARY_KEY = "USE_ID_ATTRIBUTE_AS_PRIMARY_KEY";

	/**
	 * If set, the value must be an instance of WriteConcern and will be passed
	 * to MongoDB when the object is inserted into the database, or updated.
	 * 
	 * Value type: WriteConcern
	 */
	public static final String OPTION_WRITE_CONCERN = "WRITE_CONCERN";

	/**
	 * If set to Boolean.TRUE, a query will return a MongoCursor instead of a
	 * Result
	 * 
	 * Value type: Boolean
	 */
	public static final String OPTION_QUERY_CURSOR = "QUERY_CURSOR";

	// /**
	// * This function extracts the object ID from the given URI. The URI path
	// * must have exactly 3 segments and be of the form
	// * mongodb://host:[port]/database/collection/{id} where id is optional.
	// *
	// * @param uri
	// * @return the object ID from the given URI or null if the id was not
	// * specified
	// * @throws IOException
	// * if the URI path is not exactly three segments
	// */
	// public static Object getID(URI uri) throws IOException {
	// // Require that the URI path has the form /database/collection/{id}
	// // making the id segment # 2.
	//
	// if (uri.segmentCount() != 3)
	// throw new IOException(
	// "The URI is not of the form 'mongo:/database/collection/{id}");
	//
	// String id = uri.segment(2);
	//
	// // If the ID was specified in the URI, we first attempt to create a
	// // MongoDB ObjectId. If
	// // that fails, we assume that the client has specified a non ObjectId
	// // and return the raw data.
	//
	// try {
	// return id.isEmpty() ? null : new ObjectId(id);
	// } catch (Throwable t) {
	// return id;
	// }
	// }

	/**
	 * This function determines whether or not the given EDataType can be
	 * represented natively by MongoDB.
	 * 
	 * @param dataType
	 *            the EMF data type to check
	 * @return true if the data type can be represneted natively by MongoDB;
	 *         false otherwise
	 */
	public static boolean isNativeType(EDataType dataType) {
		String instanceClassName = dataType.getInstanceClassName();
		// @formatter:off
		return instanceClassName == "java.lang.String"
				|| instanceClassName == "int" || instanceClassName == "boolean"
				|| instanceClassName == "float" || instanceClassName == "long"
				|| instanceClassName == "double"
				|| instanceClassName == "java.util.Date"
				|| instanceClassName == "short"
				|| instanceClassName == "byte[]" || instanceClassName == "byte"
				|| instanceClassName == "java.lang.Integer"
				|| instanceClassName == "java.lang.Boolean"
				|| instanceClassName == "java.lang.Long"
				|| instanceClassName == "java.lang.Float"
				|| instanceClassName == "java.lang.Double"
				|| instanceClassName == "java.lang.Short"
				|| instanceClassName == "java.lang.Byte";
		// @formatter:on
	}



}
