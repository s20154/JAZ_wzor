package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Root{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String table;
    private String currency;
    private String code;

    @Column(name="arguments")
    @ElementCollection(targetClass=String.class)
    private List<Rate> rates;

    public Root() {
    }

    public Root(String table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public Root(Long id, String table, String currency, String code, List<Rate> rates) {
        this.id = id;
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
