package com.example.nasa

import android.animation.ValueAnimator
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import com.example.nasa.databinding.ActivityStoryPageBinding

@Suppress("DEPRECATION")
class StoryPage : AppCompatActivity() {
    lateinit var binding : ActivityStoryPageBinding
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.backBtn.setOnClickListener{
            finish()
        }

        var babaText = arrayOf("Yes, Joseph, the changes in the Moon's appearance are fascinating. As the Moon revolves around the Earth, it also rotates around its own axis",
            "This rotation movement causes the Moon to show us different faces.",
            "Sometimes, the Moon appears yellowish because the dust and gases in our atmosphere color its light this way. ",
            "Additionally, the Moon looks more pronouncedly yellow when it rises or sets at a low angle.",
            "Do you see the mountains and craters on the Moon's surface? They were formed a long time ago by meteors colliding with the Moon.",
            " Humans first set foot on the Moon in 1969 during the Apollo 11 mission. ",
            "Oh, and don't forget, Joseph, jumping high on the Moon is much easier and fun due to the Moon's weak gravity.",
            " 'Yes, Joseph, the Moon is indeed a marvelous place. Now let's watch the sky to discover more. Who knows, maybe one day you will want to go to the Moon too!'")
        var usaqText = arrayOf("Grandfather, why does the Moon appear in different shapes?" , "Why does it sometimes look full, sometimes half, and sometimes not at all? Can you tell me about the Moon?" , "GrandFather, the Moon seems truly magical. Thank you, learning such wonderful things with you is amazing")
        var apariciSes = arrayOf("One night, little Joseph watched the shining Moon in the sky, and his father came beside him" , "Joseph's eyes were gleaming with curiosity, and he asked" ,
            "Smiling, his father began","Joseph was deeply impressed by his father's answers","'Smiling, his father hugged Joseph",

            )


        writeText(apariciSes[0],5000 , R.raw.aparici0)
        binding.storyImg.setImageResource(R.drawable.pic1)

        var saygac = 1
        binding.btnNext.setOnClickListener{
            saygac++

            if (saygac == 2){
                binding.storyImg.setImageResource(R.drawable.pic2)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(apariciSes[1],3000 , R.raw.aparici1)
            }
            else if (saygac == 3){
                binding.storyImg.setImageResource(R.drawable.pic5)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(usaqText[0], 2000, R.raw.usaq0)

            }
            else if (saygac == 4){
                binding.storyImg.setImageResource(R.drawable.pic6)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(usaqText[1],5000 , R.raw.usaq1)
            }
            else if (saygac == 5){
                binding.storyImg.setImageResource(R.drawable.pic4)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(apariciSes[2],2000 , R.raw.aparici2)
            }
            else if (saygac == 6){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[0] , 8000 , R.raw.baba0)
            }
            else if (saygac == 7){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[1] , 3000, R.raw.baba1)
            }
            else if (saygac == 8){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[2] , 5000 , R.raw.baba2)
            }
            else if (saygac == 9){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[3] , 4000 , R.raw.baba3)
            }
            else if (saygac == 10){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[4], 6000 , R.raw.baba4)
            }
            else if (saygac == 11){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[5], 4000 , R.raw.baba5)
            }
            else if (saygac == 12){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[6], 6000 , R.raw.baba6)
            }
            else if (saygac == 13){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(apariciSes[3], 3000 , R.raw.aparici3)
            }
            else if (saygac == 14){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(usaqText[2], 6000 , R.raw.usaq2)
            }
            else if (saygac == 15){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(apariciSes[4], 2000 , R.raw.aparici4)
            }
            else if (saygac == 16){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(babaText[7], 10000 , R.raw.baba7)
            }
            else{
                saygac = 0
                finish()
                val intent = Intent(this@StoryPage, Quiz::class.java)
                startActivity(intent)
            }
        }



    }

    fun writeText(text : String , duration: Long , audio : Int){
        val handler = Handler()

        animateTextSlowly(binding.storyText , text , duration , 200)


        mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        handler.postDelayed({
            binding.btnNext.visibility = View.VISIBLE
        }, duration)
    }

    fun animateTextSlowly(textView: TextView, text: String, duration: Long, delay: Long) {
        val interval = duration / text.length
        var currentIndex = 0

        val handler = Handler()

        fun animateText() {
            if (currentIndex < text.length) {
                val currentText = text.substring(0, currentIndex + 1)
                textView.text = currentText
                currentIndex++
                handler.postDelayed({
                    animateText()
                }, interval)
            } else {

            }
        }

        handler.postDelayed({
            animateText()
        }, delay)
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.stop()
    }
}