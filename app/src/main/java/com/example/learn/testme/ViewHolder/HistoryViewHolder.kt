package com.example.learn.testme.ViewHolder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.TextView
import com.example.learn.testme.Interface.ItemClickLIstener
import com.example.learn.testme.R

class HistoryViewHolder(itemView: View) : ViewHolder(itemView) {
    var txt_name: TextView
    var txt_score: TextView
    var txt_time: TextView
    var txt_subjecteId: TextView
    var txt_subjecteNmae: TextView
    private val itemClickLIstener: ItemClickLIstener? = null

    init {
        txt_name = itemView.findViewById<View>(R.id.his_name) as TextView
        txt_score = itemView.findViewById<View>(R.id.his_Score) as TextView
        txt_subjecteId = itemView.findViewById<View>(R.id.his_subjecte_id) as TextView
        txt_subjecteNmae = itemView.findViewById<View>(R.id.his_subjecte_name) as TextView
        txt_time = itemView.findViewById<View>(R.id.his_time) as TextView
    }
}