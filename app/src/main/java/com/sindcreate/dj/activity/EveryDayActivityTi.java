package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.params.MHandler;
import com.sindcreate.dj.util.ToastUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EveryDayActivityTi extends Activity {
@SuppressLint("HandlerLeak")
private MHandler mHandler=new MHandler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(msg.what== MsgNum.OK){
            ToastUtil.showText("获取成功");

        }
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everydayti);
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .transparentStatusBar().init();


    //   CommUtil.getEveryDayKe(mHandler,lessonID);




    }
    @OnClick(R.id.id_everyday_back)
    void back(){
        finish();

    }

}
