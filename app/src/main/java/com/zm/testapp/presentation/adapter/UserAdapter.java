package com.zm.testapp.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.zm.testapp.R;
import com.zm.testapp.databinding.ItemUserBinding;
import com.zm.testapp.domain.model.user.UserDomain;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<UserDomain> list = new ArrayList<>();
    private UserAdapterListener userAdapterListener;

    public void update(List<UserDomain> list) {
        if (list != null) {
            this.list = list;
        } else {
            this.list.clear();
        }
        notifyDataSetChanged();
    }

    public void setUserAdapterListener(UserAdapterListener userAdapterListener) {
        this.userAdapterListener = userAdapterListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        bind(holder.getBinding(), list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void bind(ItemUserBinding binding, UserDomain item) {
        binding.textViewName.setText(item.getName());
        Glide.with(binding.getRoot())
                .load(item.getPhotoUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(binding.imageViewPhoto);
        binding.getRoot().setOnClickListener(view -> {
            if (userAdapterListener != null) {
                userAdapterListener.onClick(item.getUserDetails());
            }
        });
    }
}
