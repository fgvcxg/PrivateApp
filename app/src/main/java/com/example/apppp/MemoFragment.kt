package com.example.apppp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class MemoFragment : Fragment() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_memo, container, false)

        view.findViewById<Button>(R.id.homebtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_memoFragment_to_homeFragment)
        }

        view.findViewById<Button>(R.id.mypagebtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_memoFragment_to_mypageFragment)
        }


        return view
    }

}