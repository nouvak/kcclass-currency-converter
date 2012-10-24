package si.kcclass.currencyconverter;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/foreigncurrencys")
@Controller
@RooWebScaffold(path = "foreigncurrencys", formBackingObject = ForeignCurrency.class)
public class ForeignCurrencyController {
}
