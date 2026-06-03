package com.devpulse.devpulse_backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.devpulse.devpulse_backend.dto.CreateMonitorRequest;
import com.devpulse.devpulse_backend.model.Monitor;
import com.devpulse.devpulse_backend.service.MonitorService;

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

    @GetMapping
    public List<Monitor> getAllMonitors() {
        return monitorService.getAllMonitors();
    }

    @DeleteMapping("/{monitorId}")
    public String deleteMonitor(
            @PathVariable String monitorId) {

        monitorService.deleteMonitor(monitorId);

        return "Monitor deleted successfully";
    }
}
