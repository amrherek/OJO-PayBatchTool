package com.atos.paybatch.service.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.paybatch.entity.PayBatchFile;
import com.atos.paybatch.repository.PayBatchFileRepository;

/**
 * Repository tests using @DataJpaTest and H2 in-memory database.
 */
@DataJpaTest
public class InboundFileRepositoryTest {

    @Autowired
    private PayBatchFileRepository inboundFileRepository;

    @Test
    void testSaveInboundFile() {
        PayBatchFile file = new PayBatchFile();
        file.setFilename("testfile.in");
        file.setStatus("I");

        inboundFileRepository.save(file);

        List<PayBatchFile> files = inboundFileRepository.findAll();
        assertFalse(files.isEmpty(), "InboundFile should be saved in DB");
        assertEquals("testfile.in", files.get(0).getFilename());
    }
}
