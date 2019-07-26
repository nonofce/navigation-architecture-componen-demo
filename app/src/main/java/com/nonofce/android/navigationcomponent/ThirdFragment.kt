package com.nonofce.android.navigationcomponent

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ThirdFragment : androidx.fragment.app.Fragment() {
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
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        full_name.text = getString(R.string.your_full_name_is) + " " + arguments?.let {
            ThirdFragmentArgs.fromBundle(it).yourFullName
        }
        third_button.setOnClickListener {
            Navigation.findNavController(it).navigate(ThirdFragmentDirections.thirdToFirst())
        }
    }
}
