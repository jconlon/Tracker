package com.verticon.tracker.ocl.query.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.verticon.tracker.editor.util.IViewerFilters;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewPart;
import com.verticon.tracker.ocl.query.viewer.views.OclQueryViewer;

public class OCLViewerFilters implements IViewerFilters {

	private static final String COM_VERTICON_TRACKER_OCL_QUERY_VIEW = "com.verticon.tracker.ocl.query.view";


	@Override
	public Collection<ViewerFilter> getViewerFilters(EClass type) {
		OclQueryViewer viewer = getViewer();
		if(viewer!=null){
			List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
			for (IOclQuery oclQuery : viewer.getViewModel().getTasks()) {
				if(type.isSuperTypeOf(oclQuery.getContextClass())){
				 ViewerFilter filter = new OCLViewerFilter(
						 ((OclQuery)oclQuery).clone()
				 );
				 filters.add(filter);
				}
			}
			return filters;
		}
		return Collections.emptyList();
	}
	
	/**
	 * @return OclQueryViewer
	 */
	private static OclQueryViewer getViewer() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		OclQueryViewPart part = (OclQueryViewPart)page.findView(COM_VERTICON_TRACKER_OCL_QUERY_VIEW);
		return part!=null?part.getViewer():null;
	}

}
