package com.easytrip.rest.dto.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currencies {
	@JsonProperty("Code")
	String code;
	@JsonProperty("Symbol")
	String symbol;
	@JsonProperty("ThousandsSeparator")
	String thousandsSeparator;
	@JsonProperty("DecimalSeparator")
	String decimalSeparator;
	@JsonProperty("SymbolOnLeft")
	Boolean symbolOnLeft;
	@JsonProperty("SpaceBetweenAmountAndSymbol")
	Boolean spaceBetweenAmountAndSymbol;
	@JsonProperty("RoundingCoefficient")
	String roundingCoefficient;
	@JsonProperty("DecimalDigits")
	String decimalDigits;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getThousandsSeparator() {
		return thousandsSeparator;
	}
	public void setThousandsSeparator(String thousandsSeparator) {
		this.thousandsSeparator = thousandsSeparator;
	}
	public String getDecimalSeparator() {
		return decimalSeparator;
	}
	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}
	public Boolean getSymbolOnLeft() {
		return symbolOnLeft;
	}
	public void setSymbolOnLeft(Boolean symbolOnLeft) {
		this.symbolOnLeft = symbolOnLeft;
	}
	public Boolean getSpaceBetweenAmountAndSymbol() {
		return spaceBetweenAmountAndSymbol;
	}
	public void setSpaceBetweenAmountAndSymbol(Boolean spaceBetweenAmountAndSymbol) {
		this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
	}
	public String getRoundingCoefficient() {
		return roundingCoefficient;
	}
	public void setRoundingCoefficient(String roundingCoefficient) {
		this.roundingCoefficient = roundingCoefficient;
	}
	public String getDecimalDigits() {
		return decimalDigits;
	}
	public void setDecimalDigits(String decimalDigits) {
		this.decimalDigits = decimalDigits;
	}
}
