package com.example.nasa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.random.Random

class WordFind : AppCompatActivity() {
    private val spaceWords = listOf(
        "astronaut",
        "spaceship",
        "galaxy",
        "meteor",
        "telescope",
        "orbit",
        "alien",
        "comet",
        "star",
        "planet",
        "nebula",
        "cosmos",
        "black hole",
        "shuttle",
        "exploration",
        "gravity",
        "astronomy",
        "satellite",
        "moonwalk",
        "rocket",
        "cosmonaut",
        "celestial",
        "astrophysics",
        "supernova",
        "quasar",
        "interstellar",
        "cosmic",
        "zero gravity",
        "extraterrestrial"
    )


    private lateinit var currentWord: String
    private var score = 0
    private var wordCount = 0
    private lateinit var resultTextView: TextView
    private lateinit var wordTextView: TextView
    private lateinit var editText: EditText
    private lateinit var nextButton: Button
    private lateinit var skipButton: Button
    private lateinit var pageCounter: TextView
    private var originalWord: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_find)

        resultTextView = findViewById(R.id.result)
        editText = findViewById(R.id.input)
        nextButton = findViewById(R.id.check)
        skipButton = findViewById(R.id.skip)
        pageCounter = findViewById(R.id.counter)
        wordTextView = findViewById(R.id.word)

        nextButton.setOnClickListener {
            checkAnswer()
        }

        skipButton.setOnClickListener {
            skipWord()
        }

        selectWord()
    }

    private fun selectWord() {
        if (wordCount < 5) {
            originalWord = spaceWords[Random.nextInt(spaceWords.size)]
            val shuffledWord = originalWord.toCharArray().toMutableList()
            shuffledWord.shuffle()
            currentWord = shuffledWord.joinToString("")
            wordTextView.text = currentWord
        } else {
            gameOver()
        }
    }

    private fun checkAnswer() {
        val userText = editText.text.toString().trim()
        if (userText.equals(originalWord, ignoreCase = true)) {
            score++
            resultTextView.text = "Correct!"
            resultTextView.setTextColor(ContextCompat.getColor(this, R.color.green))
        } else {
            resultTextView.text = "Wrong!"
            resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
        wordCount++
        updatePageCounter()
        selectWord()
        editText.text.clear()
    }

    private fun skipWord() {
        wordCount++
        updatePageCounter()
        selectWord()
        editText.text.clear()
    }

    private fun updatePageCounter() {
        pageCounter.text = "$wordCount / 5"
    }

    private fun gameOver() {
        pageCounter.text = "5 / 5"
        resultTextView.text = "Your Score: $score / 5"
        nextButton.isEnabled = false
        skipButton.isEnabled = false
    }
}
