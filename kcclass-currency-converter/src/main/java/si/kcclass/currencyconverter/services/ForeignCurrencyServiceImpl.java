package si.kcclass.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.repositories.ForeignCurrencyRepository;

@Repository
@Transactional(readOnly=true)
public class ForeignCurrencyServiceImpl implements ForeignCurrencyService {

	/*@PersistenceContext
	private EntityManager em;*/
	
	@Autowired
	private ForeignCurrencyRepository repository;

	@Override
	public ForeignCurrency findBySymbol(String currencySymbol) {
	    /*TypedQuery<ForeignCurrency> query = 
	    		em.createQuery("select c from ForeignCurrency c where r.symbol = ?1", 
	    		ForeignCurrency.class);
	    query.setParameter(1, currencySymbol);
	    return query.getSingleResult();*/
		return repository.findBySymbol(currencySymbol);
	}

}
