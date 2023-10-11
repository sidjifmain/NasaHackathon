package com.example.nasa

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.nasa.databinding.ActivityChoosingBinding

class Choosing : AppCompatActivity() {
    lateinit var binding: ActivityChoosingBinding
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yanlis.setOnClickListener {
            binding.yanlis.setBackgroundResource(R.drawable.red_btn_back)
            playYanlisCevapSound()
        }
        binding.yanlis2.setOnClickListener {
            binding.yanlis2.setBackgroundResource(R.drawable.red_btn_back)
            playYanlisCevapSound()
        }
        binding.dogru.setOnClickListener {
            binding.dogru.setBackgroundResource(R.drawable.btn_green)
            playDogruCevapSound()
        }
    }

    private fun playDogruCevapSound() {
        val dogruCevapMediaPlayer = MediaPlayer.create(this, R.raw.correct) // Doğru cevap ses dosyasını ekleyin
        dogruCevapMediaPlayer.start()
        dogruCevapMediaPlayer.setOnCompletionListener {
            dogruCevapMediaPlayer.release() // Çalma tamamlandığında MediaPlayer'ı serbest bırakın
        }
    }

    private fun playYanlisCevapSound() {
        val yanlisCevapMediaPlayer = MediaPlayer.create(this, R.raw.wrong) // Yanlış cevap ses dosyasını ekleyin
        yanlisCevapMediaPlayer.start()
        yanlisCevapMediaPlayer.setOnCompletionListener {
            yanlisCevapMediaPlayer.release() // Çalma tamamlandığında MediaPlayer'ı serbest bırakın
        }
    }


}