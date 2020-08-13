package com.dev.newsapp.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.dev.newsapp.Adapters.NewsPagerAdapter;
import com.dev.newsapp.R;
import com.dev.newsapp.Utils.ListResource;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        MaterialToolbar toolbar = findViewById(R.id.material_toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.material_tabs);
        ViewPager2 pager2 = findViewById(R.id.view_Pager2);
        NewsPagerAdapter adapter = new NewsPagerAdapter(this);
        pager2.setAdapter(adapter);
//        pager2.setOffscreenPageLimit(ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT);

        new TabLayoutMediator(tabLayout, pager2, (tab, position) ->
                tab.setText(ListResource.getTabString().get(position).getTabName()))
                .attach();

    }
}