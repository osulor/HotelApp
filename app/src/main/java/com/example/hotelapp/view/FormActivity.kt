package com.example.hotelapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelapp.R
import com.example.hotelapp.adapter.CustomerAdapter
import com.example.hotelapp.database.MyDatabase
import com.example.hotelapp.model.Customer
import kotlinx.android.synthetic.main.activity_customers_list.*
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    companion object{
         var customerList = mutableListOf<Customer>()
         lateinit var myDatabase: MyDatabase
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        myDatabase = MyDatabase(this)

        checkIn_button.setOnClickListener {
            val intent = Intent(this, CustomersListActivity::class.java)
            startActivity(intent)

            saveToDatabase()

        }

    }

    private fun saveToDatabase(){

        val customerName = name_text.text.toString()
        val custormerRoom = room_text.text.toString()
        val roomPrice = price_text.text.toString().toDouble()
        val checkIn_date = date_text.text.toString()

        val newCustomer = Customer(customerName,custormerRoom,roomPrice,checkIn_date)

        myDatabase.insertCustomer(newCustomer)

        clearTextFields()
        Toast.makeText(this,"Successfull Reservation", Toast.LENGTH_LONG).show()
    }




    private fun clearTextFields(){
        name_text.text.clear()
        price_text.text.clear()
        date_text.text.clear()
        room_text.text.clear()

    }


}
