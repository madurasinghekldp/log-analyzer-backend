package org.example.service.impl;

import org.example.repository.ErrorLogRepository;
import org.example.service.ErrorLogService;

public class ErrorLogServiceImpl implements ErrorLogService {

    private final ErrorLogRepository repository;

    public ErrorLogServiceImpl(ErrorLogRepository repository) {
        this.repository = repository;
    }
}
