package com.sindcreate.dj.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.Cell;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.cell.defautcell.ImageCell;
import com.sindcreate.dj.cell.defautcell.TextCell;
import com.sindcreate.dj.cell.messagecell.Part_message;
import com.sindcreate.dj.cell.messagecell.Part_title;
import com.sindcreate.dj.comm.CommUtil;
import com.sindcreate.dj.comm.bean.Notice_NewsBean;
import com.sindcreate.dj.comm.params.MHandler;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockData;
import static com.sindcreate.dj.DataMocker.mockMoreDatamessage;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class MessageFragment extends AbsBaseFragment<Entry> {
    List<Notice_NewsBean> list;
    @SuppressLint("HandlerLeak")
    private MHandler mHandler=new MHandler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what== MsgNum.OK){
            //    loadDataUI(1);
String data= (String) msg.obj;
Gson gson=new Gson();
        list=gson.fromJson(data,new TypeToken<ArrayList<Notice_NewsBean>>(){}.getType());


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


    private void loadMore(){
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
               // mBaseAdapter.addAll(getCells(mockMoreDatamessage()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell


        List<Cell> cells = new ArrayList<>();


        cells.add(new Part_title(null));

        for(Notice_NewsBean bean: list){

        Part_message mess=    new Part_message(bean);
         cells.add(mess);
        }




//        for (int i=0;i<list.size();i++){
//            Entry entry = entries.get(i);
//            if(entry.type == Entry.TYPE_IMAGE){
//               cells.add(new ImageCell(entry));
//            }if(entry.type==Entry.TYPE_MESSAGE){
//                cells.add(new Part_message(entry));
//                System.out.println("消息添加成功");
//            }
//
//            else{
//               cells.add(new TextCell(entry));
//           }
//        }
        return cells;
    }



    @Override
    public View addToolbar() {
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.title,null);
        TextView title=toolbar.findViewById(R.id.id_title_text);
        title.setText("消息");


        return toolbar;
    }

    /**
     * 模拟从服务器取数据
     */
    private void loadDataUI(int flag){
        if (flag==0) {
            View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.manu_loading_layout, null);
            mBaseAdapter.showLoading(loadingView);
        }
        if (flag==1) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBaseAdapter.hideLoading();

                }
            }, 2000);
        }
    }
    private void loadData(){
        loadDataUI(0);
        CommUtil.getNoticeNews(mHandler);


    }
}


