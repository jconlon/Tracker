package com.verticon.tracker.irouter.mqtt;


public class Utils {

	public static boolean matches(String topic, String topicFilter) {
		String regex = topicFilter.replace("/#", "/.*");
		regex = regex.replace("/+", "/.*");
		return topic.matches(regex);
	}

}
