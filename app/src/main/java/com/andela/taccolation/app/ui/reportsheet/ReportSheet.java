package com.andela.taccolation.app.ui.reportsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.andela.taccolation.R;
import com.andela.taccolation.databinding.FragmentReportSheetBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReportSheet extends Fragment {

    private FragmentReportSheetBinding mBinding;

    public ReportSheet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentReportSheetBinding.inflate(inflater);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToolbar();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private void setupToolbar() {
        final Toolbar toolbar = mBinding.reportSheetToolbar;
        toolbar.setNavigationOnClickListener(v -> NavHostFragment.findNavController(this).popBackStack(R.id.dashboardFragment, false));
    }
}