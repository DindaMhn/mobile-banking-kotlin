package com.example.livecode_kotlin.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.livecode_kotlin.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            loginButton -> {
                if (emailInput.text.toString() != "" && passInput.text.toString() != "") {
                    navController.navigate(R.id.action_loginFragment_to_dataSaldoFragment)
                } else if (emailInput.text.toString() == "" && passInput.text.toString() == "") {
                    Toast.makeText(
                        this.context,
                        "Email and Password Must be Field",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (emailInput.text.toString() == "") {
                    Toast.makeText(this.context, "Username can't be empty!", Toast.LENGTH_SHORT)
                        .show()
                } else if (passInput.text.toString() == "") {
                    Toast.makeText(this.context, "Password can't be empty!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}