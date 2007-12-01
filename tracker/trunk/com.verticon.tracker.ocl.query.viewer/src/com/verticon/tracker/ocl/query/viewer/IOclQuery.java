/**
 * 
 */
package com.verticon.tracker.ocl.query.viewer;

/**
 * Wrapper that encapsulates an OCL Query
 * 
 * @author jconlon
 * 
 */
public interface IOclQuery extends Runnable {

	boolean validateQuery();

	/**
	 * 
	 * @return name
	 */
	String getName();

	void setName(String name);

	/**
	 * Set the type of object to select with the query.
	 * 
	 * @param type
	 */
	void setType(String type);

	String getType();

	/**
	 * OCL query statement
	 * 
	 * @param query
	 */
	void setQuery(String query);

	String getQuery();

	/**
	 * Description of any syntax errors associated with query
	 * 
	 * @param description
	 */
	void setErrorSyntax(String description);

	String getErrorSyntax();

}
