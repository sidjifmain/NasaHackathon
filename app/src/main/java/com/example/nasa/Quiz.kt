package com.example.nasa

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.nasa.databinding.ActivityQuizBinding

data class SoruCevap(val soruMetni: String, val dogruCevap: Int, val cevapMetni: List<String>)
class Quiz : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding

    private val soruListesi = listOf(
        SoruCevap("In which year did Neil Armstrong, Buzz Aldrin, and Michael Collins set foot on the Moon during the Apollo 11 mission?", 1, listOf("A) 1969 - Apollo 11 ", "B) 1973 - Apollo 9", "C) 1981 - Apollo 5", "D) 1961 - Apollo 11")),
        SoruCevap("Just as Grandfather said, the Moon's low gravity is truly fascinating! How would it be to live there since the gravity on the Moon is much weaker compared to Earth? Which of the following options contains a correct explanation about the Moon's low gravity?", 3, listOf("A) Walking would be much faster; it's like we were flying!", "B) Our weights would be much lighter; everything would be easier to lift!", "C) While sitting on the Moon, we would feel higher above the ground, as if in a constant state of jumping!", "D) Due to the Moon's low gravity, we could fly, like space birds!")),
        SoruCevap("Ali's Grandfather is talking about the mountains and craters on the Moon's surface. How were these natural formations created?", 2, listOf("A) Through natural processes ", "B) By alien visitors", "C) By magical powers", "D) Through the effects of wind and rain")),
        SoruCevap("Son, the changing appearance of the Moon is actually related to the Earth's rotation around it. Which option accurately explains the reason for the Moon's varying shapes?", 4, listOf("A) Due to the movements of the Moon and Earth", "B) It might have been altered by aliens", "C) Under the influence of magical powers", "D) It might be concealed by wind and clouds")),
        SoruCevap("Ali's father emphasizes that the sky is filled with mysteries. What is the greatest mystery to explore in the sky?", 1, listOf("A) The nature of distant galaxies", "B) The possibility of extraterrestrial life", "C) The behavior of black holes", "D) The formation of stars "))
    )

    private var currentSoruIndex = 0
    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnBackQuiz.setOnClickListener {
//            finish()
//        }

        binding.btnA.setOnClickListener {
            checkCevap(1)
        }
        binding.btnB.setOnClickListener {
            checkCevap(2)
        }
        binding.btnC.setOnClickListener {
            checkCevap(3)
        }
        binding.btnD.setOnClickListener {
            checkCevap(4)
        }

        showSoru(currentSoruIndex)


    }

    private fun showSoru(index: Int) {
        if (index < soruListesi.size) {
            val soru = soruListesi[index]
            binding.question.text = soru.soruMetni
            binding.btnA.text = soru.cevapMetni[0]
            binding.btnB.text = soru.cevapMetni[1]
            binding.btnC.text = soru.cevapMetni[2]
            binding.btnD.text = soru.cevapMetni[3]
        } else {
            startActivity(Intent(this@Quiz , LevelChooeing::class.java))
            finish()
        }
    }

    private fun checkCevap(selectedCevap: Int) {
        val soru = soruListesi[currentSoruIndex]
        if (selectedCevap == soru.dogruCevap) {
            currentSoruIndex++
            showSoru(currentSoruIndex)
            playDogruCevapSound()
        } else {
            playYanlisCevapSound()
            startActivity(Intent(this@Quiz , StoryPage::class.java))
            finish()
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