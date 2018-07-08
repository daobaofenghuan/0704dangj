package com.sindcreate.dj.application;

import android.app.Application;
import android.content.Context;



/**
 * Created by Double on 2018/5/23.
 */

public class MyApplication extends Application {
    private static final int MEMORY_SIZE = 5 * 1024 * 1024;
    private static final int DISK_SIZE = 20 * 1024 * 1024;
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();


        // 初始化 Image-Loader
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .build();
//
//        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
//                .memoryCache(new LruMemoryCache(MEMORY_SIZE))
//                .diskCache(new UnlimitedDiscCache(new File(getCacheDir(),"caches")))
//                .diskCacheSize(DISK_SIZE)
//                .defaultDisplayImageOptions(options)
//                .build();
//
//        ImageLoader.getInstance().init(configuration);






    }


    public static Context getContext() {
        return mContext;
    }
}
