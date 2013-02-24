package com.verticon.tracker.trigger.view;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

import java.io.File;
import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;
import com.verticon.tracker.trigger.view.views.PrinterDialogCellEditor;

public class Validator {

	public static final IValidator LOT_VALIDATOR = new IValidator() {

		@Override
		public IStatus validate(Object value) {

			if (requiresFile()) {
				if (value == null) {
					return ValidationStatus
.error("No File specified.");
				}
			} else {
				if (value != null) {

					return ValidationStatus.warning(String.format("%s",
							"File field is not used by trigger.",
							value));
				}
			}

			if (value instanceof File) {
				if (!((File) value).isFile()) {
					return ValidationStatus
							.error("Specified file does not exist.");
				}
			} else {
				return ValidationStatus.error("Illegal argument error.");
			}
			return ValidationStatus.ok();
		}
	};

	public static final IValidator FILE_VALIDATOR = new IValidator() {

		@Override
		public IStatus validate(Object value) {
			
			if (requiresFile()) {
				if (value == null) {
				return ValidationStatus
.error("Missing File field.");
				}
			} else {
				if (value != null) {

					return ValidationStatus.warning(String.format("%s",
							"File field is not used by trigger.",
							value));
				}
			}

			if (value instanceof File) {
				if (!((File) value).isFile()) {
					return ValidationStatus
							.error("Specified file does not exist.");
				}
			} else {
				return ValidationStatus.error("Illegal argument error.");
			}
			return ValidationStatus.ok();
		}
	};

	public static final IValidator PRINTER_VALIDATOR = new IValidator() {
		@Override
		public IStatus validate(Object value) {
			if (requiresPrinter()) {
				if (value == null) {
				return ValidationStatus
.error("No Printer.");
				}

			} else {
				if (value != null) {

				return ValidationStatus.warning(String.format("%s",
							"Printer field is not used by trigger.", value));
				}
			}
			
			if (value instanceof String) {
				String printer = (String) value;
				if (isNullOrEmpty(printer)) {
					return ValidationStatus
.error("No Printer specified.");
				}

				if (!PrinterDialogCellEditor.printerNames().contains(printer)) {
					return ValidationStatus.error(String.format(
						"%s is not a valid system printer.",
										printer));
				}
			} else {
				return ValidationStatus.error("Illegal argument error.");
			}
			return ValidationStatus.ok();
		}
	};


	private static boolean requiresPrinter() {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		String root = store.getString(PreferenceConstants.P_ROOT_STRING);
		return root.contains(PreferenceConstants.PRINTER);
	}

	private static boolean requiresFile() {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		String root = store.getString(PreferenceConstants.P_ROOT_STRING);
		return root.contains(PreferenceConstants.LABEL_FILE);
	}

	public IStatus validateEntry(ITriggerEntry entry) {
		// IPreferenceStore store = TriggerViewPlugin.getDefault()
		// .getPreferenceStore();
		// String root = store.getString(PreferenceConstants.P_ROOT_STRING);
		// if (root.contains(PreferenceConstants.LABEL_FILE)) {
		// if (entry.getFile() == null) {
		// return String.format("Validation failure: %s",
		// "Missing File field. Please specify one.");
		// }
		// if (!entry.getFile().exists()) {
		// return String.format(
		// "Validation failure: File: %s does not exist.",
		// entry.getFile());
		// }
		//
		// } else {
		// if (entry.getFile() != null) {
		// return String.format("Validation failure: %s",
		// "File field is not used in trigger. Remove it.");
		// }
		// }
		List<IStatus> statusList = newArrayList();

		statusList.add(FILE_VALIDATOR.validate(entry.getFile()));
		statusList.add(PRINTER_VALIDATOR.validate(entry.getPrinter()));
		// IStatus fileValidation = FILE_VALIDATOR.validate(entry.getFile());
		//
		// IStatus printerValidation = PRINTER_VALIDATOR.validate(entry
		// .getPrinter());

		//
		//
		// if (fileValidation.matches(IStatus.ERROR)) {
		// return fileValidation;
		// } else if (printerValidation.matches(IStatus.ERROR)) {
		// return printerValidation;
		// } else if (fileValidation.matches(IStatus.WARNING)) {
		// return fileValidation;
		// } else if (printerValidation.matches(IStatus.WARNING)) {
		// return printerValidation;
		// }


	
		
		 if (entry.isRequireLot() && isNullOrEmpty(entry.getLot())) {
			statusList.add(ValidationStatus.error("Missing required Lot."));
		}

		if (!isNullOrEmpty(entry.getRequireValues())) {

			if (isNullOrEmpty(entry.getValues())) {
				statusList
						.add(ValidationStatus
						.error(String
.format(
						"%s values required, none are specified.",
										entry.getRequireValues())));
			} else {
				Iterable<String> values = Splitter.on(',').trimResults()
						.split(entry.getValues());
				int count = Iterables.size(values);

				values = Splitter.on(',').trimResults()
						.split(entry.getRequireValues());
				int reqcount = Iterables.size(values);

				if (count < reqcount) {
					statusList
							.add(ValidationStatus
.error(String.format(
							"%s values required, only %s are specified.",
											entry.getRequireValues(), count)));
				}
			}
		}

		if (statusList.isEmpty()) {
			return ValidationStatus.ok();
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (IStatus iStatus : statusList) {
			if (!iStatus.isOK()) {
				if (count > 0) {
					sb.append(' ');
				}
				sb.append(iStatus.getMessage());
				count++;
			}
		}

		MultiStatus status = new MultiStatus(TriggerViewPlugin.PLUGIN_ID, 0,
				String.format("%s validation errors: %s", count,
						sb.toString()), null);
		for (IStatus iStatus : statusList) {
			if (!iStatus.isOK()) {
				status.add(iStatus);
			}

		}
		return status;
	}

	// private void updateFormMessages(IStatus status) throws AssertionError {
	// int type;
	// switch (currentStatus.getSeverity()) {
	// case IStatus.OK:
	// type = IMessageProvider.NONE;
	// break;
	// case IStatus.CANCEL:
	// type = IMessageProvider.NONE;
	// break;
	// case IStatus.INFO:
	// type = IMessageProvider.INFORMATION;
	// break;
	// case IStatus.WARNING:
	// type = IMessageProvider.WARNING;
	// break;
	// case IStatus.ERROR:
	// type = IMessageProvider.ERROR;
	// break;
	// default:
	//			throw new AssertionError("incomplete switch statement"); //$NON-NLS-1$
	// }
	//
	// form.setMessage(currentStatus.getMessage(), type);
	// }

}
