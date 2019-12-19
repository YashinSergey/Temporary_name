package com.example.temporaryname.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.temporaryname.R;
import com.example.temporaryname.ui.adapters.TabsAdapter;
import com.example.temporaryname.ui.fragments.GreatestPeopleFragment;
import com.example.temporaryname.ui.fragments.InteriorFragment;
import com.example.temporaryname.ui.fragments.MuscleCarsFragment;
import com.example.temporaryname.ui.fragments.RecyclerFragment;
import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        MuscleCarsFragment muscleCarsFragment = new MuscleCarsFragment();
        InteriorFragment interiorFragment = new InteriorFragment();
        GreatestPeopleFragment greatestPeopleFragment = new GreatestPeopleFragment();
        RecyclerFragment recyclerFragment = new RecyclerFragment();


        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        tabsAdapter.addFragment(muscleCarsFragment, "Cars");
        tabsAdapter.addFragment(interiorFragment, "Interior");
        tabsAdapter.addFragment(greatestPeopleFragment, "People");
        tabsAdapter.addFragment(recyclerFragment, "Places");

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(tabsAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}