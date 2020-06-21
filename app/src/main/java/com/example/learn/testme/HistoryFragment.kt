package com.example.learn.testme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learn.testme.Model.QuestionHistory
import com.example.learn.testme.ViewHolder.HistoryViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HistoryFragment : androidx.fragment.app.Fragment() {
    var myFragment: View? = null
    var database: FirebaseDatabase? = null
    var questionHistory: DatabaseReference? = null
    var listHistory: androidx.recyclerview.widget.RecyclerView? = null
    var layoutManager: androidx.recyclerview.widget.RecyclerView.LayoutManager? = null
    var adapter: FirebaseRecyclerAdapter<QuestionHistory?, HistoryViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance()
        questionHistory = database!!.getReference("QuestionHistory")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myFragment = inflater.inflate(R.layout.fragment_history, container, false)
        listHistory = myFragment!!.findViewById<View>(R.id.historyList) as androidx.recyclerview.widget.RecyclerView
        listHistory!!.setHasFixedSize(true)
        layoutManager = androidx.recyclerview.widget.LinearLayoutManager(container!!.context)
        listHistory!!.layoutManager = layoutManager
        loadHistory()
        return myFragment
    }

    //load history
    private fun loadHistory() {
//        adapter = object : FirebaseRecyclerAdapter<QuestionHistory, HistoryViewHolder>(
//                QuestionHistory::class.java,
//                R.layout.item_history,
//                HistoryViewHolder::class.java,
//                questionHistory!!.orderByChild("userId").equalTo(common.currentUser.idStudent)
//        ) {
//            override fun populateViewHolder(viewHolder: HistoryViewHolder, model: QuestionHistory, position: Int) {
//                viewHolder.txt_time.text = String.format("เวลา %s", model.player_time)
//                viewHolder.txt_subjecteNmae.text = model.subjecte_Name
//                viewHolder.txt_subjecteId.text = model.subjecte_Id
//                viewHolder.txt_name.text = model.user
//                viewHolder.txt_score.text = String.format("%s คะแนน", model.score)
//            }
//        }
        adapter!!.notifyDataSetChanged()
        listHistory!!.adapter = adapter
    }

    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }
}