package com.sindcreate.dj.comm.OKutil;

import android.graphics.Bitmap;


import com.sindcreate.dj.R;
import com.sindcreate.dj.util.ToastUtil;
import com.sindcreate.dj.util.UiUtil;


/**
 * @Description 自定义请求回调类
 */

public abstract class HttpCallback {

    /**
     * @param response 返回数据
     * @Description 请求成功时回调
     */
    public void onSuccess(String response) {
    }

    /**
     * @param code    状态码
     * @param message 状态消息
     * @Description 请求失败时回调
     */
    public void onFailure(int code, String message) {
        ToastUtil.showText(message);
    }

    /**
     * @param currentTotalLen 进度
     * @param totalLen        总量
     * @Description 上传或下载时进度回调
     */
    public void onProgress(long currentTotalLen, long totalLen) {
    }

    /**
     * @param bitmap 图片bitmap
     * @Description 显示图片成功回调
     */
    public void onBitmapSuccess(Bitmap bitmap) {
    }

    /**
     * 没有网络连接的回调
     */
    public void onNetConnectFailure(){
        ToastUtil.showText(UiUtil.getString(R.string.net_error));
    }
}
