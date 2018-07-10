package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.WorkIndexBean;
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
            String data= (String) msg.obj;

            WorkIndexBean bean= gson.fromJson(data,WorkIndexBean.class);
            themetext.setText("任务主题: "+bean.getTaskTitle());
            nr.setText("    "+bean.getTaskContent());
            type.setText(bean.getTaskType());
      //      faqi.setText(bean.getNoticeId());
            time.setText(bean.getActualFinishTime());

        }
        super.handleMessage(msg);
    }
};
@BindView(R.id.id_work_theme)
TextView themetext;
@BindView(R.id.id_content)
TextView nr;
@BindView(R.id.id_work_type)
TextView type;
@BindView(R.id.id_work_faqiname)
TextView faqi;
@BindView(R.id.id_work_time)
TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_index);
        ButterKnife.bind(this);
        titletext.setText("工作任务");
        StatusBarUtils.setWindowStatusBarColor(WorkIndex_Activity.this, R.color.dj_titalred);
   String workid=getIntent().getStringExtra("workid");
        System.out.println(workid);
        CommUtil.getWorkDataIndex(mHandler,workid);


    }

}
