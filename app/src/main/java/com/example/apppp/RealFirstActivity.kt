package com.example.apppp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RealFirstActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_first)


        auth = Firebase.auth

        try{
            Log.d("splash", auth.currentUser!!.uid)
            Toast.makeText(this, "원래 로그인이 되어있습니다", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },2000)
        }catch(e : Exception){
            Log.d("splash", "회원가입 필요")

            Toast.makeText(this, "로그인이 필요합니다", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this,SplashActivity::class.java))
                finish()
            },2000)
        }
    }
}