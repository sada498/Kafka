package com.sada.kafkastreaming.Producer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sada.kafkastreaming.rest.Prices;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProduceData {


    public static void main(String[] argv) throws Exception {
        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.connect.json.JsonSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

        ObjectMapper objectMapper = new ObjectMapper();

Prices prices=new Prices();
            JsonNode jsonNode = objectMapper.valueToTree(prices);
            ProducerRecord<String, JsonNode> rec = new ProducerRecord<String, JsonNode>("test", jsonNode);
            producer.send(rec);


                producer.close();
    }
}


//    public static org.apache.kafka.clients.producer.Producer<String, Prices> getProducer() {
//        Properties configProperties = new Properties();
//        configProperties.put(ProducerConfig.CLIENT_ID_CONFIG,
//                "kafka json producer");
//        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "localhost:9092");
//        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                "org.apache.kafka.common.serialization.ByteArraySerializer");
//        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                "com.kafka.api.serdes.JsonSerializer");
//
//        org.apache.kafka.clients.producer.Producer<String, Prices> producer = new KafkaProducer<String, Prices>(
//                configProperties);
//        return producer;
//    }
//
//    public ProducerRecord<String, Prices> createRecord(Prices prices) {
//        ProducerRecord<String, Prices> record = new ProducerRecord<String, Prices>(
//                "test", prices);
//        return record;
//    }
//
//}
