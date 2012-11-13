package si.kcclass.currencyconverter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import si.kcclass.currencyconverter.domain.ConvertedCurrencyValue;
import si.kcclass.currencyconverter.domain.ForeignCurrency;
import si.kcclass.currencyconverter.domain.ForeignCurrencyToEuroRate;
import si.kcclass.currencyconverter.services.ForeignCurrencyService;
import si.kcclass.currencyconverter.services.ForeignCurrencyToEuroRateService;

@RequestMapping("/currencyconverter/**")
@Controller
public class CurrencyConverter {
	
	@Autowired
	private ForeignCurrencyService foreignCurrencyService;
	
	@Autowired
	private ForeignCurrencyToEuroRateService foreignCurrencyToEuroRateService;
    
    @RequestMapping(value="convert/{fromCurrencySymbol}/{toCurrencySymbol}/{dateCurrency}/{value}", method = RequestMethod.GET)
    public @ResponseBody ConvertedCurrencyValue convert(
    		@PathVariable String fromCurrencySymbol, 
    		@PathVariable String toCurrencySymbol, 
    		@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date dateCurrency, 
    		@PathVariable double value) {
    	ForeignCurrency fromCurrency = foreignCurrencyService.findBySymbol(fromCurrencySymbol);
    	ForeignCurrency toCurrency = foreignCurrencyService.findBySymbol(toCurrencySymbol);
    	ForeignCurrencyToEuroRate fromCurrencyRate = 
    			foreignCurrencyToEuroRateService.findByCurrencyAndDateOfConversion(fromCurrency, dateCurrency);
    	ForeignCurrencyToEuroRate toCurrencyRate =
    			foreignCurrencyToEuroRateService.findByCurrencyAndDateOfConversion(toCurrency, dateCurrency);
    	double convertedValue = value * (fromCurrencyRate.getConversionRate() / toCurrencyRate.getConversionRate());
    	ConvertedCurrencyValue convertedCurrencyValue = new ConvertedCurrencyValue();
    	convertedCurrencyValue.setSymCurrencyFrom(fromCurrencySymbol);
    	convertedCurrencyValue.setSymCurrencyTo(toCurrencySymbol);
    	convertedCurrencyValue.setCurrencyRateDate(dateCurrency);
    	convertedCurrencyValue.setConvertedValue(convertedValue);
    	return convertedCurrencyValue;
    }    
}
