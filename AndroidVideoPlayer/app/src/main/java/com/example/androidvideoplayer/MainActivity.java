package com.example.androidvideoplayer;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewDebug;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidvideoplayer.FirstFragment;
import com.example.androidvideoplayer.SecondFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.androidvideoplayer.R;
import com.google.android.material.navigation.NavigationBarView;
import android.net.Uri;
import java.io.*;

public class MainActivity extends AppCompatActivity
        implements NavigationBarView
        .OnItemSelectedListener {

    NavigationBarView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.queue);
    }
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        final int queue = R.id.queue;
        final int playlist = R.id.playlist;
        if(item.getItemId()==queue){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, firstFragment)
                    .commit();
            return true;
        }
        else if (item.getItemId()==playlist){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, secondFragment)
                    .commit();
            return true;
        }
        return false;
    }

}
