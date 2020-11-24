package com.example.rvproject.Activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.rvproject.Fragment.HomeFragment
import com.example.rvproject.Fragment.TopPeopleFragment
import com.example.rvproject.Fragment.TopRatedFragment
import com.example.rvproject.Model.Result
import com.example.rvproject.Model.TopUpComing
import com.example.rvproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var fm: FragmentManager

    }

    private lateinit var topPeopleFragment: TopPeopleFragment
    private lateinit var topRated: TopRatedFragment
    private lateinit var topUpComing: HomeFragment

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager

        topUpComing = HomeFragment()
        fm.beginTransaction().replace(R.id.fragment_container, topUpComing)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when (it.itemId) {


                R.id.btnTopRated -> {
                    topRated = TopRatedFragment()
                    fm.beginTransaction().replace(R.id.fragment_container, topRated)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.btnHome -> {
                    topUpComing = HomeFragment()
                    fm.beginTransaction().replace(R.id.fragment_container, topUpComing)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.btnTopActors -> {

                    topPeopleFragment = TopPeopleFragment()
                    fm.beginTransaction().replace(R.id.fragment_container, topPeopleFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }


            }
            true

        }

    }
}




