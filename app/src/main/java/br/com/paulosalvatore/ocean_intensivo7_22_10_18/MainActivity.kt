package br.com.paulosalvatore.ocean_intensivo7_22_10_18

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object : Callback<GitHubRepositoriesResult> {
        override fun onFailure(call: Call<GitHubRepositoriesResult>?, t: Throwable?) {
            longToast("Erro ao acessar a API.")
        }

        override fun onResponse(call: Call<GitHubRepositoriesResult>?, response: Response<GitHubRepositoriesResult>?) {
            longToast("Carregamento finalizado.")

            textView.text = ""

            response?.let {
                if (response.isSuccessful) {
                    val resultList = response.body()?.repositories ?: emptyList()

                    for (repository in resultList) {
                        textView.append("${repository.full_name}\n")
                    }
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            updateRepositories()
        }
    }

    private fun updateRepositories() {
        repositoryRetriever.getLanguageRepositories(callback, "kotlin")
    }
}
