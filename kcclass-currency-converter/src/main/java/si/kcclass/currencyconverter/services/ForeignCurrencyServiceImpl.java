package si.kcclass.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.repositories.ForeignCurrencyRepository;

@Service
@Transactional(readOnly=true)
public class ForeignCurrencyServiceImpl implements ForeignCurrencyService {

	@Autowired
	private ForeignCurrencyRepository repository;

	@Override
	public ForeignCurrency findBySymbol(String currencySymbol) {
		return repository.findBySymbol(currencySymbol);
	}

}
