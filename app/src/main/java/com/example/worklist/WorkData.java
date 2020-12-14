package com.example.worklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    EditText w_tittle,w_descr,w_date,radioData;
    RadioGroup w_priority;
    RadioButton selectedRadioButton;
    Button btn_create;
    private ProgressBar loading;
    private static String URL_REGIST = "http://192.168.43.126/work/record.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_data);

        listData = findViewById(R.id.listData);
        w_tittle = findViewById(R.id.w_tittle);
        w_descr = findViewById(R.id.w_descr);
        w_date = findViewById(R.id.w_date);
        w_priority = findViewById(R.id.w_priority);
        radioData = findViewById(R.id.radioData);
        btn_create = findViewById(R.id.btn_create);
        loading = findViewById(R.id.loading);

        // send data
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedRadioButtonId = w_priority.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedRbText = selectedRadioButton.getText().toString();
                    radioData.setText(selectedRbText);
                }

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

        final String w_tittle = this.w_tittle.getText().toString().trim();
        final String w_descr = this.w_descr.getText().toString().trim();
        final String w_date = this.w_date.getText().toString().trim();
        final String w_priority = this.radioData.getText().toString().trim();


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
                            Toast.makeText(WorkData.this, "Work Recorded Successfully " , Toast.LENGTH_SHORT).show();
                            btn_create.setVisibility(View.VISIBLE);
                            loading.setVisibility(View.GONE);

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
                params.put("w_tittle", w_tittle );
                params.put("w_descr", w_descr );
                params.put("w_date", w_date );
                params.put("w_priority", w_priority );
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}