package si.kcclass.currencyconverter;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/currencyconverter/**")
@Controller
public class CurrencyConverter {

    /*@RequestMapping
    public String index() {
        return "currencyconverter/index";
    }*/
    
//    @RequestMapping(value="convert/{fromCurrency}/{toCurrency}/{dateCurrency}/{value}", method = RequestMethod.GET)
//    public @ResponseBody ConvertedCurrencyValue convert(
//    		@PathVariable String fromCurrency, 
//    		@PathVariable String toCurrency, 
//    		@PathVariable Date dateCurrency, 
//    		@PathVariable double value) {

	@RequestMapping(value="convert/{fromCurrency}/{toCurrency}", method = RequestMethod.GET)
    public @ResponseBody ConvertedCurrencyValue convert(
    		@PathVariable String fromCurrency, 
    		@PathVariable String toCurrency) {
    	Date dateCurrency = new Date();
    	double convertedValue = 1.0;
    	ConvertedCurrencyValue convertedCurrencyValue = new ConvertedCurrencyValue();
    	convertedCurrencyValue.setSymCurrencyFrom(fromCurrency);
    	convertedCurrencyValue.setSymCurrencyTo(fromCurrency);
    	convertedCurrencyValue.setCurrencyRateDate(dateCurrency);
    	convertedCurrencyValue.setConvertedValue(convertedValue);
    	return convertedCurrencyValue;
    }    
}
