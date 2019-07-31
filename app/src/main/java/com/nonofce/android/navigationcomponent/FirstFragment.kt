package com.nonofce.android.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first.*


private const val FIRST_NAME_PARAM = "FIRST_NAME_PARAM"

class FirstFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        first_button.setOnClickListener {
            val firstToSecondAction = FirstFragmentDirections.firstToSecond().apply {
                setYourName(
                    if (your_name_edit.text.toString() == "") {
                        "No name"
                    } else {
                        your_name_edit.text.toString()
                    }
                )
            }
            Navigation.findNavController(it).navigate(firstToSecondAction);
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(FIRST_NAME_PARAM, your_name_edit.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            your_name_edit.setText(it.getString(FIRST_NAME_PARAM))
        }
    }
}
