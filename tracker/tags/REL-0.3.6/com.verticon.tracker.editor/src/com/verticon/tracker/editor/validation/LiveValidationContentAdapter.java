package com.verticon.tracker.editor.validation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import com.verticon.tracker.editor.presentation.TrackerEditor;

/**
 * A content adapter that performs live validation in response to changes in
 * the model.
 * 
 */
public class LiveValidationContentAdapter extends EContentAdapter {
	private final TrackerEditor editor;
	private ILiveValidator validator = null;

	/**
	 * @param editor
	 */
	public LiveValidationContentAdapter(TrackerEditor editor) {
		this.editor = editor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);
		
		editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (validator == null) {
					validator = (ILiveValidator) ModelValidationService
							.getInstance().newValidator(EvaluationMode.LIVE);
				}
				
				validator.validate(notification);
			}
		});
	}
}
