package org.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class SimpleLogProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        String[] levels = {"INFO", "DEBUG", "WARN", "ERROR"};

        for (int i = 0; i < 20; i++) {
            String level = levels[new Random().nextInt(levels.length)];
            //String message = "{\"level\":\"INFO\",\"timestamp\":\"" + System.currentTimeMillis() + "\",\"message\":\"Test log " + i + "\"}";
            long timestamp = System.currentTimeMillis();
            String jsonMessage = String.format("{\"level\":\"%s\",\"timestamp\":\"%d\",\"message\":\"Test log %d\"}", level, timestamp, i);
            producer.send(new ProducerRecord<>("logs", jsonMessage));
        }

        producer.close();
    }
}

