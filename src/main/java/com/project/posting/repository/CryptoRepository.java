package com.project.posting.repository;

import com.project.posting.model.Crypto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, Integer> {

    Crypto findByNamaCrypto(String nama);

	void save(Optional<Crypto> crypto);
    

}
