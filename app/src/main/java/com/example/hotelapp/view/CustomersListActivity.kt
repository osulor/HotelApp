package com.example.hotelapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelapp.R
import com.example.hotelapp.adapter.CustomerAdapter
import com.example.hotelapp.database.MyDatabase
import com.example.hotelapp.model.Customer
import com.example.hotelapp.view.FormActivity.Companion.customerList
import com.example.hotelapp.view.FormActivity.Companion.myDatabase
import kotlinx.android.synthetic.main.activity_customers_list.*

class CustomersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers_list)

        readFromDatabase()
    }

    override fun onResume() {
        super.onResume()
        readFromDatabase()
    }

    private fun readFromDatabase(){
        customerList.clear()

        val cursor = myDatabase.readAllCustomers()

        cursor.moveToFirst()

        if (cursor.count > 0) {
            val customer = Customer(
                cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_ROOMNUMBER)),
                cursor.getDouble(cursor.getColumnIndex(MyDatabase.COLUMN_PRICE)),
                cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_DATE))
            )
            customerList.add(customer)
        }
        while (cursor.moveToNext()) {
            val customerName = cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_NAME))
            val customerRoom =
                cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_ROOMNUMBER))
            val roomPrice = cursor.getInt(cursor.getColumnIndex(MyDatabase.COLUMN_PRICE))
            val date = cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_DATE))
            val readCustomer = Customer(customerName, customerRoom, roomPrice.toDouble(),date)
            customerList.add(readCustomer)
        }
        displayCustomers()
    }

    private fun displayCustomers(){

        val recyclerAdapter = CustomerAdapter(customerList)
        customers_listView.adapter = recyclerAdapter
        customers_listView.layoutManager = LinearLayoutManager(this)
    }

}
