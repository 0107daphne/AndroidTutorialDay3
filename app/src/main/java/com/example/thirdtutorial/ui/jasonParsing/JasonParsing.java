package com.example.thirdtutorial.ui.jasonParsing;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.thirdtutorial.R;

public class JasonParsing extends Fragment {
    private JasonParsingViewModel userListViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the ViewModel
        userListViewModel = new ViewModelProvider(this).get(JasonParsingViewModel.class);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Fetch the data when the fragment is created
        userListViewModel.loadUserList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jason_parsing, container, false);

        // Get the ListView
        ListView listView = rootView.findViewById(android.R.id.list);

        // Set the adapter when the data is available
        userListViewModel.getUserList().observe(getViewLifecycleOwner(), userList -> {
            ListAdapter adapter = new SimpleAdapter(requireContext(), userList, R.layout.fragment_parsing,
                    new String[]{"name", "designation", "location"},
                    new int[]{R.id.name, R.id.designation, R.id.location});
            listView.setAdapter(adapter);
        });

        return rootView;
    }

}