package com.bam.testproject

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var LOG_TAG = "MYLOG"
    var BUNGLE_COUNT_KEY = "count_value"

    lateinit var textView: TextView
    lateinit var btn: Button
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sec)
        Log.d(LOG_TAG, "onCreate() called")
        initViews()

        if (savedInstanceState != null){
            count = savedInstanceState.getInt(BUNGLE_COUNT_KEY)
            textView.text = count.toString()
        }

        btn.setOnClickListener {
            count++
            textView.text = count.toString()
            Log.i(LOG_TAG, count.toString())
        }


    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        btn = findViewById(R.id.btn)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart() called")
        Log.i(LOG_TAG, count.toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LOG_TAG, "onSaveInstanceState() called")
        outState.putInt(BUNGLE_COUNT_KEY, count)
        Log.d(LOG_TAG, "count value saved")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(LOG_TAG, "onRestoreInstanceState() called")
    }

}

