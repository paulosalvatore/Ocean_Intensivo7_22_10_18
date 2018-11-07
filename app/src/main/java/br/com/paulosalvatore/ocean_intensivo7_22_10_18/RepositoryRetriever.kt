package br.com.paulosalvatore.ocean_intensivo7_22_10_18

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    private val service: GitHubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        service = retrofit.create(GitHubService::class.java)
    }

    fun getLanguageRepositories(
        callback: Callback<GitHubRepositoriesResult>,
        query: String
    ) {
        val call = service.searchRepositories("language:$query")
        call.enqueue(callback)
    }
}
