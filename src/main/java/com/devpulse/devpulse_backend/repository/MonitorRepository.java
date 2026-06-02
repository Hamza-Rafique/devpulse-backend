package com.devpulse.devpulse_backend.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import com.devpulse.devpulse_backend.model.Monitor;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class MonitorRepository {

    private final DynamoDbTable<Monitor> monitorTable;

    public MonitorRepository(
            DynamoDbEnhancedClient enhancedClient,
            @Value("${aws.dynamodb.monitors-table}") String tableName) {

        this.monitorTable = enhancedClient.table(
                tableName,
                TableSchema.fromBean(Monitor.class));
    }

    public void save(Monitor monitor) {
        monitorTable.putItem(monitor);
    }

    public List<Monitor> findAll() {

        List<Monitor> monitors = new ArrayList<>();

        monitorTable.scan().items()
                .forEach(monitors::add);

        return monitors;
    }

}