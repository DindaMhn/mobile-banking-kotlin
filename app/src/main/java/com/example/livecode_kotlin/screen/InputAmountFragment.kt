package com.example.livecode_kotlin.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecode_kotlin.API.transaction.Transaction
import com.example.livecode_kotlin.API.transaction.TransactionViewModel
import com.example.livecode_kotlin.R
import kotlinx.android.synthetic.main.fragment_input_amount.*

class InputAmountFragment : Fragment(),View.OnClickListener {
    val transactionViewModel by activityViewModels<TransactionViewModel>()
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        nextAmountButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            nextAmountButton -> {
                transactionViewModel.saveTransaction(Transaction(amount=amountInput.text.toString()))
                navController.navigate(R.id.action_inputAmountFragment_to_confirmationFragment)
            }
        }
    }

}