package com.sada.kafkastreaming;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sada.kafkastreaming.rest.BasicData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
@EnableScheduling
public class KafkaStreamingApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    public static void main(String[] args) throws JsonProcessingException {

        Properties props = new Properties();
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

        producer.close();
    }
}

