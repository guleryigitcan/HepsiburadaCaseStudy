package com.guleryigitcan.HepsiburadaCaseStudy.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItunesRetrofitFactory private  constructor(){

    var service:ItunesService? = null

    init {

        val client = okhttp3.OkHttpClient.Builder()
            .build()

        val retrofit= Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ItunesService::class.java)


    }

    companion object {
        private var INSTANCE: ItunesRetrofitFactory? = null

        val instance: ItunesRetrofitFactory
            get()  {
                if(INSTANCE == null) {
                    INSTANCE = ItunesRetrofitFactory()
                }


                return INSTANCE!!
            }
    }
}