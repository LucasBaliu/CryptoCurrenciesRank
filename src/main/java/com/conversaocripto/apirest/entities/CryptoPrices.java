package com.conversaocripto.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoPrices implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String target;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, BigDecimal> rates;

    public CryptoPrices(){

    }

    public CryptoPrices(String target, Map<String, BigDecimal> rates) {
        this.target = target;
        this.rates = rates;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public BigDecimal getSpecificRates(String symbol) {

        for (Map.Entry<String, BigDecimal> item : this.rates.entrySet()) {
            if (item.getKey().equals(symbol)) {
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoPrices that = (CryptoPrices) o;
        return Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(target);
    }
}
