package com.sindcreate.dj.fragment.HomePage;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sindcreate.dj.util.DensityUtil.dip2px;
//第一个选择
public class Part_SanHuiYiKe_Fragment extends BaseFragment {
    private Button but, but2;
    private TextView textView;
    private List<String> mTabs;
    Unbinder unbinder;
    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.tl)
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
                CommUtil.getSanhuiEnd(mhandler,MsgNum.Part2);

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

        View view = inflater.inflate(R.layout.fragment_homepage_sanhuiyike, container, false);
        ButterKnife.bind(this, view);
      //  unbinder = ButterKnife.bind(this, view);
        titletext.setText("三会一课");
        System.out.println("进入到三会一课主页面");

        CommUtil.getSanhuiIng(mhandler,MsgNum.Part1);

        return view;

    }



    private void initTabLayout() {
    //    textView.setText("三会一课");
        mTabs = new ArrayList<>();
        mTabs.clear();
        mTabs.add("开展中");
        mTabs.add("已结束");




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

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public void reflex(final TabLayout tabLayout){
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);

                    int dp10 = dip2px(tabLayout.getContext(), 10);
                    int dp50= dip2px(tabLayout.getContext(), 40);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp50;
                        params.rightMargin = dp50;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
