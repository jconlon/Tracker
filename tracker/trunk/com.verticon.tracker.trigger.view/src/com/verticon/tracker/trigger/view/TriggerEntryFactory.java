package com.verticon.tracker.trigger.view;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Strings.nullToEmpty;

import java.io.File;

import com.google.common.collect.Iterables;

public class TriggerEntryFactory {

	public static ITriggerEntry create() {
		return new TriggerEntry();
	}

	public static ITriggerEntry create(String name) {
		return new TriggerEntry(name);
	}

	public static ITriggerEntry create(Iterable<String> tokens) {

		// System.out.println("--------------");
		// for (String string : tokens) {
		// System.out.println(string);
		// }
		// System.out.println("--------------");

		String[] args = Iterables.toArray(tokens, String.class);

		checkArgument(args.length == 8,
				"Wrong number of argurments in the import.  Expected 8 but was "
						+ args.length);

		ITriggerEntry result = new TriggerEntry();
		result.setName(nullToEmpty(args[0]));
		result.setComments(nullToEmpty(args[1]));
		result.setFile(isNullOrEmpty(args[2]) ? null : new File(args[2]));
		result.setPrinter(nullToEmpty(args[3]));
		result.setRequireLot(isNullOrEmpty(args[4]) ? false : Boolean
				.parseBoolean(args[4]));
		result.setRequireValues(nullToEmpty(args[5]));
		result.setLot(nullToEmpty(args[6]));
		result.setValues(nullToEmpty(args[7]));

		return result;
	}
}
