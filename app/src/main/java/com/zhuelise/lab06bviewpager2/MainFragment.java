package com.zhuelise.lab06bviewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {
    ViewPager2 mViewPager2;
    int position;
    //int id;
    //use this page for help: https://stackoverflow.com/questions/45786697/adding-multiple-images-to-viewpager
    //add these image files to drawable folder:
    static int[] images = {R.drawable.image001, R.drawable.image002, R.drawable.image003, R.drawable.image004, R.drawable.image005, R.drawable.image006, R.drawable.image007, R.drawable.image008, R.drawable.image009, R.drawable.image010};

    public static Fragment newInstance(ViewPager2 mViewPager2, int position) {
        MainFragment fragment = new MainFragment();
        fragment.mViewPager2 = mViewPager2;
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(images[position]);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, mViewPager2,
                (tab, position) -> tab.setText("flower "+ (position+1))
        ).attach();
        Button mButton = view.findViewById(R.id.button);
        mButton.setText("Flower " + (position+1));
    }
}
