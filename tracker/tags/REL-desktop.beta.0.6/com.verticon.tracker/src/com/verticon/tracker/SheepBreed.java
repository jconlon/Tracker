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
 * A representation of the literals of the enumeration '<em><b>Sheep Breed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.verticon.tracker.TrackerPackage#getSheepBreed()
 * @model
 * @generated
 */
public enum SheepBreed implements Enumerator
{
	/**
	 * The '<em><b>CD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD
	 * @generated
	 * @ordered
	 */
	CD_LITERAL(0, "CD", "ARCOTT - Canadian"),
	/**
	 * The '<em><b>OU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OU
	 * @generated
	 * @ordered
	 */
	OU_LITERAL(1, "OU", "ARCOTT - Outaouais"),
	/**
	 * The '<em><b>RI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RI
	 * @generated
	 * @ordered
	 */
	RI_LITERAL(2, "RI", "ARCOTT - Rideau"),
	/**
	 * The '<em><b>LY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LY
	 * @generated
	 * @ordered
	 */
	LY_LITERAL(3, "LY", "BARBADOS BLACK BELLY"),
	/**
	 * The '<em><b>FB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FB
	 * @generated
	 * @ordered
	 */
	FB_LITERAL(4, "FB", "BLACK FACE"),
	/**
	 * The '<em><b>BW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BW
	 * @generated
	 * @ordered
	 */
	BW_LITERAL(5, "BW", "BLACK WELSH MOUNTAIN"),
	/**
	 * The '<em><b>BF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BF
	 * @generated
	 * @ordered
	 */
	BF_LITERAL(6, "BF", "BLUE FACED LEISTER"),
	/**
	 * The '<em><b>BO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BO
	 * @generated
	 * @ordered
	 */
	BO_LITERAL(7, "BO", "BOOROULA"),
	/**
	 * The '<em><b>BC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC
	 * @generated
	 * @ordered
	 */
	BC_LITERAL(8, "BC", "BORDER CHEVIOT"),
	/**
	 * The '<em><b>CO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CO
	 * @generated
	 * @ordered
	 */
	CO_LITERAL(9, "CO", "CHAROLLAIS"),
	/**
	 * The '<em><b>CF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CF
	 * @generated
	 * @ordered
	 */
	CF_LITERAL(10, "CF", "CLUN FOREST"),
	/**
	 * The '<em><b>CL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CL
	 * @generated
	 * @ordered
	 */
	CL_LITERAL(11, "CL", "COLUMBIA"),
	/**
	 * The '<em><b>CP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CP
	 * @generated
	 * @ordered
	 */
	CP_LITERAL(12, "CP", "COOPWORTH"),
	/**
	 * The '<em><b>CR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CR
	 * @generated
	 * @ordered
	 */
	CR_LITERAL(13, "CR", "CORRIEDALE"),
	/**
	 * The '<em><b>DH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DH
	 * @generated
	 * @ordered
	 */
	DH_LITERAL(14, "DH", "DORSET - Horned"),
	/**
	 * The '<em><b>DP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DP
	 * @generated
	 * @ordered
	 */
	DP_LITERAL(15, "DP", "DORSET - Polled"),
	/**
	 * The '<em><b>DL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DL
	 * @generated
	 * @ordered
	 */
	DL_LITERAL(16, "DL", "DLS"),
	/**
	 * The '<em><b>ER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ER
	 * @generated
	 * @ordered
	 */
	ER_LITERAL(17, "ER", "EAST FRIESLAND"),
	/**
	 * The '<em><b>FN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FN
	 * @generated
	 * @ordered
	 */
	FN_LITERAL(18, "FN", "FINNISH LANDRACE "),
	/**
	 * The '<em><b>HS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HS
	 * @generated
	 * @ordered
	 */
	HS_LITERAL(19, "HS", "HAMPSHIRE"),
	/**
	 * The '<em><b>HY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HY
	 * @generated
	 * @ordered
	 */
	HY_LITERAL(20, "HY", "HYBRID"),
	/**
	 * The '<em><b>IL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IL
	 * @generated
	 * @ordered
	 */
	IL_LITERAL(21, "IL", "ICELANDIC"),
	/**
	 * The '<em><b>KK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KK
	 * @generated
	 * @ordered
	 */
	KK_LITERAL(22, "KK", "KARAKUL"),
	/**
	 * The '<em><b>KA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KA
	 * @generated
	 * @ordered
	 */
	KA_LITERAL(23, "KA", "KATAHDIN"),
	/**
	 * The '<em><b>KH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KH
	 * @generated
	 * @ordered
	 */
	KH_LITERAL(24, "KH", "KERRY HILL"),
	/**
	 * The '<em><b>BL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BL
	 * @generated
	 * @ordered
	 */
	BL_LITERAL(25, "BL", "LEICESTER - Border"),
	/**
	 * The '<em><b>LE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LE
	 * @generated
	 * @ordered
	 */
	LE_LITERAL(26, "LE", "LEICESTER - English"),
	/**
	 * The '<em><b>HL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HL
	 * @generated
	 * @ordered
	 */
	HL_LITERAL(27, "HL", "LEISTER - Hexam"),
	/**
	 * The '<em><b>LI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LI
	 * @generated
	 * @ordered
	 */
	LI_LITERAL(28, "LI", "LINCOLN"),
	/**
	 * The '<em><b>MM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MM
	 * @generated
	 * @ordered
	 */
	MM_LITERAL(29, "MM", "MM"),
	/**
	 * The '<em><b>MP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MP
	 * @generated
	 * @ordered
	 */
	MP_LITERAL(30, "MP", "MERINO POLLED"),
	/**
	 * The '<em><b>MT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MT
	 * @generated
	 * @ordered
	 */
	MT_LITERAL(31, "MT", "MT"),
	/**
	 * The '<em><b>NL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NL
	 * @generated
	 * @ordered
	 */
	NL_LITERAL(32, "NL", "NEWFOUNDLAND LOCO"),
	/**
	 * The '<em><b>NC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NC
	 * @generated
	 * @ordered
	 */
	NC_LITERAL(33, "NC", "NORTH COUNTRY CHEVIOT"),
	/**
	 * The '<em><b>OX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OX
	 * @generated
	 * @ordered
	 */
	OX_LITERAL(34, "OX", "OXFORD"),
	/**
	 * The '<em><b>PE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PE
	 * @generated
	 * @ordered
	 */
	PE_LITERAL(35, "PE", "PERENDALE"),
	/**
	 * The '<em><b>PO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PO
	 * @generated
	 * @ordered
	 */
	PO_LITERAL(36, "PO", "POLYPAY"),
	/**
	 * The '<em><b>RG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RG
	 * @generated
	 * @ordered
	 */
	RG_LITERAL(37, "RG", "RAMBOUILLET"),
	/**
	 * The '<em><b>RV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RV
	 * @generated
	 * @ordered
	 */
	RV_LITERAL(38, "RV", "ROMANOV"),
	/**
	 * The '<em><b>RM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RM
	 * @generated
	 * @ordered
	 */
	RM_LITERAL(39, "RM", "ROMNELET"),
	/**
	 * The '<em><b>RY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RY
	 * @generated
	 * @ordered
	 */
	RY_LITERAL(40, "RY", "ROMNEY"),
	/**
	 * The '<em><b>SX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SX
	 * @generated
	 * @ordered
	 */
	SX_LITERAL(41, "SX", "ST. CROIX"),
	/**
	 * The '<em><b>SC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SC
	 * @generated
	 * @ordered
	 */
	SC_LITERAL(42, "SC", "SCOTTISH BLACKFACE"),
	/**
	 * The '<em><b>SL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SL
	 * @generated
	 * @ordered
	 */
	SL_LITERAL(43, "SL", "SHETLAND"),
	/**
	 * The '<em><b>SR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SR
	 * @generated
	 * @ordered
	 */
	SR_LITERAL(44, "SR", "SHROPSHIRE"),
	/**
	 * The '<em><b>ST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ST
	 * @generated
	 * @ordered
	 */
	ST_LITERAL(45, "ST", "SOUTHDOWN"),
	/**
	 * The '<em><b>SU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SU
	 * @generated
	 * @ordered
	 */
	SU_LITERAL(46, "SU", "SUFFOLK"),
	/**
	 * The '<em><b>TA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TA
	 * @generated
	 * @ordered
	 */
	TA_LITERAL(47, "TA", "TARGHEE"),
	/**
	 * The '<em><b>TX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TX
	 * @generated
	 * @ordered
	 */
	TX_LITERAL(48, "TX", "TEXEL"),
	/**
	 * The '<em><b>TU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TU
	 * @generated
	 * @ordered
	 */
	TU_LITERAL(49, "TU", "TUNIS"),
	/**
	 * The '<em><b>XL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XL
	 * @generated
	 * @ordered
	 */
	XL_LITERAL(50, "XL", "CROSSBRED - Large"),
	/**
	 * The '<em><b>XM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XM
	 * @generated
	 * @ordered
	 */
	XM_LITERAL(51, "XM", "CROSSBRED - Medium"),
	/**
	 * The '<em><b>ZS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZS
	 * @generated
	 * @ordered
	 */
	ZS_LITERAL(52, "ZS", "CROSSBRED - Small"),
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(53, "Unspecified", "");
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 Verticon, Inc. All Rights Reserved.";

	/**
	 * The '<em><b>CD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CD_LITERAL
	 * @model literal="ARCOTT - Canadian"
	 * @generated
	 * @ordered
	 */
	public static final int CD = 0;

	/**
	 * The '<em><b>OU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OU_LITERAL
	 * @model literal="ARCOTT - Outaouais"
	 * @generated
	 * @ordered
	 */
	public static final int OU = 1;

	/**
	 * The '<em><b>RI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RI_LITERAL
	 * @model literal="ARCOTT - Rideau"
	 * @generated
	 * @ordered
	 */
	public static final int RI = 2;

	/**
	 * The '<em><b>LY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LY_LITERAL
	 * @model literal="BARBADOS BLACK BELLY"
	 * @generated
	 * @ordered
	 */
	public static final int LY = 3;

	/**
	 * The '<em><b>FB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FB_LITERAL
	 * @model literal="BLACK FACE"
	 * @generated
	 * @ordered
	 */
	public static final int FB = 4;

	/**
	 * The '<em><b>BW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BW_LITERAL
	 * @model literal="BLACK WELSH MOUNTAIN"
	 * @generated
	 * @ordered
	 */
	public static final int BW = 5;

	/**
	 * The '<em><b>BF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BF_LITERAL
	 * @model literal="BLUE FACED LEISTER"
	 * @generated
	 * @ordered
	 */
	public static final int BF = 6;

	/**
	 * The '<em><b>BO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BO_LITERAL
	 * @model literal="BOOROULA"
	 * @generated
	 * @ordered
	 */
	public static final int BO = 7;

	/**
	 * The '<em><b>BC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BC_LITERAL
	 * @model literal="BORDER CHEVIOT"
	 * @generated
	 * @ordered
	 */
	public static final int BC = 8;

	/**
	 * The '<em><b>CO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CO_LITERAL
	 * @model literal="CHAROLLAIS"
	 * @generated
	 * @ordered
	 */
	public static final int CO = 9;

	/**
	 * The '<em><b>CF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CF_LITERAL
	 * @model literal="CLUN FOREST"
	 * @generated
	 * @ordered
	 */
	public static final int CF = 10;

	/**
	 * The '<em><b>CL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CL_LITERAL
	 * @model literal="COLUMBIA"
	 * @generated
	 * @ordered
	 */
	public static final int CL = 11;

	/**
	 * The '<em><b>CP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CP_LITERAL
	 * @model literal="COOPWORTH"
	 * @generated
	 * @ordered
	 */
	public static final int CP = 12;

	/**
	 * The '<em><b>CR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CR_LITERAL
	 * @model literal="CORRIEDALE"
	 * @generated
	 * @ordered
	 */
	public static final int CR = 13;

	/**
	 * The '<em><b>DH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DH_LITERAL
	 * @model literal="DORSET - Horned"
	 * @generated
	 * @ordered
	 */
	public static final int DH = 14;

	/**
	 * The '<em><b>DP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DP_LITERAL
	 * @model literal="DORSET - Polled"
	 * @generated
	 * @ordered
	 */
	public static final int DP = 15;

	/**
	 * The '<em><b>DL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DL_LITERAL
	 * @model literal="DLS"
	 * @generated
	 * @ordered
	 */
	public static final int DL = 16;

	/**
	 * The '<em><b>ER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ER_LITERAL
	 * @model literal="EAST FRIESLAND"
	 * @generated
	 * @ordered
	 */
	public static final int ER = 17;

	/**
	 * The '<em><b>FN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FN_LITERAL
	 * @model literal="FINNISH LANDRACE "
	 * @generated
	 * @ordered
	 */
	public static final int FN = 18;

	/**
	 * The '<em><b>HS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HS_LITERAL
	 * @model literal="HAMPSHIRE"
	 * @generated
	 * @ordered
	 */
	public static final int HS = 19;

	/**
	 * The '<em><b>HY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HY_LITERAL
	 * @model literal="HYBRID"
	 * @generated
	 * @ordered
	 */
	public static final int HY = 20;

	/**
	 * The '<em><b>IL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IL_LITERAL
	 * @model literal="ICELANDIC"
	 * @generated
	 * @ordered
	 */
	public static final int IL = 21;

	/**
	 * The '<em><b>KK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KK_LITERAL
	 * @model literal="KARAKUL"
	 * @generated
	 * @ordered
	 */
	public static final int KK = 22;

	/**
	 * The '<em><b>KA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KA_LITERAL
	 * @model literal="KATAHDIN"
	 * @generated
	 * @ordered
	 */
	public static final int KA = 23;

	/**
	 * The '<em><b>KH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KH_LITERAL
	 * @model literal="KERRY HILL"
	 * @generated
	 * @ordered
	 */
	public static final int KH = 24;

	/**
	 * The '<em><b>BL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BL_LITERAL
	 * @model literal="LEICESTER - Border"
	 * @generated
	 * @ordered
	 */
	public static final int BL = 25;

	/**
	 * The '<em><b>LE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LE_LITERAL
	 * @model literal="LEICESTER - English"
	 * @generated
	 * @ordered
	 */
	public static final int LE = 26;

	/**
	 * The '<em><b>HL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HL_LITERAL
	 * @model literal="LEISTER - Hexam"
	 * @generated
	 * @ordered
	 */
	public static final int HL = 27;

	/**
	 * The '<em><b>LI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LI_LITERAL
	 * @model literal="LINCOLN"
	 * @generated
	 * @ordered
	 */
	public static final int LI = 28;

	/**
	 * The '<em><b>MM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MM = 29;

	/**
	 * The '<em><b>MP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MP_LITERAL
	 * @model literal="MERINO POLLED"
	 * @generated
	 * @ordered
	 */
	public static final int MP = 30;

	/**
	 * The '<em><b>MT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MT = 31;

	/**
	 * The '<em><b>NL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NL_LITERAL
	 * @model literal="NEWFOUNDLAND LOCO"
	 * @generated
	 * @ordered
	 */
	public static final int NL = 32;

	/**
	 * The '<em><b>NC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NC_LITERAL
	 * @model literal="NORTH COUNTRY CHEVIOT"
	 * @generated
	 * @ordered
	 */
	public static final int NC = 33;

	/**
	 * The '<em><b>OX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OX_LITERAL
	 * @model literal="OXFORD"
	 * @generated
	 * @ordered
	 */
	public static final int OX = 34;

	/**
	 * The '<em><b>PE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PE_LITERAL
	 * @model literal="PERENDALE"
	 * @generated
	 * @ordered
	 */
	public static final int PE = 35;

	/**
	 * The '<em><b>PO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PO_LITERAL
	 * @model literal="POLYPAY"
	 * @generated
	 * @ordered
	 */
	public static final int PO = 36;

	/**
	 * The '<em><b>RG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RG_LITERAL
	 * @model literal="RAMBOUILLET"
	 * @generated
	 * @ordered
	 */
	public static final int RG = 37;

	/**
	 * The '<em><b>RV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RV_LITERAL
	 * @model literal="ROMANOV"
	 * @generated
	 * @ordered
	 */
	public static final int RV = 38;

	/**
	 * The '<em><b>RM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RM_LITERAL
	 * @model literal="ROMNELET"
	 * @generated
	 * @ordered
	 */
	public static final int RM = 39;

	/**
	 * The '<em><b>RY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RY_LITERAL
	 * @model literal="ROMNEY"
	 * @generated
	 * @ordered
	 */
	public static final int RY = 40;

	/**
	 * The '<em><b>SX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SX_LITERAL
	 * @model literal="ST. CROIX"
	 * @generated
	 * @ordered
	 */
	public static final int SX = 41;

	/**
	 * The '<em><b>SC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SC_LITERAL
	 * @model literal="SCOTTISH BLACKFACE"
	 * @generated
	 * @ordered
	 */
	public static final int SC = 42;

	/**
	 * The '<em><b>SL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SL_LITERAL
	 * @model literal="SHETLAND"
	 * @generated
	 * @ordered
	 */
	public static final int SL = 43;

	/**
	 * The '<em><b>SR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SR_LITERAL
	 * @model literal="SHROPSHIRE"
	 * @generated
	 * @ordered
	 */
	public static final int SR = 44;

	/**
	 * The '<em><b>ST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ST_LITERAL
	 * @model literal="SOUTHDOWN"
	 * @generated
	 * @ordered
	 */
	public static final int ST = 45;

	/**
	 * The '<em><b>SU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SU_LITERAL
	 * @model literal="SUFFOLK"
	 * @generated
	 * @ordered
	 */
	public static final int SU = 46;

	/**
	 * The '<em><b>TA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TA_LITERAL
	 * @model literal="TARGHEE"
	 * @generated
	 * @ordered
	 */
	public static final int TA = 47;

	/**
	 * The '<em><b>TX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TX_LITERAL
	 * @model literal="TEXEL"
	 * @generated
	 * @ordered
	 */
	public static final int TX = 48;

	/**
	 * The '<em><b>TU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TU_LITERAL
	 * @model literal="TUNIS"
	 * @generated
	 * @ordered
	 */
	public static final int TU = 49;

	/**
	 * The '<em><b>XL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XL_LITERAL
	 * @model literal="CROSSBRED - Large"
	 * @generated
	 * @ordered
	 */
	public static final int XL = 50;

	/**
	 * The '<em><b>XM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XM_LITERAL
	 * @model literal="CROSSBRED - Medium"
	 * @generated
	 * @ordered
	 */
	public static final int XM = 51;

	/**
	 * The '<em><b>ZS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZS_LITERAL
	 * @model literal="CROSSBRED - Small"
	 * @generated
	 * @ordered
	 */
	public static final int ZS = 52;

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_LITERAL
	 * @model name="Unspecified" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED = 53;

	/**
	 * An array of all the '<em><b>Sheep Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SheepBreed[] VALUES_ARRAY =
		new SheepBreed[] {
			CD_LITERAL,
			OU_LITERAL,
			RI_LITERAL,
			LY_LITERAL,
			FB_LITERAL,
			BW_LITERAL,
			BF_LITERAL,
			BO_LITERAL,
			BC_LITERAL,
			CO_LITERAL,
			CF_LITERAL,
			CL_LITERAL,
			CP_LITERAL,
			CR_LITERAL,
			DH_LITERAL,
			DP_LITERAL,
			DL_LITERAL,
			ER_LITERAL,
			FN_LITERAL,
			HS_LITERAL,
			HY_LITERAL,
			IL_LITERAL,
			KK_LITERAL,
			KA_LITERAL,
			KH_LITERAL,
			BL_LITERAL,
			LE_LITERAL,
			HL_LITERAL,
			LI_LITERAL,
			MM_LITERAL,
			MP_LITERAL,
			MT_LITERAL,
			NL_LITERAL,
			NC_LITERAL,
			OX_LITERAL,
			PE_LITERAL,
			PO_LITERAL,
			RG_LITERAL,
			RV_LITERAL,
			RM_LITERAL,
			RY_LITERAL,
			SX_LITERAL,
			SC_LITERAL,
			SL_LITERAL,
			SR_LITERAL,
			ST_LITERAL,
			SU_LITERAL,
			TA_LITERAL,
			TX_LITERAL,
			TU_LITERAL,
			XL_LITERAL,
			XM_LITERAL,
			ZS_LITERAL,
			UNSPECIFIED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Sheep Breed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SheepBreed> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sheep Breed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SheepBreed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SheepBreed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sheep Breed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SheepBreed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SheepBreed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sheep Breed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SheepBreed get(int value) {
		switch (value) {
			case CD: return CD_LITERAL;
			case OU: return OU_LITERAL;
			case RI: return RI_LITERAL;
			case LY: return LY_LITERAL;
			case FB: return FB_LITERAL;
			case BW: return BW_LITERAL;
			case BF: return BF_LITERAL;
			case BO: return BO_LITERAL;
			case BC: return BC_LITERAL;
			case CO: return CO_LITERAL;
			case CF: return CF_LITERAL;
			case CL: return CL_LITERAL;
			case CP: return CP_LITERAL;
			case CR: return CR_LITERAL;
			case DH: return DH_LITERAL;
			case DP: return DP_LITERAL;
			case DL: return DL_LITERAL;
			case ER: return ER_LITERAL;
			case FN: return FN_LITERAL;
			case HS: return HS_LITERAL;
			case HY: return HY_LITERAL;
			case IL: return IL_LITERAL;
			case KK: return KK_LITERAL;
			case KA: return KA_LITERAL;
			case KH: return KH_LITERAL;
			case BL: return BL_LITERAL;
			case LE: return LE_LITERAL;
			case HL: return HL_LITERAL;
			case LI: return LI_LITERAL;
			case MM: return MM_LITERAL;
			case MP: return MP_LITERAL;
			case MT: return MT_LITERAL;
			case NL: return NL_LITERAL;
			case NC: return NC_LITERAL;
			case OX: return OX_LITERAL;
			case PE: return PE_LITERAL;
			case PO: return PO_LITERAL;
			case RG: return RG_LITERAL;
			case RV: return RV_LITERAL;
			case RM: return RM_LITERAL;
			case RY: return RY_LITERAL;
			case SX: return SX_LITERAL;
			case SC: return SC_LITERAL;
			case SL: return SL_LITERAL;
			case SR: return SR_LITERAL;
			case ST: return ST_LITERAL;
			case SU: return SU_LITERAL;
			case TA: return TA_LITERAL;
			case TX: return TX_LITERAL;
			case TU: return TU_LITERAL;
			case XL: return XL_LITERAL;
			case XM: return XM_LITERAL;
			case ZS: return ZS_LITERAL;
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
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
	private SheepBreed(int value, String name, String literal) {
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
}
