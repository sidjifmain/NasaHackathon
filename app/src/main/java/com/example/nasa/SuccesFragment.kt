package com.example.nasa

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SuccesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuccesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_succes, container, false)

        // Popup görünümünü başlatmak için bir düğme tıklamasını bekleyin veya otomatik olarak başlatın.
        val popupButton = rootView.findViewById<Button>(R.id.leader_board)

        popupButton.setOnClickListener {

            showPopup()
        }

        return rootView
    }


    private fun showPopup() {

        Log.d("salam" , "salam")
        val popupView = LayoutInflater.from(requireContext()).inflate(R.layout.leader_layout, null)
        Log.d("salam" , "salam2")
        val popupWindow = PopupWindow(
            popupView,
            1000,
            1500,

            true
        )

        Log.d("salam" , "salam3")
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

    }




}