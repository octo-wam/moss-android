package com.octo.moss

import android.graphics.Color
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
                SliceValue(55f, resources.getColor(R.color.colorPrimaryDark)).setLabel("WAM : 55%"),
                SliceValue(25f, resources.getColor(R.color.colorPrimary)).setLabel("IDEA : 25%"),
                SliceValue(20f, resources.getColor(R.color.colorAccent)).setLabel("FAME : 20%")
            )
        )
        pieChartData.setHasLabels(true)
        chartView.pieChartData = pieChartData
    }

}
