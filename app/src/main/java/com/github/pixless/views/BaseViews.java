package com.github.pixless.views;

import androidx.fragment.app.Fragment;

public abstract class BaseViews extends Fragment {

    public interface OnBackPressed {
        void onBackPress();
    }
}
