package com.sindcreate.dj.fragment.HomePage;

/**
 * Created by Double on 2018/6/8.
 */

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.DynamicHomeAdapter;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.SanHuiBean;
import com.sindcreate.dj.comm.params.MHandler;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui1_fragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui2_fragment;
import com.sindcreate.dj.util.UiUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//主页第二个标签
public class Part_DangRI_Fragmenttwo extends BaseFragment {
    private Button but, but2;
    private TextView textView;
    private List<String> mTabs;
    Unbinder unbinder;
    @BindView(R.id.vp5)
    ViewPager vp;

    @BindView(R.id.tl5)
    TabLayout tl;
    @BindView(R.id.id_title_text)
    TextView titletext;
    ArrayList<SanHuiBean> sanhuilist1=null;
    ArrayList<SanHuiBean> sanhuilist2=null;
    @SuppressLint("HandlerLeak")
    private MHandler mhandler = new MHandler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MsgNum.Part1) {
                String data = (String) msg.obj;
                Gson gson = new Gson();


                sanhuilist1 = gson.fromJson(data, new TypeToken<ArrayList<SanHuiBean>>() {
                }.getType());
                CommUtil.getDang2End(mhandler, MsgNum.Part2);

            }
            if (msg.what == MsgNum.Part2) {
                String data = (String) msg.obj;
                Gson gson = new Gson();


                sanhuilist2 = gson.fromJson(data, new TypeToken<ArrayList<SanHuiBean>>() {
                }.getType());

                initTabLayout();
                bindViewPager();

            }

        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage_dangri, container, false);
        ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, view);
        titletext.setText("党务工作");
     CommUtil.getDang2Ing(mhandler,MsgNum.Part1);

        return view;

    }


    private void initTabLayout() {
        //    textView.setText("三会一课");
        mTabs = new ArrayList<>();
        mTabs.clear();

        mTabs.add(UiUtil.getString(R.string.weiwancheng));
        mTabs.add(UiUtil.getString(R.string.sanhui_text2));


    }

    private void bindViewPager() {

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new Part_Sanhui1_fragment(sanhuilist1));
        fragments.add(new Part_Sanhui1_fragment(sanhuilist2));
        DynamicHomeAdapter adapter = new DynamicHomeAdapter(getChildFragmentManager(), fragments, mTabs);
        vp.setOffscreenPageLimit(2);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
        //   reflex(tl);

    }


}
