package com.kjbriyan.testloyalcust.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjbriyan.testloyalcust.R
import com.kjbriyan.testloyalcust.model.DataItemm

class RvAdapterTransaksi : RecyclerView.Adapter<RvAdapterTransaksi.UsersViewHolder>() {

    private var list = ArrayList<DataItemm>()

    inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: DataItemm?) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_transaksi, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(items: ArrayList<DataItemm>) {
        list.addAll(items)
        notifyDataSetChanged()
    }
}