package com.verticon.tracker.irouter.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

/**
 * Delegates to a collection of Monitorable objects.
 * @author jconlon
 *
 */
public class MonitorableHandler implements Monitorable {

	private final Map<String, Monitorable> delegateMap = 
		new HashMap<String, Monitorable>();
	
	public MonitorableHandler(List<Monitorable> delegates) {
		for (Monitorable monitorable : delegates) {
			for (String name : monitorable.getStatusVariableNames()) {
				if(delegateMap.containsKey(name)){
					throw new IllegalArgumentException(name+
							" is a duplicated status variable name");
				}
				delegateMap.put(name, monitorable);
			}
		}
	}

	@Override
	public String[] getStatusVariableNames() {
		String [] names = new String[delegateMap.size()];
		return (String[])delegateMap.keySet().toArray(names);
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		if(delegateMap.containsKey(id)){
			return delegateMap.get(id).getStatusVariable(id);
		}
		throw new IllegalArgumentException(
					"Invalid Status Variable name " + id);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		if(delegateMap.containsKey(id)){
			return delegateMap.get(id).notifiesOnChange(id);
		}
		throw new IllegalArgumentException(
					"Invalid Status Variable name " + id);
		
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		if(delegateMap.containsKey(id)){
			return delegateMap.get(id).resetStatusVariable(id);
		}
		throw new IllegalArgumentException(
					"Invalid Status Variable name " + id);
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		if(delegateMap.containsKey(id)){
			return delegateMap.get(id).getDescription(id);
		}
		throw new IllegalArgumentException(
					"Invalid Status Variable name " + id);
	}

}
