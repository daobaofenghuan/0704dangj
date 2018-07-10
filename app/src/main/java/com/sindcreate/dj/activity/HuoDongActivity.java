package com.sindcreate.dj.activity;

import android.content.Intent;
import android.os.Bundle;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.HomePage.SanhuiIndex.HuodongFragment;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.dj.util.StatusBarUtils;


import butterknife.ButterKnife;

public class HuoDongActivity extends BaseActivity {

HuodongFragment fragment;
public static String  workid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);
        ButterKnife.bind(this);
        titletext.setText("详情");
        System.out.println("活动详情");
        Mydata.contexthuodong=this;
        Intent intent=getIntent();
     workid=   intent.getStringExtra("id");
        System.out.println(workid);
        StatusBarUtils.setWindowStatusBarColor(HuoDongActivity.this, R.color.dj_titalred);
        fragment=new HuodongFragment();
       getSupportFragmentManager().beginTransaction().replace(R.id.contain_sanhuiindex,fragment).commit();




    }

}
