package com.UsageService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "usage_logs")
public class UsageLog {
    @Id
    private String id;

    private Long userId;

    private Long planId;

    private Double dataUsedInMb;

    private int callMinutesUsed;

    private LocalDateTime timeStamp;
}
