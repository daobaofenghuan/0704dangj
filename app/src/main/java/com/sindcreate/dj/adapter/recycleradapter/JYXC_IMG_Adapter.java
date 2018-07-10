package com.sindcreate.dj.adapter.recycleradapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.view.MPopupWindows;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/25.
 */

public class JYXC_IMG_Adapter extends RecyclerView.Adapter<JYXC_IMG_Adapter.ViewHolder> {
    private Context mContext;
    private List<String> data;
    private OnClickListener onClickListener;

    private boolean isAll = false;

private  Activity ac;
    public JYXC_IMG_Adapter(Context mContext, List<String> data, Activity ac) {
        this.mContext = mContext;
        this.data = data;
        this.ac=ac;
    }

    public void setIsAll() {
        isAll = !isAll;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.rev_jyimg, parent, false));

    }






    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {




    }

    @Override
    public int getItemCount() {

            return data.size();


    }

    @Override
    public int getItemViewType(int position) {
      if(position<data.size())  {
          return 1;
      }else {
          return 0;
      }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


@BindView(R.id.img)
        ImageView picview;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnClickListener {
        void onItemClick(int position);

        void onAddClick();

        void onDeleteClick();
    }
}
