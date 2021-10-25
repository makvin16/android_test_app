package com.zm.testapp.presentation.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.zm.testapp.databinding.ItemUserBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final ItemUserBinding binding;

    public UserViewHolder(View view) {
        super(view);
        binding = ItemUserBinding.bind(view);
    }

    public ItemUserBinding getBinding() {
        return binding;
    }
}
