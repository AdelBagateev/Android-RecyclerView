package com.example.list_items

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.list_items.databinding.FragmentInfoBinding
import com.example.list_items.model.Teacher
import com.example.list_items.model.TeacherRepository

class InfoFragment : Fragment(R.layout.fragment_info) {
    var binding: FragmentInfoBinding ?= null
    val teachers = TeacherRepository.teachers
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentInfoBinding.bind(view)
        val teacherID: Int = arguments?.getInt(ARG_NAME) ?: 1
        val teacher : Teacher? =  teachers.find {
            it.id == teacherID
        }
        val glide =  Glide.with(this)
        binding?.run {
            tvName.text = "NAME :" + teacher?.name
            tvId.text = "ID :" +teacherID.toString()
            tvSubject.text = "SUBJECT :" +teacher?.subject
            Log.e("ssss", "OK")
            glide.load(teacher?.cover)
                .placeholder(R.drawable.ic_baseline_emoji_people_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(ivPhoto)
        }


    }


    companion object {
        private const val ARG_NAME = "id"
        fun newInstance(id: Int) = InfoFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_NAME, id)
            }
        }
    }
}