package com.example.nasa

import android.os.Bundle
import android.service.voice.VoiceInteractionSession.VisibleActivityCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

data class CosmosSoru(
    val soruMetni: String,
    val cevaplar: List<String>,
    val dogruCevapIndex: Int
)

class QuickQuiz : Fragment() {

    val cosmosSorular = listOf(
        CosmosSoru(
            "What is the closest star to Earth?",
            listOf("Mars", "Venus", "The Sun"),
            2
        ),
        CosmosSoru(
            "Which planet is known as the Red Planet?",
            listOf("Earth", "Jupiter", "Mars"),
            2
        ),
        CosmosSoru(
            "How many planets are there in our Solar System?",
            listOf("8", "10", "12"),
            0
        ),
        CosmosSoru(
            "What is the largest moon of Saturn?",
            listOf("Europa", "Ganymede", "Titan"),
            2
        ),
        CosmosSoru(
            "What causes the seasons on Earth?",
            listOf("The tilt of the Earth's axis", "The distance from the Sun", "The Moon's gravity"),
            0
        ),
        CosmosSoru(
            "What is the smallest planet in our Solar System?",
            listOf("Earth", "Venus", "Mercury"),
            2
        ),
        CosmosSoru(
            "Which planet is known as the 'Morning Star' or 'Evening Star'?",
            listOf("Mars", "Jupiter", "Venus"),
            2
        ),
        CosmosSoru(
            "What is the largest planet in our Solar System?",
            listOf("Saturn", "Uranus", "Jupiter"),
            2
        ),
        CosmosSoru(
            "What is the name of the fifth planet from the Sun?",
            listOf("Neptune", "Jupiter", "Pluto"),
            1
        ),
        CosmosSoru(
            "What is the most abundant gas in Earth's atmosphere?",
            listOf("Oxygen", "Carbon dioxide", "Nitrogen"),
            2
        ),
        CosmosSoru(
            "What is the second planet from the Sun?",
            listOf("Earth", "Venus", "Mercury"),
            1
        ),
        CosmosSoru(
            "Which planet is known as the 'Red Planet'?",
            listOf("Mars", "Jupiter", "Venus"),
            0
        ),
        CosmosSoru(
            "What is the largest planet in our Solar System?",
            listOf("Saturn", "Uranus", "Jupiter"),
            2
        ),
        CosmosSoru(
            "How many Earths could fit inside Jupiter?",
            listOf("1,000", "1,300", "1,500"),
            1
        ),
        CosmosSoru(
            "What is the name of the largest moon of Neptune?",
            listOf("Triton", "Phobos", "Dione"),
            0
        ),
        CosmosSoru(
            "Which planet has the Great Red Spot?",
            listOf("Mars", "Jupiter", "Venus"),
            1
        ),
        CosmosSoru(
            "What is the farthest planet from the Sun?",
            listOf("Neptune", "Jupiter", "Pluto"),
            0
        ),
        CosmosSoru(
            "What is the name of the first American woman in space?",
            listOf("Sally Ride", "Valentina Tereshkova", "Yuri Gagarin"),
            0
        ),
        CosmosSoru(
            "What is the name of the first satellite launched into space?",
            listOf("Apollo 11", "Sputnik 1", "Voyager 2"),
            1
        )
    )


    private var currentSoruIndex = 0
    private var correctAnswers = 0
    private lateinit var optionButtons: List<Button>
    private lateinit var questionTextView: TextView
    private lateinit var restart: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quick_quiz, container, false)
        questionTextView = view.findViewById(R.id.quick_quiz_que)

        optionButtons = listOf(
            view.findViewById(R.id.variant_a),
            view.findViewById(R.id.variant_b),
            view.findViewById(R.id.variant_c)
        )

        restart = view.findViewById(R.id.restart)

        // Rastgele 5 soru al
        val selectedSorular = cosmosSorular.shuffled().take(5)

        showSoru(selectedSorular[currentSoruIndex], questionTextView, optionButtons)

        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                checkAnswer(selectedSorular[currentSoruIndex], index, selectedSorular.size, questionTextView)
            }
        }

        return view
    }

    private fun showSoru(soru: CosmosSoru, questionTextView: TextView, optionButtons: List<Button>) {
        questionTextView.text = soru.soruMetni
        soru.cevaplar.forEachIndexed { index, cevap ->
            optionButtons[index].text = cevap
        }
    }

    private fun checkAnswer(soru: CosmosSoru, cevapIndex: Int, totalSorular: Int, questionTextView: TextView) {
        if (cevapIndex == soru.dogruCevapIndex) {
            correctAnswers++
        }

        currentSoruIndex++

        if (currentSoruIndex < totalSorular) {
            showSoru(soru, questionTextView, optionButtons)
        } else {
            // Tüm soruları yanıtladıysanız sonucu görüntüleyebilirsiniz
            val resultText = "Result: $correctAnswers / $totalSorular"
            optionButtons[0].visibility = View.INVISIBLE
            optionButtons[1].visibility = View.INVISIBLE
            optionButtons[2].visibility = View.INVISIBLE
            questionTextView.text = resultText
            restart.visibility = View.VISIBLE
            restart.setOnClickListener {
                startGame()
            }
        }
    }

    private fun startGame() {
        restart.visibility = View.INVISIBLE
        optionButtons[0].visibility = View.VISIBLE
        optionButtons[1].visibility = View.VISIBLE
        optionButtons[2].visibility = View.VISIBLE
        currentSoruIndex = 0
        correctAnswers = 0
        showSoru(cosmosSorular[currentSoruIndex], questionTextView, optionButtons)
    }
}
