package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("error_logs")
@Getter
@Setter
@ToString
public class ErrorLogEntity {

    @PrimaryKey
    private UUID id;
    private String timestamp;
    private String level;
    private String message;
}
