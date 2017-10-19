package se.sbab.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import se.sbab.kafka.event.TntMessage;

@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${kafka.avro.topic}")
    private String avroTopic;

    @Autowired
    private KafkaTemplate<String, TntMessage> kafkaTemplate;

    void send(TntMessage payload) {
        LOGGER.info("sending message='{}' to topic='{}'", payload, avroTopic);
        kafkaTemplate.send(avroTopic, "Key", payload);
    }
}