package com.oceanbrasil.ocean_android_room_08_10_2020.model

import android.app.Application
import androidx.lifecycle.LiveData

class Repository(application: Application) {

    private val wordDao: WordDao
    private val userDao: UserDao

    val allWords: LiveData<List<Word>>
    val allUsernames : LiveData<List<User>>

    init {
        val db = MyRoomDatabase.getDatabase(application)
        wordDao = db.wordDao()

        allWords = wordDao.getAllWords()

        userDao = db.userDao()

        allUsernames = userDao.getAllUsernames()
    }

    fun insert(word: Word) {
        Thread(Runnable {
            wordDao.insert(word)
        }).start()
    }


    fun insert(user: User) {
        Thread(Runnable {
            userDao.insert(user)
        }).start()
    }
}
