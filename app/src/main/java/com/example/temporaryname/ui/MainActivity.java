package com.example.temporaryname.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.temporaryname.R;
import com.example.temporaryname.ui.fragments.InteriorFragment;
import com.example.temporaryname.ui.fragments.MuscleCarsFragment;
import com.example.temporaryname.ui.fragments.GreatestPeopleFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private  FloatingActionButton fab;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private InteriorFragment interiorFragment;
    private MuscleCarsFragment muscleCarsFragment;
    private GreatestPeopleFragment greatestPeopleFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initNavigationDrawer();
        initFab();
        initFragments(savedInstanceState);
    }

    private void initNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initFragments(Bundle savedInstanceState) {
        interiorFragment = new InteriorFragment();
        muscleCarsFragment = new MuscleCarsFragment();
        greatestPeopleFragment = new GreatestPeopleFragment();
        if (savedInstanceState == null) {
            replaceFragment(muscleCarsFragment);
        }
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Home");
    }

    private void initFab() {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(fabListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener fabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_interior:
                replaceFragment(interiorFragment);
                break;
            case R.id.nav_muscle_cars:
                replaceFragment(muscleCarsFragment);
                break;
            case R.id.nav_greatest_people:
                replaceFragment(greatestPeopleFragment);
                break;
        }
        setToolbarTitle(id);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_for_fragments, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setToolbarTitle(int id) {
        String title = "";
        switch (id) {
            case R.id.nav_interior:
               title = "Interior";
               break;
            case R.id.nav_muscle_cars:
                title = "Muscle cars";
                break;
            case R.id.nav_greatest_people:
                title = "Greatest people";
                break;
        }
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
}
