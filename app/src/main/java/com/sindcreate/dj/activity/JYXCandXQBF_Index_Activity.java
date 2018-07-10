package com.sindcreate.dj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.JYXCListAdapter;
import com.sindcreate.dj.adapter.recycleradapter.JYXC_IMG_Adapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.base.MyBaseActivity;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.dj.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JYXCandXQBF_Index_Activity extends BaseActivity {

@BindView(R.id.recycler_view)
    RecyclerView listv;
JYXC_IMG_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jyxc_indexmain_jyxc);
        ButterKnife.bind(this);
        titletext.setText("建言献策");
        StatusBarUtils.setWindowStatusBarColor(JYXCandXQBF_Index_Activity.this, R.color.dj_titalred);


        GridLayoutManager manager = new GridLayoutManager(this, 5, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        listv.setLayoutManager(manager);
        List <String> list=new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        adapter=new JYXC_IMG_Adapter(this,list,JYXCandXQBF_Index_Activity.this);
        listv.setAdapter(adapter);





    }

}
