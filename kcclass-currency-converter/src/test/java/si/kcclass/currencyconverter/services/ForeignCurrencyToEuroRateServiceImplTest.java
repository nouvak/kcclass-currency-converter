package si.kcclass.currencyconverter.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;
import si.kcclass.currencyconverter.services.ForeignCurrencyToEuroRateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml"})
@Transactional
public class ForeignCurrencyToEuroRateServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ForeignCurrencyService foreignCurrencyService;
	
	@Autowired
	private ForeignCurrencyToEuroRateService foreignCurrencyToEuroRateService;
	
	Date dateOfConversion = new Date();
	ForeignCurrencyToEuroRate currencyRate;
	ForeignCurrency currency;
		
	@Before
	public void setUp() throws Exception {
		currency = foreignCurrencyService.findBySymbol("USD");
		
		currencyRate = new ForeignCurrencyToEuroRate();
		currencyRate.setCurrency(currency);
		currencyRate.setDateOfConversion(dateOfConversion);
		currencyRate.setConversionRate(1.0);
		
		foreignCurrencyToEuroRateService.save(currencyRate);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindBySymbolAndDate() {
		//Date dateOfConversion = new Date();
		ForeignCurrencyToEuroRate currencyRate =
				foreignCurrencyToEuroRateService.findByCurrencyAndDateOfConversion(
				currency, dateOfConversion);
		assertNotNull(currencyRate);
	}
	
	public void testFindBySymbolAndDateNearest() {
		
	}

}
