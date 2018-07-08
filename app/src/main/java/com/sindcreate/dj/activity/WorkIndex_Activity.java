package com.sindcreate.dj.activity;

import android.os.Bundle;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.dj.util.StatusBarUtils;

import butterknife.ButterKnife;

public class WorkIndex_Activity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_index);
        ButterKnife.bind(this);
        titletext.setText("工作任务");
        StatusBarUtils.setWindowStatusBarColor(WorkIndex_Activity.this, R.color.dj_titalred);




    }

}
