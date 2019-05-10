package client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ClientService {

    private final String BASE_URL = "http://localhost:8080";

    public void getEvents () {

        WebClient client = WebClient.create(BASE_URL);

        ParameterizedTypeReference<ServerSentEvent<String>> type = new ParameterizedTypeReference<ServerSentEvent<String>>() {

        };

        Flux<ServerSentEvent<String>> eventStream = client.get().uri("/events").retrieve().bodyToFlux(type);

        eventStream.subscribe(content -> {
            System.out.println(content.data());
        });
    }
}
