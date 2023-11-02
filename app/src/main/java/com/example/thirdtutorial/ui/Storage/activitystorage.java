package com.example.thirdtutorial.ui.Storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.thirdtutorial.R;

public class activitystorage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_storage);

            if (savedInstanceState == null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_storage, new storage())
                        .commit();
            }
        }
    }






