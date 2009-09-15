/**
 * 
 */
package com.verticon.tracker.reader.event.comm;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * @author jconlon
 *
 */
public class PortEditor extends ListEditor {

    /**
     * The special label text for port chooser, 
     * or <code>null</code> if none.
     */
    private String chooserLabelText;

	protected PortEditor() {
		
	}

	/**
	 * Creates a port field editor.
	 * 
	 * @param name the name of the preference this field editor works on
	 * @param labelText the label text of the field editor
	 * @param chooserLabelText the label text displayed for the directory chooser
     * @param parent the parent of the field editor's control
	 */
	public PortEditor(String name, String labelText, String chooserLabelText, 
			Composite parent) {
		init(name, labelText);
		this.chooserLabelText = chooserLabelText;
		createControl(parent);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.ListEditor#createList(java.lang.String[])
	 */
	@Override
	protected String createList(String[] items) {
		StringBuffer path = new StringBuffer("");//$NON-NLS-1$

        for (int i = 0; i < items.length; i++) {
            path.append(items[i]);
            if(i + 1 !=items.length){
            	path.append(System.getProperty("path.separator"));
            }
        }
      
        
        return path.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.ListEditor#getNewInputObject()
	 */
	@Override
	protected String getNewInputObject() {
		InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
	            "", "Enter Serial Ports", chooserLabelText, new PortValidator());
	    if (dlg.open() == Window.OK) {
	    	String port = null;
	          // User clicked OK; update the label with the input
	          port = dlg.getValue();
	          if(port != null){
	        	  port = port.trim();
	        	  if(port.length()== 0){
	        		  return null;
	        	  }
	          }
	          
	          return port;
	    }
        return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.ListEditor#parseString(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected String[] parseString(String stringList) {
		 StringTokenizer st = new StringTokenizer(stringList, System.getProperty("path.separator")
	                + "\n\r");//$NON-NLS-1$
	        ArrayList v = new ArrayList();
	        while (st.hasMoreElements()) {
	            v.add(st.nextElement());
	        }
	        return (String[]) v.toArray(new String[v.size()]);
	}

	/**
	 * This class validates a String. It makes sure that the String is between 5 and 8
	 * characters
	 */
	class PortValidator implements IInputValidator {
	  /**
	   * Validates the String. Returns null for no error, or an error message
	   * 
	   * @param newText the String to validate
	   * @return String
	   */
	  public String isValid(String newText) {
		String osname = System.getProperty("os.name").toLowerCase();
		if(osname.equals("linux")){
			if(newText.startsWith("/dev/")){
				return null;//okay
			}else{
				return "Linux Port names should begin with '/dev/'";
			}
		}else if(osname.equals("windows")){
			if(newText.startsWith("Comm")){
				return null;//okay
			}else{
				return "Windows Port names should begin with 'Comm'";
			}
		}
	
	    // Input must be OK
	    return null;
	  }
	}
}
