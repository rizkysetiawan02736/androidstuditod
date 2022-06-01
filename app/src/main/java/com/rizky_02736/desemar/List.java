package com.rizky_02736.desemar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

public class List extends AppCompatActivity {
    RecyclerView mRecycleview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    java.util.List<ModelList> mListItems;

    private final String url ="http://192.168.43.14/Desemar/android/service_data.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecycleview = (RecyclerView) findViewById(R.id.recyclertemp);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItems = new ArrayList<>();

        request();
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycleview.setLayoutManager(mManager);
        mAdapter = new AdapterList(mListItems,List.this);
        mRecycleview.setAdapter(mAdapter);

    }
    private void  request(){
        JsonArrayRequest requestImage = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse",response.toString());
                        for(int i=0; i< response.length();i++){
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelList model = new ModelList();
                                model.setId(data.getString("id"));
                                model.setJobname(data.getString("jobname"));
                                model.setRequirement(data.getString("requirement"));
                                model.setImg(data.getString("img"));

                                mListItems.add(model);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERRORRequest", "Error :"+ error.getMessage());

                    }
                });
        mRequest.add(requestImage);
    }
}