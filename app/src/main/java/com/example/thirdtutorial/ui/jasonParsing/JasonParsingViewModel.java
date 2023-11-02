package com.example.thirdtutorial.ui.jasonParsing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JasonParsingViewModel extends ViewModel {
    private MutableLiveData<List<HashMap<String, String>>> userListLiveData = new MutableLiveData<>();

    public LiveData<List<HashMap<String, String>>> getUserList() {
        return userListLiveData;
    }

    public void loadUserList() {
        try {
            // Initialize the JSON object and extract the information
            JSONObject jObj = new JSONObject(listData);
            JSONArray jsonArry = jObj.getJSONArray("users");

            List<HashMap<String, String>> userList = new ArrayList<>();

            for (int i = 0; i < jsonArry.length(); i++) {
                HashMap<String, String> user = new HashMap<>();
                JSONObject obj = jsonArry.getJSONObject(i);
                user.put("name", obj.getString("name"));
                user.put("designation", obj.getString("designation"));
                user.put("location", obj.getString("location"));
                userList.add(user);
            }

            userListLiveData.setValue(userList);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    // JSON data in the form of a string
    private static final String listData = "{\"users\":[{\"name\":\"Ace\",\"designation\":\"Engineer\",\"location\":\"New York\"},{\"name\":\"Tom\",\"designation\":\"Director\",\"location\":\"Chicago\"},{\"name\":\"Tim\",\"designation\":\"Charted Accountant\",\"location\":\"Sunnyvale\"}]}";
}