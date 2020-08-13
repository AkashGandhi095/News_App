package com.dev.newsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.newsapp.Modal.NewsModel;
import com.dev.newsapp.R;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsModel> modelList;
    private OnItemClick onItemClick;
    public NewsAdapter(OnItemClick onItemClick) {
        modelList = new ArrayList<>();
        this.onItemClick = onItemClick;
    }

    public void setNewsData(List<NewsModel> modelList)
    {
        this.modelList = modelList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row , parent , false);
        return new NewsViewHolder(view , onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        NewsModel newsModel = modelList.get(position);
        if(newsModel != null)
        {
            if(newsModel.getImgUrl().equals("null"))
            {
                Picasso.get().load(R.drawable.news_placeholder).into(holder.imageView);
            }
            else
            {
                Picasso.get().load(newsModel.getImgUrl()).into(holder.imageView);
            }

            holder.titleText.setText(newsModel.getTitle());
            holder.descText.setText(newsModel.getDesc());
            holder.dateText.setText(newsModel.getDate());


        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private ImageView imageView;
        private MaterialTextView titleText , descText , dateText;
        private OnItemClick onItemClick;



        public NewsViewHolder(@NonNull View itemView  , OnItemClick onItemClick) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleText = itemView.findViewById(R.id.title_textView);
            descText = itemView.findViewById(R.id.desc_textView);
            dateText = itemView.findViewById(R.id.date_textView);
            this.onItemClick = onItemClick;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            onItemClick.onNewsItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClick{
        void onNewsItemClick(int pos);
    }
}


