package com.example.newsqlite;

import java.io.Serializable;
import java.util.Arrays;

public class NewsBean implements Serializable {
    private  String newsTitle;
    private String newsContent;

    public NewsBean(String newsTitle, String newsContent) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public NewsBean() {
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }
}
