package com.yabu.livechartdemoapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yabu.livechart.view.LiveChartStyle
import com.yabu.livechart.view.LiveChartView

class MainActivity : AppCompatActivity() {
    private lateinit var livechart: LiveChartView
    private lateinit var livechartSimple: LiveChartView
    private lateinit var livechartNegative: LiveChartView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        livechart = findViewById(R.id.main_live_chart)
        livechartSimple = findViewById(R.id.main_simple_live_chart)
        livechartNegative = findViewById(R.id.main_negative_live_chart)

        val dataset = SampleData.createSampleData()

        val negativeDataset = SampleData.createNegativeSampleData()

        livechartSimple.setDataset(dataset)
            .drawDataset()

        val style = LiveChartStyle().apply {
            textColor = Color.BLUE
            mainColor = Color.GREEN
            mainFillColor = Color.MAGENTA
            baselineColor = Color.BLUE
            pathStrokeWidth = 12f
            baselineStrokeWidth = 6f
        }

        livechart.setDataset(dataset)
            .setLiveChartStyle(style)
            .drawYBounds()
            .drawBaseline()
            .drawFill()
            .drawDataset()

        livechartNegative.setDataset(negativeDataset)
            .drawYBounds()
            .drawBaseline()
            .drawFill()
            .drawDataset()
    }
}