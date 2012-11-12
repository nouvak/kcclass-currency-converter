package si.kcclass.currencyconverter.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;

public interface ForeignCurrencyToEuroRateRepository extends JpaRepository<ForeignCurrencyToEuroRate, Long> {

	public ForeignCurrencyToEuroRate findByCurrencyAndDateOfConversion(
			ForeignCurrency currency, Date dateOfConversion);
	
}
