package com.example.temporaryname.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.temporaryname.R;
import com.example.temporaryname.adapters.RecyclerViewAdapter;
import com.example.temporaryname.ui.MainActivity;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImageBitmaps(view);
    }

    private void initImageBitmaps(View view){
        imageUrls.add("https://vladmadrid.ru/wp-content/uploads/2018/12/1418937866_seryy-texture-tekstura-cvet-64-1320x880.jpg");
        names.add("Bagan, Myanmar");

        imageUrls.add("https://steemitimages.com/DQmUVY4dnadzGHNcFzrv8iQdH9pEzHUHWUsB4ggMWTHa2Be/1.jpg");
        names.add("Colored Rocks, China");

        imageUrls.add("https://i.pinimg.com/originals/dc/23/9d/dc239d99d70a1e27f07bb78cac33416d.jpg");
        names.add("Li River, China");

        imageUrls.add("https://i.pinimg.com/originals/5b/c9/5b/5bc95b97331019bb4b7be7f2e9223826.jpg");
        names.add("The Meteora Monasteries, Greece");


        imageUrls.add("https://i.ytimg.com/vi/X0t1x3TDj1I/maxresdefault.jpg");
        names.add("Salar de Uni, Bolivia");

        imageUrls.add("https://youtravel.me/upload/tours/4635/media/9d5/9d580f2bc6ce7a4e261cb060af89fd8e.jpg");
        names.add("Tianzi Mountains, China");

        imageUrls.add("https://brobible.files.wordpress.com/2019/06/istock-929135598.jpg?quality=90&w=1300&h=866");
        names.add("Santorini Island, Greece");

        imageUrls.add("https://cs11.pikabu.ru/post_img/2018/04/23/4/og_og_1524461058245184804.jpg");
        names.add("Yosemite Valley, USA");

        imageUrls.add("https://steemitimages.com/DQmeAJDujP2zXMDx5V41nVWz3SLi7gDoTuMGy5g7Hk75GyA/06d68cfd8ed3bfb02d28362d22e584b7.jpg");
        names.add("Sagano Bamboo Forest – Kyoto, Japan");

        initRecyclerView(view);
    }

    private void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter((MainActivity) activity, names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
    }
}






















