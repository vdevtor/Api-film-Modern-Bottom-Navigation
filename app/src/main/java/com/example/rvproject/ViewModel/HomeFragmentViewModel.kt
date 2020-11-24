package com.example.rvproject.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Business.HomeBusiness
import com.example.rvproject.Model.TopUpComing
import kotlinx.coroutines.launch

class HomeFragmentViewModel: ViewModel() {
    val onResultTopUpComing: MutableLiveData<TopUpComing> = MutableLiveData()
    val onResultFailure : MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        HomeBusiness()

    }
    fun getTopUpComing(){
        viewModelScope.launch {
            when(val response = business.getPopular()){
                is ResponseApi.Sucess ->{
                    onResultTopUpComing.postValue(response.data as TopUpComing)
                }


                is ResponseApi.Error ->{

                    onResultFailure.postValue(response.message)
                }

            }



        }


    }

}