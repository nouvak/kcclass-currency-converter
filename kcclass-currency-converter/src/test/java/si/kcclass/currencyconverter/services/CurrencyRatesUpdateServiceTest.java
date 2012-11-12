package si.kcclass.currencyconverter.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import si.kcclass.currencyconverter.services.CurrencyRatesUpdateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})
public class CurrencyRatesUpdateServiceTest {
	
	private CurrencyRatesUpdateService service;

	@Before
	public void setUp() throws Exception {
		service = new CurrencyRatesUpdateService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrencyRates() {
		service.getCurrencyRates();
	}

}
