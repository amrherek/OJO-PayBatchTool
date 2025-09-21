package com.atos.paybatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.entity.PaymentChannel;

@Repository
public interface InboundFileRepository extends JpaRepository<InboundFile, Long> {

    List<InboundFile> findByStatus(String status);

    List<InboundFile> findByChannel(PaymentChannel channel);

    List<InboundFile> findByStatusAndChannel(String status, PaymentChannel channel);

    boolean existsByFileChecksum(String fileChecksum);

    boolean existsByFileChecksumAndStatus(String fileChecksum, String status);


}
