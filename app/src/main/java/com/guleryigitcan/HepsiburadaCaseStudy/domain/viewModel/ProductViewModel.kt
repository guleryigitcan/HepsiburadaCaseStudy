package com.guleryigitcan.HepsiburadaCaseStudy.domain.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guleryigitcan.HepsiburadaCaseStudy.data.ItunesRetrofitFactory
import com.guleryigitcan.HepsiburadaCaseStudy.model.Product
import com.guleryigitcan.HepsiburadaCaseStudy.model.ProductListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel:ViewModel() {

    private val _searchList= MutableLiveData<List<Product>>()
    val searchList get()=_searchList
    private val _getList= MutableLiveData<List<Product>>()
    val getList get()=_getList

    fun searchData(p0:String, entity:String){
        ItunesRetrofitFactory.instance.service?.getSearch(entity,p0)?.enqueue(object :
            Callback<ProductListModel> {
            override fun onResponse(
                call: Call<ProductListModel>?,
                response: Response<ProductListModel>?
            ) {
                val musicListModel= response?.body()

                _searchList.value=musicListModel?.results

            }

            override fun onFailure(call: Call<ProductListModel>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }

    fun getData(id:String){
        ItunesRetrofitFactory.instance.service?.getById(id.toString())?.enqueue(object :
            Callback<ProductListModel> {
            override fun onResponse(
                call: Call<ProductListModel>?,
                response: Response<ProductListModel>?
            ) {

                val list= response?.body()

                _getList.value= list?.results


            }

            override fun onFailure(call: Call<ProductListModel>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }


}