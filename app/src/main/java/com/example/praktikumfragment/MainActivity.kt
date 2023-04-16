package com.example.praktikumfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragementManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragementManager.findFragmentByTag(HomeFragment::class.java.simpleName)
        if (fragment !is HomeFragment){
            fragementManager.beginTransaction()
                .add(
                    R.id.fragment_container,
                    homeFragment,
                    HomeFragment::class.java.simpleName
                ).commit()
        }
    }
}