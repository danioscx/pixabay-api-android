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

import com.github.pixabay.Pixabay;
import com.github.pixabay.model.Images;
import com.github.pixabay.utils.Colors;
import com.github.pixless.R;
import com.github.pixless.utils.adapters.RecyclerViewAdapter;

import java.util.List;

public class Home extends BaseViews implements BaseViews.OnBackPressed {

    public static final String API_KEY = "16013870-0f4196b948c4f65ced4be7fff";

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_home);
        setContent();
    }

    private void setContent() {
        Pixabay pixabay = Pixabay.getInstance(requireContext())
                .apiKey(API_KEY)
                .editorChoice(true)
                .colors(Colors.BROWN);
        pixabay.setOnPixabayImageRequest(pixabay, new Pixabay.OnPixabayImageRequest() {

            @Override
            public void onResult(List<Images> images) {
                recyclerView.setAdapter(new RecyclerViewAdapter(images, object ->
                        Toast.makeText(requireContext(), ((Images)object).getId() + "", Toast.LENGTH_SHORT).show()));
                LinearLayoutManager manager = new LinearLayoutManager(requireContext());
                manager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(manager);
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: " + error);
            }
        });
    }

    @Override
    public void onBackPress() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }
}
