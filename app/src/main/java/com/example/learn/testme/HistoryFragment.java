package com.example.learn.testme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learn.testme.Common.common;
import com.example.learn.testme.Model.Question;
import com.example.learn.testme.Model.QuestionHistory;
import com.example.learn.testme.ViewHolder.HistoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HistoryFragment extends Fragment {


    View myFragment;

    FirebaseDatabase database;
    DatabaseReference questionHistory;


    RecyclerView listHistory;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<QuestionHistory,HistoryViewHolder> adapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        questionHistory = database.getReference("QuestionHistory");
    }

    public static HistoryFragment newInstance(){
        HistoryFragment historyFragment = new HistoryFragment();
        return historyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myFragment = inflater.inflate(R.layout.fragment_history , container,false);

        listHistory = (RecyclerView)myFragment.findViewById(R.id.historyList);
        listHistory.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listHistory.setLayoutManager(layoutManager);



        loadHistory();
        return myFragment;
    }


    //load history
    private void loadHistory() {

        adapter = new FirebaseRecyclerAdapter<QuestionHistory, HistoryViewHolder>(
                QuestionHistory.class,
                R.layout.layout_history,
                HistoryViewHolder.class,
                questionHistory.orderByChild("userId").equalTo(common.currentUser.getIdStudent())
        ) {
            @Override
            protected void populateViewHolder(HistoryViewHolder viewHolder, QuestionHistory model, int position) {

                viewHolder.txt_time.setText(String.format("เวลา %s",model.getPlayer_time()));
                viewHolder.txt_subjecteNmae.setText(model.getSubjecte_Name());
                viewHolder.txt_subjecteId.setText(model.getSubjecte_Id());
                viewHolder.txt_name.setText(model.getUser());
                viewHolder.txt_score.setText(String.format("%s คะแนน",model.getScore()));


            }
        };
        adapter.notifyDataSetChanged();
        listHistory.setAdapter(adapter);



    }
}
