package com.sindcreate.dj.adapter;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sindcreate.dj.R;

import java.util.ArrayList;

/**
 * Created by Double on 2018/5/22.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter {

    private ArrayList<Fragment> mData;


  public   MainRecycleAdapter(ArrayList<Fragment> mData){
       this.mData=mData;


    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     // View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);

        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       mData.get(position);

     //   holder.mTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();

    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
          //  mTv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

}
