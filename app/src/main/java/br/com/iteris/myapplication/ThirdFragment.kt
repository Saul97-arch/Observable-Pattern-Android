package br.com.iteris.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.fragment.app.Fragment

class ThirdFragment : Fragment(), Subject {

    private lateinit var button : ToggleButton

    private val observers: MutableList<Observer?>

    init {
        observers = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        button = view.findViewById(R.id.toggle_button)

        button.setOnClickListener {
            notifyObservers()
        }

        return view
    }

    override fun register(observer: Observer?) {
        if (!observers.contains(observer)) {
            observers.add(observer)
        }
    }

    override fun unregister(observer: Observer?) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer?.update(button.isChecked)
        }
    }
}