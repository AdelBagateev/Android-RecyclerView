package com.example.list_items.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.list_items.databinding.ItemTeacherBinding
import com.example.list_items.model.Teacher

class TeacherAdapter (
    private val list: List<Teacher>,
    private val glide: RequestManager,
    private val action: (Teacher) -> Unit,
) : RecyclerView.Adapter<TeacherItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeacherItem = TeacherItem(
        binding = ItemTeacherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
            false
        ),
        glide = glide,
        action = action
        )


    override fun onBindViewHolder(
        holder: TeacherItem,
        position: Int
    ) {
        holder.OnBind(list[position])
    }

    override fun getItemCount(): Int = list.size



}