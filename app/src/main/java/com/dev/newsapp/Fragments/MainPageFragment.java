package com.dev.newsapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.dev.newsapp.Activities.DisplayNewsActivity;
import com.dev.newsapp.Adapters.NewsAdapter;
import com.dev.newsapp.Modal.NewsModel;
import com.dev.newsapp.R;
import com.dev.newsapp.Utils.RequestSingleton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainPageFragment extends Fragment implements NewsAdapter.OnItemClick {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "sources";
    private static final String NEWS_URL = "https://newsapi.org/v2/everything?sources=";
    private  NewsAdapter adapter;
    private List<NewsModel> modelList;


    private String sourceName;


    public MainPageFragment() {
        // Required empty public constructor
    }


   // static method to create a new instance of this fragment
    public static MainPageFragment newInstance(String param1) {
        MainPageFragment fragment = new MainPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            sourceName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new NewsAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.setAdapter(adapter);

        callResponseFromNewApi();
    }

    private void callResponseFromNewApi() {
        String finalUrl = NEWS_URL + sourceName + "&language=en" + "&apiKey=28291808a5b4442d9f46ed1359ae7ceb";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET , finalUrl , null ,
                response ->{
                    Log.d("HttpResponse", "callResponseFromNewApi: " + response);
                    convertResponseToList(response);
                }  ,
                error -> {
                    Log.d("HttpResponse", "callResponseFromNewApi: "+error);
                });

        RequestSingleton.getRequestSingleton(requireActivity()).
                getRequestQueue().
                add(request);
    }

    private void convertResponseToList(JSONObject response) {
        modelList = new ArrayList<>();
        try {
            JSONArray jsonArray = response.getJSONArray("articles");




            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                modelList.add(new NewsModel(jsonObject.getString("urlToImage") ,
                        jsonObject.getString("title") ,
                        jsonObject.getString("description") ,
                        jsonObject.getString("publishedAt") ,
                        jsonObject.getString("url")));

            }

            adapter.setNewsData(modelList);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onNewsItemClick(int pos) {
        Intent intent = new Intent(requireActivity() , DisplayNewsActivity.class);
        intent.putExtra("news_url" , modelList.get(pos).getNewsUrl());
        startActivity(intent);
    }
}