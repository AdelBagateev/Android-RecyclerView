package com.example.list_items.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.list_items.R
import com.example.list_items.databinding.ItemTeacherBinding
import com.example.list_items.model.Teacher

class TeacherItem(
    private val binding: ItemTeacherBinding,
    private val glide: RequestManager,
    private val action: (Teacher) -> Unit,
) :  RecyclerView.ViewHolder(binding.root) {
    private var teacher: Teacher? = null

    private val option = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    init {
        itemView.setOnClickListener {
            teacher?.also(action)
        }
//         use only one [setOnClickListener]
    }

    fun OnBind(teacher: Teacher) {
        with(binding) {
            tvName.text = teacher.name
            tvSubj.text = teacher.subject




            glide
                .load(teacher.cover)
                .apply(option)
                .placeholder(R.drawable.ic_baseline_emoji_people_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(ivPhoto)
            root.setOnClickListener {
                action(teacher)
            }
        }
    }
}
