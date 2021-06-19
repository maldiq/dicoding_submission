package com.nizamapp.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        val imgSplash: ImageView = findViewById(R.id.img_splash)

        imgSplash.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_in))

        Handler().postDelayed({
            imgSplash.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_out))
            Handler().postDelayed({
                imgSplash.visibility = View.GONE
                startActivity(Intent(this, MainActivity::class.java))
                finish();
            }, 500)
        }, 2500)
    }
}