/**
 * 
 */
package com.verticon.tracker.reader;


/**
 * Publisher Used for testing.
 * 
 * @author jconlon
 * 
 */
public class AbstractReader extends AbstractModelObject implements IReader {

	String name = "dummy";
	String target = "a target";
	String template = "Some template";
	boolean started = true;

	public AbstractReader(String name) {
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
	 * @see com.verticon.tracker.reader.IPublisher#getName()
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
	 * @see com.verticon.tracker.reader.IPublisher#getDescription()
	 */
	public String getType() {
		return AbstractReader.class.getSimpleName();
	}

	public void setType(String type) {
		throw new UnsupportedOperationException(
				"Setting the type is unsupported");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verticon.tracker.reader.IPublisher#getTemplate()
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
	 * @see com.verticon.tracker.reader.IPublisher#getTarget()
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
