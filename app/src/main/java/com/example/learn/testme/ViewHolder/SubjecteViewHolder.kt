package com.example.learn.testme.ViewHolder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.TextView
import com.example.learn.testme.Interface.ItemClickLIstener
import com.example.learn.testme.R

class SubjecteViewHolder(itemView: View) : ViewHolder(itemView), View.OnClickListener {
    var Subjecte_Nmae: TextView
    var Subjecte_Detail: TextView
    private var itemClickListener: ItemClickLIstener? = null
    fun setItemClickListener(itemClickListener: ItemClickLIstener?) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(view: View) {
        itemClickListener!!.onClick(view, adapterPosition, false)
    }

    init {
        Subjecte_Nmae = itemView.findViewById<View>(R.id.subjecte_name) as TextView
        Subjecte_Detail = itemView.findViewById<View>(R.id.subjecte_detell) as TextView
        itemView.setOnClickListener(this)
    }
}