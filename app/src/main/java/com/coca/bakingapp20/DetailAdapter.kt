package com.coca.bakingapp20

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coca.bakingapp20.databinding.ListItemDetailBinding

class StepAdapter(val clickListener: StepListener) : ListAdapter<Step, StepViewHolder>(StepDiffCallback()) {

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        return StepViewHolder.from(parent)
    }
}

class StepViewHolder private constructor(val binding: ListItemDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Step, clickListener: StepListener) {
        binding.step.text = item.shortDescription
        if (item.videoURL != null){
            binding.playButton.isVisible = true
        } else{
            binding.playButton.isVisible = false
        }
        binding.playButton.setOnClickListener {
            clickListener.onClick(item)
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


open class StepListener(val clickListener: (step: Step) -> Unit) {
    fun onClick(step: Step) = clickListener(step)
}






