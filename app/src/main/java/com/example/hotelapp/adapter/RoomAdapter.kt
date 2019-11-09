package com.example.hotelapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hotelapp.R

class RoomAdapter(val roomArray: List<String>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.room_item,parent,false)
        view.findViewById<TextView>(R.id.room_textView).text = roomArray[position]

//        view.setOnClickListener {
//            Log.d("TAG","${roomArray[position]} has been selected")
//            view.findViewById<ImageView>(R.id.room_image).setImageResource(R.drawable.room_0)
//        }


        return view
    }

    override fun getItem(position: Int): Any {
        return roomArray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return roomArray.size
    }

}