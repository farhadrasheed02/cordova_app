package com.example.simplified;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private static final String url = "https://www.internetfaqs.net/superheroes.php";
        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private static ArrayList<list_item> listItem ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
       listItem = new ArrayList<>();
       loadRecyclerViewData();
       /*
       listItem.add(new list_item("header1","description"));
        listItem.add(new list_item("header2","description"));
        listItem.add(new list_item("header3","description"));
        listItem.add(new list_item("header4","description"));
        listItem.add(new list_item("header5","description"));
        listItem.add(new list_item("header6","description"));
        listItem.add(new list_item("header7","description"));
       MyAdapter addinadapter = new MyAdapter(this,listItem);
       */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
       // recyclerView.setAdapter(addinadapter);


    }

    private void loadRecyclerViewData() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data ...");
        progressDialog.show();
        // Fetch data from the server
        RequestQueue mqueue = Volley.newRequestQueue(this);
        String url = "https://reqres.in/api/users?page=2";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject data = jsonArray.getJSONObject(i);

                         firstname = data.getJSONObject("first_name");
                        //String firstname = data.getString("first_name");
                        // int id = data.getInt("id");
                        //String lastname = data.getString("last_name");
                        //String email = data.getString("email");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}