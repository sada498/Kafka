package com.sada.kafkastreaming.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicData {
    private String status;
    private Prices prices;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    @Override
    public  String toString(){
        return "BasicData{" +
                "status= '"+ status +'\''+
                ",price = '" + prices + '\''+
                '}';

    }
}
