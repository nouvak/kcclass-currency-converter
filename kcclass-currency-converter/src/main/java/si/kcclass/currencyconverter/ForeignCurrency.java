package si.kcclass.currencyconverter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ForeignCurrency {

    @NotNull
    @Column(unique = true)
    private String symbol;

    @NotNull
    private String name;
}
