package com.bor96dev.icerockgithubapp.data.network

import com.bor96dev.icerockgithubapp.data.dto.RepoDto

object Mapper {
    fun toDto(name: String, language: String, description: String): RepoDto{
        return RepoDto(name, description, language)
    }
}