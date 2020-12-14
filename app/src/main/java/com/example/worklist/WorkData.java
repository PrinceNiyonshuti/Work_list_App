package com.example.worklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WorkData extends AppCompatActivity {

    ImageView listData;

    EditText w_tittle,w_descr,w_date;
    Button btn_create;
    private ProgressBar loading;
    private static String URL_REGIST = "http://127.0.0.1/work/record.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_data);

        listData = findViewById(R.id.listData);
        w_tittle = findViewById(R.id.w_tittle);
        w_descr = findViewById(R.id.w_descr);
        w_date = findViewById(R.id.w_date);
        btn_create = findViewById(R.id.btn_create);
        loading = findViewById(R.id.loading);

        // send data
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Regist();
            }
        });

        listData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_go = new Intent(WorkData.this, MainActivity.class);
                startActivity(register_go);
            }
        });
    }

    private void Regist(){
        btn_create.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);

        final String tittle = this.w_tittle.getText().toString().trim();
        final String descr = this.w_descr.getText().toString().trim();


        StringRequest stringRequest =  new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")){
                                loading.setVisibility(View.GONE);
                                Toast.makeText(WorkData.this, " Record Done Successfully ", Toast.LENGTH_SHORT).show();

                            }else if (success.equals("0")){
                                loading.setVisibility(View.GONE);
                                Toast.makeText(WorkData.this, " Recording Went Wrong ", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(WorkData.this, "Record Not Done Error " , Toast.LENGTH_SHORT).show();
                            btn_create.setVisibility(View.VISIBLE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(WorkData.this, " Something Went Wrong ", Toast.LENGTH_SHORT).show();
                        btn_create.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("tittle", tittle );
                params.put("descr", descr );
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}