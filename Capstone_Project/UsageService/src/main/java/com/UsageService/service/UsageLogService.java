package com.UsageService.service;

import com.UsageService.dto.UsageLogDto;
import com.UsageService.entity.UsageLog;
import com.UsageService.repository.UsageLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsageLogService {

    private final UsageLogRepository usageLogRepository;

    public UsageLog saveUsageLog(UsageLog log) {
        return usageLogRepository.save(log);
    }

    public List<UsageLog> getAllLogs() {
        return usageLogRepository.findAll();
    }

    public List<UsageLogDto> getLogByUserId(Long id) {
        List<UsageLog> logs = usageLogRepository.findByUserId(id);
        return logs.stream()
                .map(log -> new UsageLogDto(log.getId(), log.getUserId(), log.getPlanId(), log.getDataUsedInMb(), log.getCallMinutesUsed(), log.getTimeStamp()))
                .collect(Collectors.toList());
    }

}

