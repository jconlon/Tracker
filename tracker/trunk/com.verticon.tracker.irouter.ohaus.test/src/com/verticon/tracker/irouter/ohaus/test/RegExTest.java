package com.verticon.tracker.irouter.ohaus.test;

import static com.google.common.collect.ImmutableMap.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class RegExTest {

	ImmutableMap<String, String> map2 = of("100 lb", "100", //
			"120.01 lb", "120.01", //
			"-120.01 lb", "-120.01",//
			"+00.55 k", "00.55"

	);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		for (Entry<String, String> entry : map2.entrySet()) {
			String raw = entry.getKey();
			String expected = entry.getValue();
			String cleaned = raw.replaceAll("[^0-9-/.]", "");
			assertThat("Wrong", cleaned, is(expected));
			try {
				Double.parseDouble(cleaned);
			} catch (NumberFormatException e) {
				fail(e.getLocalizedMessage());
			}
		}
	}

}
