package com.util;

import java.util.Currency;

public class Conversion {
	
	final static String currencyReg = "^\\$(\\d{1,3}(\\,\\d{3})*|(\\d+))(\\.\\d{2})?$";
		
	public static Double currencyToDouble(String currency) {
		if(currency.contains("$")) {
			currency.replace("$", "");
		}
		if(currency.contains(",")) {
			currency.replaceAll(",", "");
		}
		return Double.valueOf(currency);
	}	
	
	public static boolean isCurrency(String text) {
		return text.matches(currencyReg);
	}

}
