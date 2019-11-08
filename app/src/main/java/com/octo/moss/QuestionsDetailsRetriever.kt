package com.octo.moss

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class QuestionsDetailsRetriever {

    private fun loadQuestionsFromServer(): List<QuestionDetails> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://octo-moss-back.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(QuestionDetailsService::class.java).getQuestions()
    }

    interface QuestionDetailsService {
        @GET("questions")
        fun getQuestions(): List<QuestionDetails>
    }
}