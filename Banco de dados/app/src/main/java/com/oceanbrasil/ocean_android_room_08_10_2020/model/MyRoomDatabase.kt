package com.oceanbrasil.ocean_android_room_08_10_2020.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
    abstract fun userDao(): UserDao

    companion object {
        private val roomDatabaseCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                instance?.let {
                    Thread(Runnable {
                        val dao = it.wordDao()

                        dao.deleteAll()

                        val word = Word("Samsung")
                        dao.insert(word)

                        val word2 = Word("Ocean")
                        dao.insert(word2)

                        val dao2 = it.userDao()
                    }).start()
                }
            }
        }

        private var instance: com.oceanbrasil.ocean_android_room_08_10_2020.model.MyRoomDatabase? = null

        fun getDatabase(context: Context): com.oceanbrasil.ocean_android_room_08_10_2020.model.MyRoomDatabase {
            if (instance == null) {
                synchronized(RoomDatabase::class.java) {
                    // Criação do banco de dados
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyRoomDatabase::class.java,
                        "word_database"
                    ).addCallback(roomDatabaseCallback).build()
                }
            }

            return instance!!
        }
    }
}
