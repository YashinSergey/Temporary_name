package com.example.temporaryname.ui.fragments.recycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.temporaryname.R;
import com.example.temporaryname.ui.MainActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> imageNames;
    private ArrayList<String> images;
    private MainActivity activity;

    public RecyclerViewAdapter(MainActivity activity, ArrayList<String> imageNames, ArrayList<String> images ) {
        this.imageNames = imageNames;
        this.images = images;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(activity.getApplicationContext()).asBitmap().load(images.get(position)).into(holder.image);

        holder.imageName.setText(imageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("image_url", images.get(position));
                bundle.putString("image_name", imageNames.get(position));
                activity.getGalleryFragment().setArguments(bundle);
                activity.replaceFragment(activity.getGalleryFragment());
//                Intent intent = new Intent(activity.getApplicationContext(), GalleryFragment.class);
//                intent.putExtra("image_url", images.get(position));
//                intent.putExtra("image_name", imageNames.get(position));
//                activity.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















