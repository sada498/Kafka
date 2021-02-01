package com.sada.kafkastreaming.scheduled;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sada.kafkastreaming.rest.BasicData;

import com.sada.kafkastreaming.rest.Prices;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Properties;


@Component
public class RealTimeData {
    private static final Logger log = LoggerFactory.getLogger(RealTimeData.class);


    @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }


    @Scheduled(fixedDelay = 10000)
    public void checkApi() throws JsonProcessingException,IOException {

        Properties props = new Properties();
        //Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        ObjectMapper mapper = new ObjectMapper();
        //BasicData basicData = new BasicData();

        RestTemplate restTemplate = new RestTemplate();
        BasicData basicData = restTemplate.getForObject(
                "https://www.coinspot.com.au/pubapi/latest?3bb07d217d7da64a19731109d30a2e01" +
                        "=Y5DN6XAYT9GNQN9L0B71XLL69KREE141KR83PW2KCRCTPF9PZ394ZNJVXRK24CQNWYUB93FTM4QK5UVV", BasicData.class);
        String value = mapper.writeValueAsString(basicData.getPrices().getBtc().toString());
        System.out.println(value);
        producer.send(new ProducerRecord<String, String>("test", "CoinSpot", value));
       // producer.close();

//        RestTemplate restTemplate = new RestTemplate();
//        BasicData basicData = restTemplate.getForObject(
//                "https://www.coinspot.com.au/pubapi/latest?3bb07d217d7da64a19731109d30a2e01" +
//                        "=Y5DN6XAYT9GNQN9L0B71XLL69KREE141KR83PW2KCRCTPF9PZ394ZNJVXRK24CQNWYUB93FTM4QK5UVV", BasicData.class);
//       // log.info(basicData.toString());
//
//        System.out.println("*********"+ " Bitcoin Market Trade "+"****************");
//        System.out.println( "Btc Bid"+ " "+basicData.getPrices().getBtc().getBid());
//        System.out.println();
//        System.out.println("Btc ask"+ " "+basicData.getPrices().getBtc().getAsk());
//        System.out.println();
//        System.out.println("Btc price"+ " "+basicData.getPrices().getBtc().getLast());
//        System.out.println();
//        System.out.println("*********"+ " Ripple Market Trade "+"****************");
//        System.out.println();
//        System.out.println("Xrp Bid"+ " "+basicData.getPrices().getXrp().getBid());
//        System.out.println();
//        System.out.println("Xrp ask"+ " "+basicData.getPrices().getXrp().getAsk());
//        System.out.println();
//        System.out.println("Xrp Price"+ " "+basicData.getPrices().getXrp().getLast());
//        System.out.println();
//        System.out.println("*********"+ " Tron Market Trade "+"****************");
//        System.out.println();
//        System.out.println("Trx Bid"+" "+basicData.getPrices().getTrx().getBid());
//        System.out.println();
//        System.out.println("Trx ask"+ " "+basicData.getPrices().getTrx().getAsk());
//        System.out.println();
//        System.out.println("Trx Price"+ " "+basicData.getPrices().getTrx().getLast());
//        System.out.println("Trx Price"+ " "+basicData.getPrices());
    }
}
