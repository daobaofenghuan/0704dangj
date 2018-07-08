package com.sindcreate.dj.adapter.listviewadapter;

/**
 * Created by 大宝 on 2018/1/5.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.dj.view.MyCircleImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EduListAdapter extends BaseAdapter {
    private Context context;
    private View[] itemViews;
    private LayoutInflater mInflater;
    private File cache;
    /**
     *
     */
    public static List<Entry> cf;

    public EduListAdapter(Context context, List<Entry> cf2) {
        this.context = context;
        cf = cf2;
        this.cache = cache;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cf.size()/2;
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
            view = mInflater.inflate(R.layout.item_listv_edu, null);
            vh = new ViewHolder(view);

            view.setTag(vh);

        } else {

            view = converView;
            vh = (ViewHolder) view.getTag();

        }
       String url1=cf.get(position*2).imageUrl;

        System.out.println("url为"+url1);
        Glide.with(context).load(url1).into(vh.img1);
       vh.text1.setText(cf.get(position*2).nr);
        Glide.with(context).load(cf.get(position*2+1).imageUrl).into(vh.img2);
        vh.text2.setText(cf.get(position*2+1).nr);

        return view;
    }

    // 自定义 优化
    class ViewHolder {
        TextView text1, text2, text3, text4;
     ImageView img1,img2;

        public ViewHolder(View view) {
            img1=view.findViewById(R.id.item_edu_img);
            text1 =view.findViewById(R.id.item_edu_texttitle);
            img2=view.findViewById(R.id.item_edu_img2);
            text2 =view.findViewById(R.id.item_edu_texttitle2);
//            im = view.findViewById(R.id.id_groupfragmentr1_img001);
//            text1 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text1);
//            text2 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text2);
//            text3 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text3);
        }
    }






}