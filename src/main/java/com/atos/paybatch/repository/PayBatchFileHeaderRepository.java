package com.atos.paybatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.PayBatchHeader;

@Repository
public interface PayBatchFileHeaderRepository extends JpaRepository<PayBatchHeader, Long> {
}
