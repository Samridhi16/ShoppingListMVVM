package com.projects.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.projects.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase(){
    abstract fun  getShoppingDAO() : ShoppingDAO

    //singleton object
    companion object{
        //synchronize
        @Volatile
        private var instance: ShoppingDatabase?= null
        private val LOCK = Any()


        @OptIn(InternalCoroutinesApi::class)
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }


        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java,"ShoppingDB.db").build()
    }
}