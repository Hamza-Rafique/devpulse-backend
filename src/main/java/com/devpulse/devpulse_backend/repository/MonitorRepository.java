package com.devpulse.repository;

import org.springframework.stereotype.Repository;

import com.devpulse.model.Monitor;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class MonitorRepository {

    private final DynamoDbTable<Monitor> monitorTable;

    public MonitorRepository(DynamoDbEnhancedClient enhancedClient) {

        this.monitorTable =
                enhancedClient.table(
                        "Monitors",
                        TableSchema.fromBean(Monitor.class)
                );
    }

    public void save(Monitor monitor) {
        monitorTable.putItem(monitor);
    }
}