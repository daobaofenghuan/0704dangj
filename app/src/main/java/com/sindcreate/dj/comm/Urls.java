package com.sindcreate.dj.comm;

/**
 * Created by qlw on 2018/5/7.
 */

public class Urls {
    public final static String BASE_URL="http://www.youai.info:8181";
    public final static String UsrLogin="/api/auth/login";
    public final static String REGISTER="register";

//三会一课
    public final static String SANHUI_ING="/api/partyAffiars/queryAffairsForThree/02";
    public final static String SANHUI_END="/api/partyAffiars/queryAffairsForThree/03";
    //党务工作
    public final static String DANGWU_ING="/api/partyAffiars/queryAffairsNotForTree/02";
    public final static String DANGWU_END="/api/partyAffiars/queryAffairsNotForTree/03";
    public final static String DANGWU_INDEX="/api/partyAffiars/detailForMobile";
    public final static String QIAN_DAO="/api/partyAffiars/signIn";

    public final static String NEWS_URL="/api/news/queryforlist";
    //每日一课
    public final static String GET_EVERY_DAY_KE_ID ="/api/lesson/randomLesson";
    public final static String GET_EVERY_DAY_KE="/api/lesson/detail/";
//工作任务列表
    public final static String GET_WORK_DATA="/api/task/queryTask";
    //工作任务详细
    public final static String GET_WORK_INDEX="/api/task/delete/" ;







}
