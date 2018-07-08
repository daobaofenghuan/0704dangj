package com.sindcreate.dj.activity;

import android.app.Activity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EveryDaykeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everydayke);
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .transparentStatusBar().init();






    }
    @OnClick(R.id.id_everyday_back)
    void back(){
        finish();

    }

}
