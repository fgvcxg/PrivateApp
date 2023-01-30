package com.example.apppp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var isDouble = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //두번클릭하면 종료
    override fun onBackPressed() {
        Log.d("MainActivity","backbutton")
        if(isDouble == true){
            finish()
        }

        isDouble = true
        Toast.makeText(this, "종료하시려면 더블클릭", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable {
            isDouble = false
        }, 2000)
    }
}