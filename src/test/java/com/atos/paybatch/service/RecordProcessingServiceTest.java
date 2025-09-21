package com.atos.paybatch.service;

import static org.mockito.Mockito.*;

import com.atos.paybatch.dto.PaymentRecordDTO;
import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.repository.PaymentRecordRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RecordProcessingServiceTest {

    @Mock
    private PaymentRecordRepository paymentRecordRepository;


    @InjectMocks
    private RecordProcessingService recordProcessingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessSingleRecord_Valid() {
        PaymentRecordDTO recordDTO = new PaymentRecordDTO();
        recordDTO.setValid(true);

        InboundFile file = new InboundFile();

        boolean result = recordProcessingService.processSingleRecord(recordDTO, file);
        assert(result);
        verify(paymentRecordRepository, times(1)).save(any());
    }

    @Test
    void testProcessSingleRecord_Invalid() {
        PaymentRecordDTO recordDTO = new PaymentRecordDTO();
        recordDTO.setValid(false);
        recordDTO.setError("Invalid");

        InboundFile file = new InboundFile();

        boolean result = recordProcessingService.processSingleRecord(recordDTO, file);
        assert(!result);
        verify(paymentRecordRepository, times(1)).save(any());
    }
}
