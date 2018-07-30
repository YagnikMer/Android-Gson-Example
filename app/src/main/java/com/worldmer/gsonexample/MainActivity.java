package com.worldmer.gsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lsalphabets);
        String jsonResponse= jsonToString();
        AlphabetResponse response = new Gson().fromJson(jsonResponse,AlphabetResponse.class);
        createAlphabetsList(response.alphabets);
    }
    public String jsonToString() {
        try {
            InputStream inputStream =getResources().openRawResource(R.raw.alphabets);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }
    public void createAlphabetsList(List<AlphabetResponse.Alphabets> list) {
        String[] alphaArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            alphaArr[i] = list.get(i).name;
        }
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alphaArr));
    }
}
