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
package com.verticon.tracker.product.desktop;

import org.eclipse.equinox.p2.ui.Policy;

/**
 * P2Policy defines the RCP policies for the p2 UI. The policy
 * is registered as an OSGi service when the example bundle starts.
 * 
 * Previous versions of this class extended and overrode functionality.  This
 * just takes the default.
 * @since 3.6
 */
public class P2Policy extends Policy {
}

