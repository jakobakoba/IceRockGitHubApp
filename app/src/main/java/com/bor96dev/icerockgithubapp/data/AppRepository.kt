package com.bor96dev.icerockgithubapp.data

import com.bor96dev.icerockgithubapp.data.network.RepoService
import com.bor96dev.icerockgithubapp.domain.Repo

interface AppRepository{

    suspend fun getRepositories(): List<Repo>

//    suspend fun getRepository(repoId: String): RepoDetails
//
//    suspend fun getRepositoryReadme(
//        ownerName: String,
//        repositoryName: String,
//        branchName: String
//    ): String
//
//    suspend fun signIn(token: String): UserInfo
}