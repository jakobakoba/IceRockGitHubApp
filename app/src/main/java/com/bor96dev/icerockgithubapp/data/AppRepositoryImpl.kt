package com.bor96dev.icerockgithubapp.data

import com.bor96dev.icerockgithubapp.data.network.RepoService
import com.bor96dev.icerockgithubapp.domain.Repo
import com.bor96dev.icerockgithubapp.domain.toRepo
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val repoService: RepoService,
    private val keyValueStorage: KeyValueStorage
) : AppRepository {
    override suspend fun getRepositories(): List<Repo> {
        val token = "Bearer ${keyValueStorage.authToken}"
        return repoService.getRepos(token).map { it.toRepo() }
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