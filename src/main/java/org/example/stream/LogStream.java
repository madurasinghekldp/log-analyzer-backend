package org.example.stream;

import org.example.dto.LogEntry;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class LogStream {
    // Multicast to many clients, buffer a few if subscribers are momentarily slower
    private final Sinks.Many<LogEntry> sink = Sinks.many().multicast().onBackpressureBuffer(256);

    public void emit(LogEntry e) { sink.tryEmitNext(e); }
    public reactor.core.publisher.Flux<LogEntry> flux() { return sink.asFlux(); }
}
