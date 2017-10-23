package se.sbab.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.sbab.kafka.event.TntInfoEvent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Path("/send")
public class Endpoint {
    private static final AtomicInteger numRequests = new AtomicInteger();
    @Autowired
    private Sender sender;

    @GET
    public String message() throws IOException {
        int req = numRequests.incrementAndGet();
        TntInfoEvent message = TntInfoEvent.newBuilder()
                .setTimestamp(System.currentTimeMillis())
                .setMessage("Hello from TnT #" + req)
                .build();
        sender.send(message);
        return "Sending request #" + req;
    }
}
