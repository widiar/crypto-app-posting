package com.project.posting.service;

import com.project.posting.config.LoggingConfig;
import com.project.posting.dto.ResponseDto;
import com.project.posting.model.Crypto;
import com.project.posting.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptoService {

    @Autowired
    CryptoRepository cryptoRepository;
    
    @Autowired
    private LoggingConfig logCryp;

    public ResponseDto add(Crypto crypto){
        Crypto cekCrypto = cryptoRepository.findByNamaCrypto(crypto.getNamaCrypto());
        ResponseDto response = new ResponseDto();
        if (cekCrypto != null) {
            response.setMessage("Crypto sudah ada");
            response.setStatus("failed");
        }else{
            cryptoRepository.save(crypto);
            response.setSuccess();
        }
        return response;
    }

    public List<Crypto> list(){
        return cryptoRepository.findAll();
    }

    public Optional<Crypto> detail(Integer id){
        return cryptoRepository.findById(id);
    }

    public ResponseDto update(Integer id, Crypto crypto){
        Optional<Crypto> oldCrypto = cryptoRepository.findById(id);
        ResponseDto responseDto = new ResponseDto();
        if (oldCrypto.isPresent()) {
            Crypto crypto1 = oldCrypto.get();

            Crypto checkCrypto = cryptoRepository.findByNamaCrypto(crypto.getNamaCrypto());
            if (checkCrypto != null) {
                if (crypto1.getId().equals(checkCrypto.getId())){
                    crypto1.setNamaCrypto(crypto.getNamaCrypto());
                    crypto1.setJumlah(crypto.getJumlah());
                    crypto1.setHarga(crypto.getHarga());
                    cryptoRepository.save(crypto1);
                    responseDto.setSuccess();
                }else{
                    responseDto.setStatus("failed");
                    responseDto.setMessage("Nama crypto sudah ada");
                }
            }else{
                crypto1.setNamaCrypto(crypto.getNamaCrypto());
                crypto1.setJumlah(crypto.getJumlah());
                crypto1.setHarga(crypto.getHarga());
                cryptoRepository.save(crypto1);
                responseDto.setSuccess();
            }

        }else {
            responseDto.setStatus("failed");
            responseDto.setMessage("Crypto tidak ada");
        }
        return responseDto;
    }

    public ResponseDto delete(Integer id){
        ResponseDto responseDto = new ResponseDto();
        cryptoRepository.deleteById(id);
        responseDto.setSuccess();
        return responseDto;
    }
    
    public ResponseDto updateJumlahCryp(Integer id, Crypto crypto) {
    	ResponseDto responseDto = new ResponseDto();
    	try {
    		cryptoRepository.penguranganJmlCrypto(id);
        	responseDto.setSuccess();
        	logCryp.logCrypPost.info("Pengurangan Jumlah Crypto "+crypto.getNamaCrypto()+" Sukses.");
        	return responseDto;
    	} catch (Exception e) {
			logCryp.logCrypPost.error("Error pengurangan jumlah crypto: "+e);
    		responseDto.setMessage("gagal");
    		return responseDto;
		}
    }
    
    public ResponseDto tambahJumlahCryp(String cryp) {
    	ResponseDto responseDto = new ResponseDto();
    	try {
    		cryptoRepository.tambahJmlCrypto(cryp);
        	responseDto.setSuccess();
        	logCryp.logCrypPost.info("Penambahan Jumlah Crypto "+cryp+" Sukses.");
        	return responseDto;
    	} catch (Exception e) {
			logCryp.logCrypPost.error("Error pengurangan jumlah crypto: "+e);
    		responseDto.setMessage("gagal");
    		return responseDto;
		}
    }
}
