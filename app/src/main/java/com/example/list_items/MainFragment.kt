package com.example.list_items

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.list_items.adapter.SpaceItemDecorator
import com.example.list_items.adapter.TeacherAdapter
import com.example.list_items.databinding.FragmentMainBinding
import com.example.list_items.model.TeacherRepository
import com.google.android.material.snackbar.Snackbar
import java.util.zip.Inflater

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding : FragmentMainBinding ?= null
    private var adapter : TeacherAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            val itemDecoration = context?.let {
                SpaceItemDecorator(
                    it,
                    16.0f
                )
            }
            adapter = TeacherAdapter(
                TeacherRepository.teachers,
                glide = Glide.with(this@MainFragment))
                {
                    parentFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                            android.R.anim.fade_in,
                            android.R.anim.fade_out,
                        )
                        .replace(R.id.cont_main, InfoFragment.newInstance(it.id))
                        .addToBackStack("list")
                        .commit()
                }

            rvTeachers.adapter = adapter
            rvTeachers.layoutManager = LinearLayoutManager(context)
            rvTeachers.addItemDecoration(itemDecoration!!)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

}