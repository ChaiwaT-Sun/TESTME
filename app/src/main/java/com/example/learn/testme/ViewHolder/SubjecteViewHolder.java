package com.example.learn.testme.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.learn.testme.Interface.ItemClickLIstener;
import com.example.learn.testme.R;

public class SubjecteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

public TextView Subjecte_Nmae ;
public TextView Subjecte_Detail;

private ItemClickLIstener itemClickListener;


   public SubjecteViewHolder(View itemView){
    super(itemView);
    Subjecte_Nmae = (TextView)itemView.findViewById(R.id.subjecte_name);
    Subjecte_Detail = (TextView)itemView.findViewById(R.id.subjecte_detell);
    itemView.setOnClickListener(this);

  }

    public void setItemClickListener(ItemClickLIstener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view ,getAdapterPosition(),false);

    }
}
