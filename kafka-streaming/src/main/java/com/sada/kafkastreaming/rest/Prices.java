package com.sada.kafkastreaming.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Prices {
    private Btc btc;
    private Xrp xrp;
    private Trx trx;
    public Prices(){}

    public Btc getBtc() {
        return btc;
    }

    public void setBtc(Btc btc) {
        this.btc = btc;
    }

    public Xrp getXrp() {
        return xrp;
    }

    public void setXrp(Xrp xrp) {
        this.xrp = xrp;
    }

    public Trx getTrx() {
        return trx;
    }

    public void setTrx(Trx trx) {
        this.trx = trx;
    }

    @Override
    public  String toString(){
        return "Prices{" +
                "btc= '"+ btc +'\''+
                ",xrp = '" + xrp + '\''+
                ",TRX= '"+ trx  +'\''+
                '}';

    }
}
