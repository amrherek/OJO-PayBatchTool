package com.atos.paybatch.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.entity.PaymentChannel;
import com.atos.paybatch.repository.FileHeaderRepository;
import com.atos.paybatch.repository.FileTrailerRepository;
import com.atos.paybatch.repository.InboundFileRepository;

class InboundFileServiceTest {

    @Mock
    private InboundFileRepository inboundFileRepository;
    @Mock
    private FileHeaderRepository fileHeaderRepository;
    @Mock
    private FileTrailerRepository fileTrailerRepository;

    @InjectMocks
    private InboundFileService inboundFileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInitInboundFile() {
        PaymentChannel channel = new PaymentChannel();
        InboundFile file = inboundFileService.initInboundFile("test.in");
        verify(inboundFileRepository, times(1)).save(file);
    }

   /*
   *  @Test
    
    void testHandleInvalidFile() {
        InboundFile file = new InboundFile();
        inboundFileService.handleInvalidFile(file, List.of("Error1", "Error2"), null);
        verify(inboundFileRepository, times(1)).save(file);
    }
    */
}
