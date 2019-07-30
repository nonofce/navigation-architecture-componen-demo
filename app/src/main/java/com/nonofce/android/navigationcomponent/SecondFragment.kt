package com.nonofce.android.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : androidx.fragment.app.Fragment() {
    private var my_first_name: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

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
