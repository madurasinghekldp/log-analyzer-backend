package org.example.repository;

import org.example.entity.ErrorLogEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrorLogRepository extends CassandraRepository<ErrorLogEntity, UUID> {
}
