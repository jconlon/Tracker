package com.verticon.tracker.ocl.query.viewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;

import com.verticon.tracker.util.TrackerLog;

/**
 * Model for IOclQuery Objects.
 * 
 * @author jconlon
 * 
 */
public class OclQueryViewModel {
	private static final String NEW_QUERY = "New Query";
	private static final String TAG_NAME = "name";
	private static final String TAG_TYPE = "type";
	private static final String TAG_QUERY = "query";

	private static final String TAG_OCL_QUERIES = "OclQueries";
	private static final String TAG_OCL_QUERY = "OclQuery";

	private List<IOclQuery> queries;

	private Set<IOclQueryModelListener> changeListeners = new HashSet<IOclQueryModelListener>();

	/**
	 * Constructor
	 */
	public OclQueryViewModel() {
		super();
		loadQueries();
	}

	/**
	 * Return the collection of tasks
	 */
	public List<IOclQuery> getTasks() {
		return queries;
	}

	/**
	 * Add a query to the collection
	 * 
	 */
	public void addQuery() {
		IOclQuery query = new OclQuery(NEW_QUERY);
		addQuery(query);
	}

	/**
	 * Add a new query to the collection
	 */
	public void addQuery(IOclQuery query) {
		queries.add(queries.size(), query);
		Iterator<IOclQueryModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().addQuery(query);
		}
		query.validateQuery();
		saveQueries();
	}

	/**
	 * @param query
	 */
	public void removeQuery(IOclQuery query) {
		queries.remove(query);
		Iterator<IOclQueryModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().removeOclQuery(query);
		}
		saveQueries();
	}

	/**
	 * @param query
	 */
	public void queryChanged(IOclQuery query) {
		Iterator<IOclQueryModelListener> iterator = changeListeners.iterator();
		while (iterator.hasNext()) {
			iterator.next().updateOclQuery(query);
		}
		saveQueries();
	}

	/**
	 * @param listener
	 */
	public void removeChangeListener(IOclQueryModelListener listener) {
		changeListeners.remove(listener);
	}

	/**
	 * @param listener
	 */
	public void addChangeListener(IOclQueryModelListener listener) {
		changeListeners.add(listener);
	}

	// /////////////////////////////////////////////////////////////////////////
	//
	// Persisting queries
	//
	// //////////////////////////////////////////////////////////////////////////

	private void loadQueries() {
		queries = new ArrayList<IOclQuery>();
		FileReader reader = null;
		try {
			reader = new FileReader(getQueriesFile());
			loadQueries(XMLMemento.createReadRoot(reader));
		} catch (FileNotFoundException e) {
			// Ignored... no items exist yet.
		} catch (Exception e) {
			// Log the exception and move on.
			TrackerLog.logError(e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				TrackerLog.logError(e);
			}
		}
	}

	private void loadQueries(XMLMemento memento) {
		IMemento[] children = memento.getChildren(TAG_OCL_QUERY);
		for (int i = 0; i < children.length; i++) {
			IOclQuery item = newQueryFor(children[i].getString(TAG_NAME),
					children[i].getString(TAG_TYPE), children[i]
							.getString(TAG_QUERY));
			if (item != null)
				queries.add(item);
		}
	}

	private IOclQuery newQueryFor(String name, String context,
			String queryString) {
		IOclQuery query = new OclQuery();
		query.setType(context);
		query.setName(name);
		query.setQuery(queryString);
		return query;
	}

	public void saveQueries() {
		if (queries == null)
			return;
		XMLMemento memento = XMLMemento.createWriteRoot(TAG_OCL_QUERIES);
		saveQueries(memento);
		FileWriter writer = null;
		try {
			writer = new FileWriter(getQueriesFile());
			memento.save(writer);
		} catch (IOException e) {
			TrackerLog.logError(e);// Comment this out if a test app is
									// launched
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				TrackerLog.logError(e);
			}
		}
	}

	private void saveQueries(XMLMemento memento) {
		Iterator<IOclQuery> iter = queries.iterator();
		while (iter.hasNext()) {
			IOclQuery query = iter.next();
			IMemento child = memento.createChild(TAG_OCL_QUERY);
			child.putString(TAG_NAME, query.getName());
			child.putString(TAG_TYPE, query.getType());
			child.putString(TAG_QUERY, query.getQuery());
		}
	}

	private File getQueriesFile() {
		return OclQueryViewerPlugin.getDefault().getStateLocation().append(
				"oclQueries.xml").toFile();
	}

}