package se.sbab.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.sbab.kafka.event.TntMessage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/send")
public class Endpoint {
    @Autowired
    private Sender sender;

    @GET
    public String message() {
        TntMessage message = TntMessage.newBuilder()
                .setTimestamp(System.currentTimeMillis())
                .setMessage("Hello from TnT")
                .build();
        sender.send(message);
        return "Hello!!!";
    }
}
