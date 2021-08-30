package com.tobiasstrom.insta.home

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tobiasstrom.insta.R
import com.tobiasstrom.insta.databinding.HomeListItemBinding
import com.tobiasstrom.insta.model.HomeItem

class HomeListAdapter(val data: List<HomeItem>) : RecyclerView.Adapter<HomeListAdapter.ViewModel>() {

    inner class ViewModel(val binding : HomeListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val binding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewModel(binding)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        with(holder){
            with(data[position]){
                binding.userName.text = this.userName
                binding.description.text = Html.fromHtml("<b>${this.userName}</b>  ${this.description}")
                binding.likes.text = this.like
                binding.mainImage.setImageResource(this.mainImage)
                binding.profileImage.setImageResource(this.profileImage)
            }

        }

    }

    override fun getItemCount(): Int  =  data.size
}