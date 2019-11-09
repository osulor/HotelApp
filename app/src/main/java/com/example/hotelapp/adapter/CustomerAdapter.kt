package com.example.hotelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapp.R
import com.example.hotelapp.model.Customer
import kotlinx.android.synthetic.main.room_item.view.*

class CustomerAdapter(private val customerList: List<Customer>) : RecyclerView.Adapter<CustomerAdapter.customerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customerViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.customers_item_view,parent,false)
        return customerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customerList.size
    }

    override fun onBindViewHolder(holder: customerViewHolder, position: Int) {

        holder.apply {
            val customer = customerList[position]
            customerName.text = customer.customerName
            roomTextView.text = customer.roomNumber
            priceTexView.text = customer.roomPrice.toString()
            dateTextView.text = customer.date
        }

    }


    inner class customerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val customerName = itemView.findViewById<TextView>(R.id.name_textView)
        val roomTextView = itemView.findViewById<TextView>(R.id.room_textView)
        val priceTexView = itemView.findViewById<TextView>(R.id.price_textView)
        val dateTextView = itemView.findViewById<TextView>(R.id.date_textView)
    }

}