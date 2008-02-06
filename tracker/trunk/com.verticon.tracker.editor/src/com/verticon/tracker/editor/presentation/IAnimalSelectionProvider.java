package com.verticon.tracker.editor.presentation;

import org.eclipse.jface.viewers.ISelection;

public interface IAnimalSelectionProvider {


	/**
     * Returns the current selection for this provider.
     * 
     * @return the current selection
     */
    public ISelection getAnimalSelection();

   
    /**
     * Sets the current selection for this selection provider.
     *
     * @param selection the new selection
     */
    public void setAnimalSelection(ISelection selection);
}
