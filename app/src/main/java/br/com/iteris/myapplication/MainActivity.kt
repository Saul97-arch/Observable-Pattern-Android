package br.com.iteris.myapplication

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private lateinit var switch : SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {

//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            setTheme(R.style.darkTheme)
//        } else {
//            setTheme(R.style.Theme_MyApplication)
//        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val (firstFragment, secondFragment, thirdFragment) = setupFragments()
        Log.i("RONALDO", "onCreate: ESTÁ RODANDO DE NOVO")
        registerObservables(thirdFragment, firstFragment, secondFragment)
        setupSwitchListener()
        stackFragments(firstFragment, secondFragment, thirdFragment)
    }

    private fun stackFragments(
        firstFragment: FirstFragment,
        secondFragment: SecondFragment,
        thirdFragment: ThirdFragment
    ) {
        supportFragmentManager.beginTransaction().replace(R.id.first_fragment, firstFragment)
            .commit()
        supportFragmentManager.beginTransaction().replace(R.id.second_fragment, secondFragment)
            .commit()
        supportFragmentManager.beginTransaction().replace(R.id.third_fragment, thirdFragment)
            .commit()
    }

    private fun setupSwitchListener() {
        switch = findViewById(R.id.switch_theme)
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun registerObservables(
        thirdFragment: ThirdFragment,
        firstFragment: FirstFragment,
        secondFragment: SecondFragment
    ) {
        thirdFragment.register(firstFragment)
        thirdFragment.register(secondFragment)
    }

    private fun setupFragments(): Triple<FirstFragment, SecondFragment, ThirdFragment> {
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        return Triple(firstFragment, secondFragment, thirdFragment)
    }
}