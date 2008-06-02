/**
 * Copyright 2007 Verticon, Inc. All Rights Reserved.
 *
 * $Id$
 */
package com.verticon.tracker.fair.transaction.editor.presentation;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
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
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
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
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableLayout;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
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

import com.verticon.tracker.Animal;
import com.verticon.tracker.Event;
import com.verticon.tracker.Premises;
import com.verticon.tracker.edit.provider.TrackerItemProviderAdapterFactory;
import com.verticon.tracker.edit.provider.TrackerReportEditPlugin;
import com.verticon.tracker.editor.presentation.IAnimalSelectionProvider;
import com.verticon.tracker.editor.presentation.IEventSelectionProvider;
import com.verticon.tracker.editor.presentation.IQueryDataSetProvider;
import com.verticon.tracker.editor.presentation.ISelectionViewerProvider;
import com.verticon.tracker.editor.presentation.SelectionViewerFilter;
import com.verticon.tracker.editor.presentation.TrackerTableEditorUtils;
import com.verticon.tracker.fair.Exhibit;
import com.verticon.tracker.fair.Fair;
import com.verticon.tracker.fair.Person;
import com.verticon.tracker.fair.edit.provider.FairItemProviderAdapterFactory;
import com.verticon.tracker.fair.editor.presentation.FairTableEditorUtils;
import com.verticon.tracker.fair.transaction.editor.domain.FairResourceLoadedListener;
import com.verticon.tracker.transaction.editor.presentation.TransactionalEventHistoryContentProvider;


/**
 * This is an example of a Fair model editor.
 * <!-- begin-user-doc -->
 * This is an experimental version of the FairTransactionEditor.
 * It differs from the production version in it does not subclass the generated editor.
 * 
 * This editor differs from the generated EMF implementation in the following ways:
 * <ul>
 *   <li>adds an Animals table</li>
 *   <li>adds an Events table</li>
 *   <li>adds an Exhibits table </li>
 *   <li>adds an People table </li>
 *   <li>adds support for OCL Query View using an IQueryDataSetProvider adapter</li>
 *    <li>adds SelectionTree expansion and  contraction actions to the 
 *   	 ActionBarContributor</li>
 *   <li>adds Selection linking between Animals and Events Tables</li>
 *   <li>implements previous two items with adapters for IEventSelectionProvider, 
 *   	 IAnimalSelectionProvider, ISelectionViewerProvider,  </li>
 * </ul>
 * <!-- end-user-doc -->
 * @generated
 */
public class FairTransactionEditor1
	extends MultiPageEditorPart
	implements IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007, 2008 Verticon, Inc. All Rights Reserved.";
	
	/**
	 * slf4j Logger
	 * @generated NOT
	 */
	private final Logger logger = LoggerFactory.getLogger(FairTransactionEditor.class);

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;

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
	 * Events Table Viewer
	 * @generated NOT
	 */
	protected TableViewer eventsTableViewer;
	

	/**
	 * Animals Table Viewer
	 * @generated NOT
	 */
	protected TableViewer animalsTableViewer;
	
	/**
	 * People Table Viewer
	 * @generated NOT
	 */
	protected TableViewer peopleTableViewer;
	
	/**
	 * Exhibit Table Viewer
	 * @generated NOT
	 */
	protected TableViewer exhibitsTableViewer;
	
	/**
	 * Offers a selection on a set of Animals. 
	 * @generated NOT
	 */
	private IAnimalSelectionProvider animalSelectionProvider;
	
	/**
	 * Offers a generic selection. 
	 * @generated NOT
	 */
	private ISelectionViewerProvider selectionViewerProvider;
	
	/**
	 * Offers a selection on a set of Events. 
	 * @generated NOT
	 */
	private IEventSelectionProvider eventSelectionProvider;
	
	/**
	 * Offers a query on a dataSet. 
	 * @generated NOT
	 */
	private IQueryDataSetProvider queryDataSetProvider;

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
	 * This inverts the roll of parent and child in the content provider and show parents as a tree.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer parentViewer;

	/**
	 * This shows how a tree view works.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer treeViewer;

	/**
	 * This shows how a list view works.
	 * A list viewer doesn't support icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListViewer listViewer;

	/**
	 * This shows how a table view works.
	 * A table can be used as a list with icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableViewer tableViewer;

	/**
	 * This shows how a tree view with columns works.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer treeViewerWithColumns;

	/**
	 * This keeps track of the active viewer pane, in the book.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewerPane currentViewerPane;

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
	 * The MarkerHelper is responsible for creating workspace resource markers presented
	 * in Eclipse's Problems View.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();
	
	
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
	private Map<Resource, URI> movedResources = new HashMap<Resource, URI>();
	
	//.CUSTOM: We track dirty state by the last operation executed when saved
	private IUndoableOperation savedOperation;
	
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
	 * This listens for when the outline becomes active
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IPartListener partListener =
		new IPartListener() {
			public void partActivated(IWorkbenchPart p) {
				if (p instanceof ContentOutline) {
					if (((ContentOutline)p).getCurrentPage() == contentOutlinePage) {
						getActionBarContributor().setActiveEditor(FairTransactionEditor1.this);

						setCurrentViewer(contentOutlineViewer);
					}
				}
				else if (p instanceof PropertySheet) {
					if (((PropertySheet)p).getCurrentPage() == propertySheetPage) {
						getActionBarContributor().setActiveEditor(FairTransactionEditor1.this);
						handleActivate();
					}
				}
				else if (p == FairTransactionEditor1.this) {
					handleActivate();
				}
			}
			public void partBroughtToTop(IWorkbenchPart p) {
				// Ignore.
			}
			public void partClosed(IWorkbenchPart p) {
				// Ignore.
			}
			public void partDeactivated(IWorkbenchPart p) {
				// Ignore.
			}
			public void partOpened(IWorkbenchPart p) {
				// Ignore.
			}
		};

	/**
	 * Resources that have been removed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();

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
		 * Handles activation of the editor or it's associated views.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		//.CUSTOM: This editor edits only a single resource and uses a
		//         WorkspaceSynchronizer to detect external changes
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
						getSite().getPage().closeEditor(FairTransactionEditor1.this, false);
						FairTransactionEditor1.this.dispose();
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

		//.CUSTOM: Replaces EMF-generated IResourceChangeListener implementation
		private WorkspaceSynchronizer.Delegate createSynchronizationDelegate() {
			return new WorkspaceSynchronizer.Delegate() {
				public boolean handleResourceDeleted(Resource resource) {
					if ((resource == getResource()) && !isDirty()) {
						// just close now without prompt
						getSite().getShell().getDisplay().asyncExec
							(new Runnable() {
								 public void run() {
									 getSite().getPage().closeEditor(FairTransactionEditor1.this, false);
									 FairTransactionEditor1.this.dispose();
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
		protected void handleChangedResources() {
			Resource res = getResource();
			
			if (changedResources.contains(res) && (!isDirty() || handleDirtyConflict())) {
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
	 * @generated
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new FairItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new TrackerItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 getContainer().getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  firePropertyChange(IEditorPart.PROP_DIRTY);

								  // Try to select the affected objects.
								  //
								  Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
								  if (mostRecentCommand != null) {
									  setSelectionToViewer(mostRecentCommand.getAffectedObjects());
								  }
								  if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
									  propertySheetPage.refresh();
								  }
							  }
						  });
				 }
			 });
		editingDomain = (AdapterFactoryEditingDomain) 
		TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
			"com.verticon.transaction.editor.TrackerEditingDomain"); //$NON-NLS-1$
		editingDomain.getResourceSet().getAdapterFactories().add(adapterFactory);
		undoContext = new ObjectUndoContext(
			this,
			FairTransactionEditorPlugin.getPlugin().getString("_UI_FairEditor_label")); //$NON-NLS-1$
		getOperationHistory().addOperationHistoryListener(historyListener);
		}
		
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
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
		 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		//.CUSTOM we record only a single resource
		//FIXME to handle a resourceSet
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
		 */
		//.CUSTOM: This editor edits only one resource.
		protected Resource getResource() {
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
	
		
		
		/**
		 * This accesses a cached version of the content outliner.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
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
	 * Resets the Input on TableViewers
	 * 
	 * @generated NOT
	 */
	private void resetInputOnTableViewers() {
		logger.debug("Reloading resources");
		  Object rootObject = getRoot();
		  if ((rootObject instanceof Fair) && (((Fair)rootObject).getPremises()!=null))
		  {
			logger.debug("Setting input on Premises tables");
					 animalsTableViewer.setInput(((Fair)rootObject).getPremises());
					 eventsTableViewer.setInput(((Fair)rootObject).getPremises());
		  }else{
			  logger.error("Root object was not a Premises, but a  {}", rootObject.getClass().toString());
		  }
	}

  
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
					 "com.verticon.tracker.fair.editor",
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
					FairTransactionEditorPlugin.INSTANCE.log(exception);
				}
			}

			if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
				markerHelper.deleteMarkers(editingDomain.getResourceSet());
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					try {
						markerHelper.createMarkers(diagnostic);
					}
					catch (CoreException exception) {
						FairTransactionEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean handleDirtyConflict() {
		return
			MessageDialog.openQuestion
				(getSite().getShell(),
				 getString("_UI_FileConflict_label"),
				 getString("_WARN_FileConflict"));
	}

	/**
	 * This creates a model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FairTransactionEditor1() {
		super();
		initializeEditingDomain();
	}

	
	/**
	 * This is here for the listener to be able to call it.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
			@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
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
	public EditingDomain getEditingDomain() {
		return editingDomain;
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
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
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
					 "com.verticon.tracker.fair.editor",
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
					 "com.verticon.tracker.fair.editor",
					 0,
					 getString("_UI_CreateModelError_message", resource.getURI()),
					 new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
	}
	
	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc -->
	 * Added Events, and Animals tables. Removed Tree Tables.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void createPages() {
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty() &&
				!((Resource)getEditingDomain().getResourceSet().getResources().get(0)).getContents().isEmpty()) {

			createSelectionTreeViewer(getString("_UI_SelectionPage_label"));

			createListViewer(getString("_UI_ListPage_label"));

			createEventsTableViewer(getString("_UI_EventsTablePage_label"));

			createAnimalsTableViewer(getString("_UI_AnimalsTablePage_label"));
			
			createExhibitsTableViewer(getString("_UI_ExhibitsTablePage_label"));
			
			createPeopleTableViewer(getString("_UI_PeopleTablePage_label"));

			IEditorActionBarContributor abc = getActionBarContributor();
			if(abc != null && abc instanceof FairTransactionActionBarContributor){
				FairTransactionActionBarContributor fairActionBarContributor =(FairTransactionActionBarContributor)abc;
				SelectionViewerFilter svf = fairActionBarContributor.getCustomActionBarContributor().
					getSelectionViewerFilter();
				fairActionBarContributor.getCustomActionBarContributor().getSelectionViewerFilter().setMainViewer(selectionViewer);
				svf.addViewer(eventsTableViewer);
				svf.addViewer(animalsTableViewer);
				svf.addViewer(peopleTableViewer);
				svf.addViewer(exhibitsTableViewer);
			}
			
			setActivePage(0);
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener
			(new ControlAdapter() {
				boolean guard = false;
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
	
	/**
	 * ListViewer
	 */
	private void createListViewer(String pageName) {
		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
				public Viewer createViewer(Composite composite) {
					return new ListViewer(composite);
				}
				public void requestActivation() {
					super.requestActivation();
					setCurrentViewerPane(this);
				}
			};
		viewerPane.createControl(getContainer());
		listViewer = (ListViewer)viewerPane.getViewer();
		listViewer.setContentProvider(new TransactionalAdapterFactoryContentProvider((TransactionalEditingDomain) getEditingDomain(),adapterFactory));
		listViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider((TransactionalEditingDomain) getEditingDomain(),
				adapterFactory));

		createContextMenuFor(listViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, pageName);
	}
	
	/**
	 * SelectionTreeViewer
	 *
	 */
	private void createSelectionTreeViewer(String pageName ) {
		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
				public Viewer createViewer(Composite composite) {
					Tree tree = new Tree(composite, SWT.MULTI);
					TreeViewer newTreeViewer = new TreeViewer(tree);
					return newTreeViewer;
				}
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
		
		selectionViewer.setInput(editingDomain.getResourceSet());
		viewerPane.setTitle(editingDomain.getResourceSet());

		new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

		createContextMenuFor(selectionViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex,pageName );
	}
	
	/**
	 * Events Table
	 */
	private void createEventsTableViewer(String tableName) {
		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
			public Viewer createViewer(Composite composite) {
				return new TableViewer(composite);
			}
			public void requestActivation() {
				super.requestActivation();
				setCurrentViewerPane(this);
				this.getViewer().refresh();
			}
		};
		viewerPane.createControl(getContainer());
		eventsTableViewer = TrackerTableEditorUtils.createEventsTableViewer(
				viewerPane);

		eventsTableViewer.setContentProvider(new TransactionalEventHistoryContentProvider(
				(TransactionalEditingDomain)getEditingDomain(),
				adapterFactory));
		eventsTableViewer.setLabelProvider(
				new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain)getEditingDomain(),
						adapterFactory));
		

		Object rootObject = getRoot();
		if (rootObject instanceof Fair){
			eventsTableViewer.setInput(((Fair)rootObject).getPremises());
			viewerPane.setTitle(((Fair)rootObject).getPremises());
		}
		createContextMenuFor(eventsTableViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, tableName);
		
	}
	
	/**
	 * Animals Table
	 * References fields animalsTableViewer, 
	 * @param tableName 
	 */
	private void createAnimalsTableViewer(String tableName) {
		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
			public Viewer createViewer(Composite composite) {
				return new TableViewer(composite);
			}
			public void requestActivation() {
				super.requestActivation();
				setCurrentViewerPane(this);
			}
		};
		viewerPane.createControl(getContainer());
		animalsTableViewer = TrackerTableEditorUtils.createAnimalsTableViewer(
				viewerPane);
		/**
		 * The default ItemProvider returned via the adapterFactory
		 * for Premises should be able to handle all notifications 
		 * of animals being added or removed.
		 * 
		 * To get Animal Elements override the getElements method 
		 */
		animalsTableViewer.setContentProvider(
		        new TransactionalAdapterFactoryContentProvider(
		        		(TransactionalEditingDomain)getEditingDomain(),
		        		adapterFactory) // 14.2.2
		        {
		          @Override
		          public Object [] getElements(Object object)
		          {
		            return ((Premises)object).getAnimals().toArray();
		          }

		        });
		animalsTableViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(
				(TransactionalEditingDomain)getEditingDomain(),
				adapterFactory));
		Object rootObject = getRoot();
		if (rootObject instanceof Fair)
		{
			animalsTableViewer.setInput(((Fair)rootObject).getPremises());
			viewerPane.setTitle(((Fair)rootObject).getPremises());
		}

		createContextMenuFor(animalsTableViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, tableName);
	}
	
	
	/**
	 * Exhibits Table
	 * References fields exhibitsTableViewer, 
	 * @param tableName 
	 */
	protected void createExhibitsTableViewer(String tableName) {
		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
			public Viewer createViewer(Composite composite) {
				return new TableViewer(composite);
			}
			public void requestActivation() {
				super.requestActivation();
				setCurrentViewerPane(this);
			}
		};
		viewerPane.createControl(getContainer());
		exhibitsTableViewer = FairTableEditorUtils.createExhibitsTableViewer(viewerPane);

		exhibitsTableViewer.setContentProvider(new TransactionalExhibitsContentAdapter(
        		(TransactionalEditingDomain)getEditingDomain(),
        		adapterFactory));
		exhibitsTableViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(
				(TransactionalEditingDomain)getEditingDomain(),
				adapterFactory));

		Object rootObject = getRoot();
		if (rootObject instanceof Fair)
		{
			exhibitsTableViewer.setInput(rootObject);
			viewerPane.setTitle(rootObject);
		}
		

		createContextMenuFor(exhibitsTableViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, tableName);
	}

	/**
	 * People Table
	 * References fields peopleTableViewer, 
	 * @param tableName 
	 */
	private void createPeopleTableViewer(String tableName) {
		ViewerPane viewerPane =
			new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
			public Viewer createViewer(Composite composite) {
				return new TableViewer(composite);
			}
			public void requestActivation() {
				super.requestActivation();
				setCurrentViewerPane(this);
			}
		};
		viewerPane.createControl(getContainer());
		peopleTableViewer = FairTableEditorUtils.createPeopleTableViewer( viewerPane);
		
		
		/**
		 * The default ItemProvider returned via the adapterFactory for Premises
		 * should be able to handle all notifications of animals being added or
		 * removed.
		 * 
		 * To get People Elements override the getElements method
		 */
		peopleTableViewer.setContentProvider(new TransactionalAdapterFactoryContentProvider(
				(TransactionalEditingDomain)getEditingDomain(),adapterFactory) {
			@Override
			public Object[] getElements(Object object) {
				Fair fair = (Fair) object;

				return fair.getPeople().toArray();
			}

		});
		peopleTableViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(
				(TransactionalEditingDomain)getEditingDomain(),adapterFactory));

		Object rootObject = getRoot();
		if (rootObject instanceof Fair)
		{
			peopleTableViewer.setInput(rootObject);
			viewerPane.setTitle(rootObject);
		}

		createContextMenuFor(peopleTableViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, tableName);
	}
	
	/**
	 * Convienence method to find the Root
	 * @return
	 */
	private Object getRoot() {
//		Resource resource = (Resource)editingDomain.getResourceSet().getResources().get(0);
		  Object rootObject = resource.getContents().get(0);
		return rootObject;
	}

	
	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc -->
	 * Not used but here, for documentation to show what is created by the generator.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public void createPagesGen() {
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty() &&
		    !(getEditingDomain().getResourceSet().getResources().get(0)).getContents().isEmpty()) {
			// Create a page for the selection tree view.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
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
				selectionViewer.setContentProvider(new TransactionalAdapterFactoryContentProvider(
						(TransactionalEditingDomain) getEditingDomain(),
						adapterFactory));

				selectionViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain) getEditingDomain(),
						adapterFactory));
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_SelectionPage_label"));
			}

			// Create a page for the parent tree view.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
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

				parentViewer = (TreeViewer)viewerPane.getViewer();
				parentViewer.setAutoExpandLevel(30);
				parentViewer.setContentProvider(
						new TransactionalAdapterFactoryContentProvider(
								(TransactionalEditingDomain) getEditingDomain(),
								adapterFactory));
				parentViewer.setLabelProvider(
						new TransactionalAdapterFactoryLabelProvider(
								(TransactionalEditingDomain) getEditingDomain(),
								adapterFactory));

				createContextMenuFor(parentViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_ParentPage_label"));
			}

			// This is the page for the list viewer
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new ListViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());
				listViewer = (ListViewer)viewerPane.getViewer();
				listViewer.setContentProvider(
						new TransactionalAdapterFactoryContentProvider(
								(TransactionalEditingDomain) getEditingDomain(),
								adapterFactory));
				listViewer.setLabelProvider(
						new TransactionalAdapterFactoryLabelProvider(
								(TransactionalEditingDomain) getEditingDomain(),
								adapterFactory));

				createContextMenuFor(listViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_ListPage_label"));
			}

			// This is the page for the tree viewer
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new TreeViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());
				treeViewer = (TreeViewer)viewerPane.getViewer();
				treeViewer.setContentProvider(new TransactionalAdapterFactoryContentProvider(
						(TransactionalEditingDomain) getEditingDomain(),
						adapterFactory));
				treeViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain) getEditingDomain(),
						adapterFactory));
				new AdapterFactoryTreeEditor(treeViewer.getTree(), adapterFactory);

				createContextMenuFor(treeViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_TreePage_label"));
			}

			// This is the page for the table viewer.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new TableViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());
				tableViewer = (TableViewer)viewerPane.getViewer();

				Table table = tableViewer.getTable();
				TableLayout layout = new TableLayout();
				table.setLayout(layout);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);

				TableColumn objectColumn = new TableColumn(table, SWT.NONE);
				layout.addColumnData(new ColumnWeightData(3, 100, true));
				objectColumn.setText(getString("_UI_ObjectColumn_label"));
				objectColumn.setResizable(true);

				TableColumn selfColumn = new TableColumn(table, SWT.NONE);
				layout.addColumnData(new ColumnWeightData(2, 100, true));
				selfColumn.setText(getString("_UI_SelfColumn_label"));
				selfColumn.setResizable(true);

				tableViewer.setColumnProperties(new String [] {"a", "b"});
				tableViewer.setContentProvider(new TransactionalAdapterFactoryContentProvider(
						(TransactionalEditingDomain) getEditingDomain(),
						adapterFactory));
				tableViewer.setLabelProvider(new TransactionalAdapterFactoryLabelProvider(
						(TransactionalEditingDomain) getEditingDomain(),
						adapterFactory));

				createContextMenuFor(tableViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_TablePage_label"));
			}

			// This is the page for the table tree viewer.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), FairTransactionEditor1.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new TreeViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());

				treeViewerWithColumns = (TreeViewer)viewerPane.getViewer();

				Tree tree = treeViewerWithColumns.getTree();
				tree.setLayoutData(new FillLayout());
				tree.setHeaderVisible(true);
				tree.setLinesVisible(true);

				TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
				objectColumn.setText(getString("_UI_ObjectColumn_label"));
				objectColumn.setResizable(true);
				objectColumn.setWidth(250);

				TreeColumn selfColumn = new TreeColumn(tree, SWT.NONE);
				selfColumn.setText(getString("_UI_SelfColumn_label"));
				selfColumn.setResizable(true);
				selfColumn.setWidth(200);

				treeViewerWithColumns.setColumnProperties(new String [] {"a", "b"});
				treeViewerWithColumns.setContentProvider(
						new TransactionalAdapterFactoryContentProvider(
								(TransactionalEditingDomain) getEditingDomain(),
								adapterFactory));
				treeViewerWithColumns.setLabelProvider(
						new TransactionalAdapterFactoryLabelProvider(
								(TransactionalEditingDomain) getEditingDomain(),
								adapterFactory));

				createContextMenuFor(treeViewerWithColumns);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_TreeWithColumnsPage_label"));
			}

			getSite().getShell().getDisplay().asyncExec
				(new Runnable() {
					 public void run() {
						 setActivePage(0);
					 }
				 });
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

		getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				 public void run() {
					 updateProblemIndication();
				 }
			 });
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
	 * This is used to track the active viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		if (contentOutlinePage != null) {
			handleContentOutlineSelection(contentOutlinePage.getSelection());
		}
	}

	
	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * Modified to offer a IQueryDataSetProvider to support OCL Queries
	 * Modified to offer IAnimalSelectionProvider, ISelectionViewerProvider to 
	 * support navigation
	 * Add to allow for transactions
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//FIXME For OCL queries and transactions 
	@SuppressWarnings("unchecked")
	@Override
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
		//Added to support AnimalSelections
		else if (key.equals(IAnimalSelectionProvider.class)){
			if (animalSelectionProvider==null){
				animalSelectionProvider = new IAnimalSelectionProvider(){

					public ISelection getAnimalSelection() {
						return FairTransactionEditor1.this.getAnimalSelection();
					}

					public void setAnimalSelection(ISelection selection) {
						FairTransactionEditor1.this.setAnimalSelection(selection);
					}
					
				};
			}
			return animalSelectionProvider;
		}
		//Added to support the main Viewer Selections
		else if (key.equals(ISelectionViewerProvider.class)){
			if (selectionViewerProvider==null){
				selectionViewerProvider = new ISelectionViewerProvider(){

					public ISelection getSelectionViewerSelection() {
						return FairTransactionEditor1.this.getSelectionViewerSelection();
					}

					public void setSelectionViewerSelection(ISelection selection) {
						FairTransactionEditor1.this.setSelectionViewerSelection(selection);
						
					}
					
				};
			}
			return selectionViewerProvider;
		}
		else if (key.equals(IEventSelectionProvider.class)){
			if (eventSelectionProvider==null){
				eventSelectionProvider = new IEventSelectionProvider(){

					public ISelection getEventSelection() {
						return FairTransactionEditor1.this.getEventSelection();
					}

					public void setEventSelection(ISelection selection) {
						FairTransactionEditor1.this.setEventSelection(selection);
					}

					
				};
			}
			return eventSelectionProvider;
		}
		//Adds adaptive support for IQueryDataSetProvider 	
		else if (key.equals(IQueryDataSetProvider.class)){
			if (queryDataSetProvider==null){
				queryDataSetProvider = new IQueryDataSetProvider(){

					public EditingDomain getEditingDomain() {
						return FairTransactionEditor1.this.getEditingDomain();
					}

					public void setSelectionToViewer(Collection<?> collection) {
						FairTransactionEditor1.this.setSelectionToViewer(collection);
					}
					
				};
			}
			return queryDataSetProvider;
		}
		else if (key.equals(IUndoContext.class)) {
			//.CUSTOM: used by undo/redo actions to get their undo context
			return undoContext;
		}
		else {
			return super.getAdapter(key);
		}
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
					public void setSelectionToViewer(List<?> selection) {
						FairTransactionEditor1.this.setSelectionToViewer(selection);
						FairTransactionEditor1.this.setFocus();
					}

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
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the animalsTableViewer viewer, then we want it to select the same selection as this selection.
				//
				if (currentViewerPane.getViewer() == animalsTableViewer){
					if (selectedElement instanceof Animal){
				
					ArrayList<Object> selectionList = new ArrayList<Object>();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						Object o = selectedElements.next();
						if(o instanceof Animal){
							selectionList.add(o);
						}
						
					}
					
					// Set the selection to the widget.
					//
					animalsTableViewer.setSelection(new StructuredSelection(selectionList));
					
					}
					
				// Handle eventsTableViewer
				} else if (currentViewerPane.getViewer() == eventsTableViewer){
					if(selectedElement instanceof Event){

						ArrayList<Object> selectionList = new ArrayList<Object>();
						selectionList.add(selectedElement);
						while (selectedElements.hasNext()) {
							Object o = selectedElements.next();
							if(o instanceof Event){
								selectionList.add(o);
							}

						}

						// Set the selection to the widget.
						//
						eventsTableViewer.setSelection(new StructuredSelection(selectionList));
					}
					// Handle peopleTableViewer
				} else if (currentViewerPane.getViewer() == peopleTableViewer){
					if(selectedElement instanceof Person){

						ArrayList<Object> selectionList = new ArrayList<Object>();
						selectionList.add(selectedElement);
						while (selectedElements.hasNext()) {
							Object o = selectedElements.next();
							if(o instanceof Person){
								selectionList.add(o);
							}

						}

						// Set the selection to the widget.
						//
						peopleTableViewer.setSelection(new StructuredSelection(selectionList));
					}
				} else if (currentViewerPane.getViewer() == exhibitsTableViewer){
					if(selectedElement instanceof Exhibit){

						ArrayList<Object> selectionList = new ArrayList<Object>();
						selectionList.add(selectedElement);
						while (selectedElements.hasNext()) {
							Object o = selectedElements.next();
							if(o instanceof Exhibit){
								selectionList.add(o);
							}

						}

						// Set the selection to the widget.
						//
						exhibitsTableViewer.setSelection(new StructuredSelection(selectionList));
					}
				//Handle listViewer
				} else if (currentViewerPane.getViewer() == listViewer
						&& selectedElement instanceof Animal) // 14.2.2
				{
					Animal selectedAnimal = (Animal) selectedElement;
					Collection<Event> animalEvents = selectedAnimal.eventHistory();
						
					//TODO Create a more generic gif for Events
					ItemProvider listRoot = new ItemProvider("Animal Events for ANIMAL: "+selectedAnimal.getId(),
							TrackerReportEditPlugin.INSTANCE
									.getImage("full/obj16/TagApplied"),
							animalEvents);

					listViewer.setInput(listRoot);
					currentViewerPane.setTitle(listRoot);	
				} else {
					handleContentOutlineSelectionGen( selection);
				}
			}
		}
	}
	/**
	 * This deals with how we want selection in the outliner to affect the other views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void handleContentOutlineSelectionGen(ISelection selection) {
		if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the same selection as this selection.
				//
				if (currentViewerPane.getViewer() == selectionViewer) {
					ArrayList<Object> selectionList = new ArrayList<Object>();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						selectionList.add(selectedElements.next());
					}

					// Set the selection to the widget.
					//
					selectionViewer.setSelection(new StructuredSelection(selectionList));
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
	 * @generated
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation =
			new WorkspaceModifyOperation() {
				// This is the method that gets invoked when the operation runs.
				//
				@Override
				public void execute(IProgressMonitor monitor) {
					// Save the resources to the file system.
					//
					boolean first = true;
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
							try {
								savedResources.add(resource);
								resource.save(saveOptions);
							}
							catch (Exception exception) {
								resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
							}
							first = false;
						}
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
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
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
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		}
		catch (IOException e) {
			// Ignore
		}
		return result;
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
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor =
			getActionBars().getStatusLineManager() != null ?
				getActionBars().getStatusLineManager().getProgressMonitor() :
				new NullProgressMonitor();
		doSave(progressMonitor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER)) {
				String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
					if (eObject != null) {
					  setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
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
	 * @generated
	 */
//	@Override
//	public void init(IEditorSite site, IEditorInput editorInput) {
//		setSite(site);
//		setInputWithNotify(editorInput);
//		setPartName(editorInput.getName());
//		site.setSelectionProvider(this);
//		site.getPage().addPartListener(partListener);
//		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
//	}

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
	 * @generated
	 */
	@Override
	public void setFocus() {
		if (currentViewerPane != null) {
			currentViewerPane.setFocus();
		}
		else {
			getControl(getActivePage()).setFocus();
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
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
						statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
						break;
					}
					default: {
						statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
						break;
					}
				}
			}
			else {
				statusLineManager.setMessage("");
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
		return FairTransactionEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return FairTransactionEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void dispose() {
//		updateProblemIndication = false;
//
//		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
//
//		getSite().getPage().removePartListener(partListener);
//
//		adapterFactory.dispose();
//
//		if (getActionBarContributor().getActiveEditor() == this) {
//			getActionBarContributor().setActiveEditor(null);
//		}
//
//		if (propertySheetPage != null) {
//			propertySheetPage.dispose();
//		}
//
//		if (contentOutlinePage != null) {
//			contentOutlinePage.dispose();
//		}
//
//		super.dispose();
//	}

	/**
	 * Returns whether the outline view should be presented to the user.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean showOutlineView() {
		return true;
	}
	
	public ISelection getEventSelection() {
		return eventsTableViewer.getSelection();
	}

	public void setEventSelection(ISelection selection) {
		eventsTableViewer.setSelection(selection);
		
	}

	public ISelection getAnimalSelection() {
		return animalsTableViewer.getSelection();
	}

	public void setAnimalSelection(ISelection selection) {
		animalsTableViewer.setSelection(selection);
	}

	public ISelection getSelectionViewerSelection() {
		return selectionViewer.getSelection();
	}

	public void setSelectionViewerSelection(ISelection selection) {
		selectionViewer.setSelection(selection);
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
}
