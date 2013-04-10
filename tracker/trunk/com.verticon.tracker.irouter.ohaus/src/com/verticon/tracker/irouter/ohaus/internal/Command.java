package com.verticon.tracker.irouter.ohaus.internal;

import com.verticon.tracker.irouter.common.Utils;

enum Command {
	STOP_SENDING("0P%13%%10%"), //
	PRINT_UNIT("PU%13%%10%"), //
	STABLE_PRINT("SP%13%%10%"), //
	EVERY_SECOND_PRINT("1P%13%%10%"), //
	POLL("IP%13%%10%");// Not used
	final String ascii;

	Command(String ascii) {
		this.ascii = ascii;
	}

	String fromAscii() {
		return ascii != null ? Utils.fromAscii(ascii) : null;
	}
}