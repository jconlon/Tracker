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
package com.verticon.tracker.fair.transaction.editor.presentation;
import static com.verticon.tracker.fair.transaction.editor.presentation.FairTransactionEditorPlugin.bundleMarker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.FairFactory;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.editor.presentation.FairEditor;
import com.verticon.tracker.fair.editor.presentation.FairEditorPlugin;
import com.verticon.tracker.fair.editor.presentation.IFairProvider;
import com.verticon.tracker.fair.transaction.editor.domain.FairResourceLoadedListener;

/**
 * 
 * <ul>
 *   <li>Intializes a TransactionEditingDomain</li>
 *   <li>replacing the text sheet and its text sources with the
 *   transactional variants from the org.eclipse.emf.transaction.ui
 *   plug-in</li>
 *   <li>replacing the tree content provider with its transactional variant
 *   from the org.eclipse.emf.transaction.ui plug-in</li>
 *   <li>replacing the all table content providers with its transactional variant
 *   from the org.eclipse.emf.transaction.ui plug-in</li>
 *   
 *   <li>(for operation history integration) replacing the the Undo and Redo
 *   actions created by the generated action-bar contributor with the
 *   actions in the org.eclipse.emf.workspace.ui plug-in</li>
 * </ul>
 * @author jconlon
 *
 */
public class FairTransactionEditor extends FairEditor {

	//.CUSTOM: The undo context for this editor's Undo and Redo menus
	private IUndoContext undoContext;
	
	//.CUSTOM: The (one and only) resource that we are editing.  The
	//         EMF-generated editor edits any number of resources.
	//FIXME need multiple resource editing for fair
	private Resource resource;  // the resource that we are editing
	
	/**
	 * Resources that have been moved since last activation.
	 * Maps {@link Resource resource} to {@link URI new URI}
	 */
	//.CUSTOM: Demonstrates the WorkspaceSynchronizer's handling of moves
	private final Map<Resource, URI> movedResources = new HashMap<Resource, URI>();
	
	//.CUSTOM: We track dirty state by the last operation executed when saved
	private IUndoableOperation savedOperation;
	
	/**
	 * .CUSTOM Offers a query on a dataSet. 
	 * @generated NOT
	 */
	private IPremisesProvider fairProvider;
	
	//.CUSTOM: Applies this editor's undo context to operations that affect
	//         its resource.  Also sets selection to viewer on execution of
	//         operations that wrap EMF Commands.
	private final IOperationHistoryListener historyListener = new IOperationHistoryListener() {
		
		public void historyNotification(final OperationHistoryEvent event) {
			Set<?> affectedResources = ResourceUndoContext.getAffectedResources(
					event.getOperation());
			switch(event.getEventType()) {
			case OperationHistoryEvent.DONE:
				
				if (affectedResources.contains(getResource())) {
					final IUndoableOperation operation = event.getOperation();
					
					// remove the default undo context so that we can have
					//     independent undo/redo of independent resource changes
					operation.removeContext(((IWorkspaceCommandStack)
							getEditingDomain().getCommandStack()).getDefaultUndoContext());
					
					// add our undo context to populate our undo menu
					operation.addContext(getUndoContext());
					
					getSite().getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							firePropertyChange(IEditorPart.PROP_DIRTY);

							// Try to select the affected objects.
							//
							if (operation instanceof EMFCommandOperation) {
								Command command = ((EMFCommandOperation) operation).getCommand();
								
								if (command != null) {
									setSelectionToViewer(command
											.getAffectedObjects());
								}
							}
							
							if (propertySheetPage != null) {
								propertySheetPage.refresh();
							}
						}
					});
				}
				break;
			case OperationHistoryEvent.UNDONE:
			case OperationHistoryEvent.REDONE:
				if (affectedResources.contains(getResource())) {
					final IUndoableOperation operation = event.getOperation();

					getSite().getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							firePropertyChange(IEditorPart.PROP_DIRTY);

							// Try to select the affected objects.
							//
							if (operation instanceof EMFCommandOperation) {
								Command command = ((EMFCommandOperation) operation).getCommand();
								
								if (command != null) {
									setSelectionToViewer(command
											.getAffectedObjects());
								}
							}
							
							if (propertySheetPage != null) {
								propertySheetPage.refresh();
							}
						}
					});
				}
				break;
			}
		}};
	
	/**
	 * Synchronizes workspace changes with the editing domain.
	 */
	//.CUSTOM: Replaces the resourceChangeListener field generated by EMF
	private WorkspaceSynchronizer workspaceSynchronizer;
	
	/**
	 * This creates a model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairTransactionEditor() {
		super();
		initializeTransactionEditingDomain();
	}

	/**
	 * Handles activation of the editor or it's associated views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//.CUSTOM: This editor edits only a single resource and uses a
	//         WorkspaceSynchronizer to detect external changes
	@Override
	protected void handleActivate() {
		
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
		  editingDomain.getResourceToReadOnlyMap().clear();

		  // Refresh any actions that may become enabled or disabled.
		  //
		  setSelection(getSelection());
		}

		try {
			final Resource res = getResource();
			
			if (removedResources.contains(res)) {
				if (handleDirtyConflict()) {
					getSite().getPage().closeEditor(FairTransactionEditor.this, false);
					FairTransactionEditor.this.dispose();
				}
			} else if (movedResources.containsKey(res)) {
				//.CUSTOM: Generated editor does not have move support
				if (savedResources.contains(res)) {
					getOperationHistory().dispose(undoContext, true, true, true);
					
					// change saved resource's URI and remove from map
					res.setURI(movedResources.remove(res));
						
					// must change my editor input
					IEditorInput newInput = new FileEditorInput(
							WorkspaceSynchronizer.getFile(res));
					setInputWithNotify(newInput);
					setPartName(newInput.getName());
				} else {
					handleMovedResource();
				}
			} else if (changedResources.contains(res)) {
				changedResources.removeAll(savedResources);
				handleChangedResources();
			}
		} finally {
			removedResources.clear();
			changedResources.clear();
			movedResources.clear();
			savedResources.clear();
		}
	}
	
	//.CUSTOM-JC Replaced by following synchronization delegate
	//referenced in init and disposed
	protected IResourceChangeListener resourceChangeListener = null;
	
	//.CUSTOM: Replaces EMF-generated IResourceChangeListener implementation
	private WorkspaceSynchronizer.Delegate createSynchronizationDelegate() {
		return new WorkspaceSynchronizer.Delegate() {
			public boolean handleResourceDeleted(Resource resource) {
				if ((resource == getResource()) && !isDirty()) {
					// just close now without prompt
					getSite().getShell().getDisplay().asyncExec
						(new Runnable() {
							 public void run() {
								 getSite().getPage().closeEditor(FairTransactionEditor.this, false);
								 FairTransactionEditor.this.dispose();
							 }
						 });
				} else {
					removedResources.add(resource);
				}
				
				return true;
			}
			
			public boolean handleResourceChanged(Resource resource) {
                // is this a resource that we just saved?  If so, then this is
                //   notification of that save, so forget it
                if (savedResources.contains(resource)) {
                    savedResources.remove(resource);
                } else {
                    changedResources.add(resource);
                }
				
				return true;
			}
			
			public boolean handleResourceMoved(Resource resource, URI newURI) {
				movedResources.put(resource, newURI);
				
				return true;
			}
			
			public void dispose() {
				removedResources.clear();
				changedResources.clear();
				movedResources.clear();
			}};
	}
	
	/**
	 * Handles what to do with changed resource on activation.
	 */
	//.CUSTOM: Replaces EMF-generated handleChangedResources() method
	//FIXME to handle changed resources versus resource
	@Override
	protected void handleChangedResources() {
		Resource res = getResource();
		
		if (changedResources.contains(res) && 
				(!isDirty() || handleDirtyConflict())) {
			changedResources.remove(res);
			
			getOperationHistory().dispose(undoContext, true, true, true);
			firePropertyChange(IEditorPart.PROP_DIRTY);

			FairResourceLoadedListener listener = FairResourceLoadedListener.getDefault();
			listener.ignore(res);
			
			try {
				if (res.isLoaded()) {
					res.unload();
					try {
						res.load(Collections.EMPTY_MAP);
					} catch (IOException exception) {
						FairTransactionEditorPlugin.INSTANCE.log(exception);
					}
				}
	
				selectionViewer.setInput(getResource());
			} finally {
				listener.watch(res);
			}
				
			updateProblemIndication = true;
			updateProblemIndication();
		}
	}
	
	/**
	 * Handles what to do with moved resource on activation.
	 */
	//.CUSTOM: EMF-generated editor does not handle moves
	protected void handleMovedResource() {
		if (!isDirty() || handleDirtyConflict()) {
			Resource res = getResource();
			URI newURI = movedResources.get(res);
			
			if (newURI != null) {
				if (res.isLoaded()) {
					// unload
					res.unload();
				}

				// load the new URI in another editor
				res.getResourceSet().getResource(newURI, true);
			}
				
			updateProblemIndication = true;
			updateProblemIndication();
		}
	}
	
	
	/**
	 * This sets up the editing domain for the model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//.CUSTOM: Instead of the command-stack listener, we create an
	//         operation-history listener.  We also create our undo context.
	protected void initializeTransactionEditingDomain() {
		logger.info(bundleMarker,"Initializing the transactionEditingDomain");
		
		editingDomain = (AdapterFactoryEditingDomain) 
			TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
		"com.verticon.transaction.editor.TrackerEditingDomain"); //$NON-NLS-1$
		
		//There may already be a registered AdapterFactory
		ResourceSet rs = editingDomain.getResourceSet();
		for (AdapterFactory registeredAdapterFactory : rs.getAdapterFactories()) {
			if(registeredAdapterFactory instanceof ComposedAdapterFactory){
				ComposedAdapterFactory caf = (ComposedAdapterFactory)registeredAdapterFactory;
				if(caf.getFactoryForType(FairFactory.eINSTANCE.createFair()) instanceof FairItemProviderAdapterFactory){
					adapterFactory = caf;
					break;
				}
			}
		}
		if(adapterFactory ==null ){
			// Create a new adapter factory that yields item providers.
			adapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new TrackerItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			
			editingDomain.getResourceSet().getAdapterFactories().add(
					adapterFactory
			);
		}
		
		
		
		undoContext = new ObjectUndoContext(
				this,
				FairTransactionEditorPlugin.getPlugin().getString("_UI_FairEditor_label")); //$NON-NLS-1$
		getOperationHistory().addOperationHistoryListener(historyListener);
	}
	
	@Override
	protected void initializeEditingDomain() {
		//Do nothing
		logger.info(bundleMarker,"Ignoring super initialization");
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//.CUSTOM: EMF-generated class extends AdapterFactoryContentProvider
	@SuppressWarnings("ucd")
	public class ReverseAdapterFactoryContentProvider extends TransactionalAdapterFactoryContentProvider {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		//.CUSTOM: Superclass constructor requires the transactional editing domain
		public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
			super((TransactionalEditingDomain) getEditingDomain(), adapterFactory);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object [] getElements(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object [] getChildren(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public boolean hasChildren(Object object) {
			Object parent = super.getParent(object);
			return parent != null;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object getParent(Object object) {
			return null;
		}
	}
	
	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//.CUSTOM we record only a single resource
	//FIXME to handle a resourceSet
	@Override
	public void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Exception exception = null;
		resource = null; //.CUSTOM: We record our single resource
		try {
			// Load the resource through the editing domain.
			//
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource,  analyzeResourceProblems(resource, exception));
		}
		
		//.CUSTOM: We manage only the one resource in the set
		editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
	}
	
	
	/**
	 * Obtains the single resource that I edit. 
	 * 
	 * The resource is made
	 * available for other transaction editors that seek to navigate 
	 * common selections.
	 */
	//.CUSTOM: This editor edits only one resource.
    public Resource getResource() {
		return resource;
	}
	
	/**
	 * Obtains my undo context for populating the Undo and Redo menus
	 * from the operation history.
	 */
	//.CUSTOM: Operation-history-integrated editors have undo contexts.
	public IUndoContext getUndoContext() {
		return undoContext;
	}
	
	public ViewerPane getCurrentViewerPane(){
		return currentViewerPane;
	}
	
	public TreeViewer getSelectionViewerPane(){
		return selectionViewer;
	}
	
	
	@Override
	public void createPages() {
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty() &&
				!(getEditingDomain().getResourceSet().getResources().get(0)).getContents().isEmpty()) {

			createSelectionTreeViewer(FairEditorPlugin.INSTANCE.getString("_UI_SelectionPage_label"));

			// createListViewer(FairEditorPlugin.INSTANCE.getString(
			// "_UI_ListPage_label"));


			IEditorActionBarContributor abc = getActionBarContributor();
			if(abc != null && abc instanceof FairTransactionActionBarContributor){
				FairTransactionActionBarContributor fairActionBarContributor =(FairTransactionActionBarContributor)abc;
				fairActionBarContributor.getCustomActionBarContributor().getSelectionViewerFilter().setMainViewer(selectionViewer);

			}
			
			setActivePage(0);
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener
			(new ControlAdapter() {
				boolean guard = false;
				@Override
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			 });

		updateProblemIndication();
	}
	

	//.CUSTOM: Set the TransactionalAdpapterFactory Content and Label Providers.
	@Override
	protected void addListViewerProviders() {
		listViewer.setContentProvider(
				new TransactionalAdapterFactoryContentProvider(
						(TransactionalEditingDomain) getEditingDomain(),adapterFactory));
		listViewer.setLabelProvider(
				new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain) getEditingDomain(),
				adapterFactory));
	}

	
	
	//.CUSTOM: Set the TransactionalAdpapterFactory Content and Label Providers.
	@Override
	protected void addSelectionViewerProviders() {
		selectionViewer.setContentProvider(
				new TransactionalAdapterFactoryContentProvider(
						(TransactionalEditingDomain) getEditingDomain(), 
						adapterFactory
				)
		);

		selectionViewer.setLabelProvider(
				new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain) getEditingDomain(), 
						adapterFactory));
	}
	
	
	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return showOutlineView() ? getContentOutlinePage() : null;
		}
		else if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else if (key.equals(IGotoMarker.class)) {
			return this;
		}
		else if (key.equals(IUndoContext.class)) {
			//.CUSTOM: used by undo/redo actions to get their undo context
			return undoContext;
		}
		//Adds adaptive support for IPremisesProvider 	
		else if (key.equals(IPremisesProvider.class) || key.equals(IFairProvider.class)){
			if (fairProvider==null){
				fairProvider = new IFairProvider(){

					public EditingDomain getEditingDomain() {
						return FairTransactionEditor.this.getEditingDomain();
					}

					public void setSelectionToViewer(Collection<?> collection) {
						FairTransactionEditor.this.setSelectionToViewer(collection);
					}
					
					public Premises getPremises() {
						return getFair().getPremises();
					}

					//On a TransactionEditor there is only one resource.
					public Fair getFair() {
						Fair fair = null;
							if(resource.getURI().fileExtension().endsWith("fair")){
							  fair = (Fair)	resource.getEObject("/");
							 
						}
						return fair;
					}
					
				};
			}
			return fairProvider;
		}
		else {
			return super.getAdapter(key);
		}
	}
	
	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {
				@Override
				public void createControl(Composite parent) {
					super.createControl(parent);
					contentOutlineViewer = getTreeViewer();
					contentOutlineViewer.addSelectionChangedListener(this);

					// Set up the tree viewer.
					//
					//.CUSTOM: Use transactional content provider
					contentOutlineViewer.setContentProvider(
						new TransactionalAdapterFactoryContentProvider(
							(TransactionalEditingDomain) getEditingDomain(), adapterFactory));
					
					//.CUSTOM: Use transactional label provider
					contentOutlineViewer.setLabelProvider(
						new TransactionalAdapterFactoryLabelProvider(
							(TransactionalEditingDomain) getEditingDomain(), adapterFactory));
					
					contentOutlineViewer.setInput(getEditingDomain().getResourceSet());

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
					  // Select the root object in the view.
					  //
					  //.CUSTOM: I edit only a single resource.
					  ArrayList<Object> selection = new ArrayList<Object>();
					  selection.add(getResource());
					  contentOutlineViewer.setSelection(new StructuredSelection(selection), true);
					}
				}

				@Override
				public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
					super.makeContributions(menuManager, toolBarManager, statusLineManager);
					contentOutlineStatusLineManager = statusLineManager;
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			}

			contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage.addSelectionChangedListener
				(new ISelectionChangedListener() {
					 // This ensures that we handle selections correctly.
					 //
					 public void selectionChanged(SelectionChangedEvent event) {
						 handleContentOutlineSelection(event.getSelection());
					 }
				 });
		}

		return contentOutlinePage;
	}
	
	
	/**
	 * This accesses a cached version of the text sheet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage =
				new ExtendedPropertySheetPage(editingDomain) {
					@Override
					public void setSelectionToViewer(List<?> selection) {
						FairTransactionEditor.this.setSelectionToViewer(selection);
						FairTransactionEditor.this.setFocus();
					}

					@Override
					public void setActionBars(IActionBars actionBars) {
						super.setActionBars(actionBars);
						getActionBarContributor().shareGlobalActions(this, actionBars);
					}
				};
			//.CUSTOM: Use a transactional text-source provider
			propertySheetPage.setPropertySourceProvider(
					new TransactionalAdapterFactoryContentProvider((TransactionalEditingDomain) getEditingDomain(), adapterFactory));
		}

		return propertySheetPage;
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command stack.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isDirty() {
		//.CUSTOM: We track the last operation executed before save was performed
		IUndoableOperation op = getOperationHistory().getUndoOperation(getUndoContext());
		return op != savedOperation;
	}
	
	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity
		// that modifies the workbench.  Moreover, we must do this in a read-only
		// transaction in the editing domain, to ensure exclusive read access
		//
		WorkspaceModifyOperation operation =
			new WorkspaceModifyOperation() {
				// This is the method that gets invoked when the operation runs.
				//
				@Override
				public void execute(IProgressMonitor monitor) {
					try {
						//.CUSTOM: Save in a read-only transaction
						((TransactionalEditingDomain) getEditingDomain()).runExclusive(new Runnable() {
							public void run() {
								try {
									// Save the resource to the file system.
									//
									Resource savedResource = getResource();
									savedResources.add(savedResource);
									savedResource.save(saveOptions);
								}
								catch (Exception exception) {
									resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
								}
							}});
					}
					catch (Exception exception) {
						FairTransactionEditorPlugin.INSTANCE.log(exception);
					}
				}
			};

		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			//.CUSTOM: We record the last operation executed when saved.
			savedOperation = getOperationHistory().getUndoOperation(getUndoContext());
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			FairTransactionEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void doSaveAs(final URI uri, final IEditorInput editorInput) {
		// changing the URI is, conceptually, a write operation.  However, it does
		//    not affect the abstract state of the model, so we only need exclusive
		//    (read) access
		try {
			//.CUSTOM: Save in a read-only transaction
			((TransactionalEditingDomain) getEditingDomain()).runExclusive(new Runnable() {
				public void run() {
					getResource().setURI(uri);
					setInputWithNotify(editorInput);
					setPartName(editorInput.getName());
				}});
		} catch (InterruptedException e) {
			// just log it
			FairTransactionEditorPlugin.INSTANCE.log(e);
			
			// don't follow through with the save because we were interrupted while
			//    trying to start the transaction, so our URI is not actually changed
			return;
		}
		
		IProgressMonitor progressMonitor =
			getActionBars().getStatusLineManager() != null ?
				getActionBars().getStatusLineManager().getProgressMonitor() :
				new NullProgressMonitor();
		doSave(progressMonitor);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER)) {
				final String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					//.CUSTOM: Use a read-only transaction to read the resource
					//         when navigating to an object
					try {
						((TransactionalEditingDomain) getEditingDomain()).runExclusive(new Runnable() {
							public void run() {
								URI uri = URI.createURI(uriAttribute);
								EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
								if (eObject != null) {
								  setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
								}
							}});
					} catch (InterruptedException e) {
						// just log it
						FairTransactionEditorPlugin.INSTANCE.log(e);
					}
				}
			}
		}
		catch (CoreException exception) {
			FairTransactionEditorPlugin.INSTANCE.log(exception);
		}
	}
	
	/**
	 * This is called during startup.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		//.CUSTOM: Create a workspace synchronizer instead of a
		//         resource change listener
		workspaceSynchronizer = new WorkspaceSynchronizer(
				(TransactionalEditingDomain) editingDomain,
				createSynchronizationDelegate());
	}
	

	//.CUSTOM: We have a command stack that delegates
	//         to the operation history
	private IOperationHistory getOperationHistory() {
		return ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void dispose() {
		updateProblemIndication = false;

		//.CUSTOM: We use a workspace synchronizer instead of a
		//         resource change listener
		workspaceSynchronizer.dispose();
		
		//.CUSTOM: We have operation history stuff to clean up
		getOperationHistory().removeOperationHistoryListener(historyListener);
		getOperationHistory().dispose(getUndoContext(), true, true, true);
		
		//.CUSTOM: We have only one resource to edit, but it is in
		//         a shared resource set (not our own private set).
		//         So, we must unload it explicitly.  Also remove our problem
		//         indication adapter
		getResource().unload();
		editingDomain.getResourceSet().getResources().remove(getResource());
		editingDomain.getResourceSet().eAdapters().remove(problemIndicationAdapter);
		
		boolean adapterFactoryNoLongerNeeded = isRegisteredAdapterFactoryStillNeeded();
		if(adapterFactoryNoLongerNeeded){
			ResourceSet rs = editingDomain.getResourceSet();
			AdapterFactory adapterToRemove = null;
			for (AdapterFactory registeredAdapterFactory : rs.getAdapterFactories()) {
				if(registeredAdapterFactory instanceof ComposedAdapterFactory){
					ComposedAdapterFactory caf = (ComposedAdapterFactory)registeredAdapterFactory;
					if(caf.getFactoryForType(FairFactory.eINSTANCE.createFair()) instanceof FairItemProviderAdapterFactory){
						adapterToRemove = caf;
						break;
					}
				}
			}
			rs.getAdapterFactories().remove(adapterToRemove);
		}
		
		
		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}

		if (contentOutlinePage != null) {
			contentOutlinePage.dispose();
		}

		super.dispose();
	}

	/**
	 * @return true if there are more FairTransactionEditor instances in
	 *         workbench
	 */
	private boolean isRegisteredAdapterFactoryStillNeeded() {
		boolean adapterFactoryNoLongerNeeded = true;

		IWorkbench workbench = getSite().getWorkbenchWindow().getWorkbench();
		IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		if (activePage == null) {
			return false;
		}
		for (IEditorReference ref : activePage.getEditorReferences()) {
			if ("com.verticon.tracker.fair.transaction.editor.presentation.FairEditorID"
					.equals(ref.getId())) {
				adapterFactoryNoLongerNeeded = false;
				break;
			}

		}
		return adapterFactoryNoLongerNeeded;
	}
	@Override
	public void addViewer(TableViewer tableViewer) {
		FairTransactionActionBarContributor fairActionBarContributor = (FairTransactionActionBarContributor) getActionBarContributor();
		SelectionViewerFilter svf = fairActionBarContributor
				.getCustomActionBarContributor().getSelectionViewerFilter();

		svf.addViewer(tableViewer);

	}

	@Override
	public void removeViewer(TableViewer tableViewer) {
		FairTransactionActionBarContributor fairActionBarContributor = (FairTransactionActionBarContributor) getActionBarContributor();
		SelectionViewerFilter svf = fairActionBarContributor
				.getCustomActionBarContributor().getSelectionViewerFilter();

		svf.removeViewer(tableViewer);
	}
}
