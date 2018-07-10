package com.sindcreate.dj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.JYXCListAdapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.dj.util.StatusBarUtils;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JYXCandXQBF_Activity extends BaseActivity {
@BindView(R.id.list_item)
    ListView listView;
JYXCListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jyxc0708x);
        ButterKnife.bind(this);
        titletext.setText("建言献策");
        StatusBarUtils.setWindowStatusBarColor(JYXCandXQBF_Activity.this, R.color.dj_titalred);
        List<Entry>list=new ArrayList<>();
        Entry entry=new Entry();
        list.add(entry);
        adapter=new JYXCListAdapter(this,list);

listView.setAdapter(adapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(JYXCandXQBF_Activity.this,JYXCandXQBF_Index_Activity.class));
    }
});




    }

}
