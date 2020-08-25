package com.example.livecode_kotlin.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livecode_kotlin.API.transaction.TransactionViewModel
import com.example.livecode_kotlin.R
import com.example.livecode_kotlin.recycleadapter.TransactionRecycleAdapter
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {
    val transactionViewModel by activityViewModels<TransactionViewModel>()
    lateinit var adapter: TransactionRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyRecycleView.layoutManager = LinearLayoutManager(activity)
        transactionViewModel.transaction.observe(viewLifecycleOwner, Observer {
            adapter = TransactionRecycleAdapter(it)
            historyRecycleView.adapter = adapter
        })
        transactionViewModel.getTransaction()
    }
}