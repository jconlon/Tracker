package com.verticon.tracker.irouter.mqtt;

public enum Topic {

	QUERY_TEMPLATE("Agriculture/Premises/%s/Query"),
	//
	RESPONSE_TEMPLATE("Agriculture/Premises/%s/Response"),
	//
	ANIMALS_PUB_TEMPLATE("Agriculture/Premises/%s/Events/EMF"),
	//
	PREMISES_PUB_TEMPLATE("Agriculture/Premises/%s/Register/EMF");
	//

	private final String template;

	Topic(String template) {
		this.template = template;
	}

	public String replace(Object... args) {
		return String.format(template, args);
	}
}
