package com.sindcreate.dj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EveryDaykeActivity extends Activity {
@BindView(R.id.id_everydayke_text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everydayke);
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .transparentStatusBar().init();


        String lesson=getIntent().getStringExtra("lesson");
        textView.setText("   "+lesson);


    }
    @OnClick(R.id.id_everyday_back)
    void back(){
        finish();

    }

}
