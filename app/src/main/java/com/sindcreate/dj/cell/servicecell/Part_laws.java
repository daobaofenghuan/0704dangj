package com.sindcreate.dj.cell.servicecell;

/**
 * Created by Double on 2018/5/25.
 */



import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.ZengCeFaGui_Activity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_laws extends RVBaseCell<Entry> {
    //警示教育
    public static final int TYPE = 301;

    public Part_laws(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_service_laws0703xiu,parent,false));
TextView textView3=view.getTextView(R.id.id_fw_text3);
textView3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Mydata.context.startActivity(new Intent(Mydata.context, ZengCeFaGui_Activity.class));
    }
});
        TextView texttitle= view.getTextView(R.id.id_hometitle_2);
        TextView zhuti=view.getTextView(R.id.id_home_event_zhuti);

        // zhuti.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        texttitle.setText("政策法规");
        TextView righttext=view.getTextView(R.id.id_item_rtext);
        righttext.setVisibility(View.GONE);


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
