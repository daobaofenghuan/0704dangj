package com.sindcreate.dj.cell.homemaincell;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.EveryDayActivityTi;
import com.sindcreate.dj.activity.EveryDaykeActivity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.EveryDay_Ke_GetBean;
import com.sindcreate.dj.comm.params.MHandler;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_LessonAndWork extends RVBaseCell<Entry> {
    //每日一题
    public static final int TYPE = 162;

    public Part_LessonAndWork(Entry entry) {

        super(entry);
    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("HandlerLeak")
    private MHandler handler=new MHandler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
if(msg.what== MsgNum.OK){
      Gson gson=new Gson();
      String data= (String) msg.obj;
     EveryDay_Ke_GetBean bean=gson.fromJson(data, EveryDay_Ke_GetBean.class);
   String   lesson=bean.getLessonContent();
   Intent intent=new Intent(Mydata.context, EveryDaykeActivity.class);
   intent.putExtra("lesson",lesson);
    Mydata.context.startActivity(intent);
}



        }
    };

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVBaseViewHolder view = new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_lessonandwork, parent, false));
        TextView textView = view.getTextView(R.id.id_item_rtext);
        RelativeLayout everydayti = view.getRelativeLayout(R.id.id_homework_kaishidati);
        everydayti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mydata.context.startActivity(new Intent(Mydata.context, EveryDayActivityTi.class));
              
            }
        });
        final RelativeLayout lyke= view.getRelativeLayout(R.id.id_homework_ke);
   lyke.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
          

           CommUtil.getEveryDayKeID(handler);
       }
   });



        return view;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }
}
