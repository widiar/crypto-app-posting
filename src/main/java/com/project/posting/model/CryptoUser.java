package com.project.posting.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CryptoUser {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="nama_crypto")
	private String namaCrypto;
	@Column(name="harga")
	private Double harga;
	@Column(name="tgl_beli")
	private Date tglBeli;

}
