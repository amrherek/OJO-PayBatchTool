package com.atos.paybatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.entity.PayBatchChannel;

@Repository
public interface PayBatchFileRepository extends JpaRepository<PayBatchFile, Long> {

    List<PayBatchFile> findByStatus(String status);

    List<PayBatchFile> findByChannel(PayBatchChannel channel);

    List<PayBatchFile> findByStatusAndChannel(String status, PayBatchChannel channel);

    boolean existsByFileChecksum(String fileChecksum);

    boolean existsByFileChecksumAndStatus(String fileChecksum, String status);


}
