package com.verticon.tracker.reader.wizards;



import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;

import com.verticon.tracker.reader.IReaderWizard;
import com.verticon.tracker.reader.ReaderPlugin;
import com.verticon.tracker.util.TrackerLog;

/**
 * A WizardPage that nests a set of IWizardPublisher that are created from the extension point 
 * (named <code>"com.verticon.tracker.reader.publisherWizards"</code>).
 * For example, the plug-in's XML markup might contain:
 * <pre>
 * &LT;extension point="com.verticon.tracker.reader.readerWizards"&GT;
 *   &LT;wizard
 *       id="com.example.myplugin.blob"
 *       name="Blob Event Publisher"
 *       class="com.example.myplugin.BlobFilePublisher"
 *       icon="icons/import_blob_wiz.gif"&GT;
 *     &LT;description&GT;Publish Events from a BLOB file&LT;/description&GT;
 *   &LT;/wizard&GT;
 * &LT;/extension&GT;
 * </pre>
 * </p>
 * 
 * 
 * @author jconlon
 *
 */
public class EventReaderWizardSelectionPage extends WizardSelectionPage {
	
	private ListViewer listViewer;
	private IWorkbench workbench;
	private static IReaderWizard[] cachedWizards;
	
	protected EventReaderWizardSelectionPage(String pageName, IWorkbench workbench) {
		super(pageName);
		this.workbench=workbench;
		setTitle(pageName);
		setDescription("Select the type of Event Publisher you would like to create.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		
		
		listViewer=createViewer( container);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace=true;
		data.grabExcessVerticalSpace=true;
		data.heightHint = 400;
		data.widthHint = 300;
		listViewer.getControl().setLayoutData(data);
		setControl(container);
	}
	
	protected ListViewer createViewer(Composite parent) {
		ListViewer listViewer = new ListViewer(parent, SWT.SINGLE
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		listViewer.setLabelProvider(new IPublisherWizardListLabelProvider());
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.setInput(getReaderWizardsFromContributors());
		listViewer.setSorter(new ViewerSorter() {
			public int compare(Viewer viewer, Object p1, Object p2) {
				return ((PublisherWizardProxy) p1).getNameOfCreatedReader()
						.compareToIgnoreCase(
								((PublisherWizardProxy) p2)
										.getNameOfCreatedReader());
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();

				PublisherWizardProxy w = (PublisherWizardProxy) selection
						.getFirstElement();

				setSelectedNode(createIWizardNode(w, workbench));
				setErrorMessage(null);
				setMessage(w.getNameOfCreatedReader() + " "
						+ w.getDescription(), IMessageProvider.INFORMATION);

			}
		});

		return listViewer;
	}
	
	static final IWizardNode createIWizardNode(final IReaderWizard iWizard, final IWorkbench workbench  ){
		
		return new IWizardNode(){
			public void dispose() {
				iWizard.dispose();
			}

			public Point getExtent() {
				return new Point(1,1);
			}

			public IWizard getWizard() {
				iWizard.init(workbench, null);
				return iWizard;
			}

			public boolean isContentCreated() {
				return iWizard.getPageCount()>0;
			}
			
		};
	}
	
	/**
	 * Update the content before becoming visible.
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			listViewer.refresh();
		}
		super.setVisible(visible);
	}

	 
	 /**
	  * Builds a list of publisher wizards from the extension points 
	  * and do lazy instantiations after selection.
	  * 
	  * @return
	  */
	 IReaderWizard[] getReaderWizardsFromContributors(){
		 
		 if (cachedWizards !=null){
			 return cachedWizards;
		 }
		 IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
				 ReaderPlugin.PLUGIN_ID, "readerWizards")
				 .getExtensions();
		 List<IReaderWizard> found = new ArrayList<IReaderWizard>();
		 for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements =
					extensions[i].getConfigurationElements();
			for (int j = 0; j < configElements.length; j++) {
				IReaderWizard proxy =
					parseType(configElements[j],found.size());
				if(proxy != null){
					found.add(proxy);
				}
			}
		 }
		 cachedWizards=(IReaderWizard[]) found.toArray(
				 new IReaderWizard[found.size()]
		 );

		 return cachedWizards;
	 }

	private static IReaderWizard parseType(IConfigurationElement configElement, int ordinal){
		 if (!configElement.getName().equals("wizard"))
		      return null;
		   try {
		      return new PublisherWizardProxy(configElement);
		   }
		   catch (Exception e) {
		      String name = configElement.getAttribute("name");
		      if (name == null)
		         name = "[missing name attribute]";
		      String msg =
		         "Failed to load wizard named "
		            + name
		            + " in "
		            + configElement.getDeclaringExtension().getContributor().getName();
		           
		      TrackerLog.logError(msg, e);
		      return null;
		   }
	}
	
	
	
	class IPublisherWizardListLabelProvider extends LabelProvider {
		   public Image getImage(Object element) {
		      return null;
		   }	
		   public String getText(Object element) {
			   PublisherWizardProxy publisher = (PublisherWizardProxy) element;
		      return publisher.getNameOfCreatedReader();
		   }
		}

	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
	
	

}
