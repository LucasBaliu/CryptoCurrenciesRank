package com.conversaocripto.apirest.entities;

import com.conversaocripto.apirest.service.CryptoCurrencyService;
import com.conversaocripto.apirest.service.CryptoPricesService;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCurrency implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    private Boolean isNew;
    private Boolean isActive;
    private String type;
    private BigDecimal price;

    public CryptoCurrency(){

    }

    public CryptoCurrency(String id, String name, String symbol, Integer rank,
                          Boolean isNew, Boolean isActive, String type) {

        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.isNew = isNew;
        this.isActive = isActive;
        this.type = type;
    }

    @JsonCreator
    public CryptoCurrency(@JsonProperty("price") BigDecimal price) {

        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Boolean getNew() {
        return isNew;
    }

    @JsonProperty("is_new")
    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoCurrency that = (CryptoCurrency) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(symbol, that.symbol)
                && Objects.equals(rank, that.rank) && Objects.equals(isNew, that.isNew) && Objects.equals(isActive,
                that.isActive) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, symbol, rank, isNew, isActive, type);
    }

    @Override
    public String toString() {
        return "CryptoCurrency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rank=" + rank +
                ", isNew=" + isNew +
                ", isActive=" + isActive +
                ", type='" + type + '\'' +
                '}';
    }
}
