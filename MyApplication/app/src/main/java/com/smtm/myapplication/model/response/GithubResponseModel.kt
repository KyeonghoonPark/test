package com.smtm.myapplication.model.response


data class GithubResponseModel(
    val total_count: Int = 0,
    val items: ArrayList<Document>
) {
    data class Document(
        val description: String = "",
        val owner: Owner,
        val language: String = "",
        val name: String = "",
        val full_name: String = "",
        val forks_count: String = "",
        val stargazers_count: String = ""
    )


    data class Owner(
        val received_events_url: String = "",
        val organizations_url: String = "",
        val avatar_url: String = "",
        val gravatar_id: String = "",
        val gists_url: String = "",
        val starred_url: String = ""
    )
}


