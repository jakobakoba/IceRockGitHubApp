package com.bor96dev.icerockgithubapp.data

import com.bor96dev.icerockgithubapp.data.network.RepoService
import com.bor96dev.icerockgithubapp.domain.Repo
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val repoService: RepoService
) : AppRepository {
    override suspend fun getRepositories(): List<Repo> {
        return repoService.getRepos()
    }

//    override suspend fun getRepository(repoId: String): RepoDetails {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun getRepositoryReadme(
//        ownerName: String,
//        repositoryName: String,
//        branchName: String
//    ): String {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun signIn(token: String): UserInfo {
//        TODO("Not yet implemented")
//    }

}