package si.kcclass.currencyconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})
//@Transactional
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
