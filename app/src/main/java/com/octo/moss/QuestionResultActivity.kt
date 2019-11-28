package com.octo.moss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question_result.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue

class QuestionResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_result)

        val pieChartData = PieChartData(
            listOf(
                SliceValue(
                    52f,
                    resources.getColor(R.color.colorPrimaryDark)
                ).setLabel("WAM : 28 (52%)"),
                SliceValue(
                    15f,
                    resources.getColor(R.color.colorPrimary)
                ).setLabel("IDEA : 8 (15%)"),
                SliceValue(33f, resources.getColor(R.color.colorAccent)).setLabel("FAME : 18 (33%)")
            )
        )
        pieChartData.setHasLabels(true)
        chartView.pieChartData = pieChartData
    }

}
