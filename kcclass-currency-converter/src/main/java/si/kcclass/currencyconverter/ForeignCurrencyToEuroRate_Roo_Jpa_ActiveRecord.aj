// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package si.kcclass.currencyconverter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import si.kcclass.currencyconverter.ForeignCurrencyToEuroRate;

privileged aspect ForeignCurrencyToEuroRate_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ForeignCurrencyToEuroRate.entityManager;
    
    public static final EntityManager ForeignCurrencyToEuroRate.entityManager() {
        EntityManager em = new ForeignCurrencyToEuroRate().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ForeignCurrencyToEuroRate.countForeignCurrencyToEuroRates() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ForeignCurrencyToEuroRate o", Long.class).getSingleResult();
    }
    
    public static List<ForeignCurrencyToEuroRate> ForeignCurrencyToEuroRate.findAllForeignCurrencyToEuroRates() {
        return entityManager().createQuery("SELECT o FROM ForeignCurrencyToEuroRate o", ForeignCurrencyToEuroRate.class).getResultList();
    }
    
    public static ForeignCurrencyToEuroRate ForeignCurrencyToEuroRate.findForeignCurrencyToEuroRate(Long id) {
        if (id == null) return null;
        return entityManager().find(ForeignCurrencyToEuroRate.class, id);
    }
    
    public static List<ForeignCurrencyToEuroRate> ForeignCurrencyToEuroRate.findForeignCurrencyToEuroRateEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ForeignCurrencyToEuroRate o", ForeignCurrencyToEuroRate.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ForeignCurrencyToEuroRate.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ForeignCurrencyToEuroRate.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ForeignCurrencyToEuroRate attached = ForeignCurrencyToEuroRate.findForeignCurrencyToEuroRate(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ForeignCurrencyToEuroRate.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ForeignCurrencyToEuroRate.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ForeignCurrencyToEuroRate ForeignCurrencyToEuroRate.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ForeignCurrencyToEuroRate merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
