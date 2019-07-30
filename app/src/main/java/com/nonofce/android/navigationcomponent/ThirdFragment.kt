package com.nonofce.android.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_third, container, false)

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
