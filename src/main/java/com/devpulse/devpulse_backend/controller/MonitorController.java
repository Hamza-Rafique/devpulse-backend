package com.devpulse.controller;

import org.springframework.web.bind.annotation.*;

import com.devpulse.dto.CreateMonitorRequest;
import com.devpulse.model.Monitor;
import com.devpulse.service.MonitorService;

@RestController
@RequestMapping("/monitors")
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PostMapping
    public Monitor createMonitor(
            @RequestBody CreateMonitorRequest request) {

        return monitorService.createMonitor(request);
    }
}