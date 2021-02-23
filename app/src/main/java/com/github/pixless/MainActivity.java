package com.github.pixless;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.github.pixless.views.Home;
import com.github.pixless.views.Videos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
       *//* Pixabay pixabay = Pixabay.getInstance(this)
                .apiKey(API_KEY)
                .editorChoice(true)
                .query("nature");

        pixabay.setOnPixabayImageRequest(pixabay, new Pixabay.OnPixabayImageRequest() {

            @Override
            public void onResult(List<Images> images) {
                System.out.println("UKURAN " + images.size());
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });*//*
        Pixabay.Video videos = new Pixabay.Video(this).apiKey(API_KEY)
                .videoType(VideoType.ANIMATION);

        videos.setOnPixabayVideoRequest(videos, new Pixabay.Video.OnPixabayVideoRequest() {
            @Override
            public void onResult(List<Videos> videos) {
                System.out.println(videos.size());
            }

            @Override
            public void onError(String error) {

            }
        });

        *//*PixabayRequestResult result = response -> {
            try {
                JSONArray array = response.getJSONArray("hits");
                for (int i = 0; i < array.length() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    JSONObject videos1 = object.getJSONObject("videos");
                    JSONObject large = videos1.getJSONObject("large");

                    System.out.println(large.getString("url"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        };

        PixabayRequest.with(this)
                .from(videos).putIn(result);*/
        selectFragment(new Home());
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation_view);
        navigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                selectFragment(new Home());
            } else if (item.getItemId() == R.id.videos) {
                selectFragment(new Videos());
            }
            return true;
        });
    }

    private void selectFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }
}