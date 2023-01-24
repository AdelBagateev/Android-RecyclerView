package com.example.list_items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.list_items.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        val manager: FragmentManager = supportFragmentManager
        manager.beginTransaction()
            .add(R.id.cont_main, MainFragment(), "FIRST_FRAG")
            .commit()
    }
}