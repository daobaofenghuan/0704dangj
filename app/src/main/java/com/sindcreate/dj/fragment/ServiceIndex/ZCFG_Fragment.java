package com.sindcreate.dj.fragment.ServiceIndex;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.Cell;
import com.sindcreate.dj.fragment.AbsBaseFragment;
import com.sindcreate.dj.fragment.ServiceIndex.zxfgcell.ZCFG_Part0;
import com.sindcreate.dj.fragment.ServiceIndex.zxfgcell.ZCFG_Part1;
import com.sindcreate.dj.fragment.ServiceIndex.zxfgcell.ZCFG_Part2;
import com.sindcreate.dj.fragment.myindex.footcell.FootPart1;
import com.sindcreate.dj.fragment.myindex.footcell.Foot_Part2;
import com.sindcreate.dj.fragment.myindex.footcell.Foot_Part_empbig;
import com.sindcreate.dj.fragment.myindex.footcell.Foot_Part_empsm;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockData;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class ZCFG_Fragment extends AbsBaseFragment<Entry> {
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


    private void loadMore(){
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
            //    mBaseAdapter.addAll(getCells(mockMoreData()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();
        cells.add(new ZCFG_Part0(null));
        cells.add(new ZCFG_Part1(null));
        cells.add(new ZCFG_Part2(null));
        cells.add(new ZCFG_Part2(null));
        cells.add(new ZCFG_Part2(null));
        return cells;
    }



    @Override
    public View addToolbar() {
//View view=l item_home_title2
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.item_home_title2,null);
     TextView textView= toolbar.findViewById(R.id.id_hometitle_2);
     TextView textView1=toolbar.findViewById(R.id.id_item_rtext);

        textView1.setText("");
     textView.setText("政策法规");


        return toolbar;
    }

    /**
     * 模拟从服务器取数据
     */
    private void loadData(){
        View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.manu_loading_layout,null);
        mBaseAdapter.showLoading(loadingView);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBaseAdapter.hideLoading();
                mBaseAdapter.addAll(getCells(mockData()));
            }
        },20);
    }
}


