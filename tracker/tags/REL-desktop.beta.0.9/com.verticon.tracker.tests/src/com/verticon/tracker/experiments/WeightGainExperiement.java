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
package com.verticon.tracker.experiments;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * To test common Java arithmetic problems
 * 
 * href="http://www.devarticles.com/c/a/Java/How-the-BigDecimal-Class-Helps-Java-Get-its-Arithmetic-Right" 
 * @author jconlon
 *
 */
public class WeightGainExperiement {
	public static void main(String[] args) {
		// create a Scanner object and start while loop
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			System.out.print("Enter first weighIn weight: ");
			double firstWeight = sc.nextDouble();
			
			System.out.print("Enter second weighIn weight: ");
			double secondWeight = sc.nextDouble();
			
			System.out.print("Enter days: ");
			int days = sc.nextInt();

			// calculate the results 
			double weightGain = secondWeight - firstWeight;
			double weightGainPercent = weightGain / firstWeight;
			
			double weightGainPerDay = weightGain / days;
			
//			double discountPercent = 0.0;
//			if (firstWeight >= 100)
//				discountPercent = .1;
//			else
//				discountPercent = 0.0;
//			double discountAmount = firstWeight * discountPercent;
//			double totalBeforeTax = firstWeight - discountAmount;
//			double salesTax = totalBeforeTax * .05;
//			double total = totalBeforeTax + salesTax;

			// format and display the results
			NumberFormat decmialFormat = NumberFormat.getInstance();
			 if (decmialFormat instanceof DecimalFormat) {
			     ((DecimalFormat) decmialFormat).applyPattern(".##");//.setDecimalSeparatorAlwaysShown(true);
			 }
			 
			NumberFormat percent = NumberFormat.getPercentInstance();
			String message = 
					"Weight gain percent: "+ percent.format(weightGainPercent) + "\n"
					+ "Weight gain amount: " + decmialFormat.format(weightGain)+ "\n" 
					+ "Weight gain per day: "+ decmialFormat.format(weightGainPerDay) + "\n";
			System.out.println(message);
			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
//	public static void main(String[] args) {
//		// create a Scanner object and start while loop
//		Scanner sc = new Scanner(System.in);
//		String choice = "y";
//		while (choice.equalsIgnoreCase("y")) {
//			// get the input from the user
//			System.out.print("Enter subtotal: ");
//			double subtotal = sc.nextDouble();
//
//			// calculate the results
//			double discountPercent = 0.0;
//			if (subtotal >= 100)
//				discountPercent = .1;
//			else
//				discountPercent = 0.0;
//			double discountAmount = subtotal * discountPercent;
//			double totalBeforeTax = subtotal - discountAmount;
//			double salesTax = totalBeforeTax * .05;
//			double total = totalBeforeTax + salesTax;
//
//			// format and display the results
//			NumberFormat currency = NumberFormat.getCurrencyInstance();
//			NumberFormat percent = NumberFormat.getPercentInstance();
//			String message = "Discount percent: "
//					+ percent.format(discountPercent) + "\n"
//					+ "Discount amount: " + currency.format(discountAmount)
//					+ "\n" + "Total before tax: "
//					+ currency.format(totalBeforeTax) + "\n" + "Sales tax: "
//					+ currency.format(salesTax) + "\n" + "Invoice total: "
//					+ currency.format(total) + "\n";
//			System.out.println(message);
//			// see if the user wants to continue
//			System.out.print("Continue? (y/n): ");
//			choice = sc.next();
//			System.out.println();
//		}
//	}
}
