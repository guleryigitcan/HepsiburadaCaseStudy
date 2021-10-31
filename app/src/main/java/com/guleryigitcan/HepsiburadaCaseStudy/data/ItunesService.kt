package com.guleryigitcan.HepsiburadaCaseStudy.data
import com.guleryigitcan.HepsiburadaCaseStudy.model.ProductListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesService {


    @GET("search?")
    fun getSearch(
        @Query("entity")entity:String, @Query("term")term:String
    ): Call<ProductListModel>


    @GET("search?entity=musicTrack&")
    fun getMusicWithSearch(
        @Query("term")term:String
    ): Call<ProductListModel>

    @GET("search?media=movie&")
    fun getMovieWithSearch(
        @Query("term")term:String
    ): Call<ProductListModel>

    @GET("search?entity=ebook&")
    fun getBookWithSearch(
        @Query("term")term:String
    ): Call<ProductListModel>
    @GET("search?entity=software&")
    fun getAppWithSearch(
        @Query("term")term:String
    ): Call<ProductListModel>

    @GET("lookup?")
    fun getById(
        @Query("id")term:String
    ): Call<ProductListModel>



}