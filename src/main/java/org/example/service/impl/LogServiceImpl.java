package org.example.service.impl;

import org.example.dto.Log;
import org.example.repository.LogRepository;
import org.example.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository repository;

    public LogServiceImpl(LogRepository repository) {
        this.repository = repository;
    }

    public List<Log> getAllLogs() {
        return repository.findAll().stream()
                .map(entity -> {
                    Log log = new Log();
                    log.setId(entity.getId());
                    log.setTimestamp(entity.getTimestamp());
                    log.setLevel(entity.getLevel());
                    log.setMessage(entity.getMessage());
                    return log;
                })
                .toList();
    }
}
