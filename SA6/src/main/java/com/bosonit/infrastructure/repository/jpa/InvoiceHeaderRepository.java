package com.bosonit.infrastructure.repository.jpa;

import com.bosonit.domain.InvoiceHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeaderEntity, Integer> {
}
