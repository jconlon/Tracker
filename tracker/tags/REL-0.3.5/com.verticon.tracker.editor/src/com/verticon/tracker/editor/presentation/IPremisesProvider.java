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