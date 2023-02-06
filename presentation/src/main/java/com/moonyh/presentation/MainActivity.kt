package com.moonyh.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.moonyh.presentation.databinding.ActivityMainBinding
import com.moonyh.presentation.fragment.SearchFragment

class MainActivity:AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.commit {
            add(R.id.container,SearchFragment(),null)
        }
    }
}