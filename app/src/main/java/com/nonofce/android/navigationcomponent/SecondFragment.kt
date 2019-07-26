package com.nonofce.android.navigationcomponent

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : androidx.fragment.app.Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var my_first_name: String = ""

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
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //my_name.text = getString(R.string.your_name_is) + " " + SecondFragmentArgs.fromBundle(arguments).yourName
        my_first_name = arguments?.let {
            SecondFragmentArgs.fromBundle(it).yourName
        } ?: "No name"
        my_name.text = getString(R.string.your_name_is) + " " + my_first_name
        second_button.setOnClickListener {
            val secondToThirdAction = SecondFragmentDirections.secondToThird().apply {
                setYourFullName(
                    my_first_name + " " + when (last_name_edit.text.toString()) {
                        "" -> "No Last name"
                        else -> last_name_edit.text.toString()
                    }
                )
            }
            Navigation.findNavController(it).navigate(secondToThirdAction)
        }
    }

}
