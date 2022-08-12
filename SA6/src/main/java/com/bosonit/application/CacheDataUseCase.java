package com.bosonit.application;

import com.bosonit.application.port.CacheDataPort;
import com.bosonit.domain.InvoiceHeaderEntity;
import com.bosonit.infrastructure.dto.DtoResponse;
import com.bosonit.infrastructure.repository.jpa.InvoiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class CacheDataUseCase implements CacheDataPort {

    @Autowired
    InvoiceHeaderRepository invoiceHeaderRepository;

    @Override
    @Cacheable(cacheNames = "headers", condition = "#id > 1")
    public DtoResponse getDataCache(int id) throws Exception {
        Thread.sleep(500);
        Optional<InvoiceHeaderEntity> invoiceHeaderEntity = Optional.ofNullable(invoiceHeaderRepository
                .findById(id)
                .orElseThrow(() -> new Exception("No se ha encontrado el ID: " + id)));
        DtoResponse dtoResponse = new DtoResponse();
        if (invoiceHeaderEntity.isPresent()) {
            dtoResponse.setInvoiceHeaderEntity(invoiceHeaderEntity.get());
            dtoResponse.setHttpStatus(HttpStatus.OK);
            return dtoResponse;
        }
        dtoResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        return dtoResponse;
    }

    @CacheEvict(cacheNames = "headers", allEntries = true)
    public void flushCache() {
    }
}