package org.example.service;

import org.example.dto.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
    List<Log> getAllLogs();
}
