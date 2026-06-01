package com.devpulse.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devpulse.dto.CreateMonitorRequest;
import com.devpulse.model.Monitor;
import com.devpulse.repository.MonitorRepository;

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
}