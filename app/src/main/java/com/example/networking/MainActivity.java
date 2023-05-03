package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";

    private ArrayList<RecyclerViewItem> mountain;
    private adapter adapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);

    }


    @Override
    public void onPostExecute(String json) {
       Gson gson = new Gson();

       String json = gson.toJson(mountain);


       Type hamed = new TypeToken<ArrayList<RecyclerViewItem>>(){}.getType();

       ArrayList<RecyclerViewItem> data  = gson.fromJson(json, hamed);
       mountain.addAll(data);
    }

}
