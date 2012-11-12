package si.kcclass.currencyconverter.services;

import si.kcclass.currencyconverter.domain.ForeignCurrency;

public interface ForeignCurrencyService {
	
	public ForeignCurrency findBySymbol(String currencySymbol);
	
}
