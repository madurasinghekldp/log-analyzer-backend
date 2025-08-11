package org.example.service.impl;

import org.example.dto.ErrorLog;
import org.example.repository.ErrorLogRepository;
import org.example.service.ErrorLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {

    private final ErrorLogRepository repository;

    public ErrorLogServiceImpl(ErrorLogRepository repository) {
        this.repository = repository;
    }

    public List<ErrorLog> getAllErrorLogs() {
        return repository.findAll().stream()
                .map(entity -> {
                    ErrorLog log = new ErrorLog();
                    log.setId(entity.getId());
                    log.setTimestamp(entity.getTimestamp());
                    log.setLevel(entity.getLevel());
                    log.setMessage(entity.getMessage());
                    return log;
                })
                .toList();
    }
}
