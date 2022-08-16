package com.bosonit.domain;

import com.bosonit.infrastructure.dto.DtoRequest;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class InvoiceHeaderEntity {
    private static final long serialVersionUID = 1L;

    @Id
    int id;

    @Column(name = "active")
    String active;

//    @Column(name = "fiscalyear")
//    int fiscalYear;
//
//    @Column(name = "numberinvoice")
//    int numberInvoice;
//
//    @Column(name = "customerid", insertable = false, updatable = false)
//    int customerid;

}
