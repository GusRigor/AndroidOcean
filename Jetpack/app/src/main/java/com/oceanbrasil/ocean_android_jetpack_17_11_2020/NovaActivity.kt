package com.oceanbrasil.ocean_android_jetpack_17_11_2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nova.*

class NovaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova)
    }

    override fun onStart() {
        super.onStart()

        val viewModel =
            ViewModelProvider(this, TextViewModelFactory())
                .get(TextViewModel::class.java)

        textView3.text = viewModel.text
    }
}