package com.verticon.irouter.measurement.trigger.file.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.verticon.irouter.measurement.trigger.file.test.Example.Person;

public class DataBindingTest {


	Example.ViewModel model = new Example.ViewModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model = new Example.ViewModel();
	}

	@After
	public void tearDown() throws Exception {
		model = null;
	}

	@Test
	public final void testList() {

		assertThat("Wrong size", model.getPeople().size(), is(3));

		model.getPeople().add(new Person("Jack Coyote", "Tucson"));

		assertThat("Wrong size", model.getPeople().size(), is(4));


	}

	@Test
	public final void testWritableList() {

		WritableList wl = new WritableList(model.getPeople(),
				Example.Person.class);
		assertThat("Wrong size", wl.size(), is(3));

		wl.add(new Person("Jack Coyote", "Tucson"));

		assertThat("Wrong size", wl.size(), is(4));

	}

}
