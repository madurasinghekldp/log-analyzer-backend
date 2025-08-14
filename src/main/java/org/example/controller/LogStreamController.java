package org.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
public class LogStreamController {

    @GetMapping(value = "/logs/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamLogs() {
        // Simulated log streaming every 2 seconds
        return Flux.interval(Duration.ofSeconds(2))
                .map(seq -> "Log entry #" + seq);
    }
}