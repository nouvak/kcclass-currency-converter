package si.kcclass.currencyconverter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})
public class CurrencyConverterTest {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;
    
    @Test
    public void testConvert() throws Exception {
    	CurrencyConverter controller = new CurrencyConverter();
    	ConvertedCurrencyValue value = controller.convert("USD", "EUR");
    	Assert.assertNotNull(value);
    }
    
    @Test
    public void testConvertOnRequest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest(
        		"GET", "/currencyconverter/convert/USD/EUR");

        MockHttpServletResponse response = new MockHttpServletResponse();
        Object handler = handlerMapping.getHandler(request).getHandler();
        ModelAndView mav = handlerAdapter.handle(request, response, handler);
        Assert.assertNull(mav);
        Assert.assertNotNull(response);
        Assert.assertEquals("application/json;charset=UTF-8", response.getContentType());
    }

}
