package com.example.myapplication.ui.llistat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.myapplication.R;

public class DetallFragment extends Fragment {

    private DetallViewModel detallViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        detallViewModel =
                ViewModelProviders.of(this).get(DetallViewModel.class);
        View root = inflater.inflate(R.layout.fragment_asistir, container, false);
        return root;
    }
}