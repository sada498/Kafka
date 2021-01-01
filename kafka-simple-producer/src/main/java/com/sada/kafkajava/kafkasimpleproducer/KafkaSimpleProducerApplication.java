package com.sada.kafkajava.kafkasimpleproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import java.util.Arrays;
import java.time.Duration;

@SpringBootApplication
public class KafkaSimpleProducerApplication {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 100; i++) {
			producer.send(new ProducerRecord<String, String>("count-topic", "count", Integer.toString(i)));
		}
		producer.close();
	}
}
