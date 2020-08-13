package com.dev.newsapp.Utils;

import android.widget.ArrayAdapter;

import com.dev.newsapp.Modal.NewsDataSource;

import java.util.ArrayList;
import java.util.List;

public class ListResource {

    public static List<NewsDataSource> getTabString()
    {
        List<NewsDataSource> tabList = new ArrayList<>();

        tabList.add(new NewsDataSource("The Hindu" , "the-hindu"));
        tabList.add(new NewsDataSource("ABC News" , "abc-news"));
        tabList.add(new NewsDataSource("Fox News" , "fox-news"));
        tabList.add(new NewsDataSource("Business Insider" , "business-insider"));
        tabList.add(new NewsDataSource("BuzzFeed" , "buzzfeed"));
        tabList.add(new NewsDataSource("CNN" , "cnn"));
        tabList.add(new NewsDataSource("Entertainment Weekly" , "entertainment-weekly"));
        tabList.add(new NewsDataSource("The Times of India" , "the-times-of-india"));
        tabList.add(new NewsDataSource("Tech Crunch" , "techcrunch"));
        tabList.add(new NewsDataSource("USA Today" , "usa-today"));

        return tabList;


    }
}
