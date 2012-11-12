package si.kcclass.currencyconverter.domain;

import java.util.Date;

public class ConvertedCurrencyValue {
	String symCurrencyFrom;
	String symCurrencyTo;
	Date currencyRateDate;
	double convertedValue;
	
	public String getSymCurrencyFrom() {
		return symCurrencyFrom;
	}
	public void setSymCurrencyFrom(String symCurrencyFrom) {
		this.symCurrencyFrom = symCurrencyFrom;
	}
	public String getSymCurrencyTo() {
		return symCurrencyTo;
	}
	public void setSymCurrencyTo(String symCurrencyTo) {
		this.symCurrencyTo = symCurrencyTo;
	}
	public Date getCurrencyRateDate() {
		return currencyRateDate;
	}
	public void setCurrencyRateDate(Date currencyRateDate) {
		this.currencyRateDate = currencyRateDate;
	}
	public double getConvertedValue() {
		return convertedValue;
	}
	public void setConvertedValue(double convertedValue) {
		this.convertedValue = convertedValue;
	}	
}
