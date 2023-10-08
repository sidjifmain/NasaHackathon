package com.example.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.nasa.databinding.ActivityHomePageBinding

@Suppress("DEPRECATION")
class HomePage : AppCompatActivity() {
    lateinit var binding : ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var menu = binding.bottomNavBar.menu
        menu.findItem(R.id.home).isChecked = true
        replaceFragment(HomeFragment())


        binding.hambur.setOnClickListener{
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.pro.setOnClickListener{
            replaceFragment(Premium())
        }




        binding.bottomNavBar.setOnItemSelectedListener {

            when(it.itemId){

                R.id.storyMap -> story()
                R.id.vr -> vr()
                R.id.home -> home()
                R.id.store -> store()
                R.id.achievement -> achivement()

                else ->{

                }

            }

            true

        }



    }

    fun story(){
        replaceFragment(Story_Fragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.map_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.map_color))

    }

    fun vr(){
        replaceFragment(VrFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    fun home(){
        replaceFragment(HomeFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    fun store(){
        replaceFragment(StoreFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    fun achivement(){
        replaceFragment(SuccesFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

     private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()


    }
}