/**
 * 
 */
package com.verticon.tracker.util;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Base class that confers minimal JavaBeans Support
 * 
 * @author jconlon
 * 
 */
public abstract class AbstractModelObject {
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	@SuppressWarnings("ucd")
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	@SuppressWarnings("ucd")
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	@SuppressWarnings("ucd")
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@SuppressWarnings("ucd")
	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName,
				listener);
	}

	@SuppressWarnings("ucd")
	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue,
				newValue);
	}
}