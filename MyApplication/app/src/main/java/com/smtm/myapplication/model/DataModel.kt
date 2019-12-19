package com.smtm.myapplication.model


import com.smtm.myapplication.model.response.GithubResponseModel
import io.reactivex.Single

interface DataModel {
    fun getData(query:String): Single<GithubResponseModel>
}