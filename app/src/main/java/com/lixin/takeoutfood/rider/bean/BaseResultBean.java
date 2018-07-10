package com.lixin.takeoutfood.rider.bean;

import java.util.ArrayList;

public class BaseResultBean {

    private String result;
    private int totalPage;
    private String resultNote;
    private String uid;

    private ArrayList<DataListBean> datalist;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getResultNote() {
        return resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<DataListBean> getDatalist() {
        return datalist;
    }

    public void setDatalist(ArrayList<DataListBean> datalist) {
        this.datalist = datalist;
    }

    public class DataListBean {

    }
}
