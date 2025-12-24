package com.example.lifecycledemoapp.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lifecycledemoapp.fragment.HomeFragment
import com.example.lifecycledemoapp.fragment.ProfileFragment
import com.example.lifecycledemoapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")


        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment()).commit()
        }

        findViewById<Button>(R.id.btnHome).setOnClickListener {
                replaceFragment(HomeFragment())
        }

        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            replaceFragment(ProfileFragment())
        }


    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    companion  object {
        private const val TAG = "LifeCycle MainActivity"

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}