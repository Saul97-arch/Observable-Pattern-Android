package br.com.iteris.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FirstFragment : Fragment(), Observer {

    private lateinit var tv: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        tv = view.findViewById(R.id.tv_first_fragment)

        return view
    }

    @SuppressLint("SetTextI18n")
    override fun update(checked: Boolean) {
        if (checked) {
            tv.text = "ON"
        } else {
            tv.text = "OFF"
        }
    }
}