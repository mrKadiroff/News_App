package com.example.news_app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.models.NewsData
import com.example.news_app.retrofit.RetrofitClient
import com.example.news_app.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val liveData = MutableLiveData<Resource<NewsData>>()
    private val liveSearchData = MutableLiveData<Resource<NewsData>>()

    fun getWord(word:String): LiveData<Resource<NewsData>> {
        val apiService1 = RetrofitClient.apiService()

        viewModelScope.launch {
            liveData.postValue(Resource.loading(null))

            try {
                coroutineScope {

                    val async1 = async { apiService1.getData("9365b4dc294131f02dc2bec43df01d12","en",word,"popularity") }

                    val await1 = async1.await()

                    liveData.postValue(Resource.success(await1))

                }
            }catch (e: Exception){
                liveData.postValue(Resource.error(e.message ?: "Error",null))
            }



        }
        return liveData
    }











    fun getSearchWord(word:String): LiveData<Resource<NewsData>> {
        val apiService1 = RetrofitClient.apiService()

        viewModelScope.launch {
            liveSearchData.postValue(Resource.loading(null))

            try {
                coroutineScope {

                    val async1 = async { apiService1.getSearchData("9365b4dc294131f02dc2bec43df01d12","en","elon musk") }

                    val await1 = async1.await()

                    liveSearchData.postValue(Resource.success(await1))

                }
            }catch (e: Exception){
                liveSearchData.postValue(Resource.error(e.message ?: "Error",null))
            }



        }
        return liveSearchData
    }



}