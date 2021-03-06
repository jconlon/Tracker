package com.verticon.tracker.reader;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//Minimal JavaBeans support
public abstract class AbstractModelObject {
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);
	@SuppressWarnings("ucd")
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	@SuppressWarnings("ucd")
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName,
				listener);
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

	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue,
				newValue);
	}
}
