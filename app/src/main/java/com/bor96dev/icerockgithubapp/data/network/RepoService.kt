package com.bor96dev.icerockgithubapp.data.network

import com.bor96dev.icerockgithubapp.data.dto.RepoDto
import com.bor96dev.icerockgithubapp.domain.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface RepoService {

    @GET("/user/repos")
    suspend fun getRepos(
        @Header("Authorization") token: String?
    ): List<RepoDto>


//    @GET("/repos/{owner}/{repo}")
//    suspend fun getRepoDetails(
//        @Header("Authorization") token: String?,
//        @Path("owner") owner: String,
//        @Path("repo") repo: String
//    ): Call<RepoDetailsResponse>

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