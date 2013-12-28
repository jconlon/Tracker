/**
 */
package org.usaha.ecvi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Doc Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.usaha.ecvi.EcviPackage#getDocType()
 * @model extendedMetaData="name='DocType_._type'"
 * @generated
 */
public enum DocType implements Enumerator {
	/**
	 * The '<em><b>Scanned Paper CVI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNED_PAPER_CVI_VALUE
	 * @generated
	 * @ordered
	 */
	SCANNED_PAPER_CVI(0, "ScannedPaperCVI", "Scanned Paper CVI"),

	/**
	 * The '<em><b>Scanned Test Chart</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNED_TEST_CHART_VALUE
	 * @generated
	 * @ordered
	 */
	SCANNED_TEST_CHART(1, "ScannedTestChart", "Scanned Test Chart"),

	/**
	 * The '<em><b>PDFCVI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PDFCVI_VALUE
	 * @generated
	 * @ordered
	 */
	PDFCVI(2, "PDFCVI", "PDF CVI"),

	/**
	 * The '<em><b>PDF Test Chart</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PDF_TEST_CHART_VALUE
	 * @generated
	 * @ordered
	 */
	PDF_TEST_CHART(3, "PDFTestChart", "PDF Test Chart"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(4, "Other", "Other");

	/**
	 * The '<em><b>Scanned Paper CVI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scanned Paper CVI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCANNED_PAPER_CVI
	 * @model name="ScannedPaperCVI" literal="Scanned Paper CVI"
	 * @generated
	 * @ordered
	 */
	public static final int SCANNED_PAPER_CVI_VALUE = 0;

	/**
	 * The '<em><b>Scanned Test Chart</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scanned Test Chart</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCANNED_TEST_CHART
	 * @model name="ScannedTestChart" literal="Scanned Test Chart"
	 * @generated
	 * @ordered
	 */
	public static final int SCANNED_TEST_CHART_VALUE = 1;

	/**
	 * The '<em><b>PDFCVI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PDFCVI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PDFCVI
	 * @model literal="PDF CVI"
	 * @generated
	 * @ordered
	 */
	public static final int PDFCVI_VALUE = 2;

	/**
	 * The '<em><b>PDF Test Chart</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PDF Test Chart</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PDF_TEST_CHART
	 * @model name="PDFTestChart" literal="PDF Test Chart"
	 * @generated
	 * @ordered
	 */
	public static final int PDF_TEST_CHART_VALUE = 3;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER
	 * @model name="Other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Doc Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DocType[] VALUES_ARRAY =
		new DocType[] {
			SCANNED_PAPER_CVI,
			SCANNED_TEST_CHART,
			PDFCVI,
			PDF_TEST_CHART,
			OTHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Doc Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DocType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Doc Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DocType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DocType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Doc Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DocType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DocType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Doc Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DocType get(int value) {
		switch (value) {
			case SCANNED_PAPER_CVI_VALUE: return SCANNED_PAPER_CVI;
			case SCANNED_TEST_CHART_VALUE: return SCANNED_TEST_CHART;
			case PDFCVI_VALUE: return PDFCVI;
			case PDF_TEST_CHART_VALUE: return PDF_TEST_CHART;
			case OTHER_VALUE: return OTHER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DocType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DocType
