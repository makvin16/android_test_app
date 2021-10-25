package com.zm.testapp.presentation.ui.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.zm.testapp.R;
import com.zm.testapp.common.General;
import com.zm.testapp.databinding.FragmentUsersBinding;
import com.zm.testapp.domain.model.user.UserDetailsDomain;
import com.zm.testapp.domain.model.user.UserDomain;
import com.zm.testapp.presentation.AppActivity;
import com.zm.testapp.presentation.adapter.UserAdapter;
import com.zm.testapp.presentation.adapter.UserItemDecoration;
import com.zm.testapp.presentation.ui.BaseFragment;
import com.zm.testapp.presentation.ui.details.UserDetailsFragment;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class UsersFragment extends BaseFragment<List<UserDomain>> {

    private static final String TAG = UsersFragment.class.getSimpleName();
    private FragmentUsersBinding binding;
    private UsersViewModel viewModel;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(factory, UsersViewModel.class);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(
            @NonNull @NotNull LayoutInflater inflater,
            @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
            @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        ((AppActivity) requireActivity()).updateTitle(getString(R.string.users));
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
        observe(viewModel.liveDataUsers);
        initListeners();
    }

    private void initListeners() {
        binding.textViewReplay.setOnClickListener(view -> {
            viewModel.fetchUsers();
        });
    }

    @Override
    protected void onLoading(boolean isLoading) {
        Timber.tag(TAG).d("loading");
        visibilityProgressBar(true);
    }

    @Override
    protected void onSuccess(List<UserDomain> users) {
        Timber.tag(TAG).d("success");
        visibilityProgressBar(false);
        visibilityTextViewReplay(false);
        initView(users);
    }

    @Override
    protected void onError(@StringRes int stringError) {
        Toast.makeText(requireContext(), getString(stringError), Toast.LENGTH_SHORT).show();
        visibilityProgressBar(false);
        visibilityTextViewReplay(true);
    }

    private void visibilityTextViewReplay(boolean visibility) {
        binding.textViewReplay.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    private void initView(List<UserDomain> users) {
        UserAdapter adapter = new UserAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        UserItemDecoration itemDecoration = new UserItemDecoration(
                General.convertDpToPixel(16)
        );

        binding.recyclerViewUsers.setLayoutManager(layoutManager);
        binding.recyclerViewUsers.setAdapter(adapter);
        binding.recyclerViewUsers.addItemDecoration(itemDecoration);
        adapter.update(users);
        adapter.setUserAdapterListener(this::navigateToUserDetails);
    }

    private void navigateToUserDetails(UserDetailsDomain userDetails) {
        Bundle bundle = new UserDetailsFragment.Arguments().makeArgs(
                userDetails.getPhotoUrl(),
                userDetails.getFullName(),
                userDetails.getAge(),
                userDetails.getEmail(),
                userDetails.getCity(),
                userDetails.getState(),
                userDetails.getCountry()
        );
        findNavController().navigate(R.id.action_users_to_user_details, bundle);
    }
}
