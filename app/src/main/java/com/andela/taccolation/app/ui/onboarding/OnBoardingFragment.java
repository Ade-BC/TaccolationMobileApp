package com.andela.taccolation.app.ui.onboarding;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.andela.taccolation.R;
import com.andela.taccolation.app.utils.Constants;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OnBoardingFragment extends Fragment {

    private static final String TAG = Constants.LOG.getConstant();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: OnBoarding FRAGMENT CALLED");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        closeAppOnBackPressed();
        Log.d(TAG, "onCreateView: OnBoarding FRAGMENT");
        // checks if its first time app was ran, navigates to onBoarding page
        // its weird. onCreateView gets called but not onCreate when popBackStack is invoked by LoginFragment
        boolean isFirstRun = requireActivity().getPreferences(Context.MODE_PRIVATE).getBoolean(Constants.FIRST_RUN.getConstant(), true);
        if (!isFirstRun) {
            if (NavHostFragment.findNavController(this).getCurrentDestination().getId() == R.id.OnBoardingFragment)
                NavHostFragment.findNavController(this).navigate(R.id.action_OnBoardingFragment_to_workerFragment);
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.launch_auth_screen).setOnClickListener(view1 -> {
            SharedPreferences.Editor editor = requireActivity().getPreferences(Context.MODE_PRIVATE).edit();
            editor.putBoolean(Constants.FIRST_RUN.getConstant(), false);
            editor.apply();
            if (NavHostFragment.findNavController(this).getCurrentDestination().getId() == R.id.OnBoardingFragment)
                NavHostFragment.findNavController(this).navigate(R.id.action_OnBoardingFragment_to_workerFragment);
        });
    }

    private void closeAppOnBackPressed() {
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
    }

}