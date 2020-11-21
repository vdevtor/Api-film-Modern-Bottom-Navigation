package com.example.rvproject

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.rvproject.Adapter.FragmentViewPagerAdapter
import com.example.rvproject.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment : HomeFragment
    private lateinit var searchFragment : SearchFragment
    private lateinit var addFragment : AddFragment
    private lateinit var notFrag : NotificationFragment
    private lateinit var ProfileFragment : ProfileFragment

    private lateinit var mViewPager: ViewPager



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager


        //init views

        mViewPager = findViewById(R.id.mViewPager)
        // init buttons


        var adapter = FragmentViewPagerAdapter(this, this.supportFragmentManager)
        mViewPager.adapter = adapter
        mViewPager.offscreenPageLimit = 5



       homeFragment = HomeFragment()
        fm.beginTransaction().replace(R.id.fragment_container,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit()
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {

             when (it.itemId) {

                R.id.btnHome -> {

                    homeFragment = HomeFragment()
                        fm.beginTransaction().replace(R.id.fragment_container,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


                }
                 R.id.btnSearch-> {
                     fm.beginTransaction().remove(homeFragment)
                    searchFragment = SearchFragment()
                     fm.beginTransaction().replace(R.id.fragment_container,searchFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


                 }
                 R.id.btnAdd -> {
                     fm.popBackStackImmediate()
                     addFragment = AddFragment()
                     fm.beginTransaction().replace(R.id.fragment_container,addFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


                 }
                 R.id.btnNot -> {
                    notFrag = NotificationFragment()
                     fm.beginTransaction().replace(R.id.fragment_container,notFrag).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


                 }
                 R.id.btnPerfil-> {
                     ProfileFragment = ProfileFragment()
                     fm.beginTransaction().replace(R.id.fragment_container,ProfileFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                     fm.popBackStack()


                 }


        }

            true

    }



}
}




