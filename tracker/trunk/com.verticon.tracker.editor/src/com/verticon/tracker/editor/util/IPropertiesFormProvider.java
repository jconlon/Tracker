package com.verticon.tracker.editor.util;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.custom.CTabFolder;

public interface IPropertiesFormProvider {
	public void fillProperties(ISelection selection, 
			AdapterFactory adapterFactory, CTabFolder cTabFolder,
			String nameOfTab);
	
	public void setStatusMessageObservable(
			IObservableValue statusMessageObservable);
	
	public WizardPage getWizardPage();

	public void setWizardPage(WizardPage wizardPage);
}
