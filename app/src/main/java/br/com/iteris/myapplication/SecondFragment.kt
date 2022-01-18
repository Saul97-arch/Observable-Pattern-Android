package br.com.iteris.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class SecondFragment : Fragment(), Observer {

    private lateinit var tv : TextView

    companion object {
        fun newInstance() = SecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        tv = view.findViewById(R.id.tv_second_fragment)

        return view
    }

    // Passando o dado pelo construtor evitamos acoplamento, isso é o Strategy Pattern
    @SuppressLint("SetTextI18n")
    override fun update(checked: Boolean) {
        if (checked) {
            tv.text = "ON"
        } else {
            tv.text = "OFF"
        }
    }
}