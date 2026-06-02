package com.devpulse.devpulse_backend.service;

import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devpulse.devpulse_backend.dto.CreateMonitorRequest;
import com.devpulse.devpulse_backend.model.Monitor;
import com.devpulse.devpulse_backend.repository.MonitorRepository;

@Service
public class MonitorService {

    private final MonitorRepository repository;

    public MonitorService(MonitorRepository repository) {
        this.repository = repository;
    }

    public Monitor createMonitor(CreateMonitorRequest request) {

        Monitor monitor = new Monitor();

        monitor.setMonitorId(UUID.randomUUID().toString());
        monitor.setName(request.getName());
        monitor.setUrl(request.getUrl());
        monitor.setInterval(request.getInterval());

        repository.save(monitor);

        return monitor;
    }
    public List<Monitor> getAllMonitors() {
    return repository.findAll();
    }
}