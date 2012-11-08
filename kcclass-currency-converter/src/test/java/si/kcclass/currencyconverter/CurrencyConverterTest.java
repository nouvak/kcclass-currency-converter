package si.kcclass.currencyconverter;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/webmvc-config-test.xml"})
public class CurrencyConverterTest {

    @Autowired
    private ApplicationContext applicationContext;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private RequestMappingHandlerAdapter handlerAdapter;
    private CurrencyConverter controller;
    
    @Before
    public void setUp() {
       request = new MockHttpServletRequest();
       response = new MockHttpServletResponse();
       
       handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
       // I could get the controller from the context here
       controller = new CurrencyConverter();
    }
    
    @Test
    public void testMethod() throws Exception {
    	final String expectedMessage = "Hello jack, from the controller";
        final String requestUri = "/kcclass-currency-converter/currencyconverter/convert/USD/EUR";
        final String message;
        final Object handler;
        final HandlerMethod expectedHandlerMethod;
        final ModelAndView mav;
        final MockHttpServletRequest request;
        final MockHttpServletResponse response;

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

        request.setRequestURI(requestUri);
        
        expectedHandlerMethod = new HandlerMethod(controller, "convert", String.class, String.class);
        handler = this.getHandler(request);
        // For the most part we will be expecting HandlerMethod objects to be returned for our controllers.
        // Calling the to string method will print the complete method signature.
        Assert.assertEquals("Correct handler found for request url: " + requestUri, expectedHandlerMethod.toString(), handler.toString());
        
        // Handle the actual request
        mav = handlerAdapter.handle(request, response, handler);

        // Ensure that the right view is returned
        ModelAndViewAssert.assertViewName(mav, "message-show");
        // Ensure that the view will receive the message object and that it is
        // a string
        message = ModelAndViewAssert.assertAndReturnModelAttributeOfType(mav, "message", String.class);
        // We can test the message in case
        Assert.assertEquals(("Message returned was " + expectedMessage), expectedMessage, message);
    }

    /**
     * This method finds the handler for a given request URI. 
     * 
     * It will also ensure that the URI Parameters i.e. /context/test/{name} are added to the request
     * 
     * @param request
     * @return 
     * @throws Exception
     */
    private Object getHandler(MockHttpServletRequest request) throws Exception {
        HandlerExecutionChain chain = null;

        Map<String, HandlerMapping> map = applicationContext.getBeansOfType(HandlerMapping.class);
        Iterator<HandlerMapping> itt = map.values().iterator();

        while (itt.hasNext()) {
            HandlerMapping mapping = itt.next();
            chain = mapping.getHandler(request);
            if (chain != null) {
                break;
            }
        }
        if (chain == null) {
            throw new InvalidParameterException("Unable to find handler for request URI: " + request.getRequestURI());
        }
        return chain.getHandler();
    }
}
