/*******************************************************************************
 * Copyright (c) 2013 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.verticon.tracker.trigger.view;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.LABEL_FILE;
import static com.verticon.tracker.trigger.view.preferences.PreferenceConstants.PRINTER;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.verticon.tracker.trigger.view.preferences.PreferenceConstants;

public class TriggerEntry extends ModelObject implements ITriggerEntry {

	private String name = "";
	private String comments = "";
	private String status = "";
	private File file = null;
	private String printer = "";
	private String lot = "";
	private String values = "";
	private boolean requireLot = false;
	private String requireValues = "";
	private final Validator validator = new Validator();;

	private final int id;
	private static int count = 0;

	TriggerEntry() {
		this("New Trigger");

	}

	TriggerEntry(String name) {
		super();
		this.name = name;
		count++;
		this.id = count;
	}

	/**
	 * @return the requireLot
	 */
	@Override
	public boolean isRequireLot() {
		return requireLot;
	}

	/**
	 * @param requireLot
	 *            the requireLot to set
	 */
	@Override
	public void setRequireLot(boolean requireLot) {
		firePropertyChange("requireLot", this.requireLot,
				this.requireLot = requireLot);
	}

	/**
	 * @return the requireValues
	 */
	@Override
	public String getRequireValues() {
		return requireValues;
	}

	/**
	 * @param requireValues
	 *            the requireValues to set
	 */
	@Override
	public void setRequireValues(String requireValues) {
		firePropertyChange("requireValues", this.requireValues,
				this.requireValues = requireValues);
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	@Override
	public void setComments(String comments) {
		firePropertyChange("comments", this.comments, this.comments = comments);

	}

	@Override
	public String getComments() {
		return comments;
	}

	@Override
	public void setStatus(String status) {
		firePropertyChange("status", this.status, this.status = status);
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setFile(File file) {
		firePropertyChange("file", this.file, this.file = file);

	}

	@Override
	public File getFile() {
		return file;
	}

	/**
	 * @return the printer
	 */
	@Override
	public String getPrinter() {
		return printer;
	}

	/**
	 * @param printer
	 *            the printer to set
	 */
	@Override
	public void setPrinter(String printer) {
		firePropertyChange("printer", this.printer, this.printer = printer);
	}

	/**
	 * @return the lot
	 */
	@Override
	public String getLot() {
		return lot;
	}

	/**
	 * @param lot
	 *            the lot to set
	 */
	@Override
	public void setLot(String lot) {
		firePropertyChange("lot", this.lot, this.lot = lot);
	}

	/**
	 * @return the values
	 */
	@Override
	public String getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	@Override
	public void setValues(String values) {
		firePropertyChange("values", this.values, this.values = values);
	}

	/**
	 * Validates the label file, the printer TODO lot and others?
	 */
	@Override
	public IStatus validateEntry() {
		return validator.validateEntry(this);

	}

	@Override
	public String format() {
		IPreferenceStore store = TriggerViewPlugin.getDefault()
				.getPreferenceStore();
		String root = store.getString(PreferenceConstants.P_ROOT_STRING);
		String body = store.getString(PreferenceConstants.P_BODY_STRING);

		StringBuilder builder = new StringBuilder();

		if (!isNullOrEmpty(root)) {
			if (root.contains(LABEL_FILE)) {
				root = root.replace(LABEL_FILE, getFile().toString());
			}
			if (root.contains(PRINTER)) {
				root = root.replace(PRINTER, getPrinter());
			}
			builder.append(root);
		}
		builder.append(body).append(',');
		builder.append("Reserved1").append(',');
		builder.append("Reserved2").append(',');
		builder.append(getLot()).append(',');
		builder.append(getValues());
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + id;
		result = prime * result + ((lot == null) ? 0 : lot.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((printer == null) ? 0 : printer.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TriggerEntry)) {
			return false;
		}
		TriggerEntry other = (TriggerEntry) obj;
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (file == null) {
			if (other.file != null) {
				return false;
			}
		} else if (!file.equals(other.file)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lot == null) {
			if (other.lot != null) {
				return false;
			}
		} else if (!lot.equals(other.lot)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (printer == null) {
			if (other.printer != null) {
				return false;
			}
		} else if (!printer.equals(other.printer)) {
			return false;
		}
		if (values == null) {
			if (other.values != null) {
				return false;
			}
		} else if (!values.equals(other.values)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TriggerEntry [name=" + name + ", comments=" + comments
				+ ", file=" + file + ", printer=" + printer + ", lot=" + lot
				+ ", values=" + values + ", requireLot=" + requireLot
				+ ", requireValues=" + requireValues + "]";
	}

	@Override
	public String export() {
		List<String> elements = Lists.newArrayList(name, comments,
				file.toString(), printer, requireLot ? "true" : "false",
				requireValues, lot, values);
		return wrappedJoin(elements);

	}

	private String wrappedJoin(Iterable<String> arr) {
		Iterable<String> wrappedStrings = Iterables.transform(arr,
				new Function<String, String>() {
					@Override
					public String apply(String arg0) {
						return "\"" + arg0 + "\"";
					}
				});
		return Joiner.on(",").join(wrappedStrings);
	}


}
