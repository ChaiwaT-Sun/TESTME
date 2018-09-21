package com.example.learn.testme.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.learn.testme.Interface.ItemClickLIstener;
import com.example.learn.testme.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {


    public TextView txt_name, txt_score, txt_time, txt_subjecteId, txt_subjecteNmae;
    private ItemClickLIstener itemClickLIstener;


    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_name = (TextView) itemView.findViewById(R.id.his_name);
        txt_score = (TextView) itemView.findViewById(R.id.his_Score);
        txt_subjecteId = (TextView) itemView.findViewById(R.id.his_subjecte_id);
        txt_subjecteNmae = (TextView) itemView.findViewById(R.id.his_subjecte_name);
        txt_time = (TextView) itemView.findViewById(R.id.his_time);




    }


}