package org.example.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.StreamLog;
import org.example.entity.LogEntity;
import org.example.repository.LogRepository;
import org.example.stream.LogStream;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
    private final ObjectMapper mapper;
    private final LogStream stream;
    private final LogRepository logRepository;

    public LogConsumer(ObjectMapper mapper, LogStream stream, LogRepository logRepository) {
        this.mapper = mapper;
        this.stream = stream;
        this.logRepository = logRepository;
    }

    @KafkaListener(topics = "logs") // same topic your producer uses
    public void onMessage(String value) {
        try {
            // Parse JSON into DTO
            StreamLog dto = mapper.readValue(value, StreamLog.class);

            // 1. Save into Cassandra
            LogEntity entry = new LogEntity();
            entry.setLevel(dto.getLevel());
            entry.setMessage(dto.getMessage());
            entry.setTimestamp(dto.getTimestamp());
            logRepository.save(entry);

            // 2. Emit to SSE/Flux subscribers
            stream.emit(dto);
        } catch (Exception ex) {
            // log & skip bad messages
            ex.printStackTrace();
        }
    }
}
