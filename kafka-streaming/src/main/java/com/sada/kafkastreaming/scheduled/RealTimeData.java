package com.sada.kafkastreaming.scheduled;

import com.sada.kafkastreaming.rest.BasicData;
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
    @Scheduled(fixedDelay = 1000)
    public void checkApi() {

        RestTemplate restTemplate = new RestTemplate();
        BasicData basicData = restTemplate.getForObject(
                "", BasicData.class);
        log.info(basicData.toString());
        System.out.println(basicData.getPrices().getBtc().getLast());
    }
}
