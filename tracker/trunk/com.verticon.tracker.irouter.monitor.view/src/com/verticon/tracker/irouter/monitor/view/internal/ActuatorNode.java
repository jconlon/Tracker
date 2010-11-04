package com.verticon.tracker.irouter.monitor.view.internal;

public class ActuatorNode extends AbstractNode implements IExternalNode {

	private final String connectionURI;
	private final String description;

	ActuatorNode(String group, String pid, Long service_id, String label,
			String connectionURI, String description) {
		super(group, pid, service_id, label);

		this.connectionURI = connectionURI;
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActuatorNode [connectionURI=" + connectionURI
				+ ", description=" + description + "]";
	}

	@Override
	public String getSimpleName() {
		return "Actuator";
	}

	@Override
	public String getConnectionURI() {
		return connectionURI;
	}

	@Override
	public ComponentServices getParent() {
		return null;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
