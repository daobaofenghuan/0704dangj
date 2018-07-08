package com.sindcreate.dj.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.COMM;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.HttpUrls;
import com.sindcreate.dj.comm.PostParams;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui1_fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Double on 2018/7/7.
 */

public class MyIntentService  extends IntentService{

    public MyIntentService() {
        super("MyIntentService");

    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        System.out.println("欢迎来到后台服务，后台服务Myintentsrvice已经启动");
        assert intent != null;
        int part= intent.getIntExtra("part",0);
        switch (part){
            case  PartUtil.SANHUI_1:
               // CommUtil.getSanhuiIng(Mydata.SeverHander);

                break;
            case PartUtil.SANHUI_2:
                //CommUtil.getSanhuiEnd(Mydata.SeverHander);
                break;

        }



    }



    private static void Postgetdata(final String url, final PostParams params, final Handler handler) {

        new Thread() {
            @Override
            public void run() {
                System.out.println("==========================================================================");
                Log.e("db_test_databack", url);
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {
                        msg.what = COMM.OK;
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        msg.obj = jsonArray.toString();

                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }
}
