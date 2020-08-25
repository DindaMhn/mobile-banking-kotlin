package com.example.livecode_kotlin.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecode_kotlin.API.transaction.TransactionViewModel
import com.example.livecode_kotlin.API.user.UserRepository
import com.example.livecode_kotlin.API.user.UserViewModel
import com.example.livecode_kotlin.R
import kotlinx.android.synthetic.main.fragment_data_saldo.*

class DataSaldoFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    val userViewModel by activityViewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_saldo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.user.observe(viewLifecycleOwner, Observer {
            balanceView.text = it[0].balance
        })

        navController = Navigation.findNavController(view)
        transferButton.setOnClickListener(this)
        historyButton.setOnClickListener(this)
        callButton.setOnClickListener(this)
    }
    override fun onResume() {
        super.onResume()
        userViewModel.getUser()
    }
    override fun onClick(v: View?) {
        when (v) {
            transferButton -> {
                navController.navigate(R.id.action_dataSaldoFragment_to_transactionActivity)
            }
            historyButton -> {
                navController.navigate(R.id.action_dataSaldoFragment_to_historyFragment)
            }
            callButton -> {
                val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1500888"))
                startActivity(intent)
            }
        }
    }
}