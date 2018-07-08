package com.sindcreate.dj.fragment.HomePage.SanhuiIndex;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.HuoDongActivity;
import com.sindcreate.dj.base.basecell.Cell;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.HuoDongBean;
import com.sindcreate.dj.comm.bean.NewsBean;
import com.sindcreate.dj.fragment.AbsBaseFragment;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockData;
import static com.sindcreate.dj.DataMocker.mockMoreData;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class HuodongFragment extends AbsBaseFragment<Entry> {

  //  private ArrayList<NewsBean> newslist = new ArrayList<>();
    private HuoDongBean bean;
    @SuppressLint("HandlerLeak")
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MsgNum.Part3) {
                String data = (String) msg.obj;
                Gson gson = new Gson();


              bean = gson.fromJson(data, HuoDongBean.class);


                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mBaseAdapter.hideLoading();
                        //   mBaseAdapter.notifyDataSetChanged();
                        // mBaseAdapter.showLoading();
                        mBaseAdapter.clear();
                        mBaseAdapter.addAll(getCells(mockData()));

                    }
                },0);

            }

        }
    };








    @Override
    public void onRecyclerViewInitialized() {
        //初始化View和数据加载
        //设置刷新进度条颜色
        setColorSchemeResources(R.color.colorAccent);
        loadData();
    }


    @Override
    public void onPullRefresh() {
        //下拉刷新回调
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        //上拉加载回调
        loadMore();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.rv_base_fragment_layout,null);



        return view;
    }

    private void loadMore(){
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
           //     mBaseAdapter.addAll(getCells(mockMoreData()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();
        // cells.add(new Drangri_title(null));
      cells.add(new Huodong_part1(null));

        cells.add(new Huodong_part2xiu0630(bean));
        cells.add(new Huodong_part3xiu0630(null));
        return cells;
    }



    @Override
    public View addToolbar() {
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.title_show,null);


        return null;
    }

    /**
     * 模拟从服务器取数据
     */
    private void loadDataUI(){
        View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.manu_loading_layout,null);
        mBaseAdapter.showLoading(loadingView);

    }
    private void loadData(){
       loadDataUI();
        CommUtil.getHuodong(mhandler,HuoDongActivity.workid,MsgNum.Part3);

    }
}


