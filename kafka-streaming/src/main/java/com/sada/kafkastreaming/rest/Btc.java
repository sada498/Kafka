package com.sada.kafkastreaming.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Btc {
    private String bid;
    private String ask;
    private String last;
    public Btc(){}

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    @Override
    public String toString(){
        return "BTC{" +
                "Bid= '"+ bid +'\''+
                ",Ask = '" + ask + '\''+
                ",Price = '" + last + '\''+
                '}';
    }
}
