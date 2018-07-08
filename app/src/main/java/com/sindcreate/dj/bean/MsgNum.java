package com.sindcreate.dj.bean;

import android.os.Message;

/**
 * Created by Double on 2018/6/4.
 */

public class MsgNum {
    public static final int OK = 100;
    public static final int MSG_Home = 10000;
    public static final int MSG_XiaoXI = 1000;
    public static final int MSG_SanHui = 1001;
    public static final int MSG_DangRI = 1002;
    public static final int MSG_ZAIXIANKAOSHI = 1003;
    public static final int MSG_Work = 1004;
    public static final int MSG_edu = 1005;
    public static final int MSG_Question = 1006;
    public static final int MSG_Question_Result = 1007;
    public static final int  Refresh_HomePage=1008;
    public static final int Part1=11001;
    public static final int Part2=11002;
    public static final int Part3=11003;

     public static Message getmsg(int MsGNumselect){
        Message msg=Message.obtain();
        msg.what=MsGNumselect;

        return  msg;
    }


}
