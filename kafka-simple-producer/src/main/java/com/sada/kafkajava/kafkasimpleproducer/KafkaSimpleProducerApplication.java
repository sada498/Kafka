package com.sada.kafkajava.kafkasimpleproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sada.kafkajava.kafkasimpleproducer.model.CityTemp;
import com.sun.jmx.snmp.Timestamp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.kafka.clients.producer.*;

import java.util.*;
import java.time.Duration;

@SpringBootApplication
public class KafkaSimpleProducerApplication {

	public static void main(String[] args) throws JsonProcessingException {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<>(props);

		//Define list of Products
		List<String> city = new ArrayList<String>();
		city.add("Melbourne");
		city.add("Cairns");
		city.add("Adelaide");
		city.add("Brisbane");
		city.add("Perth");
		city.add("Canberra");
		city.add("Darwin");

		//Define list of Prices. Matches the corresponding products
		List<String> temp = new ArrayList<String>();
		temp.add("32");
		temp.add("25");
		temp.add("30");
		temp.add("14");
		temp.add("28");
		temp.add("16");
		temp.add("19");

		//Define a random number generator
		Random random = new Random();

		ObjectMapper mapper = new ObjectMapper();

		for (int i = 0; i < 100; i++) {
			CityTemp cityTemp=new CityTemp();

			//Generate a random city
			int randomCity=random.nextInt(city.size());
			cityTemp.setCity(city.get(randomCity));

			int randomTemp=random.nextInt(temp.size());
			cityTemp.setTemp(temp.get(randomTemp));

			String value = mapper.writeValueAsString(cityTemp);

			Timestamp timestamp=new Timestamp();
			System.out.println(timestamp);


			producer.send(new ProducerRecord<String,String >("AU-weather-report","Australia", value));

		}
		producer.close();
	}
}
