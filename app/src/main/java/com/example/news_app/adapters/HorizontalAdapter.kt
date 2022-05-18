package com.example.news_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.ItemCardBinding
import com.example.news_app.databinding.ItemMainBinding
import com.example.news_app.models.Data
import com.squareup.picasso.Picasso

class HorizontalAdapter(var list: List<Data>) : RecyclerView.Adapter<HorizontalAdapter.Vh>() {

    inner class Vh(var itemMainBinding: ItemCardBinding) :
        RecyclerView.ViewHolder(itemMainBinding.root){

        fun onBind(item: Data) {


                itemMainBinding.heading.text = item.title
                itemMainBinding.avtor.text = item.author
                itemMainBinding.about.text = item.description









        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int = list.size


}