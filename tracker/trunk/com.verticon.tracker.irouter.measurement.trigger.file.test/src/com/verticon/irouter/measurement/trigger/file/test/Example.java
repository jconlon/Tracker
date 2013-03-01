package com.verticon.irouter.measurement.trigger.file.test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Example {
	// Minimal JavaBeans support
	public static abstract class AbstractModelObject {
		private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
				this);

		public void addPropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(listener);
		}

		public void addPropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName,
					listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

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

	// The data model class. This is normally a persistent class of some sort.
	//
	// This example implements full JavaBeans bound properties so that changes
	// to instances of this class will automatically be propogated to the UI.
	public static class Person extends AbstractModelObject {
		// Constructor
		public Person(String name, String city) {
			this.name = name;
			this.city = city;
		}

		// Some JavaBean bound properties...
		String name;

		String city;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			String oldValue = this.name;
			this.name = name;
			firePropertyChange("name", oldValue, name);
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			String oldValue = this.city;
			this.city = city;
			firePropertyChange("city", oldValue, city);
		}
	}

	// The View's model--the root of our GUI's Model graph
	//
	// Typically each View class has a corresponding ViewModel class.
	// The ViewModel is responsible for getting the objects to edit from the
	// DAO. Since this snippet doesn't have any persistent objects to
	// retrieve, this ViewModel just instantiates some objects to edit.
	//
	// This ViewModel also implements JavaBean bound properties.
	static class ViewModel extends AbstractModelObject {
		// The model to bind
		private final ArrayList<Person> people = new ArrayList<Person>();
		{
			people.add(new Person("Wile E. Coyote", "Tucson"));
			people.add(new Person("Road Runner", "Lost Horse"));
			people.add(new Person("Bugs Bunny", "Forrest"));
		}

		// Choice of cities for the Combo
		private final ArrayList<String> cities = new ArrayList<String>();
		{
			cities.add("Tucson");
			cities.add("AcmeTown");
			cities.add("Lost Horse");
			cities.add("Forrest");
			cities.add("Lost Mine");
		}

		public ArrayList<Person> getPeople() {
			return people;
		}

		public ArrayList<String> getCities() {
			return cities;
		}
	}
}
