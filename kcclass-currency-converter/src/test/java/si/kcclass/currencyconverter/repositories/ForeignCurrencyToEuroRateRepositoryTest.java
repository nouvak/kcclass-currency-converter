package si.kcclass.currencyconverter.repositories;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml"})
@Transactional
public class ForeignCurrencyToEuroRateRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ForeignCurrencyRepository foreignCurrencyRepository;

	@Autowired
	private ForeignCurrencyToEuroRateRepository foreignCurrencyToEuroRateRepository;

	private ForeignCurrency currency;
	private Date dateOfConversion;
	private ForeignCurrencyToEuroRate currencyRate;
	
	@BeforeTransaction
	public void setupData() throws Exception {
		if (countRowsInTable("FOREIGN_CURRENCY") == 0) {
			executeSqlScript("classpath:import.sql", false);
		}
		if (countRowsInTable("FOREIGN_CURRENCY_TO_EURO_RATE") == 0) {
			//executeSqlScript("classpath:import.sql", false);
		}
	}

	@Before
	public void setUp() throws Exception {
		currency = foreignCurrencyRepository.findBySymbol("USD");
		dateOfConversion = new Date();
		
		currencyRate = new ForeignCurrencyToEuroRate();
		currencyRate.setCurrency(currency);
		currencyRate.setDateOfConversion(dateOfConversion);
		currencyRate.setConversionRate(1.0);
		
		foreignCurrencyToEuroRateRepository.save(currencyRate);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByCurrencyAndDateOfConversion() {
		ForeignCurrencyToEuroRate currencyRate = 
				foreignCurrencyToEuroRateRepository.findByCurrencyAndDateOfConversion(
				currency, dateOfConversion);
		assertNotNull(currencyRate);
	}

}
