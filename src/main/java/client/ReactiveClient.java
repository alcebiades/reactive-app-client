package client;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ReactiveClient implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    public static void main (String[] args) {
        new SpringApplicationBuilder(ReactiveClient.class)
                .properties(Collections.singletonMap("server.port", "8081"))
                .run(args);

    }

    @Override
    public void run (final String... args) throws Exception {
        System.out.println("APLICACAO INICIADA.................");
        clientService.getEvents();
    }
}
