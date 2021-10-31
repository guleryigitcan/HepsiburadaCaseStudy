package com.guleryigitcan.HepsiburadaCaseStudy.data
import com.guleryigitcan.HepsiburadaCaseStudy.model.ProductListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesService {


    //Fetching data with search string
    @GET("search?limit=20&")
    fun getSearch(
        @Query("entity")entity:String, @Query("term")term:String
    ): Call<ProductListModel>

    //Fetching data with id
    @GET("lookup?")
    fun getById(
        @Query("id")term:String
    ): Call<ProductListModel>



}