package com.sindcreate.dj.comm.OKutil;

import android.os.Environment;
import android.support.annotation.IntDef;
import android.support.annotation.StringDef;



import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2017/12/27.
 */

public class Constants {
    public static final String TAG = "hef";

    public static final int PAGE_SIZE = 10; //每页显示item数量
    public static final String SUBJECT_NEXT = "subject_next"; //选中科目后跳转页
    public static final String INTERACTIVE_PRACTICE_LIST = "interactive_practice_list"; //互动练习列表
    public static final String CLASS_REPORT_LIST = "class_report_list_next"; //检测报告列表
    public static final String FORWARD_AND_BACK = "forward_and_back_next"; //检测报告列表
    public static final String KNOWLEDGR_PARSING = "knowledge_parsing"; //检测报告列表
    public static final String SECRET_PAPER_LIST = "secret_paper_list_next"; //精品密卷列表
    public static final String TEST_REPORT_LIST = "test_report_list_next"; //作业报告列表
    public static final String TEST_SCORE_INFO = "test_report_score_info_next"; //作业进退步分析
    public static final String TEST_KNOWLEDGE_INFO = "test_Knowledge_info_next"; //作业知识点
    public static final String GRESS_ANALYSIS = "gress_analysis_next"; //历次考试进退步分析
    public static final String KNOWLEDGE_ANALYSIS = "knowledge_analysis"; //历次考试知识点分析
    public static final String TEST_ANALYSIS_ITEM = "test_analysis_item"; //试题解析

    public static final int MIN_SIZE = 500;// 照片大小500k

    public static final String DIR = "ParentsClient";
    public static final String PACEAGERNAME = "ParentsClient";
    public static final String FILE_NOTE_DIR = "note";
    public static final String FILE_MIRCO_CLASS = "MircoClass";
    public static final String FILE_COURSEWARE = "Courseware";
    public static final String FILE_SECRET_PAPER = "精品密卷";

    public static final String URL = "url";
    public static final String TITLE = "title";
    public static final int POP_TOP = 1;
    public static final int POP_DOWN = 2;
    public static final int POP_ALL = 8;
    public static final int POP_OTHER = 9;
    public static final int TAKE_PHOTO = 10;
    public static final int CHOSE_PHOTO = 11;
    public static final String OK = "ok";
    public static final int COMPRESS_WIDTH = 215;
    public static final int COMPRESS_HEIGHT = 143;
    public static final int CHANGE_NAME = 102;
    public static final int CHOOSE_SCHOOL = 101;
    public static final String BEHAVIOR_PRAISE = "praise";
    public static final String BEHAVIOR_SIGN = "sign";
    public static final String BEHAVIOR_COMMIT = "commit";
    public static final String BEHAVIOR_SELFTEST = "selfTest";

    public static final String DATEFLAG_ONE_MONTH = "1";
    public static final String DATEFLAG_THREE_MONTH = "2";
    public static final String DATEFLAG_HALF_YEAR = "3";
    public static final String DATEFLAG_ONE_YEAR = "4";



    //    组卷类型 1：家长组卷 2：自我检测 3：错题重做 4：家长推错题拓展 5：学生自我错题拓展
    public static final int PAPERTYPE_PARENT = 1;
    public static final int PAPERTYPE_MYSELF = 2;
    public static final int PAPERTYPE_ERRORR_EPEAT = 3;
    public static final int PAPERTYPE_EXPORT_ERROR_BY_PARENT = 4;
    public static final int PAPERTYPE_EXPORT_ERROR_BY_MYSELF = 5;


    @StringDef({
            ChartFragmentType.SCORE,
            ChartFragmentType.CLASS,
            ChartFragmentType.GRADE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ChartFragmentType {
        String SCORE = "score";

        String CLASS = "class";

        String GRADE = "grade";
    }

    @IntDef({
            QuestionType.MULTIPLE_CHOICE,
            QuestionType.TRUE_OR_FALSE,
            QuestionType.FILLS_THE_TOPIC,
            QuestionType.SHORT_ANSWER_QUESTIONS,
            QuestionType.AUTO_FILLS_THE_TOPIC
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface QuestionType {
        int MULTIPLE_CHOICE = 121;
        int TRUE_OR_FALSE = 122;
        int FILLS_THE_TOPIC = 123;
        int SHORT_ANSWER_QUESTIONS = 124;
        int AUTO_FILLS_THE_TOPIC = 125;
    }

    /**
     * sd卡根目录
     */
    public static String SD = Environment.getExternalStorageDirectory()
            .getAbsolutePath();
    /**
     * 图片文件名
     */
    public static final String PIC_PATH = SD + "/.cucomic";
    public static final String PIC_CACHE_NAME = "image";

    /**
     * 推荐页图片缓存路径
     */
    public static final String REC_PIC_CACHE_NAME = "rec_img";


}
