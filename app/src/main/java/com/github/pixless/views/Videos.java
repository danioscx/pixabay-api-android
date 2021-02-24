package com.github.pixless.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.github.danioscx.Pixabay;
import io.github.danioscx.utils.VideoType;
import com.github.pixless.R;
import com.github.pixless.utils.adapters.RecyclerViewAdapter;

import java.util.List;

public class Videos extends BaseViews implements BaseViews.OnBackPressed {

    public static final String API_KEY = "16013870-0f4196b948c4f65ced4be7fff";

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_videos);
        getContent();
    }

    private void getContent() {
        Pixabay.Video video = new Pixabay.Video(requireContext())
                .apiKey(API_KEY)
                .videoType(VideoType.ANIMATION);

        video.setOnPixabayVideoRequest(video, new Pixabay.Video.OnPixabayVideoRequest() {

            @Override
            public void onResult(List<io.github.danioscx.model.Videos> videos) {
                recyclerView.setAdapter(new RecyclerViewAdapter(videos, object ->
                        Toast.makeText(requireContext(), "This is sample images", Toast.LENGTH_SHORT).show()));
                LinearLayoutManager manager = new LinearLayoutManager(requireContext());
                manager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(manager);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    public void onBackPress() {

    }
}
