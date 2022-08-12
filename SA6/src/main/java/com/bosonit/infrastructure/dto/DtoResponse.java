package com.bosonit.infrastructure.dto;

import com.bosonit.domain.InvoiceHeaderEntity;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DtoResponse {
    long interval;
    HttpStatus httpStatus;
    InvoiceHeaderEntity invoiceHeaderEntity;
}
