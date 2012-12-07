package com.verticon.tracker.irouter.monitor.view.internal;

public class GatewayNode extends AbstractNode implements IExternalNode {
	private final String description;
	private final String connectionURI;

	GatewayNode(String group, String pid, Long service_id, String label,
			String connectionURI, String description) {
		super(group, pid, service_id, label);
		this.description = description;
		this.connectionURI = connectionURI;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GatewayNode [connectionURI=" + connectionURI
				+ ", description=" + description + "]";
	}

	@Override
	public String getSimpleName() {
		return "Gateway";
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
