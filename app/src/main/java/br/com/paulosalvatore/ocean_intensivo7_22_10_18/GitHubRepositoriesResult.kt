package br.com.paulosalvatore.ocean_intensivo7_22_10_18

import com.google.gson.annotations.SerializedName

data class GitHubRepositoriesResult(
    @SerializedName("items")
    val repositories: List<Repository>
)

data class Repository(
    val id: Long?,
    val name: String?,
    val full_name: String?,
    val description: String?,
    val owner: Owner
)

data class Owner(
    val id: Long?,
    val login: String?,
    val avatar_url: String?
)
