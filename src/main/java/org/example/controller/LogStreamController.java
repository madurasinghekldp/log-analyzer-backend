package org.example.controller;

import org.example.dto.LogEntry;
import org.example.stream.LogStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LogStreamController {

    private final LogStream stream;

    public LogStreamController(LogStream stream) {
        this.stream = stream;
    }

    // Live stream endpoint
    @GetMapping(value = "/logs/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<LogEntry> streamLogs() {
        // keepAlive helps some proxies keep the connection open
        return stream.flux().mergeWith(Flux.<LogEntry>never())
                .timeout(Duration.ofHours(12)); // long-lived connection
    }
}