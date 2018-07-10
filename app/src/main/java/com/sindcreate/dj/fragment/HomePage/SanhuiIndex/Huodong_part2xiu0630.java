package com.sindcreate.dj.fragment.HomePage.SanhuiIndex;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.comm.bean.HuoDongBean;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Huodong_part2xiu0630 extends RVBaseCell<HuoDongBean> {
    public static final int TYPE = 100122;
    public Huodong_part2xiu0630(HuoDongBean entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_huodong_part2xiu0630,parent,false));


        return view;
     //   return null;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
     holder.getTextView(R.id.id_huodong_time).setText(mData.getPartyAffairsTime());
     holder.getTextView(R.id.id_huodong_space).setText(mData.getPartyAffairsPlace());
holder.getTextView(R.id.id_huodong_stoptime).setText(mData.getPartyAffairsTime());
holder.getTextView(R.id.id_huodong_fkrenyuan).setText("   "+mData.getPartyAffairsContent());


    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }


}
