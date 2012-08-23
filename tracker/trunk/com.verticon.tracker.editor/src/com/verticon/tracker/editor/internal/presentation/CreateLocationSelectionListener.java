package com.verticon.tracker.editor.internal.presentation;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import com.verticon.location.LocationFactory;
import com.verticon.tracker.TrackerPackage;
import com.verticon.tracker.editor.presentation.IPremisesProvider;

/**
 * Forms associated with a Location may need to have the Location created first.
 * 
 * Listens for changes on text or buttons associated with a Premises Location.
 * On changes checks for a null Location element on the Premises. If it finds
 * Location is null then the user is prompted to create one.
 * 
 * 
 * @author jconlon
 * 
 */
public class CreateLocationSelectionListener extends SelectionAdapter implements
		ModifyListener {

	private final IPremisesProvider premisesProvider;

	/**
	 * 
	 * @param premisesProvider
	 */
	public CreateLocationSelectionListener(IPremisesProvider premisesProvider) {
		this.premisesProvider = premisesProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
	 * .swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		createLocationIfNotSet();
	}

	/**
	 * 
	 * @return true if the premises had no policy and the user confirmed that a
	 *         location was to be created
	 */
	private boolean createLocationIfNotSet() {
		if (premisesProvider.getPremises().getLocation() == null) {
			// Prompt to create one
			boolean result = MessageDialog
					.openConfirm(
							Display.getCurrent().getActiveShell(),
							"Create Location Element",
							"There is no Location element on the premises. Would you like to create one first?");
			if (result) {
				// OK Button selected do something
				EditingDomain ed = AdapterFactoryEditingDomain
						.getEditingDomainFor(premisesProvider.getPremises());
				ed.getCommandStack().execute(
						SetCommand.create(ed,
								premisesProvider.getPremises(), // owner
								TrackerPackage.Literals.PREMISES__LOCATION,
								LocationFactory.eINSTANCE.createLocation()));
				return true;// added
			} else {
				return false;// did not add
			}

		} else {
			return false;// already has a policy
		}
	}

	@Override
	public void modifyText(ModifyEvent e) {
		if (((Text) e.widget).getText().length() > 0) {
			createLocationIfNotSet();
		}
	}

}