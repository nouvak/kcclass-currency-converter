package si.kcclass.currencyconverter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import si.kcclass.currencyconverter.domain.ConvertedCurrencyValue;

@RequestMapping("/currencyconverter/**")
@Controller
public class CurrencyConverter {

    /*@RequestMapping
    public String index() {
        return "currencyconverter/index";
    }*/
    
    @RequestMapping(value="convert/{fromCurrency}/{toCurrency}/{dateCurrency}/{value}", method = RequestMethod.GET)
    public @ResponseBody ConvertedCurrencyValue convert(
    		@PathVariable String fromCurrency, 
    		@PathVariable String toCurrency, 
    		@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date dateCurrency, 
    		@PathVariable double value) {
    	double convertedValue = 1.0;
    	ConvertedCurrencyValue convertedCurrencyValue = new ConvertedCurrencyValue();
    	convertedCurrencyValue.setSymCurrencyFrom(fromCurrency);
    	convertedCurrencyValue.setSymCurrencyTo(fromCurrency);
    	convertedCurrencyValue.setCurrencyRateDate(dateCurrency);
    	convertedCurrencyValue.setConvertedValue(convertedValue);
    	return convertedCurrencyValue;
    }    
}
