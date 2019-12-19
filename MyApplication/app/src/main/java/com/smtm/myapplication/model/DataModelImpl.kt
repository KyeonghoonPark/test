package com.smtm.myapplication.model

import com.smtm.myapplication.model.response.GithubResponseModel
import com.smtm.myapplication.model.service.RetrofitInterface
import io.reactivex.Single

class DataModelImpl(private val service: RetrofitInterface):DataModel{

    override fun getData(query:String): Single<GithubResponseModel> {
        return service.getRepoList(query = query)
    }
}