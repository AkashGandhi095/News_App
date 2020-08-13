package com.dev.newsapp.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dev.newsapp.Fragments.MainPageFragment;
import com.dev.newsapp.Utils.ListResource;

public class NewsPagerAdapter extends FragmentStateAdapter {


    public NewsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Log.d("NewsPagerAdapter", "createFragment: "+position);
        return MainPageFragment.newInstance(ListResource.getTabString().get(position).getSource_id());
    }

    @Override
    public int getItemCount() {
        return ListResource.getTabString().size();
    }
}
