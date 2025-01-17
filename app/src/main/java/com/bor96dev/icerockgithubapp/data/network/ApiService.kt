package com.bor96dev.icerockgithubapp.data.network

import com.bor96dev.icerockgithubapp.data.list_response.ReposListResponse
import com.bor96dev.icerockgithubapp.data.repo_response.RepoDetailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {

    @GET("/user/repos")
    suspend fun getRepos(
        @Header("Authorization") token: String?
    ): Call<ReposListResponse>

    @GET("/repos/{owner}/{repo}")
    suspend fun getRepoDetails(
        @Header("Authorization") token: String?,
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Call<RepoDetailsResponse>

//    @GET("/repos/{owner}/{repo}/readme")
//    suspend fun getReadme(
//        @Path("owner") owner: String,
//        @Path("repo") repo: String
//    ): ReadmeDto
//
//    @POST("authorizations")
//    suspend fun signIn(
//        @Body authRequest: AuthorizationRequest
//    ): UserInfoDto
}