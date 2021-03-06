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

package com.verticon.tracker.ocl.query.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class QueryOCLMessages extends NLS {

	private static final String BUNDLE_NAME = "com.verticon.tracker.ocl.query.internal.l10n.QueryOCLMessages"; //$NON-NLS-1$

	public static String title;
	public static String message_interrupted;
	public static String message_exception;
	public static String oclQuery_title;
	public static String oclQuery_message_wizard;
	public static String oclQuery_prompt_metaclass;
	public static String oclQuery_prompt_condition;
	@SuppressWarnings("ucd")
	public static String oclQuery_default_metaclass;
	@SuppressWarnings("ucd")
	public static String oclQuery_fair_default_metaclass;
	public static String oclQuery_default_condition;
	@SuppressWarnings("ucd")
	public static String oclQuery_fair_default_condition;
	public static String oclQuery_message_notFound;
	public static String oclQuery_message_boolean;
	public static String cfQuery_title;
	public static String cfQuery_prompt_condition;
	public static String cfQuery_default_condition;

	static {
		NLS.initializeMessages(BUNDLE_NAME, QueryOCLMessages.class);
	}
}
