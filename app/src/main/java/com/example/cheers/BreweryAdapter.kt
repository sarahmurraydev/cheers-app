package com.example.cheers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cheers.databinding.BreweryBinding
import com.example.cheers.network.Brewery

class BreweryAdapter : ListAdapter<Brewery, BreweryAdapter.BreweryViewHolder>(Diff){

    companion object Diff : DiffUtil.ItemCallback<Brewery>() {
        override fun areItemsTheSame(oldItem: Brewery, newItem: Brewery): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Brewery, newItem: Brewery): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class BreweryViewHolder(
        private val binding: BreweryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(brewery: Brewery) {
            binding.brewery = brewery
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        return BreweryViewHolder(BreweryBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        val brewery = getItem(position)
        holder.bind(brewery)
    }
}