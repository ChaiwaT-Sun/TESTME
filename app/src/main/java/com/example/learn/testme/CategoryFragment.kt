package com.example.learn.testme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learn.testme.Model.Category
import com.example.learn.testme.ViewHolder.CategoryViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CategoryFragment : androidx.fragment.app.Fragment() {
    var myfragment: View? = null
    var listCategory: androidx.recyclerview.widget.RecyclerView? = null
    var layoutManager: androidx.recyclerview.widget.RecyclerView.LayoutManager? = null
    var adapter: FirebaseRecyclerAdapter<Category?, CategoryViewHolder>? = null
    var database: FirebaseDatabase? = null
    var categories: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance()
        categories = database!!.getReference("Category")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myfragment = inflater.inflate(R.layout.fragment_category, container, false)
        listCategory = myfragment!!.findViewById<View>(R.id.listCategory) as androidx.recyclerview.widget.RecyclerView
        listCategory!!.setHasFixedSize(true)
        layoutManager = androidx.recyclerview.widget.LinearLayoutManager(container!!.context)
        listCategory!!.layoutManager = layoutManager
        loadCategories()
        return myfragment
    }

    private fun loadCategories() {
//        adapter = object : FirebaseRecyclerAdapter<Category, CategoryViewHolder>(
//                Category,
//                R.layout.item_category,
//                CategoryViewHolder::class.java,
//                categories
//        ) {
//            override fun populateViewHolder(viewHolder: CategoryViewHolder, model: Category, position: Int) {
//                viewHolder.category_name.text = model.name
//                Log.e("caategory >> ", model.image)
//                Picasso.with(activity)
//                        .load(model.image)
//                        .into(viewHolder.category_image)
//                viewHolder.setItemClickListener { view, position, isLongClick ->
//                    val transaction = activity!!.supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.frame_layout, Subject.newInstance())
//                    transaction.commit()
//                    Log.e("position >>", adapter!!.getRef(position).key)
//                    common.categoryId = adapter!!.getRef(position).key
//                    common.categoryName = model.name
//                }
//            }
//        }
        adapter!!.notifyDataSetChanged()
        listCategory!!.adapter = adapter
    }

    companion object {
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }
}