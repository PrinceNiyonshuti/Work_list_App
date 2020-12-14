package com.example.worklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WorkSorted extends AppCompatActivity {

    ImageView go_back,orderWork;
    RecyclerView recyclerView;
    List<Song> songs;
    private static String JSON_URL = "http://192.168.43.126/work/order_work_list.php";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_sorted);

        recyclerView = findViewById(R.id.songsList);
        go_back = findViewById(R.id.go_back);
        orderWork = findViewById(R.id.orderWork);
        songs = new ArrayList<>();
        extractSongs();

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_go = new Intent(WorkSorted.this, WorkData.class);
                startActivity(register_go);
            }
        });

        orderWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_go = new Intent(WorkSorted.this, MainActivity.class);
                startActivity(register_go);
            }
        });

    }

    private void extractSongs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i <= response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);

                        Song song = new Song();
                        song.setTitle(songObject.getString("tittle").toString());
                        song.setArtists(songObject.getString("priority").toString());
                        song.setCoverImage(songObject.getString("work_image"));
                        songs.add(song);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(),songs);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","OnErrorResponse : " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
    }
}