package com.example.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nasa.databinding.ActivityQuizBinding

class Quiz : AppCompatActivity() {
    lateinit var binding : ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackQuiz.setOnClickListener{
                finish()
        }
    }
}