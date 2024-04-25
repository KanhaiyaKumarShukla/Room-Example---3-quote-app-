package com.example.quoteapp_2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {

       abstract fun quoteDao():QuoteDao

       companion object{
           var INSTANCE : QuoteDatabase? =null
           fun getInstance(context:Context):QuoteDatabase{
               if(INSTANCE==null){
                   INSTANCE= Room.databaseBuilder(context,
                       QuoteDatabase::class.java,
                       "QuoteDatabase"
                   ).createFromAsset("quotes.db").build()
               }
               return INSTANCE!!
           }
       }
}