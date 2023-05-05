package com.project.posting.controller;

import com.project.posting.dto.ResponseDto;
import com.project.posting.model.Crypto;
import com.project.posting.model.CryptoUser;
import com.project.posting.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("crypto")
public class CryptoController {

    @Autowired
    CryptoService service;

    @PostMapping
    public ResponseEntity<ResponseDto> addCrypto(
            @RequestBody Crypto crypto
    ){
        return ResponseEntity.ok(service.add(crypto));
    }

    @GetMapping
    public ResponseEntity<List<Crypto>> listCrypto(){
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Crypto>> detailCrypto(@PathVariable Integer id){
        return ResponseEntity.ok(service.detail(id));
    }

    @GetMapping("/nama/{nama}")
    public ResponseEntity<Crypto> detailCrypto(@PathVariable String nama){
        return ResponseEntity.ok(service.detail(nama));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCrypto(@PathVariable Integer id, @RequestBody Crypto crypto){
        return ResponseEntity.ok(service.update(id, crypto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCrypto(@PathVariable Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
    
    @PutMapping("/min/{id}")
    public ResponseEntity<ResponseDto> updateJumlahCrypto(@PathVariable Integer id, @RequestBody Crypto crypto){
        return ResponseEntity.ok(service.updateJumlahCryp(id, crypto));
    }
    
    @PutMapping("/plus/{id}")
    public ResponseEntity<ResponseDto> tambahJumlahCrypto(@PathVariable Integer id, @RequestBody CryptoUser cryptoUser){
    	String cryp = cryptoUser.getNamaCrypto();
        return ResponseEntity.ok(service.tambahJumlahCryp(cryp, cryptoUser));
    }
}
