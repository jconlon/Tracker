package com.verticon.tracker.irouter.monitor.view.internal;

interface IExternalNode extends INode {
		
    String getSimpleName();
	
	Long getService_id();

	String getConnectionURI();
	
	String getDescription();
	
}
