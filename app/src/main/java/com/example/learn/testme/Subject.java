package com.example.learn.testme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learn.testme.Common.common;
import com.example.learn.testme.Interface.ItemClickLIstener;
import com.example.learn.testme.Model.Subjecte;
import com.example.learn.testme.ViewHolder.SubjecteViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Subject extends Fragment {



    View myfragment;

    RecyclerView listSubjecte;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Subjecte,SubjecteViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference subjecteDB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        subjecteDB = database.getReference("Subjecte");

    }

    public static Subject newInstance(){
        Subject subject = new Subject();
        return subject;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myfragment = inflater.inflate(R.layout.fragment_subject,container,false);

        listSubjecte = (RecyclerView)myfragment.findViewById(R.id.listSubjecte);
        listSubjecte.setHasFixedSize(true);;
        layoutManager = new LinearLayoutManager(container.getContext());
        listSubjecte.setLayoutManager(layoutManager);

        
        loadSubject();

       
        return myfragment;
    }



    //load subject use category id is index for load

    private void loadSubject() {

        adapter = new FirebaseRecyclerAdapter<Subjecte, SubjecteViewHolder>(
                Subjecte.class,
                R.layout.subjecte_layout,
                SubjecteViewHolder.class,
                subjecteDB.orderByChild("Category_id").equalTo(common.categoryId)

        ){
            @Override
            protected void populateViewHolder(SubjecteViewHolder viewHolder, final Subjecte model, int position) {
                  viewHolder.Subjecte_Nmae.setText(model.getSubjecte_Name());
                  viewHolder.Subjecte_Detail.setText(model.getSubjecte_Deteil());

                  viewHolder.setItemClickListener(new ItemClickLIstener() {
                      @Override
                      public void onClick(View view, int position, boolean isLongClick) {



                     common.Subjecte_Id =  adapter.getRef(position).getKey();
                     Log.e("Test Click subjecte >> ", common.Subjecte_Id);
                     common.Subjecte_Deteil = model.getSubjecte_Deteil();
                     Log.e("Test Click Subjecte Deteil",common.Subjecte_Deteil);
                      common.Subjecte_Name = model.getSubjecte_Name();
                     Intent startgame = new Intent(getActivity(),Start.class);
                     startActivity(startgame);
                      }
                  });

            }


        };
        adapter.notifyDataSetChanged();
        listSubjecte.setAdapter(adapter);
    }
}
