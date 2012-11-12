package si.kcclass.currencyconverter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import si.kcclass.currencyconverter.domain.ForeignCurrency;


@Transactional(readOnly = true)
public interface ForeignCurrencyRepository extends JpaRepository<ForeignCurrency, Long> {
	
	public ForeignCurrency findBySymbol(String currencySymbol);

}
