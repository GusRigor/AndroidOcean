package com.oceanbrasil.ocean_android_jetpack_17_11_2020

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class TextViewModelFactory : ViewModelProvider.Factory {

    var textView = TextViewModel()
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return textView as T
    }

}
