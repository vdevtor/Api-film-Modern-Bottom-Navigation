package com.example.rvproject.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Business.MainBussiness
import com.example.rvproject.Model.TopRated
import kotlinx.coroutines.launch

class TopRatedViewModel : ViewModel(){

    val onResultTopRated: MutableLiveData<TopRated> = MutableLiveData()
    val onResultFailure : MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        MainBussiness()

    }

    fun getTopRated(){
        viewModelScope.launch {
        when(val response = business.getRated()){
            is ResponseApi.Sucess ->{
                onResultTopRated.postValue(response.data as TopRated)
            }


            is ResponseApi.Error ->{

                onResultFailure.postValue(response.message)
            }

        }



        }







    }


}