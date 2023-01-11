package com.xxnbr;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {
    static Logger logger = LoggerFactory.getLogger(Producer.class);

    public static void main(String[] args) {

        var properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        var producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i <= 1000; i++) {
            producer.send(new ProducerRecord<>("test-1", "MSG = " + i));
        }

        producer.close();

    }
}
