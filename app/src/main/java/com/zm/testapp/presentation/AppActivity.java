package com.zm.testapp.presentation;

import android.os.Bundle;
import android.view.View;
import com.zm.testapp.databinding.ActivityAppBinding;
import dagger.android.support.DaggerAppCompatActivity;

public class AppActivity extends DaggerAppCompatActivity {

    private ActivityAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void updateTitle(String title) {
        binding.textViewTitle.setText(title);
    }

    public void updateProgressBar(boolean visibilityProgressBar) {
        binding.progressBar.setVisibility(visibilityProgressBar ? View.VISIBLE : View.GONE);
        binding.fragmentNavHost.setVisibility(!visibilityProgressBar ? View.VISIBLE : View.GONE);
    }

}
