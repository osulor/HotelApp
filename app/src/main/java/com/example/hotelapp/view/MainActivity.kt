package com.example.hotelapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hotelapp.R
import com.example.hotelapp.adapter.RoomAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val roomsArray = listOf("Room A", "Room B", "Room C")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillListview()

        goToCheckIn_button.setOnClickListener {
            val intent = Intent(this,FormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fillListview(){
        for (i in 0 until roomsArray.count()){
            val arrayAdapter = RoomAdapter(roomsArray)
            room_listView.adapter = arrayAdapter
        }

        room_listView.setOnItemClickListener { parent, view, position, id ->
            val roomChoice = roomsArray[position]

            displayRoom(roomChoice)
        }
    }


    private fun displayRoom(roomChoice: String){

        if (roomChoice == "Room A") {
                room_image.setImageResource(R.drawable.room_0)
            }

            if (roomChoice == "Room B" ) {
                room_image.setImageResource(R.drawable.room_1)
            }

            if (roomChoice == "Room C") {
                room_image.setImageResource(R.drawable.room_2)
            }
    }

}


