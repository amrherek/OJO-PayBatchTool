package com.atos.paybatch.service.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.paybatch.entity.InboundFile;
import com.atos.paybatch.repository.InboundFileRepository;

/**
 * Repository tests using @DataJpaTest and H2 in-memory database.
 */
@DataJpaTest
public class InboundFileRepositoryTest {

    @Autowired
    private InboundFileRepository inboundFileRepository;

    @Test
    void testSaveInboundFile() {
        InboundFile file = new InboundFile();
        file.setFilename("testfile.in");
        file.setStatus("I");

        inboundFileRepository.save(file);

        List<InboundFile> files = inboundFileRepository.findAll();
        assertFalse(files.isEmpty(), "InboundFile should be saved in DB");
        assertEquals("testfile.in", files.get(0).getFilename());
    }
}
