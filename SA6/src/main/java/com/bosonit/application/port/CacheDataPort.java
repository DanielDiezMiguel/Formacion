package com.bosonit.application.port;

import com.bosonit.infrastructure.dto.DtoRequest;
import com.bosonit.infrastructure.dto.DtoResponse;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface CacheDataPort {
    @Cacheable(cacheNames = "headers", condition = "#id > 1")
    DtoResponse getDataCache(int id) throws Exception;

    @CacheEvict(cacheNames = "headers", allEntries = true)
    void flushCache();

    @CachePut(cacheNames = "headers", key = "#dtoRequest.id")
    DtoResponse update(DtoRequest dtoRequest);
}
