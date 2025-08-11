package org.example.service;

import org.example.dto.ErrorLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ErrorLogService {
    List<ErrorLog> getAllErrorLogs();
}
