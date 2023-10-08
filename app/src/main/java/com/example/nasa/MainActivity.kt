package com.example.nasa

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.nasa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var register = false

        val animation = AnimationUtils.loadAnimation(this ,  R.anim.logo_anim)

        binding.logo.startAnimation(animation)

        val animation2 = AnimationUtils.loadAnimation(this ,  R.anim.logo_anim2)

        binding.textView.startAnimation(animation2)


        mediaPlayer = MediaPlayer.create(this, R.raw.ses)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                mediaPlayer.start()
            }

            override fun onAnimationEnd(animation: Animation?) {
                if (register == true){
                    val intent = Intent(this@MainActivity, RegisterPage::class.java)
                    startActivity(intent)
                }
                else {
                    val intent = Intent(this@MainActivity, HomePage::class.java)
                    startActivity(intent)
                }

            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()

        mediaPlayer.release()
    }

}

