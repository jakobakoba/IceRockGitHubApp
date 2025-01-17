package com.bor96dev.icerockgithubapp.data.list_response

data class Permissions(
    val admin: Boolean,
    val pull: Boolean,
    val push: Boolean
)