package edu.icet.dto;

import jakarta.validation.constraints.NotNull;


public class AuditLogDto {

    @NotNull(message = "Request ID is required")
    private Integer logId;
    @NotNull(message = "Timestamp is required")
    private String timestamp;

}
