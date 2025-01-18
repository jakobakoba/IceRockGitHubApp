package com.bor96dev.icerockgithubapp.domain

import com.bor96dev.icerockgithubapp.data.dto.RepoDto
import com.google.gson.annotations.SerializedName

data class Repo (
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val language: String
)

fun RepoDto.toRepo(): Repo {
    return Repo(
        name = this.name,
        description = this.description ?: "",
        language = this.language ?: "",
    )
}