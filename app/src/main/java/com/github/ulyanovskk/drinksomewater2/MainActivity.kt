package com.github.ulyanovskk.drinksomewater2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationHost = supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        val navController = navigationHost.navController
        findViewById<BottomNavigationView>(R.id.bottomNavView).apply {
            setupWithNavController(navController)
        }
    }
}