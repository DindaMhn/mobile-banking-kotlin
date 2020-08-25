package com.example.livecode_kotlin.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.livecode_kotlin.API.transaction.TransactionViewModel
import com.example.livecode_kotlin.R
import kotlinx.android.synthetic.main.fragment_confirmation.*

class ConfirmationFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doneButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            doneButton -> {
                activity?.finish()
            }
        }
    }

}