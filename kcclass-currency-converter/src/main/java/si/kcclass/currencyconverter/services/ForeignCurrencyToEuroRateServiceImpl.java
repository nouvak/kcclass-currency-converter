package si.kcclass.currencyconverter.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;
import si.kcclass.currencyconverter.repositories.ForeignCurrencyToEuroRateRepository;

@Service
@Transactional(readOnly=true)
public class ForeignCurrencyToEuroRateServiceImpl implements ForeignCurrencyToEuroRateService {
	
	@Autowired 
	private ForeignCurrencyToEuroRateRepository repository;
	
	@Override
	public ForeignCurrencyToEuroRate findByCurrencyAndDateOfConversion(
			ForeignCurrency currency, Date dateOfConversion) {
		return repository.findByCurrencyAndDateOfConversion(currency, dateOfConversion);
	}

	@Override
	public ForeignCurrencyToEuroRate save(ForeignCurrencyToEuroRate currencyRate) {
		return repository.save(currencyRate);
	}
	
}
