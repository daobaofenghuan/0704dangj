package com.sindcreate.dj.util;


import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;


import com.sindcreate.dj.application.MyApplication;


/**
 * @Description 通用Toast提示
 */

public class ToastUtil {

    private volatile static ToastUtil globalBoast = null;
    private final static int posY = 300;
    private Toast internalToast;

    private ToastUtil(Toast toast) {
        if (toast == null) {
            throw new NullPointerException("Toast requires a non-null parameter.");
        }
        internalToast = toast;
    }

    public static Context getContext() {
        return MyApplication.getContext();
    }

    public static void showText(CharSequence text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public static void showText(CharSequence text, int duration) {
        Toast.makeText(getContext(), text, duration).show();
    }

    public static void showText(int resId) throws Resources.NotFoundException {
        Toast.makeText(getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void showText(int resId, int duration) throws Resources.NotFoundException {
        Toast.makeText(getContext(), resId, duration).show();
    }


}
