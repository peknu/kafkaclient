package se.sbab.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;
import se.sbab.kafka.event.TntInfoEvent;
import se.sbab.kafka.utils.EventUtils;

import java.io.IOException;

@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${kafka.avro.topic}")
    private String avroTopic;

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void send(TntInfoEvent payload) throws IOException {
        kafkaTemplate.send(avroTopic, "Key", EventUtils.convertToByteArray(payload.getSchema(), payload)).addCallback(
                new ListenableFutureCallback<SendResult<String, byte[]>>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        LOGGER.info("Sending message='{}' to topic='{}' failed with error {}", payload, avroTopic, throwable.getMessage());
                    }

                    @Override
                    public void onSuccess(SendResult<String, byte[]> stringSendResult) {
                        LOGGER.info("Sending message='{}' to topic='{}' succeeded", payload, avroTopic);
                    }
                }
        );
    }
}