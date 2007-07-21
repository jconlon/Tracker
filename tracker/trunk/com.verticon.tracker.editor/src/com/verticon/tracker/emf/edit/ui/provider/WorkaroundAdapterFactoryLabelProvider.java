package com.verticon.tracker.emf.edit.ui.provider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * 
 */

/**
 * @author jconlon
 *
 */
public class WorkaroundAdapterFactoryLabelProvider extends
		AdapterFactoryLabelProvider {

	/**
	 * @param adapterFactory
	 */
	public WorkaroundAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		
	}

	@Override
	public Image getColumnImage(Object object, int columnIndex) {
		return super.getImage(object);
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		return super.getText(object);
	}

}
