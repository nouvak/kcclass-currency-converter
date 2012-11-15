
package si.kcclass.currencyconverter.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import si.kcclass.currencyconverter.controllers.CurrencyConverter;
import si.kcclass.currencyconverter.domain.ConvertedCurrencyValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})
public class CurrencyConverterTest {
    
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;
    
    Date dateCurrency;
    
	@Before
	public void setUp() throws Exception {
		dateCurrency = new Date();
	}

	@After
	public void tearDown() throws Exception {
	}
    
    @Test
    public void testConvert() throws Exception {
    	CurrencyConverter controller = new CurrencyConverter();
    	ConvertedCurrencyValue value = controller.convert("USD", "EUR", dateCurrency, 1.0);
    	Assert.assertNotNull(value);
    }
    
    @Test
    public void testConvertOnRequest() throws Exception {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	dateCurrency.toString();
        MockHttpServletRequest request = new MockHttpServletRequest(
        		"GET", "/currencyconverter/convert/USD/EUR/" + 
        		df.format(dateCurrency) + "/1.0");

        MockHttpServletResponse response = new MockHttpServletResponse();
        Object handler = handlerMapping.getHandler(request).getHandler();
        ModelAndView mav = handlerAdapter.handle(request, response, handler);
        Assert.assertNull(mav);
        Assert.assertNotNull(response);
        Assert.assertEquals("application/json;charset=UTF-8", response.getContentType());
    }

}
