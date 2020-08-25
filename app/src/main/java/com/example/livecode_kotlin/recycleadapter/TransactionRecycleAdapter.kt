package com.example.livecode_kotlin.recycleadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.livecode_kotlin.API.transaction.Transaction
import com.example.livecode_kotlin.R
import com.squareup.picasso.Picasso

class TransactionRecycleAdapter(
    private val transactionList: List<Transaction>
) : RecyclerView.Adapter<TransactionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_item_layout, parent, false)
        return TransactionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.amountView.text = "$"+transactionList[position].amount
        holder.date.text = transactionList[position].date
    }
}

class TransactionViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val amountView = v.findViewById<TextView>(R.id.amountView)
    val date = v.findViewById<TextView>(R.id.dateView)
}