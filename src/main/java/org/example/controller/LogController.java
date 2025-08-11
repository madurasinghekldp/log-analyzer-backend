package org.example.controller;

import org.example.dto.ErrorLog;
import org.example.service.ErrorLogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin
public class LogController {

    private final ErrorLogService errorLogService;

    public LogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @GetMapping
    public List<ErrorLog> getAllLogs() {
        return errorLogService.getAllErrorLogs();
    }
}
