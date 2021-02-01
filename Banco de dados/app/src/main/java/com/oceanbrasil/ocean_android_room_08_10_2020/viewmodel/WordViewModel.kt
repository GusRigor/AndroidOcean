package com.oceanbrasil.ocean_android_room_08_10_2020.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.oceanbrasil.ocean_android_room_08_10_2020.model.Word
import com.oceanbrasil.ocean_android_room_08_10_2020.model.Repository

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)

    val allWords = repository.allWords

    fun insert(word: Word) {
        repository.insert(word)
    }
}
