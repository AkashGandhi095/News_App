package com.dev.newsapp.Modal;

public class NewsDataSource {

    private String tabName , source_id;

    public NewsDataSource(String tabName, String source_id) {
        this.tabName = tabName;
        this.source_id = source_id;
    }

    public String getTabName() {
        return tabName;
    }

    public String getSource_id() {
        return source_id;
    }
}
