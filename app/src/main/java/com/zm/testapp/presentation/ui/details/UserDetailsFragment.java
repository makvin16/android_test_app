package com.zm.testapp.presentation.ui.details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.zm.testapp.R;
import com.zm.testapp.databinding.FragmentUserDetailsBinding;
import com.zm.testapp.domain.model.user.UserDetailsDomain;
import com.zm.testapp.presentation.AppActivity;
import com.zm.testapp.presentation.ui.BaseFragment;
import org.jetbrains.annotations.NotNull;

public class UserDetailsFragment extends BaseFragment<UserDetailsDomain> {

    private FragmentUserDetailsBinding binding;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(
            @NonNull @NotNull LayoutInflater inflater,
            @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
            @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false);
        ((AppActivity) requireActivity()).updateTitle(getString(R.string.user_details));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull @NotNull View view,
            @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        if (getArguments() != null) {
            UserDetailsDomain userDetails = UserDetailsDomain.builder()
                    .photoUrl(getArguments().getString(Arguments.ARG_PHOTO_URL))
                    .fullName(getArguments().getString(Arguments.ARG_FULL_NAME))
                    .age(getArguments().getInt(Arguments.ARG_AGE))
                    .email(getArguments().getString(Arguments.ARG_EMAIL))
                    .city(getArguments().getString(Arguments.ARG_CITY))
                    .state(getArguments().getString(Arguments.ARG_STATE))
                    .country(getArguments().getString(Arguments.ARG_COUNTRY))
                    .build();
            initView(userDetails);
        }
    }

    @SuppressLint("SetTextI18n")
    private void initView(UserDetailsDomain userDetails) {
        Glide.with(this)
                .load(userDetails.getPhotoUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(binding.imageViewPhoto);
        binding.textViewName.setText(userDetails.getFullName());
        binding.textViewAge.setText(userDetails.getAge() + " " + getString(R.string.year));
        binding.textViewEmail.setText(userDetails.getEmail());
        binding.textViewCity.setText(userDetails.getCity());
        binding.textViewState.setText(userDetails.getState());
        binding.textViewCountry.setText(userDetails.getCountry());
    }

    @Override
    protected void onLoading(boolean isLoading) {

    }

    @Override
    protected void onSuccess(UserDetailsDomain data) {

    }

    @Override
    protected void onError(int error) {

    }

    public static class Arguments {

        static final String ARG_PHOTO_URL = "photo_url";
        static final String ARG_FULL_NAME = "full_name";
        static final String ARG_AGE = "age";
        static final String ARG_EMAIL = "email";
        static final String ARG_CITY = "city";
        static final String ARG_STATE = "state";
        static final String ARG_COUNTRY = "country";

        public Bundle makeArgs(
                String photoUrl,
                String fullName,
                int age,
                String email,
                String city,
                String state,
                String country
        ) {
            Bundle bundle = new Bundle();
            bundle.putString(ARG_PHOTO_URL, photoUrl);
            bundle.putString(ARG_FULL_NAME, fullName);
            bundle.putInt(ARG_AGE, age);
            bundle.putString(ARG_EMAIL, email);
            bundle.putString(ARG_CITY, city);
            bundle.putString(ARG_STATE, state);
            bundle.putString(ARG_COUNTRY, country);
            return bundle;
        }
    }

    static class Test implements Parcelable {

        protected Test(Parcel in) {
        }

        public static final Creator<Test> CREATOR = new Creator<Test>() {
            @Override
            public Test createFromParcel(Parcel in) {
                return new Test(in);
            }

            @Override
            public Test[] newArray(int size) {
                return new Test[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }
    }
}
