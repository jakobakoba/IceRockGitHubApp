package com.bor96dev.icerockgithubapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RepoDto (
    val name: String,
    val description: String?,
    val language: String?,
)