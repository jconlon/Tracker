package com.verticon.mongo.internal;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.osgi.service.monitor.Monitorable;
import org.osgi.service.monitor.StatusVariable;

public class Monitor implements Monitorable {

	private final AtomicLong lastConnectRequest = new AtomicLong(0);
	private Map<String, Object> config;

	

	@Override
	public String[] getStatusVariableNames() {
		return StatusAndConfigVariables.getStatusVariableNames();
	}

	@Override
	public StatusVariable getStatusVariable(String id)
			throws IllegalArgumentException {
		StatusAndConfigVariables var = StatusAndConfigVariables.instance(id);
		switch (var) {
		case KEY_MONGODB_SERVER:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
		case LOCATION:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
		case DESCRIPTION:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
		case KEY_MONGODB_DBNAME:
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					(String) config.get(var.configID));
		case LAST_CONNECTION_TIME:
			Date date = new Date(lastConnectRequest.get());
			return new StatusVariable(id, StatusVariable.TYPE_STRING,
					date.toString());
		default:
			break;
		}
		throw new IllegalArgumentException("Invalid Status Variable name "
				+ var);
	}

	@Override
	public boolean notifiesOnChange(String id) throws IllegalArgumentException {
		return StatusAndConfigVariables.instance(id).notifiesOnChange;
	}

	@Override
	public boolean resetStatusVariable(String id)
			throws IllegalArgumentException {
		
			return false;
	}

	@Override
	public String getDescription(String id) throws IllegalArgumentException {
		return StatusAndConfigVariables.instance(id).description;
	}

	void activate(Map<String, Object> config) {
		this.config = config;

	}

	void deactivate() {
		this.config = null;

	}

	void setConnectionTime() {
		lastConnectRequest.set(System.currentTimeMillis());
	}
}
