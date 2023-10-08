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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLevelChooeingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.lvl1.setOnClickListener{
            val intent = Intent(this@LevelChooeing, StoryPage::class.java)
            startActivity(intent)
        }

        binding.lvl2.setOnClickListener{

            val alertDialogView = layoutInflater.inflate(R.layout.custom_dialog_layout, null)

            // Resmi ImageView'e yerleştirin
            val imageView = alertDialogView.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(R.drawable.store4) // your_image yerine göstermek istediğiniz resmin kaynağı

            // AlertDialog'ı oluşturun
            val builder = AlertDialog.Builder(this)
            builder.setView(alertDialogView)
            builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }


            // AlertDialog'ı göster
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}