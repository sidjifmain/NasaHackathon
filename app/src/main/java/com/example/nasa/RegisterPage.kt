package com.example.nasa

import SelectSkin
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.nasa.databinding.ActivityHomePageBinding
import com.example.nasa.databinding.ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {
    lateinit var binding: ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(GetDatas())

        var clickCount = 0

        binding.button.setOnClickListener{
            clickCount++

            if (clickCount == 2){
                val intent = Intent(this@RegisterPage, HomePage::class.java)
                startActivity(intent)
            }

            replaceFragment(SelectSkin())


        }




    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.register_frame,fragment)
        fragmentTransaction.commit()


    }
}