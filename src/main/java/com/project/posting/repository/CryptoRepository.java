package com.project.posting.repository;

import com.project.posting.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, Integer> {

    Crypto findByNamaCrypto(String nama);
}
