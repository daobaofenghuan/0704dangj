package com.sindcreate.dj.comm.bean;

import java.util.List;

/**
 * Created by Double on 2018/7/6.
 */

public class HuoDongBean {


    /**
     * buttonType :
     * isFeedBack : 1
     * isNotFeedBack : ["管理员","张三","测试3","测试3","6"]
     * isNotNotice : ["管理员","张三","测试3","测试3","6"]
     * isNotRegister : ["管理员","张三","测试3","测试3","6"]
     * isNotice : 1
     * isRecordRegister : 1
     * list : []
     * memberRange : 01
     * orgRange : 03
     * partyAffairsContent : 2222
     * partyAffairsDetailId : 0
     * partyAffairsId : 465569254683574272
     * partyAffairsPlace : 测试地点
     * partyAffairsState : 02
     * partyAffairsStateName : 进行中
     * partyAffairsTheme : 测试支部委员会
     * partyAffairsTime : 2018-03-01 14:00:00
     * partyAffairsType : 02
     * partyAffairsTypeName : 困难走访
     */

    private String buttonType;
    private String isFeedBack;
    private String isNotice;
    private String isRecordRegister;
    private String memberRange;
    private String orgRange;
    private String partyAffairsContent;
    private int partyAffairsDetailId;
    private String partyAffairsId;
    private String partyAffairsPlace;
    private String partyAffairsState;
    private String partyAffairsStateName;
    private String partyAffairsTheme;
    private String partyAffairsTime;
    private String partyAffairsType;
    private String partyAffairsTypeName;
    private List<String> isNotFeedBack;
    private List<String> isNotNotice;
    private List<String> isNotRegister;
    private List<?> list;

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getIsFeedBack() {
        return isFeedBack;
    }

    public void setIsFeedBack(String isFeedBack) {
        this.isFeedBack = isFeedBack;
    }

    public String getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(String isNotice) {
        this.isNotice = isNotice;
    }

    public String getIsRecordRegister() {
        return isRecordRegister;
    }

    public void setIsRecordRegister(String isRecordRegister) {
        this.isRecordRegister = isRecordRegister;
    }

    public String getMemberRange() {
        return memberRange;
    }

    public void setMemberRange(String memberRange) {
        this.memberRange = memberRange;
    }

    public String getOrgRange() {
        return orgRange;
    }

    public void setOrgRange(String orgRange) {
        this.orgRange = orgRange;
    }

    public String getPartyAffairsContent() {
        return partyAffairsContent;
    }

    public void setPartyAffairsContent(String partyAffairsContent) {
        this.partyAffairsContent = partyAffairsContent;
    }

    public int getPartyAffairsDetailId() {
        return partyAffairsDetailId;
    }

    public void setPartyAffairsDetailId(int partyAffairsDetailId) {
        this.partyAffairsDetailId = partyAffairsDetailId;
    }

    public String getPartyAffairsId() {
        return partyAffairsId;
    }

    public void setPartyAffairsId(String partyAffairsId) {
        this.partyAffairsId = partyAffairsId;
    }

    public String getPartyAffairsPlace() {
        return partyAffairsPlace;
    }

    public void setPartyAffairsPlace(String partyAffairsPlace) {
        this.partyAffairsPlace = partyAffairsPlace;
    }

    public String getPartyAffairsState() {
        return partyAffairsState;
    }

    public void setPartyAffairsState(String partyAffairsState) {
        this.partyAffairsState = partyAffairsState;
    }

    public String getPartyAffairsStateName() {
        return partyAffairsStateName;
    }

    public void setPartyAffairsStateName(String partyAffairsStateName) {
        this.partyAffairsStateName = partyAffairsStateName;
    }

    public String getPartyAffairsTheme() {
        return partyAffairsTheme;
    }

    public void setPartyAffairsTheme(String partyAffairsTheme) {
        this.partyAffairsTheme = partyAffairsTheme;
    }

    public String getPartyAffairsTime() {
        return partyAffairsTime;
    }

    public void setPartyAffairsTime(String partyAffairsTime) {
        this.partyAffairsTime = partyAffairsTime;
    }

    public String getPartyAffairsType() {
        return partyAffairsType;
    }

    public void setPartyAffairsType(String partyAffairsType) {
        this.partyAffairsType = partyAffairsType;
    }

    public String getPartyAffairsTypeName() {
        return partyAffairsTypeName;
    }

    public void setPartyAffairsTypeName(String partyAffairsTypeName) {
        this.partyAffairsTypeName = partyAffairsTypeName;
    }

    public List<String> getIsNotFeedBack() {
        return isNotFeedBack;
    }

    public void setIsNotFeedBack(List<String> isNotFeedBack) {
        this.isNotFeedBack = isNotFeedBack;
    }

    public List<String> getIsNotNotice() {
        return isNotNotice;
    }

    public void setIsNotNotice(List<String> isNotNotice) {
        this.isNotNotice = isNotNotice;
    }

    public List<String> getIsNotRegister() {
        return isNotRegister;
    }

    public void setIsNotRegister(List<String> isNotRegister) {
        this.isNotRegister = isNotRegister;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
