package com.sindcreate.dj.fragment.HomePage.Sanhuifragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.HuoDongActivity;
import com.sindcreate.dj.adapter.listviewadapter.SanhuiListAdapter;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.SanHuiBean;
import com.sindcreate.dj.service.MyIntentService;
import com.sindcreate.dj.service.PartUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Double on 2018/6/4.
 */

public class Part_Sanhui1_fragment extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    SanhuiListAdapter adapter;
    ArrayList<SanHuiBean> list=new ArrayList<>();


    @SuppressLint("ValidFragment")
    public Part_Sanhui1_fragment(ArrayList<SanHuiBean> list){
        super();
          this.list=list ;
       // System.out.println( "页面初始化+"+list.get(0).getPartyAffairsId());
    }
 public   Part_Sanhui1_fragment (){
        super();

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_homepage_sanhuiyike_1,container,false);
        ButterKnife.bind(this,view);
        System.out.println("进入到三会一课分页面1");


        adapter=new SanhuiListAdapter(getContext(),list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), HuoDongActivity.class);
                intent.putExtra("id", list.get(position).getPartyAffairsId());
                startActivity(intent);

            }
        });



        return view;
    }


}
