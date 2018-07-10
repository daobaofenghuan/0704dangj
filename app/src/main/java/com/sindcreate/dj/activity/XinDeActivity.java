package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.recycleradapter.ApplyforHelpAdapter;
import com.sindcreate.dj.adapter.recycleradapter.XindeHelpAdapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.params.MHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XinDeActivity extends Activity {
    private static final int TAKE_PICTURE = 0x000000;
    private static final int SHOW_CAMERA = 0x000001;
    private static final int SHOW_CAMERA_RESULT = 0x000002;
    public static final int SHOW_ALL_PICTURE = 0x14;// 查看图片
    public static final int SHOW_PICTURE_RESULT = 0x15;// 查看图片返回
    public static final int CLOSE_INPUT = 0x01;// 关闭软键盘
    String tupian = "";
    @BindView(R.id.id_title_text)
    public  TextView titletext;
  XindeHelpAdapter adapter;
    @BindView(R.id.id_xinde_test1)
    TextView xindetext;
    @BindView(R.id.recycler_view)
    RecyclerView listv;
    @BindView(R.id.id_title_back)
    RelativeLayout titleback;
    List<Bitmap> listdata = new ArrayList<>();

    @SuppressLint("HandlerLeak")
    private MHandler mhandler = new MHandler() {
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            if (msg.what == MsgNum.OK) {
                int postion = (int) msg.obj;
                listdata.remove(postion);
                adapter.notifyDataSetChanged();


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinde);
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .transparentStatusBar().init();
        Mydata.xindehandler=mhandler;

        GridLayoutManager manager = new GridLayoutManager(this, 6, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new XindeHelpAdapter(this, listdata,XinDeActivity.this);
        listv.setLayoutManager(manager);
        listv.setAdapter(adapter);
        String str="上传内容<font color='#fb4f5e'>*</font>";

        xindetext.setText(Html.fromHtml(str));
        titletext.setText("心得体会");


    }



    @SuppressLint("WrongConstant")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK
                && null != data) {
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                //   Toast.makeText(GroupMainActivity.this, "未找到SDK", 1).show();
                return;
            }
            new android.text.format.DateFormat();
            String name = android.text.format.DateFormat.format(
                    "yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA))
                    + ".jpg";
            Bundle bundle = data.getExtras();
            // 获取相机返回的数据，并转换为图片格式
            final Bitmap bitmap;
            String filename = null;
            bitmap = (Bitmap) bundle.get("data");


            Message msg = Message.obtain();
            msg.what = 20001;
            msg.obj = tupian;
            mhandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    List<Bitmap> listdata2 = new ArrayList<>();
                    listdata2.add(bitmap);
                    listdata.addAll(listdata2);
                    adapter.notifyDataSetChanged();


                }
            }, 300);
        } else if (requestCode == SHOW_CAMERA
                && resultCode == SHOW_CAMERA_RESULT) {
            Bundle bundle = data.getExtras();
            Object camera = bundle.get("imgUrl");

            // TODO 新起线程发送图片
            final String camera2 = camera.toString();


            // 将图片发送到聊天界面
            if (camera.toString().length() > 0) {

            }
        }
    }
    @OnClick(R.id.id_title_back)
    public  void  goback(View v){
        finish();
    }
}
