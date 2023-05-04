package com.project.posting.repository;

import com.project.posting.model.Crypto;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Integer> {

    Crypto findByNamaCrypto(String nama);

	void save(Optional<Crypto> crypto);
	
	@Modifying
	@Transactional
	@Query(value="update crypto set jumlah=jumlah-1 where id=? ", nativeQuery=true)
	void penguranganJmlCrypto(Integer id);
	
	@Modifying
	@Transactional
	@Query(value="update crypto set jumlah=jumlah+1 where nama_crypto=? ", nativeQuery=true)
	void tambahJmlCrypto(String cryp);
    

}
