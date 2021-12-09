package com.ronnie.presenatation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronnie.domain.Image
import com.ronnie.presenatation.databinding.ImageItemBinding
import kotlin.random.Random

class ImagesAdapter(private val clicked: (String) -> Unit) :
    RecyclerView.Adapter<ImagesAdapter.OrdersViewHolder>() {

    private val imagesList = ArrayList<Image>()

    @SuppressLint("NotifyDataSetChanged")
    fun setImages(list: List<Image>) {
        imagesList.clear()
        imagesList.addAll(list)
        notifyDataSetChanged()
    }

    inner class OrdersViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindPlayer(imagePassed: Image) {
            binding.apply {
                setImage(imagePassed)
                root.setOnClickListener {
                    clicked.invoke("")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        return OrdersViewHolder(
           ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.bindPlayer(imagesList[position])
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}