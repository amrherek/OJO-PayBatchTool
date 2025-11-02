package com.atos.paybatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.PayBatchTrailer;

@Repository
public interface PayBatchFileTrailerRepository extends JpaRepository<PayBatchTrailer, Long> {
}
