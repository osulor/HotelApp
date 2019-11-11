package com.example.hotelapp.adapter

import android.content.Context
import android.graphics.Color
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

        val roomItem = view.findViewById<TextView>(R.id.room_textView)
        roomItem.text = roomArray[position]

//        if(roomArray[position] == "Room A"){
//            roomItem.setBackgroundColor(Color.parseColor("#51417C"))
//        }

//        if(roomArray[position] == "Room B"){
//            roomItem.setBackgroundColor(250)
//        }
//
//        if(roomArray[position] == "Room C"){
//            roomItem.setBackgroundColor(265)
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