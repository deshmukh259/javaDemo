package com.hackerrank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Currancy {
    public static void main5(String args[]) {

        // Create a currency for GERMANY locale
        Locale locale = Locale.GERMANY;
        Currency cur1 = Currency.getInstance(locale);

        // Get and print the symbol of the currency
        String symbol = cur1.getSymbol(locale);
        System.out.println("Currency symbol is = " + symbol);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        System.out.println("US: " + DecimalFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: " + DecimalFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment));
        System.out.println("China: " + DecimalFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + DecimalFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }

    public static void main3(String[] args) {
        // Print out a number using the localized number, integer, currency,
        // and percent format for each locale
        Locale[] locales = NumberFormat.getAvailableLocales();
        double myNumber = -1234.56;
        NumberFormat form;
        for (int j = 0; j < 4; ++j) {
            System.out.println("FORMAT");
            for (int i = 0; i < locales.length; ++i) {
                if (locales[i].getCountry().length() == 0) {
                    continue; // Skip language-only locales
                }
                System.out.print(locales[i].getDisplayName());
                switch (j) {
                    case 0:
                        form = NumberFormat.getInstance(locales[i]);
                        break;
                    case 1:
                        form = NumberFormat.getIntegerInstance(locales[i]);
                        break;
                    case 2:
                        form = NumberFormat.getCurrencyInstance(locales[i]);
                        break;
                    default:
                        form = NumberFormat.getPercentInstance(locales[i]);
                        break;
                }
                if (form instanceof DecimalFormat) {
                    System.out.print(": " + ((DecimalFormat) form).toPattern());
                }
                System.out.print(" -> " + form.format(myNumber));
                try {
                    System.out.println(" -> " + form.parse(form.format(myNumber)));
                } catch (ParseException e) {
                }
            }
        }
    }
}
