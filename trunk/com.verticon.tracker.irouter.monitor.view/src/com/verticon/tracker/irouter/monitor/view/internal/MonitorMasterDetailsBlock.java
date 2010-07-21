package com.verticon.tracker.irouter.monitor.view.internal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;


public class MonitorMasterDetailsBlock extends MasterDetailsBlock{

	private GraphViewer viewer;
	
	/**
	 * Map factory Pids as keys to IDetailsPage implementations. A template factory use a 
	 * TEMPLATE constant .
	 */
	private Map<Object, IDetailsPage> keyMap = new HashMap<Object, IDetailsPage>();
	
	
	@Override
	protected void createMasterPart(final IManagedForm managedForm, final Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		
		Section section = toolkit.createSection(parent, Section.DESCRIPTION);
		section.setText("iRouter Network Services and Wire Connections");
		section.setDescription(
				"Select node to display service property details and status variables");
		
		section.marginWidth = 10;
		section.marginHeight = 5;
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		FillLayout layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 4;
		client.setLayout(layout);
		viewer = new GraphViewer(client, SWT.BORDER);
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED); 
		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);
		
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});
		
		
		setUpViewer(parent.getDisplay());
	}
	
	private void setUpViewer(Display display) {
		viewer.setContentProvider(new WiredNodeGraphEntityContentProvider(display));
		viewer.setLabelProvider(new WiredNodeLabelProvider());
		//viewer.setSorter(new NameSorter());
		IObservableSet observables = (IObservableSet)Component.INSTANCE.getModel();
		//Model contains a set WiredNode objects
		viewer.setInput(observables);
		
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		
		detailsPart.setPageProvider(new IDetailsPageProvider(){

			@Override
			public IDetailsPage getPage(Object key) {
				return keyMap.get(key);
			}

			/**
			 * Selections will be String PIDs for Wires, Producers and 
			 * Consumers
			 */
			@Override
			public Object getPageKey(Object object) {
				
				if(keyMap.containsKey(object)){
					return object;
				}
				WiredNode key = (WiredNode) object;
				keyMap.put(key, new WiredNodeDetailsPage(key));//Just a holder for now
				return key;
				}
			});

	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		Action haction = new Action("hor", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal orientation");
		try {
			URL url = new URL("platform:/plugin/com.verticon.osgi.metatype.core.model.editor/icons/th_horizontal.gif");
			
			haction.setImageDescriptor( ImageDescriptor.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical orientation");
		try {
			URL url = new URL("platform:/plugin/com.verticon.osgi.metatype.core.model.editor/icons/th_vertical.gif");
			
			vaction.setImageDescriptor( ImageDescriptor.createFromURL(url));
		} catch (MalformedURLException e) {

		}
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}

}
