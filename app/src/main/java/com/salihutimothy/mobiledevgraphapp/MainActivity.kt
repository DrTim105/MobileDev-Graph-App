package com.salihutimothy.mobiledevgraphapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import android.view.View

import com.anychart.chart.common.dataentry.ValueDataEntry

import com.anychart.chart.common.dataentry.DataEntry

import com.anychart.charts.Pie



//import com.anychart.DataEntry;
//import com.anychart.Pie;
//import com.anychart.ValueDataEntry;


class MainActivity : AppCompatActivity(), GetJsonData.OnDownloadComplete, ParseJsonData.OnDataAvailable {
    private val TAG = "MainActivity"

    private lateinit var widowEmploymentStatus: AnyChartView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getJsonData = GetJsonData(this)
        getJsonData.execute(this)

        widowEmploymentStatus = findViewById(R.id.widowEmploymentStatus)

    }

    override fun onDownloadComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            Log.d(TAG, "onDownloadComplete called")

            val parseJsonData = ParseJsonData(this)
            parseJsonData.execute(data)
        } else {
            // download failed
            Log.d(TAG, "onDownloadComplete failed with status $status. Error message is: $data")
        }
    }

    override fun onDataAvailable(data: List<Widow>) {
        Log.d(TAG, ".onDataAvailable called ${data[0]}")

        widowEmploymentStatus = findViewById(R.id.widowEmploymentStatus)

        var withNgo = 0
        var withoutNgo = 0

        for (widow in data) {
            if (widow.ngoName == null) {
                withoutNgo++
            } else {
                withNgo++
            }
        }
        val pie = AnyChart.pie()

        val pieData: MutableList<DataEntry> = ArrayList()
        pieData.add(ValueDataEntry("Yes", withNgo))
        pieData.add(ValueDataEntry("No", withoutNgo))

        pie.data(pieData)
        pie.palette(arrayOf("#039CDD", "#602BF8"))
//        val anyChartView = findViewById<View>(R.id.widowEmploymentStatus) as AnyChartView
        widowEmploymentStatus.setChart(pie)

    }

    override fun onError(exception: Exception) {
        Log.e(TAG, "onError called with ${exception.message}")
    }


}