package com.coca.edittextapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coca.bakingapp20.Recipe
import com.coca.bakingapp20.databinding.ListItemBinding

class RecipeAdapter(val clickListener: RecipeListener)  : ListAdapter<Recipe, RecipeViewHolder>(NoteDiffCallback()) {

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent)
    }
}
class RecipeViewHolder private constructor(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Recipe, clickListener: RecipeListener) {
        binding.recipeName.text = item.name

        binding.recipeName.setOnClickListener {
            clickListener.onClick(item)
        }
    }
    companion object {
        fun from(parent: ViewGroup): RecipeViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(layoutInflater, parent, false)
            return RecipeViewHolder(binding)
        }
    }
}
class NoteDiffCallback :
    DiffUtil.ItemCallback<Recipe>() {
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem == newItem
    }
}
open class RecipeListener(val clickListener: (recipe: Recipe) -> Unit) {
    fun onClick(recipe: Recipe) = clickListener(recipe)
}
