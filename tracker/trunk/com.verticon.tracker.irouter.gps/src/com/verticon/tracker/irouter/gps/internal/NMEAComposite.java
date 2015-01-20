package com.verticon.tracker.irouter.gps.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.verticon.messaging.MessageAppender;

public class NMEAComposite implements MessageAppender {

	private final Map<String, MessageAppender> messages = new HashMap<String, MessageAppender>();
	private Date date;

	void add(MessageAppender message) {
		messages.put(message.getClass().getSimpleName(), message);
		this.date = message.getDate();
	}

	boolean isEmpty() {
		return messages.isEmpty();
	}

	@Override
	public void appendMessage(StringBuffer output, String delimiter) {
		// int messagesSize = messages.size();
		for (MessageAppender message : messages.values()) {
			message.appendMessage(output, delimiter);
		}

	}

	@Override
	public Date getDate() {
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer("NMEAComposite [date=");
		buf.append(date);
		appendMessage(buf, ",");
		buf.append(']');
		return buf.toString();
	}

}
