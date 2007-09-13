package com.verticon.tracker.transaction.publisher.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.verticon.tracker.transaction.publisher.Publisher;

public class PublisherTableLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	public Image getColumnImage(Object obj, int index) {
		if(obj instanceof Publisher){
			
				switch (index) {
				case 0:
					return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
				
				case 2:
					return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
					
				case 3:
					return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

				default:
					break;
				}
				return null;
			
			
		}
		return getImage(obj);
	}
	
	public Image getImage(Object obj) {
		return PlatformUI.getWorkbench().
				getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}

	public String getColumnText(Object obj, int index) {
		if(obj instanceof Publisher){
			switch (index) {
				case 0:
					return ((Publisher)obj).getName();
				
				case 1:
					return ((Publisher)obj).getDescription();
				
				case 2:
					return ((Publisher)obj).getTemplate();
					
				case 3:
					return ((Publisher)obj).getTarget();

				case 4:
					return ((Publisher)obj).getStatus();

				default:
					break;
			}
			return null;
			
		}
		return getText(obj);
	}

}
