package com.example.nasa

import android.animation.ValueAnimator
import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.backBtn.setOnClickListener{
            finish()
        }


        var text1 = "One night, little Ali watched the shining Moon in the sky, and his father came beside him. Ali's eyes were gleaming with curiosity, and he asked  him"
        var text2 = "Dad, why does the Moon appear in different shapes? Why does it sometimes look full, sometimes half, and sometimes not at all? Can you tell me about the Moon?"
        var text3 = "Smiling, his father began, 'Yes, Ali, the changes in the Moon's appearance are fascinating. As the Moon revolves around the Earth, it also rotates around its own axis. This rotation movement causes the Moon to show us different faces"
        var text4 = " Sometimes, the Moon appears yellowish because the dust and gases in our atmosphere color its light this way. Additionally, the Moon looks more pronouncedly yellow when it rises or sets at a low angle."
        var text5 = "Do you see the mountains and craters on the Moon's surface? They were formed a long time ago by meteors colliding with the Moon. Humans first set foot on the Moon in 1969 during the Apollo 11 mission. Oh, and don't forget, Ali, jumping high on the Moon is much easier and fun due to the Moon's weak gravity.'"
        var text6 = "Ali was deeply impressed by his father's answers. 'Dad, the Moon seems truly magical. Thank you, learning such wonderful things with you is amazing!'Smiling, his father hugged Ali. 'Yes, Ali, the Moon is indeed a marvelous place. Now let's watch the sky to discover more. Who knows, maybe one day you will want to go to the Moon too!"

        writeText(text1,2500)
        binding.storyImg.setImageResource(R.drawable.pic1)

        var saygac = 1
        binding.btnNext.setOnClickListener{
            saygac++

            if (saygac == 2){
                binding.storyImg.setImageResource(R.drawable.pic2)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(text2,2500)
            }
            else if (saygac == 3){
//                binding.storyImg.setImageResource(R.drawable.pic5)
//                binding.btnNext.visibility = View.INVISIBLE
//                writeText(text3,2500)
                binding.storyText.text = text3
            }
            else if (saygac == 4){
                binding.storyImg.setImageResource(R.drawable.pic6)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(text4,2500)
            }
            else if (saygac == 5){
                binding.storyImg.setImageResource(R.drawable.pic4)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(text5,2500)
            }
            else if (saygac == 6){
                binding.storyImg.setImageResource(R.drawable.pic3)
                binding.btnNext.visibility = View.INVISIBLE
                writeText(text6 , 2500)
            }
            else{
                saygac = 0
                finish()
                val intent = Intent(this@StoryPage, Quiz::class.java)
                startActivity(intent)
            }
        }



    }

    fun writeText(text : String , duration: Long){
        val handler = Handler()

        animateTextSlowly(binding.storyText , text , duration , 500)

        handler.postDelayed({
            binding.btnNext.visibility = View.VISIBLE
        }, 10000)
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
}