package si.kcclass.currencyconverter.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;

public interface ForeignCurrencyToEuroRateRepository extends JpaRepository<ForeignCurrencyToEuroRate, Long> {
	
	@Query("select r from ForeignCurrencyToEuroRate r where r.currency = :currency and " +
			"r.dateOfConversion between DATEADD(dd, -1, :dateOfConversion) and " +
			"DATEADD(dd, 1, :dateOfConversion) order by ABS(DATEDIFF (dd , :dateOfConversion , r.dateOfConversion))")
	ForeignCurrencyToEuroRate findByCurrencyAndDateOfConversion(
			@Param("currency") ForeignCurrency currency, 
			@Param("dateOfConversion") Date dateOfConversion);
	
	public List<ForeignCurrencyToEuroRate> findByCurrency(ForeignCurrency currency);

	
}
