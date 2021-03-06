package br.com.paulosalvatore.ocean_intensivo7_22_10_18

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("/search/repositories")
    fun searchRepositories(
        @Query("q") query: String
    ) : Call<GitHubRepositoriesResult>
}
