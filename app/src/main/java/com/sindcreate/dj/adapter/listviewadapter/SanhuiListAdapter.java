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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.comm.bean.SanHuiBean;
import com.sindcreate.dj.view.MyCircleImageView;

import java.io.File;
import java.util.ArrayList;

public class SanhuiListAdapter extends BaseAdapter {
    private Context context;
    private View[] itemViews;
    private LayoutInflater mInflater;
    private File cache;
    /**
     *
     */
    public  ArrayList<SanHuiBean> cf;

    public SanhuiListAdapter(Context context, ArrayList<SanHuiBean> cf2) {
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
            view = mInflater.inflate(R.layout.item_listv_sanhui_xiugai, null);
            vh = new ViewHolder(view);

            view.setTag(vh);

        } else {

            view = converView;
            vh = (ViewHolder) view.getTag();

        }
        SanHuiBean bean=cf.get(position);

vh.zhutitext.setText(bean.getPartyAffairsTheme());
vh.timetext.setText(bean.getPartyAffairsTime()+"截止");







//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.mipmap.head_error)
//                .diskCacheStrategy(DiskCacheStrategy.ALL);
//               Glide.with(context)
//                .load(item.getHeadImgUrl())
//                .apply(options)
//                .into(vh.im);

        return view;
    }

    // 自定义 优化
    class ViewHolder {
        TextView zhutitext, timetext, text3, text4;
        MyCircleImageView im;

        public ViewHolder(View view) {

//            im = view.findViewById(R.id.id_groupfragmentr1_img001);
            zhutitext = (TextView) view.findViewById(R.id.id_sanhui_zhuti);
            timetext = (TextView) view.findViewById(R.id.id_sanhui_time);
//            text3 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text3);
        }
    }






}