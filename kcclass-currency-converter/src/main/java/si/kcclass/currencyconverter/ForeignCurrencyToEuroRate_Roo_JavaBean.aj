// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package si.kcclass.currencyconverter;

import java.util.Date;
import si.kcclass.currencyconverter.ForeignCurrency;
import si.kcclass.currencyconverter.ForeignCurrencyToEuroRate;

privileged aspect ForeignCurrencyToEuroRate_Roo_JavaBean {
    
    public ForeignCurrency ForeignCurrencyToEuroRate.getCurrency() {
        return this.currency;
    }
    
    public void ForeignCurrencyToEuroRate.setCurrency(ForeignCurrency currency) {
        this.currency = currency;
    }
    
    public Date ForeignCurrencyToEuroRate.getDateOfConversion() {
        return this.dateOfConversion;
    }
    
    public void ForeignCurrencyToEuroRate.setDateOfConversion(Date dateOfConversion) {
        this.dateOfConversion = dateOfConversion;
    }
    
    public double ForeignCurrencyToEuroRate.getConversionRate() {
        return this.conversionRate;
    }
    
    public void ForeignCurrencyToEuroRate.setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
    
}