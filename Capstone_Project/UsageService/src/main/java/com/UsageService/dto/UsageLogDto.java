package com.UsageService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsageLogDto {
    private String id;
    private Long userId;
    private Long planId;
    private Double dataUsedInMb;
    private int callMinutesUsed;
    private LocalDateTime timeStamp;
}
