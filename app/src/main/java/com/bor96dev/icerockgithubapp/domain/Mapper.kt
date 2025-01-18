package com.bor96dev.icerockgithubapp.domain

import com.bor96dev.icerockgithubapp.data.dto.RepoDto
import javax.inject.Inject

class Mapper @Inject constructor(){
    //from dto to model
    fun buildFrom(repoDto: RepoDto): Repo {
        return Repo(
            name = repoDto.name,
            description = repoDto.description ?: "",
            language = repoDto.language ?: ""
            )
    }

    fun toDto(name: String, language: String, description: String): RepoDto{
        return RepoDto(name, description, language)
    }
}