package com.example.learn.testme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learn.testme.Model.Subjecte
import com.example.learn.testme.ViewHolder.SubjecteViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Subject : androidx.fragment.app.Fragment() {
    var myfragment: View? = null
    var listSubjecte: androidx.recyclerview.widget.RecyclerView? = null
    var layoutManager: androidx.recyclerview.widget.RecyclerView.LayoutManager? = null
    var adapter: FirebaseRecyclerAdapter<Subjecte?, SubjecteViewHolder>? = null
    var database: FirebaseDatabase? = null
    var subjecteDB: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance()
        subjecteDB = database!!.getReference("Subjecte")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myfragment = inflater.inflate(R.layout.fragment_subject, container, false)
        listSubjecte = myfragment!!.findViewById<View>(R.id.listSubjecte) as androidx.recyclerview.widget.RecyclerView
        listSubjecte!!.setHasFixedSize(true)
        layoutManager = androidx.recyclerview.widget.LinearLayoutManager(container!!.context)
        listSubjecte!!.layoutManager = layoutManager
        loadSubject()
        return myfragment
    }

    //load subject use category id is index for load
    private fun loadSubject() {
//        adapter = object : FirebaseRecyclerAdapter<Subjecte, SubjecteViewHolder>(
//                Subjecte,
//                R.layout.item_subjecte,
//                SubjecteViewHolder::class.java,
//                subjecteDB!!.orderByChild("Category_id").equalTo(common.categoryId)
//        ) {
//            override fun populateViewHolder(viewHolder: SubjecteViewHolder, model: Subjecte, position: Int) {
//                viewHolder.Subjecte_Nmae.text = model.subjecte_Name
//                viewHolder.Subjecte_Detail.text = model.subjecte_Deteil
//                viewHolder.setItemClickListener { view, position, isLongClick ->
//                    common.Subjecte_Id = adapter!!.getRef(position).key
//                    Log.e("Test Click subjecte >> ", common.Subjecte_Id)
//                    common.Subjecte_Deteil = model.subjecte_Deteil
//                    Log.e("Test Click Subjecte Deteil", common.Subjecte_Deteil)
//                    common.Subjecte_Name = model.subjecte_Name
//                    val startgame = Intent(activity, Start::class.java)
//                    startActivity(startgame)
//                }
//            }
//        }
//        adapter.notifyDataSetChanged()
        listSubjecte!!.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(): Subject {
            return Subject()
        }
    }
}