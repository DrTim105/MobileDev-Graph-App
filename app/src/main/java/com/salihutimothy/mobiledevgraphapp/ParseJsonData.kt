package com.salihutimothy.mobiledevgraphapp

import android.os.AsyncTask
import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import org.json.JSONException

class ParseJsonData (private val listener: OnDataAvailable) : AsyncTask<String, Void, List<Widow>>(){

    private val TAG = "ParseJsonData"

    interface OnDataAvailable {
        fun onDataAvailable(data: List<Widow>)
        fun onError(exception: Exception)
    }

    override fun doInBackground(vararg param: String): List<Widow> {

        lateinit var widows: List<Widow>
        var jsonString = param[0]
        try {
            val listWidow = object :  TypeToken<List<Widow>>()
            {}.type

            widows = Gson().fromJson(jsonString, listWidow)

        } catch (e: JSONException) {
            e.printStackTrace()
            Log.e(TAG, ".doInBackground: Error processing Json data. ${e.message}")
            cancel(true)
            listener.onError(e)
        }

        Log.d(TAG, ".doInBackground ends")

        return widows
    }

    override fun onPostExecute(result: List<Widow>) {
        Log.d(TAG, "onPostExecute starts")
        super.onPostExecute(result)
        listener.onDataAvailable(result)
        Log.d(TAG, ".onPostExecute ends")
    }

}