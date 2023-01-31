package com.salihutimothy.mobiledevgraphapp

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.util.*

enum class DownloadStatus {
    OK, IDLE, NOT_INITIALISED, FAILED_OR_EMPTY, PERMISSIONS_ERROR, ERROR
}

class GetJsonData (private val listener: OnDownloadComplete) : AsyncTask<Context, Void, String>(){

    private val TAG = "GetJsonData"
    private var downloadStatus = DownloadStatus.IDLE

    interface OnDownloadComplete {
        fun onDownloadComplete(data: String, status: DownloadStatus)
    }

    override fun doInBackground(vararg params: Context): String {
        if (params[0] == null) {
            downloadStatus = DownloadStatus.NOT_INITIALISED
            return "No context specified"
        }

        try {
            downloadStatus = DownloadStatus.OK
            val inputStream: InputStream = params[0].assets.open("Forged Widows Data.json")
            return inputStream.bufferedReader()
                .use { it.readText() }

        } catch (e: Exception) {
            val errorMessage = when (e) {
                is IOException -> {
                    downloadStatus = DownloadStatus.FAILED_OR_EMPTY
                    "doInBackground: IO Exception reading data: ${e.message}"
                }
                else -> {
                    downloadStatus = DownloadStatus.ERROR
                    "Unknown error: ${e.message}"
                }
            }
            Log.e(TAG, errorMessage)

            return errorMessage
        }

    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        listener.onDownloadComplete(result, downloadStatus)
    }
}