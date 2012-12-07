package com.verticon.birt.report.engine.generator;

import com.verticon.birt.report.engine.generator.internal.Generator;


public class GeneratorFactory {
	private static IGenerator instance;

	public static final IGenerator getGenerator() {
		if (instance == null) {
			instance = new Generator();
		}
		return instance;
	}
}
