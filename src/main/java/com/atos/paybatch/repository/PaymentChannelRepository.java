package com.atos.paybatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.PaymentChannel;

@Repository
public interface PaymentChannelRepository extends JpaRepository<PaymentChannel, Long> {

    Optional<PaymentChannel> findByChannelCode(String channelCode);
}
