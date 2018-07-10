package com.sindcreate.dj.comm.params;

import android.os.Handler;
import android.os.Message;

import com.sindcreate.dj.comm.COMM;
import com.sindcreate.dj.util.ToastUtil;

/**
 * Created by Double on 2018/7/8.
 */

public class MHandler extends Handler{

    public void handleMessage(Message msg){
        super.handleMessage(msg);
        if (msg.what== COMM.MISS){

            ToastUtil.showText("请检查网络");
        }
        if(msg.what==COMM.Failed){
            ToastUtil.showText("服务器请求失败稍后重试");

        }


    }

}
