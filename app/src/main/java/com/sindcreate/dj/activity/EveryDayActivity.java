package com.sindcreate.dj.activity;

import android.app.Activity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EveryDayActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everydayti);
        ButterKnife.bind(this);
        ImmersionBar.with(this);







    }
    @OnClick(R.id.id_everyday_back)
    void back(){
        finish();

    }

}
