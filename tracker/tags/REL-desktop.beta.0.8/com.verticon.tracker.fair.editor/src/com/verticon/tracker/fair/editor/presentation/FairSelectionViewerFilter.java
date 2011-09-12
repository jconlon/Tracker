/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.fair.editor.presentation;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;

import com.verticon.tracker.Animal;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Person;

/**
 * @author jconlon
 * 
 */
public class FairSelectionViewerFilter extends SelectionViewerFilter {

	private final ArrayList<Person> targetedPeople = new ArrayList<Person>();
	private final ArrayList<Exhibit> targetedExhibits = new ArrayList<Exhibit>();

	

	/**
	 * The superclass will clear and then recreateTargets. Let the superclass
	 * compute targets first because it clears them first.
	 */
	@Override
	protected void computeTargets(ISelection selection) {
		super.computeTargets(selection);
		computeExplicitTargets(selection);
	}

	/**
	 * Computes all the targets that are explicitly selected.
	 * 
	 * @param selection
	 */
	private void computeExplicitTargets(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			
			for (Iterator<?> iter = ((IStructuredSelection) selection)
					.iterator(); iter.hasNext();) {
				Object o = iter.next();
				if (o instanceof Person) {
					targetedPeople.add((Person) o);
				} else if (o instanceof Exhibit) {
					targetedExhibits.add((Exhibit) o);

				}
			}
		}
	}

	/**
	 * Exhibits should be targets if they relate to a targeted animal.
	 * 
	 * Exhibits should be targets if they relate to a targeted person.
	 * 
	 * People should be targets if they reference a targeted exhibit
	 */
	@Override
	public synchronized boolean select(Viewer viewer, Object parentElement,
			Object element) {
		
		// do selection first
		if (noTargets()) {
			return true;// No targets enabled
		
		} else if (element instanceof Animal) {

			Animal animal = (Animal) element;
			for (Exhibit exhibit : targetedExhibits) {
				if (animal.equals(exhibit.getAnimal())) {
					return true;
				}
			}

		} else if (element instanceof Person) {
			Person person = (Person) element;
			if (targetedPeople.contains(person)) {
				return true;
			}
			for (Exhibit exhibit : targetedExhibits) {
				if (person.equals(exhibit.getExhibitor())) {
					return true;
				}
			}
			return false;

		} else if (element instanceof Exhibit) {
			Exhibit exhibit = (Exhibit) element;
			if (targetedExhibits.contains(exhibit)) {
				return true;
			}
			for (Person person : targetedPeople) {
				if (person.equals(exhibit.getExhibitor())) {
					return true;
				}
			}
			for (Animal animal : targetedAnimals) {
				if (animal.equals(exhibit.getAnimal())) {
					return true;
				}
			}
			return false;

		}

		// then let the super do it
		
		return super.select(viewer, parentElement, element);
	}

	@Override
	protected void clearTargets() {
		targetedPeople.clear();
		targetedExhibits.clear();
		super.clearTargets();
	}

	@Override
	protected boolean noTargets() {
		return super.noTargets()
		&& targetedPeople.isEmpty() && targetedExhibits.isEmpty();
		
	}

}
