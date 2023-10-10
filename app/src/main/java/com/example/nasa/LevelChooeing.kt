package com.example.nasa

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.nasa.databinding.ActivityLevelChooeingBinding
import com.example.nasa.databinding.CustomDialogLayoutBinding

class LevelChooeing : AppCompatActivity() {
    lateinit var binding : ActivityLevelChooeingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelChooeingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvl1Btn.setOnClickListener{
            val intent = Intent(this@LevelChooeing , StoryPage::class.java)
            startActivity(intent)
        }


        binding.lvl2Btn.setOnClickListener{
            val intent = Intent(this@LevelChooeing , Choosing::class.java)
            startActivity(intent)
        }

    }
}