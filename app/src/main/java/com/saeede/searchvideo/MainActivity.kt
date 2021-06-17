package com.saeede.searchvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saeede.searchvideo.features.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container,SearchFragment(),null).commit()

    }
}