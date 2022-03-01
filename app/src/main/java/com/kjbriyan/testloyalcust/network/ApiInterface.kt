package com.kjbriyan.testloyalcust.network

import com.kjbriyan.testloyalcust.model.ResponseLogin
import com.kjbriyan.testloyalcust.model.ResponseRiwayat
import com.kjbriyan.testloyalcust.model.ResponseTransaksi
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @FormUrlEncoded
    @POST("auth/auth")
    fun userLogin(
        @Field("email") email: String,
        @Field("pass") password: String
    ): Call<ResponseLogin>

    @FormUrlEncoded
    @POST("auth/update/{id}")
    fun userUpdate(
        @Path("id") id: String,
        @Field("name") name: String,
        @Field("alamat") alamat: String
    ): Call<ResponseTransaksi>

    @FormUrlEncoded
    @POST("transaksi/filter/{id}")
    fun riwayat(
        @Path("id") id: String,
    ): Call<ResponseRiwayat>
}