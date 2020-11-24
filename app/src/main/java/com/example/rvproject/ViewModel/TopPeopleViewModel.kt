package com.example.rvproject.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rvproject.Api.ResponseApi
import com.example.rvproject.Model.Business.MainBussiness
import com.example.rvproject.Model.Business.TopPeopleBusiness
import com.example.rvproject.Model.TopPeopleRated
import com.example.rvproject.Model.TopRated
import kotlinx.coroutines.launch

class TopPeopleViewModel : ViewModel(){


    val onResultTopPople: MutableLiveData<TopPeopleRated> = MutableLiveData()
    val onResultFailure : MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        TopPeopleBusiness()

    }

    fun getTopPolular(){
        viewModelScope.launch {
            when(val response = business.getPopular()){
                is ResponseApi.Sucess ->{
                    onResultTopPople.postValue(response.data as TopPeopleRated)
                }


                is ResponseApi.Error ->{

                    onResultFailure.postValue(response.message)
                }

            }



        }


    }
}