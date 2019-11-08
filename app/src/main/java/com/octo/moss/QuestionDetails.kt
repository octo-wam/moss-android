package com.octo.moss

data class QuestionDetails(
    val id: String,
    val title: String,
    val description: String,
    val endingDate: String,
    val answers: List<QuestionAnswer>
)

data class QuestionAnswer(
    val id: String,
    val title: String,
    val description: String
)