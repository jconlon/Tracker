package com.verticon.tracker.editor.util;

import java.util.List;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EReference;

/**
 * PROVISIONAL This API is subject to arbitrary change, including renaming or
 * removal.
 */
public class EMFUpdateEReferenceValueStrategy extends UpdateValueStrategy {
	public EMFUpdateEReferenceValueStrategy() {
		this(true, POLICY_UPDATE);
	}

	public EMFUpdateEReferenceValueStrategy(int updatePolicy) {
		this(true, updatePolicy);
	}

  public EMFUpdateEReferenceValueStrategy(boolean provideDefaults,
			int updatePolicy) {
		super(provideDefaults, updatePolicy);
	}

	@Override
	protected IConverter createConverter(Object fromType, Object toType) {
		// if (fromType == String.class) {
		// if (toType instanceof EReference) {
		// final EReference eReference = (EReference) toType;
		// final EClass eClass = eReference.eClass();
		// final EFactory eFactory = eClass.getEPackage()
		// .getEFactoryInstance();
		// return new Converter(fromType, toType) {
		// public Object convert(Object fromObject) {
		// String value = fromObject == null ? null : fromObject
		// .toString();
		// if (eReference.isMany()) {
		// List<Object> result = new ArrayList<Object>();
		// if (value != null) {
		// for (String element : value.split(" ")) {
		// result.add(eFactory.createFromString(
		// eClass, element));
		// }
		// }
		// return result;
		// } else {
		// return eFactory.createFromString(eClass, value);
		// }
		// }
		// };
		// }
		// } else
		if (toType == String.class) {
			if (fromType instanceof EReference) {
				final EAttribute eAttribute = (EAttribute) fromType;
				final EDataType eDataType = eAttribute.getEAttributeType();
				final EFactory eFactory = eDataType.getEPackage()
						.getEFactoryInstance();
				return new Converter(fromType, toType) {
					public Object convert(Object fromObject) {
						if (eAttribute.isMany()) {
							StringBuilder result = new StringBuilder();
							for (Object value : (List<?>) fromObject) {
								if (result.length() == 0) {
									result.append(' ');
								}
								result.append(eFactory.convertToString(
										eDataType, value));
							}
							return result.toString();
						} else {
							return eFactory.convertToString(eDataType,
									fromObject);
						}
					}
				};
			}
		}
		return super.createConverter(fromType, toType);
	}
}
