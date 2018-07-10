package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.params.MHandler;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.dj.util.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkIndex_Activity extends BaseActivity {

@SuppressLint("HandlerLeak")
private MHandler mHandler=new MHandler(){
    @Override
    public void handleMessage(Message msg) {
        if (msg.what== MsgNum.OK){
           // themetext.setText();

        }
        super.handleMessage(msg);
    }
};
//@BindView(R.id.)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_index);
        ButterKnife.bind(this);
        titletext.setText("工作任务");
        StatusBarUtils.setWindowStatusBarColor(WorkIndex_Activity.this, R.color.dj_titalred);

   String workid=getIntent().getStringExtra("workid");
        CommUtil.getWorkDataIndex(mHandler,workid);

    }

}
