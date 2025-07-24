package com.UsageService.controller;

import com.UsageService.dto.UsageLogDto;
import com.UsageService.entity.UsageLog;
import com.UsageService.service.UsageLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/usage")
@RequiredArgsConstructor

public class UsageController {

    private final UsageLogService usageLogService;

    @GetMapping("/all")
    public List<UsageLog> getAllLogs() {
        return usageLogService.getAllLogs();
    }

    @GetMapping("/log/{id}")
    public ResponseEntity<List<UsageLogDto>> getLogByUserId(@PathVariable Long id){
        return ResponseEntity.ok(usageLogService.getLogByUserId(id));
    }

}
