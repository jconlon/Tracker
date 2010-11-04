package com.verticon.tracker.irouter.monitor.view.internal;

import static com.verticon.tracker.irouter.monitor.view.internal.Component.bundleMarker;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.tracker.irouter.monitor.view.internal.FilterControl.FilterType;

public class FilterStateMachine {

	private enum State {
		CONSTRUCTED, INITIAL, CLEAR, RUNNING, FINISHED, DISPOSED, VIEWER_DISPOSED
	}

	private final ViewerFilter[] nodeFilter = new ViewerFilter[] { new NodeFilter() };
	private final ViewerFilter[] scopeFilter = new ViewerFilter[] { new ScopeFilter() };
	private final ViewerFilter[] groupFilter = new ViewerFilter[] { new GroupFilter() };
	/**
	 * The text to initially show in the filter text control.
	 */
	private static final String INTIAL_TEXT = "type filter text";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory
			.getLogger(FilterStateMachine.class);
	private final GraphViewer viewer;
	private final Combo combo;

	/**
	 * The filter text widget to be used. This value may NOT be
	 * <code>null</code>.
	 */
	private final Text filterText;
	/**
	 * The control representing the clear button for the filter text entry. This
	 * value may NOT be <code>null</code>.
	 */
	private final ToolBarManager filterToolBar;

	/**
	 * The job used to refresh the tree.
	 */
	private final Job refreshJob;

	private State state = State.CONSTRUCTED;
	private ModifyListener textTransition;
	private FilterTransition filterTransition;

	FilterStateMachine(GraphViewer viewer, Combo combo, Text text,
			ToolBarManager filterToolBar, Job refreshJob) {
		super();
		this.viewer = viewer;
		this.combo = combo;
		this.filterText = text;
		filterText.setText(INTIAL_TEXT);
		this.filterToolBar = filterToolBar;
		if (filterToolBar != null) {
			filterToolBar.update(false);
			// initially there is no text to clear
			filterToolBar.getControl().setVisible(false);
		}
		this.refreshJob = refreshJob;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FilterStateMachine [state=" + state + "]";
	}

	void init() {
		textTransition = new TextTransition();
		filterTransition = new FilterTransition();

		filterText.addModifyListener(textTransition);
		
		combo.addSelectionListener(filterTransition);

		state = State.INITIAL;
	}

	void dispose() {
		if(!filterText.isDisposed()){
			filterText.removeModifyListener(textTransition);
		}
		if(!combo.isDisposed()){
			combo.removeSelectionListener(filterTransition);
		}

		textTransition = null;
		filterTransition = null;
		state = State.DISPOSED;
	}

	private String getFilterPrefix() {
		return filterText.getText().trim();
	}

	IStatus processJob() {
		logger.debug(bundleMarker, "{} processing", this);

		switch (state) {

		case INITIAL:
			
			if (getFilterPrefix().equals(INTIAL_TEXT)) {
				return Status.OK_STATUS;
			}
			
			if (getFilterPrefix() != null && getFilterPrefix().length() == 0) {
				state = State.RUNNING;
				return Status.OK_STATUS;
			}
			
			if (getFilterPrefix() != null && getFilterPrefix().length() > 0 ) {
				state = State.RUNNING;
				return Status.OK_STATUS;
			}

			break;

		case RUNNING:
			if (viewer.getControl().isDisposed()) {
				state = State.VIEWER_DISPOSED;
				return Status.CANCEL_STATUS;
			}
			refreshViewer();

			if (getFilterPrefix().length() > 0) {
				// enabled toolbar - there is text to clear
				// and the list is currently being filtered
				updateToolbar(true);
			} else {
				// disabled toolbar - there is no text to clear
				// and the list is currently not filtered
				updateToolbar(false);
			}
			break;

		}

		return Status.OK_STATUS;
	}

	private void refreshViewer() {
		logger.debug(bundleMarker, "{} refreshing viewer", this);
		viewer.refresh();
		viewer.applyLayout();
	}

	private void updateToolbar(boolean visible) {
		if (filterToolBar != null) {
			filterToolBar.getControl().setVisible(visible);
		}
	}
	
	private void rescheduleJob() {
		logger.debug(bundleMarker, "{} rescheduling Job", this);
		refreshJob.cancel();
		refreshJob.schedule(300);
	}

	private class TextTransition implements ModifyListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "TextTransition []";
		}

		@Override
		public void modifyText(ModifyEvent e) {
			logger.debug(bundleMarker, "{} text changed=<{}>", this,getFilterPrefix());
			rescheduleJob();
		}
	}

	private class FilterTransition implements SelectionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "FilterTransition []";
		}


		@Override
		public void widgetSelected(SelectionEvent e) {
			comboChanged();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// ignore
		}

		private void comboChanged() {
			switch (state) {
			case INITIAL:
				filterText.setText("");
				//Fall through to next case is intentional.
			case RUNNING:
				switch (FilterType.valueOf(combo.getText())) {
				case SCOPE:
					viewer.setFilters(scopeFilter);
					logger.debug(bundleMarker, "{} set scope filter", this);
					break;

				case NODE:
					viewer.setFilters(nodeFilter);
					logger.debug(bundleMarker, "{} set node filter", this);
					break;

				case GROUP:
					viewer.setFilters(groupFilter);
					logger.debug(bundleMarker, "{} set group filter", this);
					break;
				}

			}


		}
	}

	/**
	 * Shows only Nodes that start with the text.
	 * 
	 * @author jconlon
	 * 
	 */
	class NodeFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			String prefix = getFilterPrefix();

			if (prefix.length() == 0) {
				return true;
			}

			if (element instanceof WiredNode) {
				WiredNode node = (WiredNode) element;
				return node.getComponentLabel().startsWith(prefix);

			}
			if (element instanceof ComponentServices) {
				ComponentServices node = (ComponentServices) element;
				return node.getText().startsWith(prefix);

			}
			return true;
		}

	}

	class ScopeFilter extends ViewerFilter {

		boolean canPass(String prefix, WiredNode wiredNode) {
			String scope = wiredNode.getScope();
			String[] scopes = scope.substring(1, scope.length() - 1).split(",");

			for (String s : scopes) {
				scope = s.trim();
				if (scope.startsWith(prefix)) {
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			String prefix = getFilterPrefix();

			if (prefix.length() == 0) {
				return true;
			}

			if (element instanceof ComponentServices) {
				ComponentServices node = (ComponentServices) element;
				for (WiredNode wiredNode : node.getChildren()) {
					if (canPass(prefix, wiredNode)) {
						return true;
					}
				}
				return false;
			}

			if (element instanceof WiredNode) {
				WiredNode wiredNode = (WiredNode) element;
				canPass(prefix, wiredNode);

			}
			if (element instanceof EntityConnectionData) {
				EntityConnectionData connection = (EntityConnectionData) element;
				String label = WiredNodeLabelProvider
						.getConnectionLabel(connection);
				String[] scopes = label.split(",");
				String scope;
				for (String s : scopes) {
					scope = s.trim();
					if (scope.startsWith(prefix)) {
						return true;
					}
				}
				return false;
			}
			return true;
		}

	}

	class GroupFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {

			String prefix = getFilterPrefix();

			if (prefix.length() == 0) {
				return true;
			}
			if (element instanceof INode) {
				INode node = (INode) element;
				return node.getGroup().startsWith(prefix);

			}
			return true;

		}

	}
}
