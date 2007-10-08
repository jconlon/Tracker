/**
 * 
 */
package com.verticon.tracker.transaction.publisher;

import com.verticon.tracker.editor.presentation.AbstractModelObject;

/**
 * Publisher Used for testing.
 * 
 * @author jconlon
 * 
 */
public class MockPublisher extends AbstractModelObject implements IPublisher {

	String name = "dummy";
	String target = "a target";
	String template = "Some template";
	boolean started = true;

	public MockPublisher(String name) {
		super();
		this.name = name;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean start) {
		boolean oldValue = this.started;
		this.started = start;
		firePropertyChange("started", oldValue, started);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.transaction.publisher.IPublisher#getName()
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		firePropertyChange("name", oldValue, name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.transaction.publisher.IPublisher#getDescription()
	 */
	public String getType() {
		return MockPublisher.class.getSimpleName();
	}

	public void setType(String type) {
		throw new UnsupportedOperationException(
				"Setting the type is unsupported");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.transaction.publisher.IPublisher#getTemplate()
	 */
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		String oldValue = this.template;
		this.template = template;
		firePropertyChange("template", oldValue, template);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.transaction.publisher.IPublisher#getTarget()
	 */
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		String oldValue = this.target;
		this.target = target;
		firePropertyChange("target", oldValue, target);

	}

}
