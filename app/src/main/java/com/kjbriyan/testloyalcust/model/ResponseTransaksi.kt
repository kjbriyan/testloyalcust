package com.kjbriyan.testloyalcust.model

import com.google.gson.annotations.SerializedName

data class ResponseTransaksi(

	@field:SerializedName("data")
	val data: List<DataItems?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DataItems(

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("level")
	val level: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id_transaksi")
	val idTransaksi: String? = null,

	@field:SerializedName("id_user")
	val idUser: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("jumlah")
	val jumlah: String? = null,

	@field:SerializedName("harga")
	val harga: String? = null,

	@field:SerializedName("id_barang")
	val idBarang: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("nama_barang")
	val namaBarang: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
