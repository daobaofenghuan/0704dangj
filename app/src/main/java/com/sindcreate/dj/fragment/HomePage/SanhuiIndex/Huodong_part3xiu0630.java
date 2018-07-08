package com.sindcreate.dj.fragment.HomePage.SanhuiIndex;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.XinDeActivity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Huodong_part3xiu0630 extends RVBaseCell<Entry> {
    public static final int TYPE = 10016;
    int flag1=0;
    int flag2=0;
    int flag3=0;
    public Huodong_part3xiu0630(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_huodong_part3xiu0630,parent,false));
         LinearLayout xindely= view.getLinearLayout(R.id.id_xindexihui_click);
         xindely.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Mydata.contexthuodong.startActivity(new Intent(   Mydata.contexthuodong, XinDeActivity.class));
             }
         });
TextView qiandaotext=view.getTextView(R.id.id_huodong_qiandao);
qiandaotext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       // CommUtil
    }
});


        return view;
     //   return null;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {


    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }


}
