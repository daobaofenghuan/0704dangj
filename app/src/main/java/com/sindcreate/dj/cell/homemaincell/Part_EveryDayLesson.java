package com.sindcreate.dj.cell.homemaincell;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.EveryDaykeActivity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_EveryDayLesson extends RVBaseCell<Entry> {
    public static final int TYPE = 103;
    public Part_EveryDayLesson(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


 RVBaseViewHolder view=    new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_lesson,parent,false));

        RelativeLayout lessonly= view.getRelativeLayout(R.id.id_lesson_ly);
        lessonly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.context.startActivity(new Intent(Mydata.context, EveryDaykeActivity.class));
            }
        });
        return view;
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
