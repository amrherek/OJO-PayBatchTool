package com.atos.paybatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.paybatch.entity.FileTrailer;

@Repository
public interface FileTrailerRepository extends JpaRepository<FileTrailer, Long> {
}
