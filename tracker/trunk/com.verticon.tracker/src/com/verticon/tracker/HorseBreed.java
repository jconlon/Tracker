/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Horse Breed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getHorseBreed()
 * @model
 * @generated
 */
public enum HorseBreed implements Enumerator {
	/**
	 * The '<em><b>AC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AC_VALUE
	 * @generated
	 * @ordered
	 */
	AC(0, "AC", "AMERICAN BASHKIR CURLY"),

	/**
	 * The '<em><b>AS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AS_VALUE
	 * @generated
	 * @ordered
	 */
	AS(1, "AS", "AMERICAN SADDLEBRED"),

	/**
	 * The '<em><b>AA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AA_VALUE
	 * @generated
	 * @ordered
	 */
	AA(2, "AA", "ANDALUSIAN"),

	/**
	 * The '<em><b>AO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AO_VALUE
	 * @generated
	 * @ordered
	 */
	AO(3, "AO", "ANGLO-ARABIAN"),

	/**
	 * The '<em><b>NO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_VALUE
	 * @generated
	 * @ordered
	 */
	NO(4, "NO", "ANGLO-NORMAND"),

	/**
	 * The '<em><b>AP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AP_VALUE
	 * @generated
	 * @ordered
	 */
	AP(5, "AP", "APPALOSA"),

	/**
	 * The '<em><b>AD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AD_VALUE
	 * @generated
	 * @ordered
	 */
	AD(6, "AD", "ARABIAN"),

	/**
	 * The '<em><b>BW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BW_VALUE
	 * @generated
	 * @ordered
	 */
	BW(7, "BW", "BADEN-WURTTEMBERG"),

	/**
	 * The '<em><b>BY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BY_VALUE
	 * @generated
	 * @ordered
	 */
	BY(8, "BY", "BAYERISCHES WARMBLOOD"),

	/**
	 * The '<em><b>BU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BU_VALUE
	 * @generated
	 * @ordered
	 */
	BU(9, "BU", "BUCKSKIN"),

	/**
	 * The '<em><b>CI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CI_VALUE
	 * @generated
	 * @ordered
	 */
	CI(10, "CI", "CANADIAN HORSE"),

	/**
	 * The '<em><b>FC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FC_VALUE
	 * @generated
	 * @ordered
	 */
	FC(11, "FC", "CHEVAL DE SELLE FRANCAIS (FRENCH SADDLE HORSE)"),

	/**
	 * The '<em><b>CV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CV_VALUE
	 * @generated
	 * @ordered
	 */
	CV(12, "CV", "CLEVELAND BAY"),

	/**
	 * The '<em><b>CY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CY_VALUE
	 * @generated
	 * @ordered
	 */
	CY(13, "CY", "CLYDESDALE"),

	/**
	 * The '<em><b>CM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CM_VALUE
	 * @generated
	 * @ordered
	 */
	CM(14, "CM", "CONNEMARA"),

	/**
	 * The '<em><b>DT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DT_VALUE
	 * @generated
	 * @ordered
	 */
	DT(15, "DT", "DARTMOOR PONY"),

	/**
	 * The '<em><b>DW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DW_VALUE
	 * @generated
	 * @ordered
	 */
	DW(16, "DW", "DUTCH WARMBLOOD"),

	/**
	 * The '<em><b>EX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EX_VALUE
	 * @generated
	 * @ordered
	 */
	EX(17, "EX", "EXMOOR PONY"),

	/**
	 * The '<em><b>FE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FE_VALUE
	 * @generated
	 * @ordered
	 */
	FE(18, "FE", "FELL PONY"),

	/**
	 * The '<em><b>FJ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FJ_VALUE
	 * @generated
	 * @ordered
	 */
	FJ(19, "FJ", "FJORD"),

	/**
	 * The '<em><b>FH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FH_VALUE
	 * @generated
	 * @ordered
	 */
	FH(20, "FH", "FRENCH HORSE"),

	/**
	 * The '<em><b>FR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FR_VALUE
	 * @generated
	 * @ordered
	 */
	FR(21, "FR", "FRIESIAN"),

	/**
	 * The '<em><b>GL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GL_VALUE
	 * @generated
	 * @ordered
	 */
	GL(22, "GL", "GELDERLANDER"),

	/**
	 * The '<em><b>WG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WG_VALUE
	 * @generated
	 * @ordered
	 */
	WG(23, "WG", "GERMAN WARMBLOOD"),

	/**
	 * The '<em><b>HN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HN_VALUE
	 * @generated
	 * @ordered
	 */
	HN(24, "HN", "HACKNEY (horse/cheval)"),

	/**
	 * The '<em><b>HK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HK_VALUE
	 * @generated
	 * @ordered
	 */
	HK(25, "HK", "HACKNEY (pony/poney)"),

	/**
	 * The '<em><b>HF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HF_VALUE
	 * @generated
	 * @ordered
	 */
	HF(26, "HF", "HAFLINGER"),

	/**
	 * The '<em><b>HV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HV_VALUE
	 * @generated
	 * @ordered
	 */
	HV(27, "HV", "HANOVERIAN"),

	/**
	 * The '<em><b>HG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HG_VALUE
	 * @generated
	 * @ordered
	 */
	HG(28, "HG", "HIGHLAND PONY"),

	/**
	 * The '<em><b>HT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HT_VALUE
	 * @generated
	 * @ordered
	 */
	HT(29, "HT", "HOLSTEINER"),

	/**
	 * The '<em><b>HW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HW_VALUE
	 * @generated
	 * @ordered
	 */
	HW(30, "HW", "HUNGARIAN WARMBLOOD"),

	/**
	 * The '<em><b>HU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HU_VALUE
	 * @generated
	 * @ordered
	 */
	HU(31, "HU", "HUNTER"),

	/**
	 * The '<em><b>IC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IC_VALUE
	 * @generated
	 * @ordered
	 */
	IC(32, "IC", "ICELANDIC"),

	/**
	 * The '<em><b>LZ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LZ_VALUE
	 * @generated
	 * @ordered
	 */
	LZ(33, "LZ", "LIPIZZANER"),

	/**
	 * The '<em><b>MU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MU_VALUE
	 * @generated
	 * @ordered
	 */
	MU(34, "MU", "MINATURE HORSE"),

	/**
	 * The '<em><b>MF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MF_VALUE
	 * @generated
	 * @ordered
	 */
	MF(35, "MF", "MISSOURI FOXTROTTING"),

	/**
	 * The '<em><b>MN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MN_VALUE
	 * @generated
	 * @ordered
	 */
	MN(36, "MN", "MORGAN"),

	/**
	 * The '<em><b>NF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NF_VALUE
	 * @generated
	 * @ordered
	 */
	NF(37, "NF", "NEW FOREST"),

	/**
	 * The '<em><b>NK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NK_VALUE
	 * @generated
	 * @ordered
	 */
	NK(38, "NK", "NORIKER"),

	/**
	 * The '<em><b>OB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OB_VALUE
	 * @generated
	 * @ordered
	 */
	OB(39, "OB", "OLDENBURG"),

	/**
	 * The '<em><b>PT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PT_VALUE
	 * @generated
	 * @ordered
	 */
	PT(40, "PT", "PAINT"),

	/**
	 * The '<em><b>PL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PL_VALUE
	 * @generated
	 * @ordered
	 */
	PL(41, "PL", "PALOMINO"),

	/**
	 * The '<em><b>PF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PF_VALUE
	 * @generated
	 * @ordered
	 */
	PF(42, "PF", "PASO FINO"),

	/**
	 * The '<em><b>PH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PH_VALUE
	 * @generated
	 * @ordered
	 */
	PH(43, "PH", "PERCHERON"),

	/**
	 * The '<em><b>PV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PV_VALUE
	 * @generated
	 * @ordered
	 */
	PV(44, "PV", "PERUVIAN"),

	/**
	 * The '<em><b>PN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PN_VALUE
	 * @generated
	 * @ordered
	 */
	PN(45, "PN", "PINTO"),

	/**
	 * The '<em><b>PW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PW_VALUE
	 * @generated
	 * @ordered
	 */
	PW(46, "PW", "POLISH WARMBLOOD"),

	/**
	 * The '<em><b>OL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OL_VALUE
	 * @generated
	 * @ordered
	 */
	OL(47, "OL", "POLO PONY"),

	/**
	 * The '<em><b>QH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QH_VALUE
	 * @generated
	 * @ordered
	 */
	QH(48, "QH", "OUARTER HORSE"),

	/**
	 * The '<em><b>RH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RH_VALUE
	 * @generated
	 * @ordered
	 */
	RH(49, "RH", "RHEINLANDER"),

	/**
	 * The '<em><b>RU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RU_VALUE
	 * @generated
	 * @ordered
	 */
	RU(50, "RU", "RUSTIC PONY"),

	/**
	 * The '<em><b>SE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SE_VALUE
	 * @generated
	 * @ordered
	 */
	SE(51, "SE", "SHETLAND"),

	/**
	 * The '<em><b>SY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SY_VALUE
	 * @generated
	 * @ordered
	 */
	SY(52, "SY", "SHIRE"),

	/**
	 * The '<em><b>SN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SN_VALUE
	 * @generated
	 * @ordered
	 */
	SN(53, "SN", "STANDARDBRED"),

	/**
	 * The '<em><b>SF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SF_VALUE
	 * @generated
	 * @ordered
	 */
	SF(54, "SF", "SUFFOLK PUNCH"),

	/**
	 * The '<em><b>WW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WW_VALUE
	 * @generated
	 * @ordered
	 */
	WW(55, "WW", "SWEDISH WARMBLOOD"),

	/**
	 * The '<em><b>WI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WI_VALUE
	 * @generated
	 * @ordered
	 */
	WI(56, "WI", "SWISS HORSE"),

	/**
	 * The '<em><b>TP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TP_VALUE
	 * @generated
	 * @ordered
	 */
	TP(57, "TP", "TARPAN"),

	/**
	 * The '<em><b>TW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TW_VALUE
	 * @generated
	 * @ordered
	 */
	TW(58, "TW", "TENNESSEE WALKING"),

	/**
	 * The '<em><b>TH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TH_VALUE
	 * @generated
	 * @ordered
	 */
	TH(59, "TH", "THOROUGHBRED"),

	/**
	 * The '<em><b>TR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TR_VALUE
	 * @generated
	 * @ordered
	 */
	TR(60, "TR", "TRAKEHNER"),

	/**
	 * The '<em><b>TF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TF_VALUE
	 * @generated
	 * @ordered
	 */
	TF(61, "TF", "TROTTEUR FRANCAIS"),

	/**
	 * The '<em><b>VK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VK_VALUE
	 * @generated
	 * @ordered
	 */
	VK(62, "VK", "VIKING"),

	/**
	 * The '<em><b>WE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WE_VALUE
	 * @generated
	 * @ordered
	 */
	WE(63, "WE", "WELSH"),

	/**
	 * The '<em><b>WF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WF_VALUE
	 * @generated
	 * @ordered
	 */
	WF(64, "WF", "WESTFALEN"),

	/**
	 * The '<em><b>WU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WU_VALUE
	 * @generated
	 * @ordered
	 */
	WU(65, "WU", "WURTTEMBERG"),

	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(66, "Unspecified", "");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>AC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AC
	 * @model literal="AMERICAN BASHKIR CURLY"
	 * @generated
	 * @ordered
	 */
	public static final int AC_VALUE = 0;

	/**
	 * The '<em><b>AS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AS
	 * @model literal="AMERICAN SADDLEBRED"
	 * @generated
	 * @ordered
	 */
	public static final int AS_VALUE = 1;

	/**
	 * The '<em><b>AA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AA
	 * @model literal="ANDALUSIAN"
	 * @generated
	 * @ordered
	 */
	public static final int AA_VALUE = 2;

	/**
	 * The '<em><b>AO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AO
	 * @model literal="ANGLO-ARABIAN"
	 * @generated
	 * @ordered
	 */
	public static final int AO_VALUE = 3;

	/**
	 * The '<em><b>NO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO
	 * @model literal="ANGLO-NORMAND"
	 * @generated
	 * @ordered
	 */
	public static final int NO_VALUE = 4;

	/**
	 * The '<em><b>AP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AP
	 * @model literal="APPALOSA"
	 * @generated
	 * @ordered
	 */
	public static final int AP_VALUE = 5;

	/**
	 * The '<em><b>AD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AD
	 * @model literal="ARABIAN"
	 * @generated
	 * @ordered
	 */
	public static final int AD_VALUE = 6;

	/**
	 * The '<em><b>BW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BW
	 * @model literal="BADEN-WURTTEMBERG"
	 * @generated
	 * @ordered
	 */
	public static final int BW_VALUE = 7;

	/**
	 * The '<em><b>BY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BY
	 * @model literal="BAYERISCHES WARMBLOOD"
	 * @generated
	 * @ordered
	 */
	public static final int BY_VALUE = 8;

	/**
	 * The '<em><b>BU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BU
	 * @model literal="BUCKSKIN"
	 * @generated
	 * @ordered
	 */
	public static final int BU_VALUE = 9;

	/**
	 * The '<em><b>CI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CI
	 * @model literal="CANADIAN HORSE"
	 * @generated
	 * @ordered
	 */
	public static final int CI_VALUE = 10;

	/**
	 * The '<em><b>FC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FC
	 * @model literal="CHEVAL DE SELLE FRANCAIS (FRENCH SADDLE HORSE)"
	 * @generated
	 * @ordered
	 */
	public static final int FC_VALUE = 11;

	/**
	 * The '<em><b>CV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CV
	 * @model literal="CLEVELAND BAY"
	 * @generated
	 * @ordered
	 */
	public static final int CV_VALUE = 12;

	/**
	 * The '<em><b>CY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CY
	 * @model literal="CLYDESDALE"
	 * @generated
	 * @ordered
	 */
	public static final int CY_VALUE = 13;

	/**
	 * The '<em><b>CM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CM
	 * @model literal="CONNEMARA"
	 * @generated
	 * @ordered
	 */
	public static final int CM_VALUE = 14;

	/**
	 * The '<em><b>DT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DT
	 * @model literal="DARTMOOR PONY"
	 * @generated
	 * @ordered
	 */
	public static final int DT_VALUE = 15;

	/**
	 * The '<em><b>DW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DW
	 * @model literal="DUTCH WARMBLOOD"
	 * @generated
	 * @ordered
	 */
	public static final int DW_VALUE = 16;

	/**
	 * The '<em><b>EX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EX
	 * @model literal="EXMOOR PONY"
	 * @generated
	 * @ordered
	 */
	public static final int EX_VALUE = 17;

	/**
	 * The '<em><b>FE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FE
	 * @model literal="FELL PONY"
	 * @generated
	 * @ordered
	 */
	public static final int FE_VALUE = 18;

	/**
	 * The '<em><b>FJ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FJ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FJ
	 * @model literal="FJORD"
	 * @generated
	 * @ordered
	 */
	public static final int FJ_VALUE = 19;

	/**
	 * The '<em><b>FH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FH
	 * @model literal="FRENCH HORSE"
	 * @generated
	 * @ordered
	 */
	public static final int FH_VALUE = 20;

	/**
	 * The '<em><b>FR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FR
	 * @model literal="FRIESIAN"
	 * @generated
	 * @ordered
	 */
	public static final int FR_VALUE = 21;

	/**
	 * The '<em><b>GL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GL
	 * @model literal="GELDERLANDER"
	 * @generated
	 * @ordered
	 */
	public static final int GL_VALUE = 22;

	/**
	 * The '<em><b>WG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WG
	 * @model literal="GERMAN WARMBLOOD"
	 * @generated
	 * @ordered
	 */
	public static final int WG_VALUE = 23;

	/**
	 * The '<em><b>HN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HN
	 * @model literal="HACKNEY (horse/cheval)"
	 * @generated
	 * @ordered
	 */
	public static final int HN_VALUE = 24;

	/**
	 * The '<em><b>HK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HK
	 * @model literal="HACKNEY (pony/poney)"
	 * @generated
	 * @ordered
	 */
	public static final int HK_VALUE = 25;

	/**
	 * The '<em><b>HF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HF
	 * @model literal="HAFLINGER"
	 * @generated
	 * @ordered
	 */
	public static final int HF_VALUE = 26;

	/**
	 * The '<em><b>HV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HV
	 * @model literal="HANOVERIAN"
	 * @generated
	 * @ordered
	 */
	public static final int HV_VALUE = 27;

	/**
	 * The '<em><b>HG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HG
	 * @model literal="HIGHLAND PONY"
	 * @generated
	 * @ordered
	 */
	public static final int HG_VALUE = 28;

	/**
	 * The '<em><b>HT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HT
	 * @model literal="HOLSTEINER"
	 * @generated
	 * @ordered
	 */
	public static final int HT_VALUE = 29;

	/**
	 * The '<em><b>HW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HW
	 * @model literal="HUNGARIAN WARMBLOOD"
	 * @generated
	 * @ordered
	 */
	public static final int HW_VALUE = 30;

	/**
	 * The '<em><b>HU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HU
	 * @model literal="HUNTER"
	 * @generated
	 * @ordered
	 */
	public static final int HU_VALUE = 31;

	/**
	 * The '<em><b>IC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IC
	 * @model literal="ICELANDIC"
	 * @generated
	 * @ordered
	 */
	public static final int IC_VALUE = 32;

	/**
	 * The '<em><b>LZ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LZ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LZ
	 * @model literal="LIPIZZANER"
	 * @generated
	 * @ordered
	 */
	public static final int LZ_VALUE = 33;

	/**
	 * The '<em><b>MU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MU
	 * @model literal="MINATURE HORSE"
	 * @generated
	 * @ordered
	 */
	public static final int MU_VALUE = 34;

	/**
	 * The '<em><b>MF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MF
	 * @model literal="MISSOURI FOXTROTTING"
	 * @generated
	 * @ordered
	 */
	public static final int MF_VALUE = 35;

	/**
	 * The '<em><b>MN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MN
	 * @model literal="MORGAN"
	 * @generated
	 * @ordered
	 */
	public static final int MN_VALUE = 36;

	/**
	 * The '<em><b>NF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NF
	 * @model literal="NEW FOREST"
	 * @generated
	 * @ordered
	 */
	public static final int NF_VALUE = 37;

	/**
	 * The '<em><b>NK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NK
	 * @model literal="NORIKER"
	 * @generated
	 * @ordered
	 */
	public static final int NK_VALUE = 38;

	/**
	 * The '<em><b>OB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OB
	 * @model literal="OLDENBURG"
	 * @generated
	 * @ordered
	 */
	public static final int OB_VALUE = 39;

	/**
	 * The '<em><b>PT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PT
	 * @model literal="PAINT"
	 * @generated
	 * @ordered
	 */
	public static final int PT_VALUE = 40;

	/**
	 * The '<em><b>PL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PL
	 * @model literal="PALOMINO"
	 * @generated
	 * @ordered
	 */
	public static final int PL_VALUE = 41;

	/**
	 * The '<em><b>PF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PF
	 * @model literal="PASO FINO"
	 * @generated
	 * @ordered
	 */
	public static final int PF_VALUE = 42;

	/**
	 * The '<em><b>PH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PH
	 * @model literal="PERCHERON"
	 * @generated
	 * @ordered
	 */
	public static final int PH_VALUE = 43;

	/**
	 * The '<em><b>PV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PV
	 * @model literal="PERUVIAN"
	 * @generated
	 * @ordered
	 */
	public static final int PV_VALUE = 44;

	/**
	 * The '<em><b>PN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PN
	 * @model literal="PINTO"
	 * @generated
	 * @ordered
	 */
	public static final int PN_VALUE = 45;

	/**
	 * The '<em><b>PW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PW
	 * @model literal="POLISH WARMBLOOD"
	 * @generated
	 * @ordered
	 */
	public static final int PW_VALUE = 46;

	/**
	 * The '<em><b>OL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OL
	 * @model literal="POLO PONY"
	 * @generated
	 * @ordered
	 */
	public static final int OL_VALUE = 47;

	/**
	 * The '<em><b>QH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QH
	 * @model literal="OUARTER HORSE"
	 * @generated
	 * @ordered
	 */
	public static final int QH_VALUE = 48;

	/**
	 * The '<em><b>RH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RH
	 * @model literal="RHEINLANDER"
	 * @generated
	 * @ordered
	 */
	public static final int RH_VALUE = 49;

	/**
	 * The '<em><b>RU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RU
	 * @model literal="RUSTIC PONY"
	 * @generated
	 * @ordered
	 */
	public static final int RU_VALUE = 50;

	/**
	 * The '<em><b>SE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SE
	 * @model literal="SHETLAND"
	 * @generated
	 * @ordered
	 */
	public static final int SE_VALUE = 51;

	/**
	 * The '<em><b>SY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SY
	 * @model literal="SHIRE"
	 * @generated
	 * @ordered
	 */
	public static final int SY_VALUE = 52;

	/**
	 * The '<em><b>SN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SN
	 * @model literal="STANDARDBRED"
	 * @generated
	 * @ordered
	 */
	public static final int SN_VALUE = 53;

	/**
	 * The '<em><b>SF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SF
	 * @model literal="SUFFOLK PUNCH"
	 * @generated
	 * @ordered
	 */
	public static final int SF_VALUE = 54;

	/**
	 * The '<em><b>WW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WW
	 * @model literal="SWEDISH WARMBLOOD"
	 * @generated
	 * @ordered
	 */
	public static final int WW_VALUE = 55;

	/**
	 * The '<em><b>WI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WI
	 * @model literal="SWISS HORSE"
	 * @generated
	 * @ordered
	 */
	public static final int WI_VALUE = 56;

	/**
	 * The '<em><b>TP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TP
	 * @model literal="TARPAN"
	 * @generated
	 * @ordered
	 */
	public static final int TP_VALUE = 57;

	/**
	 * The '<em><b>TW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TW
	 * @model literal="TENNESSEE WALKING"
	 * @generated
	 * @ordered
	 */
	public static final int TW_VALUE = 58;

	/**
	 * The '<em><b>TH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TH
	 * @model literal="THOROUGHBRED"
	 * @generated
	 * @ordered
	 */
	public static final int TH_VALUE = 59;

	/**
	 * The '<em><b>TR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TR
	 * @model literal="TRAKEHNER"
	 * @generated
	 * @ordered
	 */
	public static final int TR_VALUE = 60;

	/**
	 * The '<em><b>TF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TF
	 * @model literal="TROTTEUR FRANCAIS"
	 * @generated
	 * @ordered
	 */
	public static final int TF_VALUE = 61;

	/**
	 * The '<em><b>VK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VK
	 * @model literal="VIKING"
	 * @generated
	 * @ordered
	 */
	public static final int VK_VALUE = 62;

	/**
	 * The '<em><b>WE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WE
	 * @model literal="WELSH"
	 * @generated
	 * @ordered
	 */
	public static final int WE_VALUE = 63;

	/**
	 * The '<em><b>WF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WF
	 * @model literal="WESTFALEN"
	 * @generated
	 * @ordered
	 */
	public static final int WF_VALUE = 64;

	/**
	 * The '<em><b>WU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WU
	 * @model literal="WURTTEMBERG"
	 * @generated
	 * @ordered
	 */
	public static final int WU_VALUE = 65;

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @model name="Unspecified" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE = 66;

	/**
	 * An array of all the '<em><b>Horse Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HorseBreed[] VALUES_ARRAY =
		new HorseBreed[] {
			AC,
			AS,
			AA,
			AO,
			NO,
			AP,
			AD,
			BW,
			BY,
			BU,
			CI,
			FC,
			CV,
			CY,
			CM,
			DT,
			DW,
			EX,
			FE,
			FJ,
			FH,
			FR,
			GL,
			WG,
			HN,
			HK,
			HF,
			HV,
			HG,
			HT,
			HW,
			HU,
			IC,
			LZ,
			MU,
			MF,
			MN,
			NF,
			NK,
			OB,
			PT,
			PL,
			PF,
			PH,
			PV,
			PN,
			PW,
			OL,
			QH,
			RH,
			RU,
			SE,
			SY,
			SN,
			SF,
			WW,
			WI,
			TP,
			TW,
			TH,
			TR,
			TF,
			VK,
			WE,
			WF,
			WU,
			UNSPECIFIED,
		};

	/**
	 * A public read-only list of all the '<em><b>Horse Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HorseBreed> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Horse Breed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HorseBreed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HorseBreed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Horse Breed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HorseBreed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HorseBreed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Horse Breed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HorseBreed get(int value) {
		switch (value) {
			case AC_VALUE: return AC;
			case AS_VALUE: return AS;
			case AA_VALUE: return AA;
			case AO_VALUE: return AO;
			case NO_VALUE: return NO;
			case AP_VALUE: return AP;
			case AD_VALUE: return AD;
			case BW_VALUE: return BW;
			case BY_VALUE: return BY;
			case BU_VALUE: return BU;
			case CI_VALUE: return CI;
			case FC_VALUE: return FC;
			case CV_VALUE: return CV;
			case CY_VALUE: return CY;
			case CM_VALUE: return CM;
			case DT_VALUE: return DT;
			case DW_VALUE: return DW;
			case EX_VALUE: return EX;
			case FE_VALUE: return FE;
			case FJ_VALUE: return FJ;
			case FH_VALUE: return FH;
			case FR_VALUE: return FR;
			case GL_VALUE: return GL;
			case WG_VALUE: return WG;
			case HN_VALUE: return HN;
			case HK_VALUE: return HK;
			case HF_VALUE: return HF;
			case HV_VALUE: return HV;
			case HG_VALUE: return HG;
			case HT_VALUE: return HT;
			case HW_VALUE: return HW;
			case HU_VALUE: return HU;
			case IC_VALUE: return IC;
			case LZ_VALUE: return LZ;
			case MU_VALUE: return MU;
			case MF_VALUE: return MF;
			case MN_VALUE: return MN;
			case NF_VALUE: return NF;
			case NK_VALUE: return NK;
			case OB_VALUE: return OB;
			case PT_VALUE: return PT;
			case PL_VALUE: return PL;
			case PF_VALUE: return PF;
			case PH_VALUE: return PH;
			case PV_VALUE: return PV;
			case PN_VALUE: return PN;
			case PW_VALUE: return PW;
			case OL_VALUE: return OL;
			case QH_VALUE: return QH;
			case RH_VALUE: return RH;
			case RU_VALUE: return RU;
			case SE_VALUE: return SE;
			case SY_VALUE: return SY;
			case SN_VALUE: return SN;
			case SF_VALUE: return SF;
			case WW_VALUE: return WW;
			case WI_VALUE: return WI;
			case TP_VALUE: return TP;
			case TW_VALUE: return TW;
			case TH_VALUE: return TH;
			case TR_VALUE: return TR;
			case TF_VALUE: return TF;
			case VK_VALUE: return VK;
			case WE_VALUE: return WE;
			case WF_VALUE: return WF;
			case WU_VALUE: return WU;
			case UNSPECIFIED_VALUE: return UNSPECIFIED;
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
	private HorseBreed(int value, String name, String literal) {
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
	
} //HorseBreed
