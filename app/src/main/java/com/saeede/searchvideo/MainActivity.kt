package com.saeede.searchvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saeede.searchvideo.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.mainContainer,SearchFragment(),null).commit()

    }
}