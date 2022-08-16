package com.bosonit.application;

import com.bosonit.application.port.CacheDataPort;
import com.bosonit.domain.InvoiceHeaderEntity;
import com.bosonit.infrastructure.dto.DtoRequest;
import com.bosonit.infrastructure.dto.DtoResponse;
import com.bosonit.infrastructure.repository.jpa.InvoiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CacheDataUseCase implements CacheDataPort {

    @Autowired
    InvoiceHeaderRepository invoiceHeaderRepository;

//    public DtoResponse crearEntity(DtoRequest dtoRequest) {
//        DtoResponse dtoResponse = new DtoResponse();
//    }

    @Override
    @Cacheable(cacheNames = "headers", condition = "#id > 1")
    public DtoResponse getDataCache(int id) throws Exception {
        Thread.sleep(500);
        Optional<InvoiceHeaderEntity> invoiceHeaderEntity = invoiceHeaderRepository.findById(id);
        DtoResponse dtoResponse = new DtoResponse();
        if (invoiceHeaderEntity.isPresent()) {
            dtoResponse.setInvoiceHeaderEntity(invoiceHeaderEntity.get());
            dtoResponse.setHttpStatus(HttpStatus.OK);
            return dtoResponse;
        }
        dtoResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        return dtoResponse;
    }

    @Override
    @CacheEvict(cacheNames = "headers", allEntries = true)
    public void flushCache() {
    }

    @Override
    @CachePut(cacheNames = "headers", key = "#dtoRequest.id")
    public DtoResponse update(DtoRequest dtoRequest) {
        DtoResponse dtoResponse = new DtoResponse();
        Optional<InvoiceHeaderEntity> invoiceHeaderEntityOptional = invoiceHeaderRepository.findById(dtoRequest.getId());
        if (!invoiceHeaderEntityOptional.isPresent()) {
            dtoResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            return dtoResponse;
        }
        InvoiceHeaderEntity invoiceHeaderEntity = new InvoiceHeaderEntity();
        invoiceHeaderEntity.setActive(dtoRequest.getActive());
        invoiceHeaderRepository.save(invoiceHeaderEntity);

        dtoResponse.setInvoiceHeaderEntity(invoiceHeaderEntity);
        dtoResponse.setHttpStatus(HttpStatus.OK);
        return dtoResponse;
    }
}