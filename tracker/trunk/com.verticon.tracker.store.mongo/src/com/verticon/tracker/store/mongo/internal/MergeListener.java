/*******************************************************************************
 * Copyright (c) 2012 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package com.verticon.tracker.store.mongo.internal;

import java.io.IOException;

import org.eclipse.emf.compare.diff.merge.IMergeListener;
import org.eclipse.emf.compare.diff.merge.MergeEvent;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.ecore.EObject;

import com.mongodb.DB;
import com.verticon.tracker.Animal;

/**
 * @author jconlon
 * 
 */
public class MergeListener implements IMergeListener {

//	private final TrackerStoreUpdatingAnimal trackerStore;
	private final DB db;

	private IOException exception;

	/**
	 * @param db
	 */
	public MergeListener(DB db) {
		super();
		this.db = db;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.compare.diff.merge.IMergeListener#mergeDiffEnd(org.eclipse
	 * .emf.compare.diff.merge.MergeEvent)
	 */
	@Override
	public void mergeDiffEnd(MergeEvent event) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.compare.diff.merge.IMergeListener#mergeDiffStart(org.
	 * eclipse.emf.compare.diff.merge.MergeEvent)
	 */
	@Override
	public void mergeDiffStart(MergeEvent event) {
		for (DiffElement diffElement : event.getDifferences()) {
			// Look for new References
			if (diffElement instanceof UpdateReference
					&& diffElement.getKind() == DifferenceKind.CHANGE) {
				handleUpdateReferenceChange((UpdateReference) diffElement);
			}
		}
	}

	/**
	 * @param diffElement
	 */
	private void handleUpdateReferenceChange(UpdateReference rc) {
		String name = rc.getReference().getName();
		if (name.equals("sire")) {
			handleSireReferenceChange(rc);
		} else if (name.equals("dam")) {
			handleDamReferenceChange(rc);
		}
	}

	/**
	 * If left element has a sire, make sure it is persisted.
	 * 
	 * @param rc
	 */
	private void handleSireReferenceChange(UpdateReference rc) {
		// EObject lt = rc.getLeftTarget();
		// String ltSire = lt != null ? ((Animal) lt).getSire() != null ?
		// ((Animal) lt)
		// .getSire().getId() : "null"
		// : "null";
		//
		// EObject rt = rc.getRightTarget();
		// String rtSire = rt != null ? ((Animal) rt).getSire() != null ?
		// ((Animal) rt)
		// .getSire().getId() : "null"
		// : "null";
		//
		// EObject re = rc.getRightElement();
		// String reSire = re != null ? ((Animal) re).getSire() != null ?
		// ((Animal) re)
		// .getSire().getId() : "null"
		// : "null";

		EObject le = rc.getLeftElement();
		if (le == null || ((Animal) le).getSire() == null) {
			return;
		}

		// System.out.println("left target: " + lt);
		// System.out.println("\t left target sire: " + ltSire);

		// System.out.println("left element: " + le);
		// System.out.println("\t" + "left element sire: "
		// + ((Animal) le).getSire().getId());
		String sireID = ((Animal) le).getSire().getId();
		if (!Utils.isAnimalPersisted(sireID,db)) {
			exception = new IOException(
					"The new sire is not persisted. Save it first.");
		}

		// System.out.println("right target: " + rt);
		// System.out.println("\t" + " right target sire: " + rtSire);
		//
		// System.out.println("right element: " + re);
		// System.out.println("\t" + "right element sire: " + reSire);

		// System.out.println("Reference: " + rc.getReference());
	}

	/**
	 * If left element has a sire, make sure it is persisted.
	 * 
	 * @param rc
	 */
	private void handleDamReferenceChange(UpdateReference rc) {
		EObject le = rc.getLeftElement();
		if (le == null || ((Animal) le).getDam() == null) {
			return;
		}

		String id = ((Animal) le).getDam().getId();
		if (!Utils.isAnimalPersisted(id,db)) {
			exception = new IOException(
					"The new dam is not persisted. Save it first.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.compare.diff.merge.IMergeListener#mergeOperationEnd(org
	 * .eclipse.emf.compare.diff.merge.MergeEvent)
	 */
	@Override
	public void mergeOperationEnd(MergeEvent event) {
		// System.out.println("<operation>");
		// exception = null;
	}

	/**
	 * @return the exception
	 */
	IOException getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            the exception to set
	 */
	void setException(IOException exception) {
		this.exception = exception;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.compare.diff.merge.IMergeListener#mergeOperationStart
	 * (org.eclipse.emf.compare.diff.merge.MergeEvent)
	 */
	@Override
	public void mergeOperationStart(MergeEvent event) {
		// System.out.println("</operation>");
	}

}
