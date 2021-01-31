package com.sada.kafkastreaming;

import com.sada.kafkastreaming.rest.BasicData;
import com.sada.kafkastreaming.rest.Btc;
import com.sada.kafkastreaming.rest.Prices;
import com.sada.kafkastreaming.rest.Xrp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.awt.*;

@SpringBootApplication
@EnableScheduling
public class KafkaStreamingApplication  {
    private static final Logger log = LoggerFactory.getLogger(KafkaStreamingApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamingApplication.class, args);
          }

}
