package com.verticon.tracker.irouter.monitor.view.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.progress.WorkbenchJob;


/**
 * Creates two controls a text widget with a clearing function and a combo box
 * for choosing the kind of filter to use.
 * @author jconlon
 *
 */
public class FilterControl extends ControlContribution {

	 enum FilterType {
		SCOPE, NODE, GROUP
	};
	
	/**
	 * The filter text widget to be used by this tree. This value may be
	 * <code>null</code> if there is no filter widget, or if the controls have
	 * not yet been created.
	 */
	private Text filterText;
	
	/**
	 * The control representing the clear button for the filter text entry. This
	 * value may be <code>null</code> if no such button exists, or if the
	 * controls have not yet been created.
	 */
	private ToolBarManager filterToolBar;
	
	
	/**
	 * The job used to refresh the tree.
	 */
	private Job refreshJob;

	/**
	 * Image descriptor for enabled clear button.
	 */
	private static final String CLEAR_ICON = "org.eclipse.ui.internal.dialogs.CLEAR_ICON";

	/**
	 * Image descriptor for disabled clear button.
	 */
	private static final String DCLEAR_ICON = "org.eclipse.ui.internal.dialogs.DCLEAR_ICON";

	/**
	 * Maximum time spent expanding the tree after the filter text has been
	 * updated (this is only used if we were able to at least expand the visible
	 * nodes)
	 */
	// private static final long SOFT_MAX_EXPAND_TIME = 200;
	/**
	 * Get image descriptors for the clear button.
	 */
	static {
		ImageDescriptor descriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(PlatformUI.PLUGIN_ID,
						"$nl$/icons/full/etool16/clear_co.gif");
		if (descriptor != null) {
			JFaceResources.getImageRegistry().put(CLEAR_ICON, descriptor);
		}
		descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(
				PlatformUI.PLUGIN_ID, "$nl$/icons/full/dtool16/clear_co.gif");
		if (descriptor != null) {
			JFaceResources.getImageRegistry().put(DCLEAR_ICON, descriptor);
		}
	}
	

	private final MonitorMasterDetailsBlock block;
	private Combo combo;

	private FilterStateMachine stateMachine;
	
	protected FilterControl(MonitorMasterDetailsBlock block, String id) {
		super(id);
		this.block=block;
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.ContributionItem#dispose()
	 */
	@Override
	public void dispose() {
		stateMachine.dispose();
		super.dispose();
	}


	@Override
	protected Control createControl(Composite parent) {
		Composite controlComposite = new Composite(parent, SWT.BORDER);
		GridLayout filterLayout = new GridLayout();
		filterLayout.numColumns = 3;
		filterLayout.marginHeight = 0;
		filterLayout.marginWidth = 0;
		controlComposite.setLayout(filterLayout);
		controlComposite.setFont(parent.getFont());

		controlComposite.setLayoutData(
				new GridData(SWT.FILL, SWT.BEGINNING,
				true, false));
		createFilterControls(controlComposite);
		

		createRefreshJob();
		
		stateMachine = new FilterStateMachine(
				block.getViewer(), combo, filterText, filterToolBar, refreshJob);
		
		stateMachine.init();
		
		return controlComposite;
	}
	
	/**
	 * Create the filter controls. By default, a text and corresponding tool bar
	 * button that clears the contents of the text is created. Subclasses may
	 * override.
	 * 
	 * @param parent
	 *            parent <code>Composite</code> of the filter controls
	 * @return the <code>Composite</code> that contains the filter controls
	 */
	private Composite createFilterControls(Composite parent) {
		createFilterText(parent);
		createCombo(parent);
		createClearText(parent);
		if (filterToolBar != null) {
			filterToolBar.update(false);
			// initially there is no text to clear
			filterToolBar.getControl().setVisible(false);
		}
		return parent;
	}
	
	private void createCombo(Composite parent) {
		combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setToolTipText(
				"Sets the type of filter to use when drawing the graph.");

		for (FilterType filter : FilterType.values()) {
			combo.add(filter.name());
		}

		GridData gridData = 
			new GridData(SWT.FILL, SWT.TOP, true, false);
		gridData.widthHint = SWT.DEFAULT;
		gridData.heightHint = SWT.DEFAULT;
		combo.setLayoutData(gridData);
	}
	
	private void createFilterText(Composite parent) {
		filterText = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH
				| SWT.CANCEL);


		GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		// if the text widget supported cancel then it will have it's own
		// integrated button. We can take all of the space.
		if ((filterText.getStyle() & SWT.CANCEL) != 0){
			gridData.horizontalSpan = 2;
		}
		filterText.setLayoutData(gridData);
	}
	
	/**
	 * Create the button that clears the text.
	 * 
	 * @param parent
	 *            parent <code>Composite</code> of toolbar button
	 */
	private void createClearText(Composite parent) {
		// only create the button if the text widget doesn't support one
		// natively
		if ((filterText.getStyle() & SWT.CANCEL) == 0) {
			filterToolBar = new ToolBarManager(SWT.FLAT | SWT.HORIZONTAL);
			filterToolBar.createControl(parent);

			IAction clearTextAction = new Action("", IAction.AS_PUSH_BUTTON) {
				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.action.Action#run()
				 */
				public void run() {
					filterText.setText("");
					refreshJob.cancel();
					refreshJob.schedule(200);
				}
			};

			clearTextAction.setToolTipText("Clear filter text");
			clearTextAction.setImageDescriptor(JFaceResources
					.getImageRegistry().getDescriptor(CLEAR_ICON));
			clearTextAction.setDisabledImageDescriptor(JFaceResources
					.getImageRegistry().getDescriptor(DCLEAR_ICON));

			filterToolBar.add(clearTextAction);
		}
	}
	
	
	/**
	 * Create the refresh job for the receiver.
	 * 
	 */
	private void createRefreshJob() {
		refreshJob = new WorkbenchJob("Refresh Filter") {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
			 */
			public IStatus runInUIThread(IProgressMonitor monitor) {
				return stateMachine.processJob();
			}

		};
		refreshJob.setSystem(true);
	}

}
