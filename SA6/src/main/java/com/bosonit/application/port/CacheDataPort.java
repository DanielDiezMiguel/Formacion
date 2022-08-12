package com.bosonit.application.port;

import com.bosonit.infrastructure.dto.DtoResponse;
import org.springframework.cache.annotation.Cacheable;

public interface CacheDataPort {
    @Cacheable(cacheNames = "headers", condition = "#id > 1")
    DtoResponse getDataCache(int id) throws Exception;
}
