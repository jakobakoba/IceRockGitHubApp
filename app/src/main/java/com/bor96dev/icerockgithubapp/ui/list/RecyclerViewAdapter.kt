package com.bor96dev.icerockgithubapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bor96dev.icerockgithubapp.databinding.ItemLayoutBinding
import com.bor96dev.icerockgithubapp.domain.Repo

class RecyclerViewAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var repos: List<Repo> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int = repos.size

    fun setItems(list: List<Repo>) {
        repos = list
        notifyDataSetChanged()
    }
}

class ItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(source: Repo) {
        binding.tvItemProjectName.text = source.name
        binding.tvItemLanguage.text = source.language
        binding.tvItemDescription.text = source.description
    }
}

