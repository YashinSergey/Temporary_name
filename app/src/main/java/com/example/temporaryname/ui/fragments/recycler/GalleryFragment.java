package com.example.temporaryname.ui.fragments.recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.temporaryname.R;

import java.util.Objects;

public class GalleryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getIncomingIntent(view);
    }

    private void getIncomingIntent(View view){
//        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
//            String imageUrl = getIntent().getStringExtra("image_url");
//            String imageName = getIntent().getStringExtra("image_name");
//            setImage(imageUrl, imageName);
//        }
        Bundle bundle = getArguments();
        assert bundle != null;
        if(bundle.containsKey("image_url") && bundle.containsKey("image_name")){
            String imageUrl = bundle.getString("image_url");
            String imageName = bundle.getString("image_name");
            setImage(view, imageUrl, imageName);
        }
    }

    private void setImage(View view, String imageUrl, String imageName){
        TextView name = view.findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = view.findViewById(R.id.image);
        Glide.with(Objects.requireNonNull(getActivity()).getApplicationContext()).asBitmap().load(imageUrl).into(image);
    }

}


















