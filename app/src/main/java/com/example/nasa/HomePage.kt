package com.example.nasa


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.PopupWindow
import android.widget.Switch
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.nasa.databinding.ActivityHomePageBinding

@Suppress("DEPRECATION")
class HomePage : AppCompatActivity() {

    lateinit var binding: ActivityHomePageBinding
    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler(Looper.getMainLooper()).postDelayed({
            tanitim()
        }, 1000)

        var menu = binding.bottomNavBar.menu
        menu.findItem(R.id.home).isChecked = true
        replaceFragment(com.example.nasa.HomeFragment())

//        For the back music

            mediaPlayer = MediaPlayer.create(this, R.raw.home_back_sound)
            mediaPlayer.isLooping = true

//        -----------------

        binding.pro.setOnClickListener{
            showPopupWindow()
        }

        binding.logoBtn.setOnClickListener {
            tanitim()
        }

        binding.btnNotification.setOnClickListener {
            notifications()
        }


        binding.hambur.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }


        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.sound -> soundSetting()
                R.id.language -> language()
                R.id.profile_status ->startActivity(Intent(this@HomePage , Quiz::class.java))
            }
            true
        }

        binding.bottomNavBar.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.storyMap -> story()
                R.id.vr -> vr()
                R.id.home -> home()
                R.id.store -> store()
                R.id.achievement -> achivement()

                else -> {

                }
            }

            true

        }


    }

    fun story() {
        replaceFragment(com.example.nasa.Story_Fragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.map_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.map_color))

    }

    fun vr() {
        replaceFragment(QuickQuiz())
        friend()
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    fun home() {
        replaceFragment(com.example.nasa.HomeFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    fun store() {
        replaceFragment(com.example.nasa.StoreFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    fun achivement() {
        replaceFragment(com.example.nasa.SuccesFragment())
        binding.bottomNavBar.setBackgroundColor(resources.getColor(R.color.primary_color))
        binding.toolbar.setBackgroundColor(resources.getColor(R.color.primary_color))

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()


    }


    private fun showPopupWindow() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.popup_window, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)


        val closeButton: Button = popupView.findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }


    }

    private fun soundSetting() {

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.sound_setting, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )


        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)


        binding.drawerLayout.closeDrawer(GravityCompat.START)

        val closeButton: Button = popupView.findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }

        val onOffSwitch = popupView.findViewById<Switch>(R.id.onOffSwitchSound)


        onOffSwitch.isChecked = mediaPlayer.isPlaying

        onOffSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                }
            } else {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()

                }
            }
        }


    }

    private fun notifications() {

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.notflications, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )


        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)




        val closeButton: Button = popupView.findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }







    }

    private fun language() {

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.languages, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )


        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)


        binding.drawerLayout.closeDrawer(GravityCompat.START)

        val check1 = popupView.findViewById<CheckBox>(R.id.checkBox1)
        val check2 = popupView.findViewById<CheckBox>(R.id.checkBox2)
        val check3 = popupView.findViewById<CheckBox>(R.id.checkBox3)

        check2.isChecked = true

        check1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                check2.isChecked = false
                check3.isChecked = false
            }
        }

        check2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                check1.isChecked = false
                check3.isChecked = false
            }
        }

        check3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                check2.isChecked = false
                check1.isChecked = false
            }
        }




        val closeButton: Button = popupView.findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }



    }


    private fun tanitim() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.tanitma, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        val closeButton: Button = popupView.findViewById(R.id.ok_btn)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }
    }

    fun friend() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.friend_popup, null)


        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // Belirli bir süre sonra otomatik olarak kapat
        val handler = android.os.Handler()
        handler.postDelayed({
            if (popupWindow.isShowing) {
                popupWindow.dismiss()
            }
        }, 3000)
    }







    fun muteMediaVolume(activity: Activity) {
        val audioManager = activity.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE)
    }

    fun unmuteMediaVolume(activity: Activity) {
        val audioManager = activity.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE)
    }

    override fun onResume() {
        super.onResume()
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}