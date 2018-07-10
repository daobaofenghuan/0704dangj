package com.sindcreate.dj.comm;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.sindcreate.dj.application.MyApplication;
import com.sindcreate.dj.comm.params.NewsParams;
import com.sindcreate.dj.util.ACache;
import com.sindcreate.dj.util.ThreadManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Double on 2018/5/7.
 */

public class CommUtil {
    static PostParams Params = new PostParams();
    public static boolean flag = false;


    //注册
    public static void Register(String tupian, String name, String password, String nickname, Handler mhandler) {
        String url = Urls.BASE_URL + Urls.REGISTER;
        Params = new PostParams();
        Params.userid = name;
        Params.pwd = password;
        Params.name = nickname;
        Params.headdata = tupian;

        //Postgetreturn(url, Params, mhandler,interfacedataback);


    }

    //1登录
    public static void Login(String name, String password, Handler mhandler) {
        String url = Urls.BASE_URL + Urls.UsrLogin;
        Params = new PostParams();
        Params.account = name;
        Params.passwd = password;
        Interfacedataback interfacedataback = new Interfacedataback() {
            @Override
            public void getdataback(String databack) {
                ACache ac = ACache.get(MyApplication.getContext());
                try {
                    JSONObject jsonback = new JSONObject(databack);
                    JSONObject jobject = jsonback.getJSONObject("data");
                    String token = jobject.getString("token");
                    ac.put("token", token, ACache.TIME_DAY * 8);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        Postgetreturn(url, Params, mhandler, interfacedataback);

    }

    //2获取时政要闻轮播图
    public static void getNews(Handler mhandler) {
        String url = Urls.BASE_URL + Urls.NEWS_URL;
        //  Params=new PostParams();
        NewsParams params = new NewsParams();
        params.getPagination().setCurrent(1);
        params.getPagination().setPagesize(5);
        params.getPagination().setTotal(0);


        Postgetdatas(url, params, mhandler);


    }
//3三会一课开展中
public static void getSanhuiIng(Handler mhandler,int part) {
    String url = Urls.BASE_URL + Urls.SANHUI_ING;
    //  Params=new PostParams();
    NewsParams params = new NewsParams();


    Postgetdatas(url, params, mhandler,part);


}
    //4三会一课已结束
    public static void getSanhuiEnd(Handler mhandler,int part) {
        String url = Urls.BASE_URL + Urls.SANHUI_END;
        //  Params=new PostParams();
        NewsParams params = new NewsParams();


        Postgetdatas(url, params, mhandler,part);


    }
    //5党务工作开展中
    public static void getDang2Ing(Handler mhandler,int part) {
        String url = Urls.BASE_URL + Urls.DANGWU_ING;
        //  Params=new PostParams();
        NewsParams params = new NewsParams();


        Postgetdatas(url, params, mhandler,part);


    }
    //6党务工作已结束
    public static void getDang2End(Handler mhandler,int part) {
        String url = Urls.BASE_URL + Urls.DANGWU_END;
        //  Params=new PostParams();
        NewsParams params = new NewsParams();


        Postgetdatas(url, params, mhandler,part);


    }
// 7活动详情
    public static void getHuodong(Handler mhandler,String workid,int Part){
        String url = Urls.BASE_URL + Urls.DANGWU_INDEX+"/"+workid;
        //  Params=new PostParams();



        Postgetdata(url, null, mhandler,Part);


    }
    //8签到
    public static void ClickQianDao(Handler mhandler,String workid,String whereareyouqiandao){
        String url = Urls.BASE_URL + Urls.QIAN_DAO;

        Params = new PostParams();
        Params.partyAffairsDetailId=workid;
        Params.registerPlace=whereareyouqiandao;
        Postgetdata(url, Params, mhandler);



    }
    //9每日一课
    public static void getEveryDayKeID(Handler mhandler){
        String url = Urls.BASE_URL + Urls.GET_EVERY_DAY_KE_ID;
        Postgetdata(url,null,mhandler);

    }
    //10每日一课详细
    public static void getEveryDayKe(Handler mhandler,String lessonID){
        String url = Urls.BASE_URL + Urls.GET_EVERY_DAY_KE+lessonID;
        Postgetdata(url,null,mhandler);

    }
    //11工作任务
    public  static void getWorkData(Handler mhandler){
        String url = Urls.BASE_URL + Urls.GET_WORK_DATA;
        Postgetdatas(url,null,mhandler);

    }

    public  static void getWorkDataIndex(Handler mhandler,String workid){
        String url = Urls.BASE_URL + Urls.    GET_WORK_INDEX+workid;
        Postgetdata(url,null,mhandler);

    }











    //==========================================================================================================================================

    //下面为基本链接
    private static void Post(final String url, final PostParams params, final Handler handler) {

        new Thread() {
            @Override
            public void run() {
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                //  Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {
                        msg.what = COMM.OK;


                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }

    private static void Postgetreturn(final String url, final PostParams params, final Handler handler, final Interfacedataback interfacedataback) {

        new Thread() {
            @Override
            public void run() {
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                //  Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {
                        msg.what = COMM.OK;


                    } else {
                        msg.what = COMM.Failed;

                    }
                    handler.sendMessage(msg);
                    interfacedataback.getdataback(databack);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }


    private static void Postgetdata(final String url, final PostParams params, final Handler handler, final int part) {

        new Thread() {
            @Override
            public void run() {
                System.out.println("==========================================================================");
                Log.e("db_test_databack", url);
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {
                        if (part!=0){msg.what=part;
                        }else {
                        msg.what = COMM.OK;}
                        JSONObject jsonObject2 = jsonObject.getJSONObject("data");
                        msg.obj = jsonObject2.toString();

                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }

    private static void Postgetdata(final String url, final PostParams params, final Handler handler) {

        new Thread() {
            @Override
            public void run() {
                System.out.println("==========================================================================");
                Log.e("db_test_databack", url);
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {

                            msg.what = COMM.OK;
                       msg.obj = jsonObject.getString("data");


                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }
    private static void Postgetdatas(final String url, final PostParams params, final Handler handler) {

        new Thread() {
            @Override
            public void run() {
                System.out.println("==========================================================================");
                Log.e("db_test_databack", url);
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {

                            msg.what = COMM.OK;
                        JSONArray jsonArray = jsonObject.getJSONArray("datas");
                        msg.obj = jsonArray.toString();

                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }
    private static void Postgetdatas(final String url, final PostParams params, final Handler handler,final  int part) {

        new Thread() {
            @Override
            public void run() {
                System.out.println("==========================================================================");
                Log.e("db_test_databack", url);
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {

                        if (part!=0){msg.what=part;
                        }else {
                            msg.what = COMM.OK;}
                        JSONArray jsonArray = jsonObject.getJSONArray("datas");
                        msg.obj = jsonArray.toString();

                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }

    private static void Postuserid(final String ur, final String userid, final Handler handler) {

        new Thread() {
            @Override
            public void run() {

                String url = ur + "/" + userid;
                StringBuffer ssr = HttpUrls.post(url, null);
                String databack = ssr.toString();
                Log.e("db_test", databack);
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    String value = jsonObject.getString("back");
                    String data = null;
                    if (flag) {
                        data = jsonObject.getString("data");
                    }

                    if (value.equals("1")) {
                        msg.what = COMM.OK;
                        if (data != null && !"".equals(data)) {
                            msg.obj = data;

                        }


                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }



    private static void Pos(final String url, final PostParams params, final Handler handler) {
new ThreadManager();


        new Thread() {
            @Override
            public void run() {
                System.out.println("==========================================================================");
                Log.e("db_test_databack", url);
                Gson gson = new Gson();
                StringBuffer data = new StringBuffer(gson.toJson(params));
                Log.e("db_test_post", data.toString());
                StringBuffer ssr = HttpUrls.post(url, data);
                String databack = ssr.toString();
                System.out.println("==========================================================================");
                Log.e("db_test_databack", databack);
                System.out.println("==========================================================================");
                Message msg = Message.obtain();

                try {
                    JSONObject jsonObject = new JSONObject(databack);
                    int value = jsonObject.getInt("error_code");
                    if (value == 200) {

                        msg.what = COMM.OK;
                        JSONArray jsonArray = jsonObject.getJSONArray("datas");
                        msg.obj = jsonArray.toString();

                    } else {
                        msg.what = COMM.Failed;
                    }
                    handler.sendMessage(msg);
                } catch (JSONException e) {
                    e.printStackTrace();
                    msg.what = COMM.MISS;
                    handler.sendMessage(msg);
                }


            }
        }.start();


    }


}
