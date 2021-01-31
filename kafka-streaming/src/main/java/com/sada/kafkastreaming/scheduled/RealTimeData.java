package com.sada.kafkastreaming.scheduled;

import com.sada.kafkastreaming.rest.BasicData;
import com.sada.kafkastreaming.rest.Trx;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class RealTimeData {
    private static final Logger log = LoggerFactory.getLogger(RealTimeData.class);
    @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }
    @Scheduled(fixedDelay = 10000)
    public void checkApi() {

        RestTemplate restTemplate = new RestTemplate();
        BasicData basicData = restTemplate.getForObject(
                "", BasicData.class);
        log.info(basicData.toString());

        System.out.println("*********"+ " Bitcoin Market Trade "+"****************");
        System.out.println( "Btc Bid"+ " "+basicData.getPrices().getBtc().getBid());
        System.out.println();
        System.out.println("Btc ask"+ " "+basicData.getPrices().getBtc().getAsk());
        System.out.println();
        System.out.println("Btc price"+ " "+basicData.getPrices().getBtc().getLast());
        System.out.println();
        System.out.println("*********"+ " Ripple Market Trade "+"****************");
        System.out.println();
        System.out.println("Xrp Bid"+ " "+basicData.getPrices().getXrp().getBid());
        System.out.println();
        System.out.println("Xrp ask"+ " "+basicData.getPrices().getXrp().getAsk());
        System.out.println();
        System.out.println("Xrp Price"+ " "+basicData.getPrices().getXrp().getLast());
        System.out.println();
        System.out.println("*********"+ " Tron Market Trade "+"****************");
        System.out.println();
        System.out.println("Trx Bid"+" "+basicData.getPrices().getTrx().getBid());
        System.out.println();
        System.out.println("Trx ask"+ " "+basicData.getPrices().getTrx().getAsk());
        System.out.println();
        System.out.println("Trx Price"+ " "+basicData.getPrices().getTrx().getLast());
        System.out.println("Trx Price"+ " "+basicData.getPrices());








    }
}
