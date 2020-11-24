package com.example.rvproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rvproject.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

       var sp = ivSplashScreen
        sp.alpha =0f

        sp.animate().alpha(1f).setDuration(2000).withEndAction {
            val i = Intent(this,MainActivity::class.java)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            startActivity(i)
            finish()

        }





    }
}