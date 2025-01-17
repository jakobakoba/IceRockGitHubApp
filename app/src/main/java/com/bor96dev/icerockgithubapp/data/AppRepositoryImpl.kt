package com.bor96dev.icerockgithubapp.data

class AppRepositoryImpl: AppRepository {
    override suspend fun getRepositories(): List<Repo> {
        TODO("Not yet implemented")
    }

    override suspend fun getRepository(repoId: String): RepoDetails {
        TODO("Not yet implemented")
    }

    override suspend fun getRepositoryReadme(
        ownerName: String,
        repositoryName: String,
        branchName: String
    ): String {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(token: String): UserInfo {
        TODO("Not yet implemented")
    }

}