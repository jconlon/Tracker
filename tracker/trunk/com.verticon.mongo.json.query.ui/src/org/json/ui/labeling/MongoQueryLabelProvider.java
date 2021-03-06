/*
* generated by Xtext
*/
package org.json.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class MongoQueryLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public MongoQueryLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

//	/* (non-Javadoc)
//	 * @see org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider#doGetText(java.lang.Object)
//	 */
//	@Override
//	protected Object doGetText(Object element) {
//		// TODO Auto-generated method stub
//		Object result = super.doGetText(element);
//		System.out.println("Label for "+element+" is "+result);
//		return result;
//	}
	
	

//	/* (non-Javadoc)
//	 * @see org.eclipse.xtext.ui.label.DeclarativeLabelProvider#text(java.lang.Object)
//	 */
//	@Override
//	public Object text(Object element) {
//		
//		Object result = super.text(element);
//		System.out.println("Label for "+element+" is "+result);
//		return result;
//	}
	
//	/* (non-Javadoc)
//	 * @see org.eclipse.xtext.ui.label.DeclarativeLabelProvider#doGetImage(java.lang.Object)
//	 */
//	@Override
//	protected Object doGetImage(Object element) {
//		// TODO Auto-generated method stub
//		Object result = super.doGetImage(element);
//		System.out.println("Image for "+element+" is "+result);
//		return result;
//	}
//
//	String text(JsonDate date){
//		return "xdate";
//		
//	}
//	String text(FieldSelection fieldSelection){
//		return "my "+fieldSelection.getEnabled();
//	}
//	
//	String image(FieldSelection fieldSelection) {
//	      return "MyModel.gif";
//	}

/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
