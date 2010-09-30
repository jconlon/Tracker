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
package com.verticon.tracker.fair.transaction.editor.internal.l10n;

import org.eclipse.osgi.util.NLS;


/**
 * Localized messages for the EMF Workbench Example Library Editor plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class Messages
	extends NLS {

	private static final String BUNDLE_NAME = "com.verticon.tracker.fair.transaction.editor.internal.l10n.Messages"; //$NON-NLS-1$	 
	public static String cmdFailed;
	public static String cmdRollback;
	public static String cmdException;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
