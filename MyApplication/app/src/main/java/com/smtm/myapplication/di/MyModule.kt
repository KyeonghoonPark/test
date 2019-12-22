package com.smtm.myapplication.di


import com.smtm.myapplication.MainSearchRecyclerViewAdapter
import com.smtm.myapplication.model.DataModel
import com.smtm.myapplication.model.DataModelImpl
import com.smtm.myapplication.restful.OkHttp3RetrofitManager
import com.smtm.myapplication.model.service.RetrofitInterface
import com.smtm.myapplication.viewmodel.MainViewModel

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


var retrofitPart = module {
    single<RetrofitInterface> {
        OkHttp3RetrofitManager.getRetrofitService(RetrofitInterface::class.java)
    }
}

var adapterPart = module {
    factory {
        MainSearchRecyclerViewAdapter()
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(retrofitPart, adapterPart, modelPart, viewModelPart)