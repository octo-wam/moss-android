package com.octo.moss

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuestionDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_details)

        loadQuestions()

        radioGroup.setOnCheckedChangeListener { _, _ ->
            validateButton.isEnabled = true
        }
        validateButton.setOnClickListener {
            validateAnswer()
        }
        resultButton.setOnClickListener {
            goToQuestionResults()
        }
    }

    private fun loadQuestions() {
        GlobalScope.launch {
            val questionDetails = loadLocalQuestions()

            withContext(Dispatchers.Main) {
                val firstQuestion = questionDetails.first()

                questionTextView.text = firstQuestion.title
                endingDateTextView.text = firstQuestion.endingDate

                firstQuestion.answers.forEach {
                    generateOptionView(it.id, "${it.title}\n${it.description}")
                }
            }
        }
    }

    private fun loadLocalQuestions(): List<QuestionDetails> {
        return listOf(
            QuestionDetails(
                id = "1",
                title = "Quel nom pour la league?",
                description = "",
                endingDate = "Expire le 12/10/2019",
                answers = listOf(
                    QuestionAnswer(
                        id = "1",
                        title = "WAM",
                        description = "Web Application Mobile"
                    ),
                    QuestionAnswer(
                        id = "2",
                        title = "IDEA",
                        description = "Interfaces, Digital Experiences & API"
                    ),
                    QuestionAnswer(
                        id = "3",
                        title = "FAME",
                        description = "Front Api Mobile Experience"
                    )
                )
            )
        )
    }

    private fun generateOptionView(id: String, text: String) {
        val optionView = (layoutInflater.inflate(
            R.layout.cell_option_item, radioGroup, false
        ) as RadioButton).apply {
            this.id = View.generateViewId()
            this.tag = id
            this.text = text
        }

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        radioGroup.addView(optionView, layoutParams)
    }

    private fun validateAnswer() {
        val answerId = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).tag

        // TODO

        goToQuestionResults()
    }

    private fun goToQuestionResults() {
        startActivity(Intent(this, QuestionResultActivity::class.java))
    }
}
