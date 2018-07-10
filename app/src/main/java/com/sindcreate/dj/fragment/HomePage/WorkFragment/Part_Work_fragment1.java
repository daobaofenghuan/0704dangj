package com.sindcreate.dj.fragment.HomePage.WorkFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.WorkIndex_Activity;
import com.sindcreate.dj.adapter.listviewadapter.WorkListAdapter;
import com.sindcreate.dj.adapter.listviewadapter.ZaiXianListAdapter;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.WorkBean;
import com.sindcreate.dj.comm.params.MHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Double on 2018/6/4.
 */

public class Part_Work_fragment1 extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    WorkListAdapter adapter;
    ArrayList<AcceptData> datalist=new ArrayList<>();
    @BindView(R.id.id_title_text)
    TextView textView;


        @SuppressLint("HandlerLeak")
    private MHandler mHandler=new MHandler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what== MsgNum.OK){
                String data= (String) msg.obj;
                Gson gson=new Gson();
                final ArrayList<WorkBean> list =  gson.fromJson(data,new TypeToken<ArrayList<WorkBean>>(){}.getType());
                String time=    list.get(0).getActualFinishTime();
                System.out.println(time);

                adapter =new WorkListAdapter(getContext(),list);
                listView.setAdapter(adapter);

                listView.addFooterView(view1);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getActivity(), WorkIndex_Activity.class);
                        intent.putExtra("workid",list.get(position).getNoticeId());


                        getActivity().startActivity(intent);
                    }
                });
            }
        }
    };
View view1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_work_list,container,false);
        ButterKnife.bind(this,view);
        AcceptData databean=new AcceptData();
textView.setText("工作任务");
        CommUtil.getWorkData(mHandler);


   view1=inflater.inflate(R.layout.item_nomore,container,false);



        return view;
    }

    @OnClick({R.id.id_title_back})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){

            case R.id.id_title_back:

                msg.what= MsgNum.MSG_Home;
                Mydata.handler.sendMessage(msg);
                break;

        }

    }
}
