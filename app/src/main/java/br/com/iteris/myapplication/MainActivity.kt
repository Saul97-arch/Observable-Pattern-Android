package br.com.iteris.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        // SEMPRE QUE USAR FRAGMENT USE UM FRAMELAYOUT
        /*
        *  Strategy
        *
        * */
        supportFragmentManager.beginTransaction().add(R.id.first_fragment, firstFragment)
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.second_fragment, secondFragment)
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.third_fragment, thirdFragment)
            .commit()

        thirdFragment.register(firstFragment)
        thirdFragment.register(secondFragment)
    }
}