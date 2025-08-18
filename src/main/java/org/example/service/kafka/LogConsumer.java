package org.example.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.StreamLog;
import org.example.stream.LogStream;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
    private final ObjectMapper mapper;
    private final LogStream stream;

    public LogConsumer(ObjectMapper mapper, LogStream stream) {
        this.mapper = mapper;
        this.stream = stream;
    }

    @KafkaListener(topics = "logs") // same topic your producer uses
    public void onMessage(String value) {
        try {
            // value is the JSON your producer sent
            StreamLog e = mapper.readValue(value, StreamLog.class);

            // Optional: only push certain levels to the UI
            // if (!"ERROR".equalsIgnoreCase(e.getLevel())) return;

            stream.emit(e);
        } catch (Exception ex) {
            // log & skip bad messages
            ex.printStackTrace();
        }
    }
}
