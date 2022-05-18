package com.example.news_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.ItemMainBinding
import com.example.news_app.models.Data
import com.squareup.picasso.Picasso

class MainAdapter(var list: List<Data>) : RecyclerView.Adapter<MainAdapter.Vh>() {

    inner class Vh(var itemMainBinding: ItemMainBinding) :
        RecyclerView.ViewHolder(itemMainBinding.root){

        fun onBind(item: Data) {


                itemMainBinding.headline.text = item.title
                itemMainBinding.author.text = item.author
                itemMainBinding.dare.text = item.published_at.slice(0 until 10)









        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int = list.size


}