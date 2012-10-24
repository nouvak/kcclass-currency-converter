package si.kcclass.currencyconverter;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/foreigncurrencytoeuroconversions")
@Controller
@RooWebScaffold(path = "foreigncurrencytoeuroconversions", formBackingObject = ForeignCurrencyToEuroConversion.class)
public class ForeignCurrencyToEuroConversionController {
}
