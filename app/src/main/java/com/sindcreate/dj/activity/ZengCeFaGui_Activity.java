package com.sindcreate.dj.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sindcreate.dj.R;
import com.sindcreate.dj.fragment.ServiceIndex.ZCFG_Fragment;
import com.sindcreate.dj.util.StatusBarUtils;


import butterknife.ButterKnife;

public class ZengCeFaGui_Activity extends AppCompatActivity {

ZCFG_Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);
        ButterKnife.bind(this);
      //  titletext.setText("活动详情");

        StatusBarUtils.setWindowStatusBarColor(ZengCeFaGui_Activity.this, R.color.dj_titalred);
       fragment=new ZCFG_Fragment();
       getSupportFragmentManager().beginTransaction().replace(R.id.contain_sanhuiindex,fragment).commit();




    }

}
