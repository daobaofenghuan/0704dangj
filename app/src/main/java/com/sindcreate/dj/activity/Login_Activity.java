package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.MyBaseActivity;
import com.sindcreate.dj.comm.COMM;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.util.ACache;
import com.sindcreate.dj.util.StatusBarUtils;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login_Activity extends MyBaseActivity {
@BindView(R.id.id_login_button)
TextView loginbut;
@SuppressLint("HandlerLeak")
private Handler mhandler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        if (msg.what==COMM.OK)
        {
        startActivity(new Intent(Login_Activity.this, MainActivity.class));//TODO 後面傢finish或者main为干掉其他启动
            finish();
             }else {
            Toast.makeText(getApplicationContext(),"用户名或密码不正确",Toast.LENGTH_SHORT).show();

        }

        super.handleMessage(msg);
    }
};
@BindView(R.id.id_username)
    EditText useretext;
    @BindView(R.id.id_password)
    EditText passetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ACache ac=ACache.get(this);
        if (ac.getAsString("token")!=null){
            startActivity(new Intent(Login_Activity.this, MainActivity.class));
            finish();

        }

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //沉浸式状态栏
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
       StatusBarUtils.setWindowStatusBarColor(Login_Activity.this, R.color.dj_login_red1);}





    }

@OnClick({R.id.id_login_button})
   void viewclick(View v){
        switch (v.getId()){
            case R.id.id_login_button:

               // System.out.println(useretext.getText().toString()+"  ce"+passetext.getText().toString());
                CommUtil.Login(useretext.getText().toString(),passetext.getText().toString(),mhandler);
              //  CommUtil.getNews(mhandler);
                System.out.println("点击操作");


                break;


        }

}

}
