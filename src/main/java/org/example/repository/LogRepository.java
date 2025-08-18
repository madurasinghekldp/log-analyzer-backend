package org.example.repository;

import org.example.entity.LogEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogRepository extends CassandraRepository<LogEntity, UUID> {
}
