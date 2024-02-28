package com.coca.bakingapp20

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coca.bakingapp20.databinding.ListItemDetailBinding

class StepAdapter() : ListAdapter<Step, StepViewHolder>(StepDiffCallback()) {

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        return StepViewHolder.from(parent)
    }
}

class StepViewHolder private constructor(val binding: ListItemDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Step) {
        binding.step.text = item.shortDescription
        Log.e("tagz", "outside ${item.videoURL}")
        if (item.videoURL != null){
            Log.e("tagz", "video${item.videoURL}")
            binding.playButton.isVisible = true
        } else{
            binding.playButton.isVisible = false
        }
    }

    companion object {
        fun from(parent: ViewGroup): StepViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemDetailBinding.inflate(layoutInflater, parent, false)
            return StepViewHolder(binding)
        }
    }
}

class StepDiffCallback :
    DiffUtil.ItemCallback<Step>() {
    override fun areItemsTheSame(oldItem: Step, newItem: Step): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Step, newItem: Step): Boolean {
        return oldItem == newItem
    }
}






