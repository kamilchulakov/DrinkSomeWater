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
        navController.popBackStack(R.id.drinkFragment2, true)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavigationView.apply {
            setupWithNavController(navController)
        }
    }
}