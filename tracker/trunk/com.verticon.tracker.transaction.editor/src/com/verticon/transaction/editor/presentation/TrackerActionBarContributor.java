/**
 * <copyright>
 * </copyright>
 *
 * $Id: EXTLibraryActionBarContributor.java,v 1.2 2006/02/22 15:17:44 cmcgee Exp $
 */
package com.verticon.transaction.editor.presentation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import com.verticon.tracker.editor.presentation.CustomActionBarContributor;
import com.verticon.tracker.editor.presentation.ICustomActionBarContributor;
import com.verticon.tracker.transaction.editor.TransactionEditorPlugin;
import com.verticon.transaction.editor.actions.LongRunningReadAction;

/**
 * This is the action bar contributor for the EXTLibrary model editor.
 * <!-- begin-user-doc -->
 * It is customized from its EMF-generated form to provide alternative implementations
 * of the undo and redo menu actions (delegating to the operation history) and
 * additional example actions such as initiation of long-running background reader
 * jobs.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackerActionBarContributor
	extends EditingDomainActionBarContributor
	implements ISelectionChangedListener {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 Verticon, Inc. All Rights Reserved.";

	/**
	 * Customization of the EditingDomainActionBarContributor happens in this class.
	 * 
	 * @generated NOT
	 */
	ICustomActionBarContributor customActionBarContributor = new CustomActionBarContributor();
	
	
	
	/**
	 * This keeps track of the active editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	/**
	 * This action opens the Properties view.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction showPropertiesViewAction =
		new Action(TransactionEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) //$NON-NLS-1$
		{
			public void run() {
				try {
					getPage().showView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
				}
				catch (PartInitException exception) {
					TransactionEditorPlugin.INSTANCE.log(exception);
				}
			}
		};

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction refreshViewerAction =
		new Action(TransactionEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) //$NON-NLS-1$
		{
			public boolean isEnabled() {
				return activeEditorPart instanceof IViewerProvider;
			}

			public void run() {
				if (activeEditorPart instanceof IViewerProvider) {
					Viewer viewer = ((IViewerProvider)activeEditorPart).getViewer();
					if (viewer != null) {
						viewer.refresh();
					}
				}
			}
		};
		
	protected LongRunningReadAction longRunningReadAction = new LongRunningReadAction();

	/**
	 * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor
	 * generated for the current selection by the item provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<IAction> createChildActions;

	/**
	 * This is the menu manager into which menu contribution items should be added for CreateChild actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMenuManager createChildMenuManager;

	/**
	 * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor
	 * generated for the current selection by the item provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<IAction> createSiblingActions;

	/**
	 * This is the menu manager into which menu contribution items should be added for CreateSibling actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMenuManager createSiblingMenuManager;

	/**
	 * This creates an instance of the contributor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerActionBarContributor() {
		loadResourceAction = new LoadResourceAction();
		validateAction = new ValidateAction();
	}

	public void init(IActionBars actionBars) {
		super.init(actionBars);

	    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
	    
		// override the superclass implementation of these actions
	    undoAction = new UndoActionWrapper();
	    undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
	    actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);

	    redoAction = new RedoActionWrapper();
	    redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
	    actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}
	
	
	/**
	 * This adds Separators for editor additions to the tool bar.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void contributeToToolBarGen(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator("extlibrary-settings")); //$NON-NLS-1$
		toolBarManager.add(new Separator("extlibrary-additions")); //$NON-NLS-1$
	}
	
	/**
	 * This adds custom Separators for editor additions to the tool bar.
	 * 
	 * @generated NOT
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		contributeToToolBarGen( toolBarManager);
		customActionBarContributor.contributeToToolBar(toolBarManager);
	}


	/**
	 * This adds to the menu bar a menu and some separators for editor additions,
	 * as well as the sub-menus for object creation items.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		IMenuManager submenuManager = new MenuManager(TransactionEditorPlugin.INSTANCE.getString("_UI_EXTLibraryEditor_menu"), "com.verticon.tracker.transaction.TrackerMenuID"); //$NON-NLS-1$ //$NON-NLS-2$
		menuManager.insertAfter("additions", submenuManager); //$NON-NLS-1$
		submenuManager.add(new Separator("settings")); //$NON-NLS-1$
		submenuManager.add(new Separator("actions")); //$NON-NLS-1$
		submenuManager.add(new Separator("additions")); //$NON-NLS-1$
		submenuManager.add(new Separator("additions-end")); //$NON-NLS-1$

		// Prepare for CreateChild item addition or removal.
		//
		createChildMenuManager = new MenuManager(TransactionEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item")); //$NON-NLS-1$
		submenuManager.insertBefore("additions", createChildMenuManager); //$NON-NLS-1$

		// Prepare for CreateSibling item addition or removal.
		//
		createSiblingMenuManager = new MenuManager(TransactionEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item")); //$NON-NLS-1$
		submenuManager.insertBefore("additions", createSiblingMenuManager); //$NON-NLS-1$

		// Force an update because Eclipse hides empty menus now.
		//
		submenuManager.addMenuListener
			(new IMenuListener() {
				 public void menuAboutToShow(IMenuManager menuManager) {
					 menuManager.updateAll(true);
				 }
			 });

		addGlobalActions(submenuManager);
	}

	/**
	 * When the active editor changes, this remembers the change and registers with it as a selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveEditorGen(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		}
		else {
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
	}
	
	/**
	 * When the active editor changes, this sets up the customActionBarContributor before
	 * calling the generated method.
	 * @generated NOT
	 */
	@Override
	public void setActiveEditor(IEditorPart part) {
		customActionBarContributor.setActiveEditor(part);
		setActiveEditorGen( part);
	}
	
	public void activate() {
		longRunningReadAction.setActiveWorkbenchPart(activeEditor);
		
		super.activate();
	}
	
	public void deactivate() {
		longRunningReadAction.setActiveWorkbenchPart(null);
		
		super.deactivate();
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings
	 * that can be added to the selected object and updating the menus accordingly.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		// Remove any menu items for old selection.
		//
		if (createChildMenuManager != null) {
			depopulateManager(createChildMenuManager, createChildActions);
		}
		if (createSiblingMenuManager != null) {
			depopulateManager(createSiblingMenuManager, createSiblingActions);
		}

		// Query the new selection for appropriate new child/sibling descriptors
		//
		Collection<?> newChildDescriptors = null;
		Collection<?> newSiblingDescriptors = null;

		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			Object object = ((IStructuredSelection)selection).getFirstElement();

			EditingDomain domain = ((IEditingDomainProvider)activeEditorPart).getEditingDomain();

			newChildDescriptors = domain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
		}

		// Generate actions for selection; populate and redraw the menus.
		//
		createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

		if (createChildMenuManager != null) {
			populateManager(createChildMenuManager, createChildActions, null);
			createChildMenuManager.update(true);
		}
		if (createSiblingMenuManager != null) {
			populateManager(createSiblingMenuManager, createSiblingActions, null);
			createSiblingMenuManager.update(true);
		}
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if (descriptors != null) {
			for (Object descriptor : descriptors) {
				actions.add(new CreateChildAction(activeEditorPart, selection, descriptor));
			}
		}
		return actions;
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if (descriptors != null) {
			for (Object descriptor : descriptors) {
				actions.add(new CreateSiblingAction(activeEditorPart, selection, descriptor));
			}
		}
		return actions;
	}

	/**
	 * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection,
	 * by inserting them before the specified contribution item <code>contributionID</code>.
	 * If <code>ID</code> is <code>null</code>, they are simply added.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions, String contributionID) {
		if (actions != null) {
			for (IAction action : actions) {
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				}
				else {
					manager.add(action);
				}
			}
		}
	}
		
	/**
	 * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {
		if (actions != null) {
			IContributionItem[] items = manager.getItems();
			for (int i = 0; i < items.length; i++) {
				// Look into SubContributionItems
				//
				IContributionItem contributionItem = items[i];
				while (contributionItem instanceof SubContributionItem) {
					contributionItem = ((SubContributionItem)contributionItem).getInnerItem();
				}

				// Delete the ActionContributionItems with matching action.
				//
				if (contributionItem instanceof ActionContributionItem) {
					IAction action = ((ActionContributionItem)contributionItem).getAction();
					if (actions.contains(action)) {
						manager.remove(contributionItem);
					}
				}
			}
		}
	}

	/**
	 * This populates the pop-up menu before it appears.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		super.menuAboutToShow(menuManager);
		MenuManager submenuManager = null;

		submenuManager = new MenuManager(TransactionEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item")); //$NON-NLS-1$
		populateManager(submenuManager, createChildActions, null);
		menuManager.insertBefore("additions", submenuManager); //$NON-NLS-1$

		submenuManager = new MenuManager(TransactionEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item")); //$NON-NLS-1$
		populateManager(submenuManager, createSiblingActions, null);
		menuManager.insertBefore("additions", submenuManager); //$NON-NLS-1$
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions")); //$NON-NLS-1$ //$NON-NLS-2$
		menuManager.insertAfter("ui-actions", showPropertiesViewAction); //$NON-NLS-1$

		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());		
		menuManager.insertAfter("ui-actions", refreshViewerAction); //$NON-NLS-1$
		
		// add the long-running read action to the menu
	    menuManager.insertBefore("additions-end", new ActionContributionItem( //$NON-NLS-1$
	    		longRunningReadAction));

		super.addGlobalActions(menuManager);
	}

	/**
	 * This ensures that a delete action will clean up all references to deleted objects.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

}
