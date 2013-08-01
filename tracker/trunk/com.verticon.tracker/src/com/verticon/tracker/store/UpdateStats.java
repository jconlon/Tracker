package com.verticon.tracker.store;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Splitter;

public class UpdateStats implements IUpdateStats {

	private static final String PATTERN = "\\{UpdateStats: \\{animalsProcessed:(.*),animalsAdded:(.*),tagsAdded:(.*),eventsAdded:(.*),exceptions:\\[(.*)\\]\\}\\}";
	private static final String PATTERN1 = "\\{?name:'(.*)',message:'(.*)'\\}?";

	private int animalsProcessed;

	private int animalsAdded;
	private int tagsAdded;
	private int eventsAdded;

	private final Collection<Exception> exceptions = newArrayList();

	public UpdateStats() {
		this(0, 0, 0);
	}

	UpdateStats(int animalsAdded, int tagsAdded, int eventsAdded) {
		super();
		this.animalsAdded = animalsAdded;
		this.tagsAdded = tagsAdded;
		this.eventsAdded = eventsAdded;
	}

	public UpdateStats(String response) throws ClassNotFoundException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchMethodException {
		checkArgument(!isNullOrEmpty(response),
				"Argument must not be null or empty.");
		Pattern pattern = Pattern.compile(PATTERN);
		// In case you would like to ignore case sensitivity you could use this
		// statement
		// Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(response);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(
					"Response does not have an acceptable pattern.");
		}
		this.animalsProcessed = Integer.parseInt(matcher.group(1));
		this.animalsAdded = Integer.parseInt(matcher.group(2));
		this.tagsAdded = Integer.parseInt(matcher.group(3));
		this.eventsAdded = Integer.parseInt(matcher.group(4));
		String exceptions = matcher.group(5);
		// String[] exs = exceptions.split("//},//{");
		pattern = Pattern.compile(PATTERN1);
		Iterable<String> exs = Splitter.on("},{").trimResults()
				.split(exceptions);
		// name:'java.lang.IllegalStateException',message:'testone'
		for (String string : exs) {
			matcher = pattern.matcher(string);
			while (matcher.find()) {
				// System.out.print("Start index: " + matcher.start());
				// System.out.print(" End index: " + matcher.end() + " ");
				String clazz = matcher.group(1);
				String message = matcher.group(2);

					Class<?> cl = Class.forName(clazz);
					Constructor<?> con = cl
							.getDeclaredConstructor(String.class);
					Exception ex = (Exception) con.newInstance(message);
					this.exceptions.add(ex);
				// System.out.print("Added clazz: " + clazz + " ");
				// System.out.println("with message: " + message + " ");

			}
		}

	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.store.mongodb.internal.IUpdateStats#getEventsAdded()
	 */
	@Override
	public int getEventsAdded() {
		return eventsAdded;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.store.mongodb.internal.IUpdateStats#getAnimalsAdded()
	 */
	@Override
	public int getAnimalsAdded() {
		return animalsAdded;
	}

	/* (non-Javadoc)
	 * @see com.verticon.tracker.store.mongodb.internal.IUpdateStats#getTagsAdded()
	 */
	@Override
	public int getTagsAdded() {
		return tagsAdded;
	}
	

	public void animalsAdded(int count) {
		animalsAdded = animalsAdded + count;
	}

	public void tagsAdded(int count) {
		tagsAdded = tagsAdded + count;
	}

	public void eventsAdded(int count) {
		eventsAdded = eventsAdded + count;
	}

	public void addException(Exception exception) {
		exceptions.add(exception);
	}
	
	/**
	 * @param animalsProcessed
	 *            the animalsProcessed to set
	 */
	public void setAnimalsProcessed(int animalsProcessed) {
		this.animalsProcessed = animalsProcessed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{UpdateStats: {animalsProcessed:" + animalsProcessed
				+ ",animalsAdded:" + animalsAdded + ",tagsAdded:" + tagsAdded
				+ ",eventsAdded:" + eventsAdded + ",exceptions:"
				+ serializeExceptions()
				+ "}}";
	}
	@Override
	public int getAnimalsProcessed() {
		return animalsProcessed;
	}

	@Override
	public Collection<Exception> getExceptions() {
		return exceptions;
	}

	private String serializeExceptions() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (Iterator<Exception> iterator = exceptions.iterator(); iterator
				.hasNext();) {
			Exception e = iterator.next();
			builder.append("{name:'").append(e.getClass().getName())
					.append("',message:'").append(e.getLocalizedMessage())
					.append("'}");
			if (iterator.hasNext()) {
				builder.append(',');
			}
		}
		builder.append(']');

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
		result = prime * result + animalsAdded;
		result = prime * result + animalsProcessed;
		result = prime * result + eventsAdded;
		result = prime * result
				+ ((exceptions == null) ? 0 : exceptions.hashCode());
		result = prime * result + tagsAdded;
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
		if (!(obj instanceof UpdateStats)) {
			return false;
		}
		UpdateStats other = (UpdateStats) obj;
		if (animalsAdded != other.animalsAdded) {
			return false;
		}
		if (animalsProcessed != other.animalsProcessed) {
			return false;
		}
		if (eventsAdded != other.eventsAdded) {
			return false;
		}
		if (exceptions == null) {
			if (other.exceptions != null) {
				return false;
			}
		} else if (!elementsEqual(exceptions.iterator(),
				other.exceptions.iterator())) {
			return false;
		}
		if (tagsAdded != other.tagsAdded) {
			return false;
		}
		return true;
	}

	public static boolean elementsEqual(Iterator<Exception> iterator1,
			Iterator<Exception> iterator2) {
		while (iterator1.hasNext()) {
			if (!iterator2.hasNext()) {
				return false;
			}
			Exception o1 = iterator1.next();
			Exception o2 = iterator2.next();
			if (!o1.getClass().equals(o2.getClass())) {
				return false;
			}
			if (!o1.getMessage().equals(o2.getMessage())) {
				return false;
			}
		}
		return !iterator2.hasNext();
	}

}
