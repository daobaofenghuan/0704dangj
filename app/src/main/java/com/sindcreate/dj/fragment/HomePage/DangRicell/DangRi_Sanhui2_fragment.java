package com.sindcreate.dj.fragment.HomePage.DangRicell;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.SanHuiBean;
import com.sindcreate.dj.comm.params.MHandler;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Double on 2018/6/4.
 */

public class DangRi_Sanhui2_fragment extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    SanhuiListAdapter adapter;


    ArrayList<SanHuiBean> list=new ArrayList<>();
    @SuppressLint("HandlerLeak")
    private MHandler mhandler = new MHandler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MsgNum.Part2) {
                String data = (String) msg.obj;
                Gson gson = new Gson();


             list = gson.fromJson(data, new TypeToken<ArrayList<SanHuiBean>>() {
                }.getType());

                adapter=new SanhuiListAdapter(getContext(),list);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getActivity(), HuoDongActivity.class);
                        intent.putExtra("id",list.get(position).getPartyAffairsId());
                        startActivity(intent);
                    }
                });



            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_homepage_sanhuiyike_1,container,false);
        ButterKnife.bind(this,view);
        System.out.println("进入到三会一课分页面");





        CommUtil.getDang2End(mhandler,MsgNum.Part2);

        return view;
    }
}
