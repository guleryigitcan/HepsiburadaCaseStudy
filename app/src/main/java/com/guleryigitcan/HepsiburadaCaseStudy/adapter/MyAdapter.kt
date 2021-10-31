package com.guleryigitcan.HepsiburadaCaseStudy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guleryigitcan.HepsiburadaCaseStudy.Comminicator
import com.guleryigitcan.HepsiburadaCaseStudy.R

import com.guleryigitcan.HepsiburadaCaseStudy.model.Product

class MyAdapter(private val list:List<Product>, private val listener:Comminicator):RecyclerView.Adapter<MyAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        private val artistName by lazy {itemView.findViewById<TextView>(R.id.artist_name_item)}
        private val collectionName by lazy {itemView.findViewById<TextView>(R.id.collection_name_item)}
        private val collectionPrice by lazy { itemView.findViewById<TextView>(R.id.collection_price_item) }
        private val releaseDate by lazy { itemView.findViewById<TextView>(R.id.release_date_item) }
        private val imageOfMusic by lazy {itemView.findViewById<ImageView>(R.id.list_image)}

        fun bind(product:Product){


            if(product.kind=="ebook"){
                Glide.with(imageOfMusic.context)
                    .load(product.artworkUrl100)
                    .circleCrop()
                    .into(imageOfMusic)

                artistName.text=product.artistName
                collectionPrice.text= product.price.toString()+"$"
                releaseDate.text=product.releaseDate
            }
            else if(product.kind=="software"){
                Glide.with(imageOfMusic.context)
                    .load(product.artworkUrl100)
                    .circleCrop()
                    .into(imageOfMusic)

                artistName.text=product.artistName
                collectionName.text=product.trackName
                collectionPrice.text= product.price.toString()+"$"
                releaseDate.text=product.releaseDate

            }
            else{
                artistName.text=product.artistName
                collectionName.text=product.trackName
                collectionPrice.text=product.collectionPrice.toString()+"$"
                releaseDate.text=product.releaseDate


                Glide.with(imageOfMusic.context)
                    .load(product.artworkUrl100)
                    .circleCrop()
                    .into(imageOfMusic)

            }



        }


        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position=adapterPosition
            val id=list[position].trackId
            if (position != RecyclerView.NO_POSITION) {
                if (id != null) {
                    listener.passData(id)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(list[position])

    }



    override fun getItemCount(): Int {
        return list.size
    }
}