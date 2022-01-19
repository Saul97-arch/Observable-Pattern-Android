package br.com.iteris.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme)
        } else {
            setTheme(R.style.Theme_MyApplication)
        }

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        thirdFragment.register(firstFragment)
        thirdFragment.register(secondFragment)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch = findViewById<SwitchCompat>(R.id.switch_theme)

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        supportFragmentManager.beginTransaction().add(R.id.first_fragment, firstFragment)
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.second_fragment, secondFragment)
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.third_fragment, thirdFragment)
            .commit()
    }
}