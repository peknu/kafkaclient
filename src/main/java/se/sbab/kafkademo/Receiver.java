package se.sbab.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import se.sbab.kafka.event.TntInfoEvent;
import se.sbab.kafka.utils.EventUtils;

import java.io.IOException;

@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${kafka.avro.topic}")
    public void receive(byte[] event, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException {
        TntInfoEvent message = EventUtils.convertToEvent(event, TntInfoEvent.getClassSchema());
        LOGGER.info("received key='{}' message='{}'", key, message);
    }
}
