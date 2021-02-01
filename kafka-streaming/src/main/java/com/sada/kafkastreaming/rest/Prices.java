package com.sada.kafkastreaming.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("prices")
public class Prices implements Serializable {
    private Btc btc;
    private Xrp xrp;
    private Trx trx;
    public Prices(){}
    @JsonCreator
    public Prices(@JsonProperty("btc") Btc btc, @JsonProperty("xrp") Xrp xrp, @JsonProperty("trx") Trx trx) {
        this.btc = btc;
        this.xrp = xrp;
        this.trx = trx;
    }

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
