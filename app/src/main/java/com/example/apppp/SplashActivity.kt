package com.example.apppp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private var isDouble = false

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        //이메일 회원가입 버튼
        val joinBtn = findViewById<Button>(R.id.emailJoinBtn)
        joinBtn.setOnClickListener {

            val email = findViewById<EditText>(R.id.emailText)
            val pass = findViewById<EditText>(R.id.passText)

            Log.d("Main",email.text.toString())
            Log.d("Main",pass.text.toString())

            auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this,"이메일 가입 성공",Toast.LENGTH_SHORT).show()

                        Handler().postDelayed({
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        },2000)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this,"이메일 가입 실패",Toast.LENGTH_SHORT).show()
                    }
                }

        }

        //이메일 로그인 버튼
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {

            val email = findViewById<EditText>(R.id.emailText)
            val pass = findViewById<EditText>(R.id.passText)

            Log.d("Main",email.text.toString())
            Log.d("Main",pass.text.toString())

            auth.signInWithEmailAndPassword(email.text.toString(), pass.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this,"이메일 로그인 성공",Toast.LENGTH_SHORT).show()
                        Handler().postDelayed({
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        },2000)

                        //startActivity(Intent(this,MainActivity::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this,"이메일 로그인 실패",Toast.LENGTH_SHORT).show()
                    }
                }

        }


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