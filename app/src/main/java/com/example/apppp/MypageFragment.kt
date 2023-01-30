package com.example.apppp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MypageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        view.findViewById<Button>(R.id.homebtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_homeFragment)
        }

        view.findViewById<Button>(R.id.memobtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_memoFragment)
        }

        view.findViewById<AppCompatButton>(R.id.logoutbtn).setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(context,"로그아웃",Toast.LENGTH_SHORT).show()

        }

        return view
    }

}