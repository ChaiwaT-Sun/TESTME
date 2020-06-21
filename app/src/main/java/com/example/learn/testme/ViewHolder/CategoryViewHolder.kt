package com.example.learn.testme.ViewHolder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.learn.testme.Interface.ItemClickLIstener
import com.example.learn.testme.R

class CategoryViewHolder(itemView: View) : ViewHolder(itemView), View.OnClickListener {
    var category_name: TextView
    var category_image: ImageView
    private var itemClickListener: ItemClickLIstener? = null
    fun setItemClickListener(itemClickListener: ItemClickLIstener?) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(view: View) {
        itemClickListener!!.onClick(view, adapterPosition, false)
    }

    init {
        category_image = itemView.findViewById<View>(R.id.category_image) as ImageView
        category_name = itemView.findViewById<View>(R.id.category_name) as TextView
        itemView.setOnClickListener(this)
    }
}