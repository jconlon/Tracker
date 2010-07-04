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
package com.verticon.tracker.fair.edit.provider;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.verticon.tracker.fair.Fair;

/**
 * Base class for non-model based nodes in the Tree View
 * Created for Ticket 240 
 * See EMF Modeling book 14.2.3
 * @author jconlon
 *
 */
public class TransientFairItemProvider // 14.2.3
		extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	
	
	@SuppressWarnings("unused")
	private Collection<?> collection;


	public TransientFairItemProvider(AdapterFactory adapterFactory,
			Fair fair) {
		super(adapterFactory);
		fair.eAdapters().add(this);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return super.getChildren(target);
	}
	@Override
	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain, Object sibling) {
		return super.getNewChildDescriptors(target, editingDomain, sibling);
	}

	@Override
	public Object getParent(Object object) {
		return target;
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/Supplier");
	}

	@Override
	public ResourceLocator getResourceLocator() {
		return FairEditPlugin.INSTANCE;
	}

	@Override
	public Command createCommand(final Object object,
			final EditingDomain domain, Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		commandParameter.setOwner(target);
		return super.createCommand(target, domain, commandClass,
				commandParameter);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EReference feature, Collection<?> collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner,
				feature, collection), owner);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			EReference feature, Collection<?> collection, int index) {
		this.collection = collection;
		return createWrappedCommand(super.createAddCommand(domain, owner,
				feature, collection, index), owner);
	}

	
	protected Command createWrappedCommand(Command command, final EObject owner) {
		return new CommandWrapper(command) {
			@Override
			public Collection<?> getAffectedObjects() {
				Collection<?> affected = super.getAffectedObjects();
				if (affected.contains(owner))
					affected = Collections
							.singleton(TransientFairItemProvider.this);
				return affected;
			}
		};
	}
}