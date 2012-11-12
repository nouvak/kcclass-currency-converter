package si.kcclass.currencyconverter.services;

import java.util.Date;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;

public interface ForeignCurrencyToEuroRateService {
	
	public ForeignCurrencyToEuroRate findByCurrencyAndDateOfConversion(
			ForeignCurrency currency, Date dateOfConversion);
	
}
