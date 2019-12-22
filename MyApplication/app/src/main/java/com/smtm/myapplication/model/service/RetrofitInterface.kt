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
    @GET("search/repositories?sort=stars&order=desc")
    fun getRepoList(
        @Query("q") query: String,
        @Query("page") page:Int,
        @Query("per_page") per_page:Int
    ): Single<GithubResponseModel>
}



//companion object {
//    fun getRepoList(query: String): Observable<GithubResponseModel> {
//        r