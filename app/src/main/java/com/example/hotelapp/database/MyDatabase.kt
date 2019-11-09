package com.example.hotelapp.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.hotelapp.model.Customer

class MyDatabase(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION,null){

    companion object{
        const val DATABASE_NAME = "customers.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "customers"
        const val CUSTOMER_ID = "customer_id"
        const val COLUMN_NAME ="name"
        const val COLUMN_ROOMNUMBER = "room_number"
        const val COLUMN_PRICE = "price"
        const val COLUMN_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase) {

        val createStatement ="CREATE TABLE $TABLE_NAME ($CUSTOMER_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT," +
                                        " $COLUMN_ROOMNUMBER TEXT, $COLUMN_PRICE DOUBLE, $COLUMN_DATE TEXT)"
        db.execSQL(createStatement)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertCustomer (newCustomer: Customer){

        val customerValues = ContentValues()
        customerValues.put(COLUMN_NAME,newCustomer.customerName)
        customerValues.put(COLUMN_ROOMNUMBER, newCustomer.roomNumber)
        customerValues.put(COLUMN_PRICE,newCustomer.roomPrice)
        customerValues.put(COLUMN_DATE,newCustomer.date)

        val db = writableDatabase
        db.insert(TABLE_NAME,null,customerValues)
        db.close()
    }

    fun readAllCustomers(): Cursor {

         val query = "SELECT * FROM $TABLE_NAME"
         val db = readableDatabase
        return db.rawQuery(query,null)
    }


}