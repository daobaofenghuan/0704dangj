package com.sindcreate.dj.adapter.recycleradapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.Datebean.QSstatus;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.view.MPopupWindows;
import com.sindcreate.dj.view.MPopupWindows2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sindcreate.dj.util.UiUtil.getResources;

/**
 * Created by Administrator on 2018/1/25.
 */

public class ApplyforHelpAdapter extends RecyclerView.Adapter<ApplyforHelpAdapter.ViewHolder> {
    private Context mContext;
    private List<Bitmap> data;
    private OnClickListener onClickListener;

    private boolean isAll = false;

private  Activity ac;
    public ApplyforHelpAdapter(Context mContext, List<Bitmap> data, Activity ac) {
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
        if(viewType==1){
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_applyforhelp_pic, parent, false));}
        else {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_applyforhelp_pic2, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
      if(position>=data.size()){

holder.picview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        new MPopupWindows(mContext,holder.picview,ac);
    }
});
      }else {

          Bitmap bitmap = data.get(position);
          holder.picview.setImageBitmap(bitmap);


          holder.wrongly.setOnClickListener(new View.OnClickListener() {
              @SuppressLint("ResourceAsColor")
              @Override
              public void onClick(View v) {
                  System.out.println("被点击" + position);
                  // v.setBackgroundColor(R.color.base_orange);
                  Message msg = Message.obtain();
                  msg.what = MsgNum.OK;
                  msg.obj = position;
                  Mydata.helphandler.sendMessage(msg);
              }
          });
      }

    }

    @Override
    public int getItemCount() {

            return data.size()+1;


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



        @BindView(R.id.item_wrongly)
        RelativeLayout wrongly;
   @BindView(R.id.item_img)
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
