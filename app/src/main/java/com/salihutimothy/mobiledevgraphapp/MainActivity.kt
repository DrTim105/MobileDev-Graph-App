package com.salihutimothy.mobiledevgraphapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), GetJsonData.OnDownloadComplete, ParseJsonData.OnDataAvailable {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getJsonData = GetJsonData(this)
        getJsonData.execute(this)


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
    }

    override fun onError(exception: Exception) {
        Log.e(TAG, "onError called with ${exception.message}")
    }


}