package com.example.thirdtutorial.ui.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.thirdtutorial.R;

public class storage extends Fragment {
    private EditText name, age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.storage, container, false);

        name = rootView.findViewById(R.id.edit1);
        age = rootView.findViewById(R.id.edit2);

        return rootView;
    }

    // Fetch the stored data in onResume()
    @Override
    public void onResume() {
        super.onResume();

        // Fetching the stored data from the SharedPreferences
        SharedPreferences sh = requireActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);

        // Setting the fetched data in the EditTexts
        name.setText(s1);
        age.setText(String.valueOf(a));
    }

    @Override
    public void onPause() {
        super.onPause();

        // Saving data to SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.apply();
    }
}
