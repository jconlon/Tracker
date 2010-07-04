/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/

package at.bestsolution.dataforms.util.viewers;

import java.text.MessageFormat;
import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;

/**
 * @author tomson <tom.schindl@bestsolution.at>
 * @version $Revision: $ 
 * @since 1.0
 *
 */
public class GenericObservableMapCellLabelProvider extends ColumnLabelProvider {
	/**
	 * Template text
	 */
	private final String templateText;

	/**
	 * The attribute maps
	 */
	private final IObservableMap[] attributeMaps;

	/**
	 * Change listener to track changes
	 */
	private final IMapChangeListener mapChangeListener = new IMapChangeListener() {
		@SuppressWarnings("unchecked")
		public void handleMapChange(MapChangeEvent event) {
			Set affectedElements = event.diff.getChangedKeys();
			LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
					GenericObservableMapCellLabelProvider.this, affectedElements.toArray());
			fireLabelProviderChanged(newEvent);
		}
	};

	

	/**
	 * @param attributeMaps
	 * @param templateText 
	 */
	public GenericObservableMapCellLabelProvider(IObservableMap[] attributeMaps,String templateText) {
		this.attributeMaps = attributeMaps;
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
		this.templateText = templateText;
	}

	@Override
	public void dispose() {
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].removeMapChangeListener(mapChangeListener);
		}
		super.dispose();
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (templateText != null && templateText.length() > 0) {
			Object[] elements = new Object[attributeMaps.length];
			for (int i = 0; i < elements.length; i++) {
				elements[i] = attributeMaps[i].get(element);
			}
			String out = MessageFormat.format(templateText, elements);
			return out.equals("null")?null:out;
		}
		
		return null;
	}
}
