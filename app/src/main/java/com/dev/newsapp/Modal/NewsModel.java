package com.dev.newsapp.Modal;

public class NewsModel {
    private String imgUrl , title , desc , date , newsUrl;

    public NewsModel(String imgUrl, String title, String desc, String date , String newsUrl) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.newsUrl = newsUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public String getNewsUrl() {
        return newsUrl;
    }
}
