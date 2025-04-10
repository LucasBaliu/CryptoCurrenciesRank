package com.conversaocripto.apirest.entities;

import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CryptoCurrency implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String symbol;
    private Integer rank;
    private Boolean isNew;
    private Boolean isActive;
    private String type;

    public CryptoCurrency(){

    }

    public CryptoCurrency(Integer id, String name, String symbol, Integer rank,
                          Boolean isNew, Boolean isActive, String type) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.isNew = isNew;
        this.isActive = isActive;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoCurrency that = (CryptoCurrency) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(symbol, that.symbol) && Objects.equals(rank, that.rank) && Objects.equals(isNew, that.isNew) && Objects.equals(isActive, that.isActive) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, symbol, rank, isNew, isActive, type);
    }
}
