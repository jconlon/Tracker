package com.verticon.tracker.irouter.gps.ui.internal;

import java.util.List;

import org.eclipse.core.expressions.PropertyTester;

import com.verticon.osgi.metatype.Designate;

public class DesignatePropertyTester extends PropertyTester {

	private static final String COM_VERTICON_TRACKER_IROUTER_GPS = "com.verticon.tracker.irouter.gps";
	private static final String isGPSChild = "isGPSChild";

	
	/**
	 * 
	 * One gps designate selected with the factoryPid set
	 * 
	 * Executes the property test determined by the parameter <code>property</code>.
	 * 
	 * @param receiver the receiver of the property test
	 * @param property the property to test
	 * @param args additional arguments to evaluate the property. If no arguments are specified in
	 *            the <code>test</code> expression an array of length 0 is passed
	 * @param expectedValue the expected value of the property. The value is either of type
	 *            <code>java.lang.String</code> or a boxed base type. If no value was specified in
	 *            the <code>test</code> expressions then <code>null</code> is passed
	 * 
	 * @return returns <code>true</code> if the property is equal to the expected value; otherwise
	 *         <code>false</code> is returned
	 */
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {

		boolean passedTest = false;
		if (isGPSChild.equals(property) ) {
			if(receiver instanceof List){
				@SuppressWarnings("unchecked")
				List<Designate> designates = (List<Designate>)receiver;
				if(designates.size()==1){
					Designate designate = designates.get(0);
					if( designate.getFactoryPid()!=null){
						if(SetUriOnGPSProxyWizard.getUriAttribute( designate)!=null){
							
							passedTest = designate.getFactoryPid().equals(COM_VERTICON_TRACKER_IROUTER_GPS);
						}
					}
				}
			}else{
				System.out.println(receiver.getClass().getName());
			}
		}

		return passedTest;
	}

}
