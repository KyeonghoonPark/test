package com.smtm.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smtm.myapplication.base.BaseKotlinViewModel
import com.smtm.myapplication.model.DataModel
import com.smtm.myapplication.model.response.GithubResponseModel


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model: DataModel) : BaseKotlinViewModel() {

    private val TAG = "MainViewModel"

    private val _searchResponseLiveData = MutableLiveData<GithubResponseModel>()
    val searchResponseLiveData:LiveData<GithubResponseModel>
        get() =  _searchResponseLiveData

    fun getSearch(query: String, page:Int, per_page:Int) {
        addDisposable(model.getData(query, page, per_page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if (items.size > 0) {
                        Log.e(TAG, "items : $items")
                        _searchResponseLiveData.postValue(this)
                    }
                }
            }, {
                Log.e(TAG, "response error, message : ${it.message}")
            }))
    }
}