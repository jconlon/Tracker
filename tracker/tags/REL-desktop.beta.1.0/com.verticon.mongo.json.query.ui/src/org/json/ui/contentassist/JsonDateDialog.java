package org.json.ui.contentassist;

import java.util.Date;

import org.eclipse.swt.widgets.Shell;
import org.json.validation.MongoQueryJavaValidator;

import com.verticon.ui.dialogs.DateDialog;

/**
 * JsonDateDialog is based on the Nebula CDateTime Component.  The pattern is set to the default pattern from the JSON
 * validator which includes a TimeZone offset.  Clearing the control and choosing add will return a new Date() string.
 * @author jconlon
 *
 */
public class JsonDateDialog extends DateDialog {

	JsonDateDialog(Shell parentShell, String pattern) {
		super(parentShell, pattern);
	}
	

	/**
	 * Need to wrap the formated date with the Json structure
	 */
	protected String saveInput() {
		StringBuffer sb = new StringBuffer("new Date(");
		if (getSelection() != null) {
			sb.append('"')
					.append(getFormatedDate())
					.append('"');
		}
		sb.append(')');
		return sb.toString();
	}
	
}
