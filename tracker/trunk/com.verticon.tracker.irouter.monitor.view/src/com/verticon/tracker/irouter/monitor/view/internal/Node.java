package com.verticon.tracker.irouter.monitor.view.internal;

public interface Node {

    String nodeText();

    String getPid();

    String getGroup();

    ComponentServices getParent();

}