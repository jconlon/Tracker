package com.verticon.tracker.transaction.publisher.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.verticon.tracker.editor.util.ConsoleUtil;
import com.verticon.tracker.transaction.publisher.Publisher;
import com.verticon.tracker.transaction.publisher.TrackerFileTailPublisherPlugin;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class EventPublisherView extends ViewPart {

	public static final String CONSOLE =EventPublisherView.class.getSimpleName();
	

	private TableViewer tableViewer;
	private Action startAction;
	private Action stopAction;
	private Action logAction;
	
	
	class TableViewContentProvider implements IStructuredContentProvider {
		List<Publisher> model = new ArrayList<Publisher>();
		
		TableViewContentProvider(){
				model.add(TrackerFileTailPublisherPlugin.getDefault().getFileTailPublisher());
		}
		
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return model.toArray();
		}
	}
	
	
	
	
	/**
	 * This is a callback that will allow us
	 * to create the tableViewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		tableViewer.setContentProvider(new TableViewContentProvider());
		tableViewer.setLabelProvider(new PublisherTableLabelProvider());
		tableViewer.setSorter(new NameSorter());
		
		addColumns( tableViewer);
		tableViewer.setInput(getViewSite());
		
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}
	/**
	 * 0.Name
	 * 1.Description
	 * 2.Template
	 * 3.Target
	 * 4.status 
	 */
	private void addColumns(final TableViewer tableViewer){
		Table table = tableViewer.getTable();
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		table.setLayoutData(gridData);		
					
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		//column Name
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);		
		column.setText("Name");
		column.setWidth(150);
		//Add listener to column so tasks are sorted by Name when clicked 
//		column.addSelectionListener(new SelectionAdapter() {
//	       	
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new EventSorter(EventSorter.NAME));
//			}
//		});
		
		// column Description
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Description");
		column.setWidth(200);
		// Add listener to column so tasks are sorted by description when clicked 
//		column.addSelectionListener(new SelectionAdapter() {
//       	
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new EventSorter(EventSorter.DATETIME));
//			}
//		});


		// column Template
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("Template");
		column.setWidth(300);
		// Add listener to column so tasks are sorted by owner when clicked
//		column.addSelectionListener(new SelectionAdapter() {
//       	
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new EventSorter(EventSorter.TEMPLATE));
//			}
//		});

		//column Target 
		column = new TableColumn(table, SWT.LEFT, 3);
		column.setText("Target");
		column.setWidth(300);
		//  Add listener to column so tasks are sorted by percent when clicked
//		column.addSelectionListener(new SelectionAdapter() {
//       	
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new EventSorter(EventSorter.TARGET));
//			}
//		});
		
		//column Status 
		column = new TableColumn(table, SWT.CENTER, 4);
		column.setText("Status");
		column.setWidth(20);
		//  Add listener to column so tasks are sorted by percent when clicked
//		column.addSelectionListener(new SelectionAdapter() {
//       	
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new EventSorter(EventSorter.AIN));
//			}
//		});
	}

	private void makeActions() {
		
		startAction = new Action() {
			
			public void run() {
				ISelection selection = tableViewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof Publisher){
					try {
						((Publisher)obj).start();
					} catch (IOException e) {
						log("Failed to start "+obj+" because "+e);
					}
				}
				tableViewer.update(obj, null);
			}
		};
		startAction.setText("Start data aquisition");
		startAction.setToolTipText("Starts data aquisition from a sensor.");
		startAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		
		stopAction = new Action() {
			public void run() {
				ISelection selection = tableViewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof Publisher){
					((Publisher)obj).stop();
				}
				tableViewer.update(obj, null);
			}
		};
		stopAction.setText("Stops data aquisition");
		stopAction.setToolTipText("Stops data aquisition from a sensor.");
		stopAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		
		logAction = new Action() {
			public void run() {
				ISelection selection = tableViewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof Publisher){
					((Publisher)obj).logStatus();
				}
				
			}
		};
	}


	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				EventPublisherView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
		tableViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tableViewer);
	}

	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				logAction.run();
			}
		});
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(startAction);
		manager.add(new Separator());
		manager.add(stopAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(startAction);
		manager.add(stopAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(startAction);
		manager.add(stopAction);
	}
	

	class NameSorter extends ViewerSorter {
	}
	
	

	/**
	 * The constructor.
	 */
	public EventPublisherView() {
	}


	
	
	private void log(String message) {	
		ConsoleUtil.showConsole(CONSOLE);
		ConsoleUtil.println(CONSOLE, new Date()+"\t"+message);
	}

	/**
	 * Passing the focus request to the treeViewer's control.
	 */
	public void setFocus() {
		tableViewer.getControl().setFocus();
	}
}