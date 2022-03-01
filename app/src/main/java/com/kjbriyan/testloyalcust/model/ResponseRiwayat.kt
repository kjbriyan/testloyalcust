package com.kjbriyan.testloyalcust.model

data class ResponseRiwayat(
	val data: List<DataItemm?>? = null,
	val status: Int? = null
)

data class DataItemm(
	val img: String? = null,
	val level: String? = null,
	val createdAt: String? = null,
	val idTransaksi: String? = null,
	val idUser: String? = null,
	val alamat: String? = null,
	val password: String? = null,
	val jumlah: String? = null,
	val harga: String? = null,
	val idBarang: String? = null,
	val name: String? = null,
	val namaBarang: String? = null,
	val email: String? = null
)

