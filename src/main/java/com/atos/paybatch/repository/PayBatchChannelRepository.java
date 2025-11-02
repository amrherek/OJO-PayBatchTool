package com.atos.paybatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.PayBatchChannel;

@Repository
public interface PayBatchChannelRepository extends JpaRepository<PayBatchChannel, Long> {
    Optional<PayBatchChannel> findByChannelCode(String channelCode);

}
