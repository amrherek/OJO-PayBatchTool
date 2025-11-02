package com.atos.paybatch.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.entity.PayBatchChannel;
import com.atos.paybatch.repository.PayBatchFileHeaderRepository;
import com.atos.paybatch.repository.PayBatchFileTrailerRepository;
import com.atos.paybatch.repository.PayBatchFileRepository;

class InboundFileServiceTest {

    @Mock
    private PayBatchFileRepository inboundFileRepository;
    @Mock
    private PayBatchFileHeaderRepository fileHeaderRepository;
    @Mock
    private PayBatchFileTrailerRepository fileTrailerRepository;

    @InjectMocks
    private FileHandlerService inboundFileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInitInboundFile() {
        PayBatchChannel channel = new PayBatchChannel();
        PayBatchFile file = inboundFileService.initFile("test.in");
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
