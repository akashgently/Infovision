package com.UsageService.repository;

import com.UsageService.entity.UsageLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageLogRepository extends MongoRepository<UsageLog, String> {
    List<UsageLog> findByUserId(Long userId);
}
