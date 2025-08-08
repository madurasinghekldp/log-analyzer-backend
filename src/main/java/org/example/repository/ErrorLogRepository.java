package org.example.repository;

import org.example.entity.ErrorLogEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ErrorLogRepository extends CassandraRepository<ErrorLogEntity, UUID> {
}
