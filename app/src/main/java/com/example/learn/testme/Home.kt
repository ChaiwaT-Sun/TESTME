package com.example.learn.testme

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class Home : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById<View>(R.id.manu_ber) as BottomNavigationView
        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: androidx.fragment.app.Fragment? = null
            when (item.itemId) {
                R.id.action_category -> selectedFragment = CategoryFragment.Companion.newInstance()
                R.id.action_history -> selectedFragment = HistoryFragment.Companion.newInstance()
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, selectedFragment!!)
            transaction.commit()
            true
        }
        setDefaultFragment()
    }

    private fun setDefaultFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, CategoryFragment.Companion.newInstance())
        transaction.commit()
    }
}