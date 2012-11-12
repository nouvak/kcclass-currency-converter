package si.kcclass.currencyconverter.repositories;

import static org.junit.Assert.*;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml"})
@Transactional
public class ForeignCurrencyRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private ForeignCurrencyRepository foreignCurrencyRepository;
	
	@BeforeTransaction
	public void setupData() throws Exception {
		if (countRowsInTable("FOREIGN_CURRENCY") == 0) {
			executeSqlScript("classpath:import.sql", false);
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindBySymbol() {
		ForeignCurrency currency = foreignCurrencyRepository.findBySymbol("USD");
		assertNotNull(currency);
	}

}
