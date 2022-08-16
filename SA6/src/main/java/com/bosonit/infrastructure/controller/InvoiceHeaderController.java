package com.bosonit.infrastructure.controller;

import com.bosonit.application.CacheDataUseCase;
import com.bosonit.application.port.CacheDataPort;
import com.bosonit.infrastructure.dto.DtoRequest;
import com.bosonit.infrastructure.dto.DtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceHeaderController {

    @Autowired
    CacheDataPort cacheDataPort;

    @GetMapping("{id}")
    public ResponseEntity<DtoResponse> get(@PathVariable int id) throws Exception {
        long timeInit = System.currentTimeMillis();
        DtoResponse dtoResponse = cacheDataPort.getDataCache(id);
        long timeEnd = System.currentTimeMillis();
        dtoResponse.setInterval(timeEnd - timeInit);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<DtoResponse> update(@RequestBody DtoRequest dtoRequest) throws Exception {
        cacheDataPort.update(dtoRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/flushcache")
    public String flushCache() {
        cacheDataPort.flushCache();
        return "Cache flushed";
    }
}
