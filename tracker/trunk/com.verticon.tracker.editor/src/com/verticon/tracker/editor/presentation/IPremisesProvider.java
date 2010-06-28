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
package com.verticon.tracker.editor.presentation;

import java.util.Collection;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;

import com.verticon.tracker.Premises;

public interface IPremisesProvider extends IEditingDomainProvider{

	/**
	 * This sets the selection into whichever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public abstract void setSelectionToViewer(Collection<?> collection);
	
	/**
	 * 
	 * @return premises or null
	 */
	public Premises getPremises();

}