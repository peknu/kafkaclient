package se.sbab.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class Endpoint {
    @Autowired
    private Sender sender;

    @GET
    public String message() {
        sender.send("test", "hello");
        return "Hello!!!";
    }
}
