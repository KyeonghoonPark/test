package com.smtm.myapplication.model.service


import com.smtm.myapplication.model.response.GithubResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Created by pk on 2019-12-18.
 * 보낼 요청을 구성한다
 */
interface RetrofitInterface {
    /*
    * 검색(json data)
    */
    @GET("search/repositories?sort=stars&order=desc&page=1&per_page=10")
    fun getRepoList(
        @Query("q") query: String
    ): Single<GithubResponseModel>
}



//companion object {
//    fun getRepoList(query: String): Observable<GithubResponseModel> {
//        r