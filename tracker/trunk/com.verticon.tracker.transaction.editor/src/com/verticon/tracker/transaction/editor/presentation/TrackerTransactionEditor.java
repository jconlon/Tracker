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
package com.verticon.tracker.transaction.editor.presentation;

import static com.verticon.tracker.transaction.editor.TransactionEditorPlugin.bundleMarker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.editor.presentation.ICustomActionBarContributor;
import com.verticon.tracker.editor.presentation.IPremisesProvider;
import com.verticon.tracker.editor.presentation.ISelectionViewerProvider;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.editor.util.ITrackerViewRegister;
import com.verticon.tracker.transaction.editor.TransactionEditorPlugin;
import com.verticon.tracker.transaction.editor.domain.ResourceLoadedListener;

/**
 * Tracker transaction aware model editor. <!-- begin-user-doc --> This
 * particular implementation is customized from the default editor generated by
 * EMF.
 * 
 * This editor differs from the generated EMF implementation in the following
 * ways:
 * <ul>
 * <li>all instances operate in a single, shared
 * {@link TransactionalEditingDomain transactional editing domain}</li>
 * <li>a {@link ResourceSetListener} is statically registered on this editing
 * domain that automatically creates editors for any resource loaded (e.g., by
 * proxy resolution)</li>
 * <li>the editing domain delegates command-stack functionality to the worbench
 * {@link IOperationHistory}. It provides its {@link IUndoContext} to
 * specialized implementations of the undo/redo actions that operate on the
 * operation history. Execution of commands is also delegated to the operation
 * history</li>
 * <li>refreshing of the tree content and property sheet is performed within
 * read-only transactions on the editing domain, using the
 * {@link TransactionalEditingDomain#runExclusive(Runnable)} API</li>
 * <li>Animals and Events are shown in a multi-page editor</li>
 * <li>synchronization of the workspace resource with the loaded EMF resource
 * uses the {@link WorkspaceSynchronizer} utility API</li>
 * <li>adds an Animals and an Events table</li>
 * <li>adds SelectionTree expansion and contraction actions to the
 * ActionBarContributor</li>
 * <li>adds Selection linking between Animals and Events Tables</li>
 * <li>adds support for OCL Query View using an IPremisesProvider adapter</li>
 * <li>implements previous three items with interfaces IEventSelectionProvider,
 * IAnimalSelectionProvider, ISelectionViewerProvider, IPremisesProvider</li>
 * <li>adds support for registering views by implementing ITrackerViewRegister</li>
 * </ul>
 * 
 * @implements ITrackerViewRegister
 * 
 *             <!-- end-user-doc -->
 * @generated
 */
public class TrackerTransactionEditor
	extends MultiPageEditorPart
	implements
		IEditingDomainProvider, ISelectionProvider, IMenuListener,
		IViewerProvider, IGotoMarker, ITrackerViewRegister {
	
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(TrackerTransactionEditor.class);

		/**
	 * Offers a generic selection.
	 */
	private ISelectionViewerProvider selectionViewerProvider;
	
	/**
	 * Offers a query on a dataSet. 
	 */
	private IPremisesProvider premisesProvider;
	
	/**
	 * Synchronizes workspace changes with the editing domain.
	 */
	//.CUSTOM: Replaces the resourceChangeListener field generated by EMF
	protected WorkspaceSynchronizer workspaceSynchronizer;
	
	
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;


	//.CUSTOM: The undo context for this editor's Undo and Redo menus
	private IUndoContext undoContext;
	
	//.CUSTOM: The (one and only) resource that we are editing.  The
	//         EMF-generated editor edits any number of resources.
	protected Resource resource;  
	
	/**
	 * This keeps track of the active viewer pane, in the book.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewerPane currentViewerPane;
	
	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	/**
	 * This is a kludge...
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * This is the content outline page's viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is the property sheet page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySheetPage propertySheetPage;

	/**
	 * This is the viewer that shadows the selection in the content outline.
	 * The parent relation must be correctly defined for this to work.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content outline viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;
	
	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented
	 * in Eclipse's Problems View.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();


	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to this editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * This listens for when the outline becomes active
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IPartListener partListener =
		new IPartListener() {
			@Override
			public void partActivated(IWorkbenchPart p) {
				if (p instanceof ContentOutline) {
					if (((ContentOutline)p).getCurrentPage() == contentOutlinePage) {
						getActionBarContributor().setActiveEditor(TrackerTransactionEditor.this);

						setCurrentViewer(contentOutlineViewer);
					}
				}
				else if (p instanceof PropertySheet) {
					if (((PropertySheet)p).getCurrentPage() == propertySheetPage) {
						getActionBarContributor().setActiveEditor(TrackerTransactionEditor.this);
						handleActivate();
					}
				}
				else if (p == TrackerTransactionEditor.this) {
					handleActivate();
				}
			}
			@Override
			public void partBroughtToTop(IWorkbenchPart p) {
			}
			@Override
			public void partClosed(IWorkbenchPart p) {
			}
			@Override
			public void partDeactivated(IWorkbenchPart p) {
			}
			@Override
			public void partOpened(IWorkbenchPart p) {
			}
		};

	/**
	 * Resources that have been removed since last activation.
	 * @generated
	 */
	Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 * @generated
	 */
	Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been moved since last activation.
	 * Maps {@link Resource resource} to {@link URI new URI}
	 */
	//.CUSTOM: Demonstrates the WorkspaceSynchronizer's handling of moves
	Map<Resource, URI> movedResources = new HashMap<Resource, URI>();

	//.CUSTOM: We track dirty state by the last operation executed when saved
	private IUndoableOperation savedOperation;
	
	/**
	 * Resources that have been saved.
	 * @generated
	 */
	Collection<Resource> savedResources = new ArrayList<Resource>();
	
	/**
	 * Map to store the diagnostic associated with a resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	
	
	//.CUSTOM: Applies this editor's undo context to operations that affect
	//         its resource.  Also sets selection to viewer on execution of
	//         operations that wrap EMF Commands.
	private final IOperationHistoryListener historyListener = new IOperationHistoryListener() {
		@Override
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
						@Override
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
						@Override
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
		 * Updates the problems indication with the information described in the specified diagnostic.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected void updateProblemIndication() {
			if (updateProblemIndication) {
				BasicDiagnostic diagnostic =
					new BasicDiagnostic
						(Diagnostic.OK,
						 "com.verticon.tracker.transaction.editor",
						 0,
						 null,
						 new Object [] { editingDomain.getResourceSet() });
				for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
					if (childDiagnostic.getSeverity() != Diagnostic.OK) {
						diagnostic.add(childDiagnostic);
					}
				}

				int lastEditorPage = getPageCount() - 1;
				if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
					((ProblemEditorPart)getEditor(lastEditorPage)).setDiagnostic(diagnostic);
					if (diagnostic.getSeverity() != Diagnostic.OK) {
						setActivePage(lastEditorPage);
					}
				}
				else if (diagnostic.getSeverity() != Diagnostic.OK) {
					ProblemEditorPart problemEditorPart = new ProblemEditorPart();
					problemEditorPart.setDiagnostic(diagnostic);
					problemEditorPart.setMarkerHelper(markerHelper);
					try {
						addPage(++lastEditorPage, problemEditorPart, getEditorInput());
						setPageText(lastEditorPage, problemEditorPart.getPartName());
						setActivePage(lastEditorPage);
						showTabs();
					}
					catch (PartInitException exception) {
						TransactionEditorPlugin.INSTANCE.log(exception);
					}
				}

				if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
					markerHelper.deleteMarkers(editingDomain.getResourceSet());
					if (diagnostic.getSeverity() != Diagnostic.OK) {
						try {
							markerHelper.createMarkers(diagnostic);
						}
						catch (CoreException exception) {
							TransactionEditorPlugin.INSTANCE.log(exception);
						}
					}
				}
			}
		}
	
	/**
	 * Handles activation of the editor or it's associated views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//.CUSTOM: This editor edits only a single resource and uses a
	//         WorkspaceSynchronizer to detect external changes
	protected void handleActivate() {
		logger.debug(bundleMarker,"HandleActivate entered");
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
					getSite().getPage().closeEditor(TrackerTransactionEditor.this, false);
					TrackerTransactionEditor.this.dispose();
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

	/**
	 * Customized behavior for the WorkspaceSynchronizer that records resource
	 * changes to a set of collections to defer processing to Activation of 
	 * this Editor in handleActivate().
	 * 
	 * @return
	 */
	//.CUSTOM: Replaces EMF-generated IResourceChangeListener implementation
	private WorkspaceSynchronizer.Delegate createSynchronizationDelegate() {
		return new WorkspaceSynchronizer.Delegate() {
			@Override
			public boolean handleResourceDeleted(Resource resource) {
				if ((resource == getResource()) && !isDirty()) {
					// just close now without prompt
					getSite().getShell().getDisplay().asyncExec
						(new Runnable() {
							 @Override
							public void run() {
								 getSite().getPage().closeEditor(TrackerTransactionEditor.this, false);
								 TrackerTransactionEditor.this.dispose();
							 }
						 });
				} else {
					removedResources.add(resource);
				}
				
				return true;
			}
			
			@Override
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
			
			@Override
			public boolean handleResourceMoved(Resource resource, URI newURI) {
				movedResources.put(resource, newURI);
				return true;
			}
			
			@Override
			public void dispose() {
				removedResources.clear();
				changedResources.clear();
				movedResources.clear();
			}};
	}
	
	/**
	 * Handles what to do with changed resource on activation.
	 * FIXME Issue 205
	 */
	//.CUSTOM: Replaces EMF-generated handleChangedResources() method
	protected void handleChangedResources() {
		logger.debug(bundleMarker,"HandleChangeResources entered");
		Resource res = getResource();
		boolean myResourceChanged = changedResources.contains(res);

		logger.debug(bundleMarker,"HandleChangeResources myResourceChanged={} somethingChanged={}, ", myResourceChanged, !changedResources.isEmpty());
		if (changedResources.contains(res) && 
				(!isDirty() || handleDirtyConflict())) {
			logger.debug(bundleMarker,"Attempting to load resource");
			changedResources.remove(res);
			
			getOperationHistory().dispose(undoContext, true, true, true);
			firePropertyChange(IEditorPart.PROP_DIRTY);

			ResourceLoadedListener listener = ResourceLoadedListener.getDefault();
			listener.ignore(res);
			
			try {
				if (res.isLoaded()) {
					res.unload();
					try {
						res.load(Collections.EMPTY_MAP);
						logger.debug(bundleMarker,"Loaded changed Resource {}",res);
					} catch (IOException exception) {
						TransactionEditorPlugin.INSTANCE.log(exception);
					}
				}
	
				selectionViewer.setInput(getResource());
			} finally {
				listener.watch(res);
			}
		}
		//.CUSTOM-JC: 
//		resetInputOnTableViewers(res);
		
		updateProblemIndication = true;
		updateProblemIndication();
	}

	
	/**
	 * Handles what to do with moved resource on activation.
	 */
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
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 * 
	 * @generated
	 */
	protected boolean handleDirtyConflict() {
		return
			MessageDialog.openQuestion
				(getSite().getShell(),
				 getString("_UI_FileConflict_label"), //$NON-NLS-1$
				 getString("_WARN_FileConflict")); //$NON-NLS-1$
	}

	/**
	 * This creates a model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public TrackerTransactionEditor() {
		super();

		initializeEditingDomain();
	}
	
	/**
	 * This sets up the editing domain for the model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//.CUSTOM: Instead of the command-stack listener, we create an
	//         operation-history listener.  We also create our undo context.
	protected void initializeEditingDomain() {
		
		// Get the registered workbench editing domain.
		//
		editingDomain = (AdapterFactoryEditingDomain) TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
		"com.verticon.transaction.editor.TrackerEditingDomain"); //$NON-NLS-1$
		
		//There may already be a registered AdapterFactory
		ResourceSet rs = editingDomain.getResourceSet();
		for (AdapterFactory registeredAdapterFactory : rs.getAdapterFactories()) {
			if(registeredAdapterFactory instanceof TrackerTransactionEditorAdapterFactory){
				adapterFactory = (ComposedAdapterFactory)registeredAdapterFactory;
			}
		}
		
		if(adapterFactory==null){
			// Create an adapter factory that yields item providers.
			adapterFactory = new TrackerTransactionEditorAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new TrackerItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

			editingDomain.getResourceSet().getAdapterFactories().add(adapterFactory);
		}
		
		undoContext = new ObjectUndoContext(
				this,
				TransactionEditorPlugin.getPlugin().getString("_UI_EXTLibraryEditor_label")); //$NON-NLS-1$
		getOperationHistory().addOperationHistoryListener(historyListener);
	}

	/**
	 * This is here for the listener to be able to call it. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * This sets the selection into whichever viewer is active. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSelectionToViewer(Collection<?>  collection) {
		final Collection<?>  theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			// I don't know if this should be run this deferred
			// because we might have to give the editor a chance to process the viewer update events
			// and hence to update the views first.
			//
			//
			Runnable runnable =
				new Runnable() {
					@Override
					public void run() {
						// Try to select the items in the current content viewer of the editor.
						//
						if (currentViewer != null) {
							currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
						}
					}
				};
			runnable.run();
		}
	}

	/**
	 * This returns the editing domain as required by the {@link IEditingDomainProvider} interface.
	 * This is important for implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	//.CUSTOM: EMF-generated class extends AdapterFactoryContentProvider
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
	 * This makes sure that one content viewer, either for the current page or the outline view, if it has focus,
	 * is the current one.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener =
					new ISelectionChangedListener() {
						// This just notifies those things that are affected by the section.
						//
						@Override
						public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
							setSelection(selectionChangedEvent.getSelection());
						}
					};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's selection.
			//
			setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
		}
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider} interface.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Viewer getViewer() {
		return currentViewer;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(new Separator("additions")); //$NON-NLS-1$
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, viewer);

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//.CUSTOM we record only a single resource
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
	 * Returns a diagnostic describing the errors and warnings listed in the resource
	 * and the specified exception (if any).
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic =
				new BasicDiagnostic
					(Diagnostic.ERROR,
					 "com.verticon.tracker.transaction.editor",
					 0,
					 getString("_UI_CreateModelError_message", resource.getURI()),
					 new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null) {
			return
				new BasicDiagnostic
					(Diagnostic.ERROR,
					 "com.verticon.tracker.transaction.editor",
					 0,
					 getString("_UI_CreateModelError_message", resource.getURI()),
					 new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
	}
	
	/**
	 * Adapter used to update the problem indication when resources are demanded loaded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EContentAdapter problemIndicationAdapter = 
		new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getNotifier() instanceof Resource) {
					switch (notification.getFeatureID(Resource.class)) {
						case Resource.RESOURCE__IS_LOADED:
						case Resource.RESOURCE__ERRORS:
						case Resource.RESOURCE__WARNINGS: {
							Resource resource = (Resource)notification.getNotifier();
							Diagnostic diagnostic = analyzeResourceProblems(resource, null);
							if (diagnostic.getSeverity() != Diagnostic.OK) {
								resourceToDiagnosticMap.put(resource, diagnostic);
							}
							else {
								resourceToDiagnosticMap.remove(resource);
							}

							if (updateProblemIndication) {
								getSite().getShell().getDisplay().asyncExec
									(new Runnable() {
										 @Override
										public void run() {
											 updateProblemIndication();
										 }
									 });
							}
							break;
						}
					}
				}
				else {
					super.notifyChanged(notification);
				}
			}

			@Override
			protected void setTarget(Resource target) {
				basicSetTarget(target);
			}

			@Override
			protected void unsetTarget(Resource target) {
				basicUnsetTarget(target);
			}
		};
		
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

	
	@Override
	protected void createPages() {
		createModel();

		createSelectionTreeViewer(getString("_UI_SelectionPage_label"));
		
		IEditorActionBarContributor abc = getActionBarContributor();
		if(abc != null && abc instanceof TrackerActionBarContributor){
			TrackerActionBarContributor trackerActionBarContributor =(TrackerActionBarContributor)abc;
			trackerActionBarContributor.getCustomActionBarContributor().getSelectionViewerFilter().setMainViewer(selectionViewer);
			
		}
		setActivePage(0);
		
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

		
	}
	
	
	protected void createSelectionTreeViewer(String pageName){

		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), TrackerTransactionEditor.this) {
				@Override
				public Viewer createViewer(Composite composite) {
					Tree tree = new Tree(composite, SWT.MULTI);
					TreeViewer newTreeViewer = new TreeViewer(tree);
					return newTreeViewer;
				}
				@Override
				public void requestActivation() {
					super.requestActivation();
					setCurrentViewerPane(this);
				}
			};
		viewerPane.createControl(getContainer());

		selectionViewer = (TreeViewer)viewerPane.getViewer();

		selectionViewer.setContentProvider(
				new TransactionalAdapterFactoryContentProvider(
						(TransactionalEditingDomain) getEditingDomain(), 
						adapterFactory
				)
		);

		selectionViewer.setLabelProvider(
				new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain) getEditingDomain(), adapterFactory));
		
		// unlike other EMF editors, I edit only a single resource, not a resource set
		Resource resource = getResource();
		selectionViewer.setInput(resource);
		viewerPane.setTitle(resource);
		new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

		createContextMenuFor(selectionViewer);
		
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex,pageName );
	}
	
	

	/**
	 * If there is just one page in the multi-page editor part,
	 * this hides the single tab at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void hideTabs() {
		if (getPageCount() <= 1) {
			setPageText(0, "");
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
			}
		}
	}

	/**
	 * If there is more than one page in the multi-page editor part,
	 * this shows the tabs at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void showTabs() {
		if (getPageCount() > 1) {
			setPageText(0, getString("_UI_SelectionPage_label"));
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(SWT.DEFAULT);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y - 6);
			}
		}
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewerPane(ViewerPane viewerPane) {
		if (currentViewerPane != viewerPane) {
			if (currentViewerPane != null) {
				currentViewerPane.showFocus(false);
			}
			currentViewerPane = viewerPane;
		}
		setCurrentViewer(currentViewerPane.getViewer());
	}

	
	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * Modified to offer IAnimalSelectionProvider, ISelectionViewerProvider, 
	 * IPremisesProvider
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return getContentOutlinePage();
		}
		else if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else if (key.equals(IGotoMarker.class)) {
			return this;
		}
		else if (key.equals(IUndoContext.class)) {
			// used by undo/redo actions to get their undo context
			return undoContext;
		}
		
		//Added to support the main Viewer Selections
		else if (key.equals(ISelectionViewerProvider.class)){
			if (selectionViewerProvider==null){
				selectionViewerProvider = new ISelectionViewerProvider(){

					@Override
					public ISelection getSelectionViewerSelection() {
						return TrackerTransactionEditor.this.getSelectionViewerSelection();
					}

					@Override
					public void setSelectionViewerSelection(ISelection selection) {
						TrackerTransactionEditor.this.setSelectionViewerSelection(selection);
						
					}
					
				};
			}
			return selectionViewerProvider;
		}

		//Adds adaptive support for IPremisesProvider 	
		else if (key.equals(IPremisesProvider.class)){
			if (premisesProvider==null){
				premisesProvider = new IPremisesProvider(){

					@Override
					public EditingDomain getEditingDomain() {
						return TrackerTransactionEditor.this.getEditingDomain();
					}

					@Override
					public void setSelectionToViewer(Collection<?> collection) {
						TrackerTransactionEditor.this.setSelectionToViewer(collection);
					}
					
					@Override
					public Premises getPremises() {
						Premises premises = null;
						if(resource.getURI().fileExtension().endsWith("premises")){
							  premises = (Premises)	resource.getEObject("/");
						}
						return premises;
					}
					
				};
			}
			return premisesProvider;
		}
		else {
			return super.getAdapter(key);
		}
	}

	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
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
					
					//.CUSTOM: I edit only a single resource, not a resource set
					contentOutlineViewer.setInput(getResource());

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
					  // Select the root object in the view.
					  //
					  //.CUSTOM: I edit only a single resource.
					  ArrayList<Resource> selection = new ArrayList<Resource>();
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
					 @Override
					public void selectionChanged(SelectionChangedEvent event) {
						 handleContentOutlineSelection(event.getSelection());
					 }
				 });
		}

		return contentOutlinePage;
	}

	/**
	 * This accesses a cached version of the property sheet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage =
				new ExtendedPropertySheetPage(editingDomain) {
					@Override
					public void setSelectionToViewer(List<?> selection) {
						TrackerTransactionEditor.this.setSelectionToViewer(selection);
						TrackerTransactionEditor.this.setFocus();
					}

					@Override
					public void setActionBars(IActionBars actionBars) {
						super.setActionBars(actionBars);
						getActionBarContributor().shareGlobalActions(this, actionBars);
					}
				};
		   //.CUSTOM: Use a transactional property-source provider
		   propertySheetPage.setPropertySourceProvider(
				   new TransactionalAdapterFactoryContentProvider(
						   (TransactionalEditingDomain) getEditingDomain(), adapterFactory));
		}

		return propertySheetPage;
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other views.
	 * <!-- begin-user-doc -->
	 * Ties in the eventsTableViewer to the selection in the outliner.
	 * <!-- end-user-doc -->
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the same selection as this selection.
				//
				if (currentViewerPane.getViewer() == selectionViewer ) {
					ArrayList<Object> selectionList = new ArrayList<Object>();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						selectionList.add(selectedElements.next());
					}

					// Set the selection to the widget.
					//
					selectionViewer.setSelection(new StructuredSelection(
							selectionList));				
				}
				else {
					// Set the input to the widget.
					//
					if (currentViewerPane.getViewer().getInput() != selectedElement) {
						currentViewerPane.getViewer().setInput(selectedElement);
						currentViewerPane.setTitle(selectedElement);
					}
				}
			}
		}
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
							@Override
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
						TransactionEditorPlugin.INSTANCE.log(exception);
					}
				}
			};

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
			TransactionEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}

	/**
	 * This always returns true because it is not currently supported.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This also changes the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog= new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path= saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(),true), new FileEditorInput(file));
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void doSaveAs(final URI uri, final IEditorInput editorInput) {
		// changing the URI is, conceptually, a write operation.  However, it does
		//    not affect the abstract state of the model, so we only need exclusive
		//    (read) access
		try {
			((TransactionalEditingDomain) getEditingDomain()).runExclusive(new Runnable() {
				@Override
				public void run() {
					getResource().setURI(uri);
					setInputWithNotify(editorInput);
					setPartName(editorInput.getName());
				}});
		} catch (InterruptedException e) {
			TransactionEditorPlugin.INSTANCE.log(e);
			
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
							@Override
							public void run() {
								URI uri = URI.createURI(uriAttribute);
								EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
								if (eObject != null) {
								  setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
								}
							}});
					} catch (InterruptedException e) {
						TransactionEditorPlugin.INSTANCE.log(e);
					}
				}
			}
		}
		catch (CoreException exception) {
			TransactionEditorPlugin.INSTANCE.log(exception);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setFocus() {
		selectionViewer.getControl().setFocus();
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's overall selection.
	 * Calling this result will notify the listeners.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (Iterator<?> listeners = selectionChangedListeners.iterator(); listeners.hasNext(); ) {
			ISelectionChangedListener listener = (ISelectionChangedListener)listeners.next();
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
		setStatusLineManager(selection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = currentViewer != null && currentViewer == contentOutlineViewer ?
			contentOutlineStatusLineManager : getActionBars().getStatusLineManager();
	
		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection)selection).toList();
				switch (collection.size()) {
					case 0: {
						statusLineManager.setMessage(getString("_UI_NoObjectSelected")); //$NON-NLS-1$
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text)); //$NON-NLS-1$
						break;
					}
					default: {
						statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size()))); //$NON-NLS-1$
						break;
					}
				}
			}
			else {
				statusLineManager.setMessage(""); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key) {
		return TransactionEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return TransactionEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	//.CUSTOM: We have a command stack that delegates
	//         to the operation history
	private IOperationHistory getOperationHistory() {
		return ((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Added a unset of myContentAdapter
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void dispose() {
		updateProblemIndication = false;

		//.CUSTOM: We use a workspace synchronizer instead of a
		//         resource change listener
		workspaceSynchronizer.dispose();
		getOperationHistory().removeOperationHistoryListener(historyListener);
		getOperationHistory().dispose(getUndoContext(), true, true, true);
		
		getResource().unload();
		editingDomain.getResourceSet().getResources().remove(getResource());
		editingDomain.getResourceSet().eAdapters().remove(problemIndicationAdapter);
		
		
		boolean adapterFactoryNoLongerNeeded = isRegisteredAdapterFactoryStillNeeded();
		if(adapterFactoryNoLongerNeeded){
			ResourceSet rs = editingDomain.getResourceSet();
			AdapterFactory adapterToRemove = null;
			for (AdapterFactory registeredAdapterFactory : rs.getAdapterFactories()) {
				if(registeredAdapterFactory instanceof TrackerTransactionEditorAdapterFactory){
					adapterToRemove = registeredAdapterFactory;
					break;
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
	 * Remove the registered AdpaterFactory if there are no more Transaction
	 * Editor instances in workbench
	 * 
	 * @param adapterFactoryNoLongerNeeded
	 * @return
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
			if ("com.verticon.tracker.transaction.editor.TrackerEditorID"
					.equals(ref.getId())) {
				adapterFactoryNoLongerNeeded = false;
				break;
			}

		}
		return adapterFactoryNoLongerNeeded;
	}

	

	/**
	 * This is used to track the active viewer.
	 * <!-- begin-user-doc -->
	 * Also used to enable and disable buttons
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);
		IEditorActionBarContributor abc = getActionBarContributor();
		if(abc != null && abc instanceof TrackerActionBarContributor){
			TrackerActionBarContributor tabc = (TrackerActionBarContributor)abc;
			resetActionBarContributor(tabc.getCustomActionBarContributor());
		}
		
		if (contentOutlinePage != null) {
			handleContentOutlineSelection(contentOutlinePage.getSelection());
		}
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.editor.presentation.CustomActionBarContributor#setActivePage(com.verticon.tracker.editor.presentation.TrackerEditor, int)
	 */
	private void resetActionBarContributor(ICustomActionBarContributor icabc){
		if (currentViewerPane != null){
			
			if (currentViewerPane.getViewer() instanceof TreeViewer ) {
				icabc.enableTreeViewerActions();
			} else {
				icabc.disableTreeViewerActions();
			}
			if (currentViewerPane.getViewer() == selectionViewer ){
				icabc.enableSelectionViewerActions();
			}else{
				icabc.disableSelectionViewerActions();
			}
		}
	}

	public ISelection getSelectionViewerSelection() {
		return selectionViewer.getSelection();
	}

	public void setSelectionViewerSelection(ISelection selection) {
		selectionViewer.setSelection(selection);
	}
	
	/**
	 * A private ComposedAdapterFactory for this Editor that can be 
	 * detected and removed at disposal time from the list of registered 
	 * AdapterFactories.
	 * @author jconlon
	 *
	 */
	private class TrackerTransactionEditorAdapterFactory extends ComposedAdapterFactory{

		public TrackerTransactionEditorAdapterFactory(
				Registry adapterFactoryDescriptorRegistry) {
			super(adapterFactoryDescriptorRegistry);
		}
		
	}
	
	@Override
	public void addViewer(TableViewer tableViewer) {
		TrackerActionBarContributor trackerActionBarContributor = (TrackerActionBarContributor) getActionBarContributor();
		SelectionViewerFilter svf = trackerActionBarContributor
				.getCustomActionBarContributor().getSelectionViewerFilter();

		svf.addViewer(tableViewer);

	}

	@Override
	public void removeViewer(TableViewer tableViewer) {
		TrackerActionBarContributor trackerActionBarContributor = (TrackerActionBarContributor) getActionBarContributor();
		SelectionViewerFilter svf = trackerActionBarContributor
				.getCustomActionBarContributor().getSelectionViewerFilter();

		svf.removeViewer(tableViewer);
	}
}
