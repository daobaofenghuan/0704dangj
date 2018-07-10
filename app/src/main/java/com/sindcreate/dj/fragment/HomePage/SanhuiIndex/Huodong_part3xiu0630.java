package com.sindcreate.dj.fragment.HomePage.SanhuiIndex;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.XinDeActivity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.COMM;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.HuoDongBean;
import com.sindcreate.dj.comm.params.MHandler;
import com.sindcreate.dj.util.ToastUtil;

import java.util.List;


/**
 * Created by Double on 2018/5/23.
 */

public class Huodong_part3xiu0630 extends RVBaseCell<HuoDongBean> {
    public static final int TYPE = 10016;
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;

@SuppressLint("HandlerLeak")
private MHandler handler=new MHandler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
   if(msg.what== MsgNum.OK){

       ToastUtil.showText("签到成功");
   }
        if(msg.what== COMM.MISS){
        ToastUtil.showText("请检查网络");

        }
    }
};





    public Huodong_part3xiu0630(HuoDongBean bean) {
        super(bean);

    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view = new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_huodong_part3xiu0630, parent, false));
        LinearLayout xindely = view.getLinearLayout(R.id.id_xindexihui_click);
        xindely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.contexthuodong.startActivity(new Intent(Mydata.contexthuodong, XinDeActivity.class));
            }
        });
        TextView qiandaotext = view.getTextView(R.id.id_huodong_qiandao);
        qiandaotext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CommUtil
            }
        });






        return view;
        //   return null;
    }

    TextView textview1;
    TextView textview2;
    TextView textview3;
 TextView ydrenyuan;
 TextView qiandao;

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        ydrenyuan = holder.getTextView(R.id.id_huodong_yidurenyuan);
        textview1 = holder.getTextView(R.id.id_huodng_weidu);
        textview2 = holder.getTextView(R.id.id_huodong_weiqiandao);
        textview3 = holder.getTextView(R.id.id_huodong_yishangchuan);
  qiandao=holder.getTextView(R.id.id_huodong_qiandao);
  qiandao.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          CommUtil.ClickQianDao(handler,mData.getPartyAffairsId(),"测试地点签的猜猜看");

      }
  });
        renyuanshaixuan();






    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell", "Partone releaseResource");
    }

    void select() {
        textview1.setTextColor(Color.parseColor("#15182d"));
        textview2.setTextColor(Color.parseColor("#15182d"));
        textview3.setTextColor(Color.parseColor("#15182d"));
        //   textView.setTextColor(Color.parseColor("#fb4f5e"));


    }



   void renyuanshaixuan(){



       String renyuan1 = " ";
       String renyuan2 = " ";
       String renyuan3 = " ";


       final List<String> weidulist = mData.getIsNotNotice();
       for (int i = 0; i < weidulist.size(); i++) {
           String name = weidulist.get(i);
           renyuan1 = renyuan1 + "   " + name;

       }
       final List<String> weiqiandaolist = mData.getIsNotRegister();
       for (int i = 0; i < weiqiandaolist.size(); i++) {
           String name = weiqiandaolist.get(i);
           renyuan2 = renyuan2 + "   " + name;

       }
       final List<String> yifankuilist = mData.getIsNotFeedBack();
       for (int i = 0; i < yifankuilist.size(); i++) {
           String name = yifankuilist.get(i);
           renyuan3 = renyuan3 + "   " + name;

       }

       ydrenyuan.setText(renyuan1);
       textview1.setText("未读("+weidulist.size()+")");
       textview2.setText("未签到("+weiqiandaolist.size()+")");
       textview3.setText("已上传心得体会("+yifankuilist.size()+")");
       final String finalRenyuan = renyuan1;
       textview1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ydrenyuan.setText(finalRenyuan);
               select();

               textview1.setTextColor(Color.parseColor("#fb4f5e"));


           }
       });
       final String finalRenyuan1 = renyuan2;
       textview2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ydrenyuan.setText(finalRenyuan1);
               select();

               textview2.setTextColor(Color.parseColor("#fb4f5e"));

           }
       });
       final String finalRenyuan2 = renyuan3;
       textview3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ydrenyuan.setText(finalRenyuan2);
               select();

               textview3.setTextColor(Color.parseColor("#fb4f5e"));

           }
       });



   }
}
