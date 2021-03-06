package com.sindcreate.dj.adapter.listviewadapter;

/**
 * Created by 大宝 on 2018/1/5.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.comm.bean.WorkBean;
import com.sindcreate.dj.view.MyCircleImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WorkListAdapter extends BaseAdapter {
    private Context context;
    private View[] itemViews;
    private LayoutInflater mInflater;
    private File cache;
    /**
     *
     */
    public static List<WorkBean> cf;

    public WorkListAdapter(Context context, List<WorkBean> cf2) {
        this.context = context;
        cf = cf2;
        this.cache = cache;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cf.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return cf.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup arg2) {
        // TODO Auto-generated method stub
        View view;
        ViewHolder vh;

        if (converView == null) {
            view = mInflater.inflate(R.layout.item_listv_work0630, null);
            vh = new ViewHolder(view);

            view.setTag(vh);

        } else {

            view = converView;
            vh = (ViewHolder) view.getTag();


        }
         WorkBean bean=cf.get(position);
     vh.timetext.setText("要求完成时间： "+bean.getActualFinishTime().toString());
vh.titletext.setText(bean.getTaskTitle());
vh.nametext.setText("发起人："+bean.getRunPeopleName());





        return view;
    }

    // 自定义 优化
    class ViewHolder {
        TextView timetext, titletext, nametext, text4;
        MyCircleImageView im;

        public ViewHolder(View view) {


//            im = view.findViewById(R.id.id_groupfragmentr1_img001);
            timetext = (TextView) view.findViewById(R.id.id_itemwork_textsj);
           titletext= (TextView) view.findViewById(R.id.id_work_text1);
       nametext= (TextView) view.findViewById(R.id.id_work_name);
        }
    }






}