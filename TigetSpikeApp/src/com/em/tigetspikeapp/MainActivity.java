package com.em.tigetspikeapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.em.tigetspike.model.Casestudies;
import com.em.tigetspike.model.TigerResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.renderscript.Type;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button load, delete;
	ProgressDialog progressDialog;
	String urlJsurlonObj = "http://api.myjson.com/bins/2ukm9";
	private Context context;
	private ListAdapter adapter;
	ListView list;

	JSONArray casestudies = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		load = (Button) findViewById(R.id.bt1);
		load.setOnClickListener(this);
		delete = (Button) findViewById(R.id.bt2);
		delete.setOnClickListener(this);
		context = this;
		list = (ListView) findViewById(R.id.listView1);
//		adapter = new ListAdapter(this, MyApplication.result);
//		list.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.bt1:
			// to do
			loadImageFromWeb();
			break;

		case R.id.bt2:
			// to do

			break;

		}
	}

	private void loadImageFromWeb() {
		// TODO Auto-generated method stub
		JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
				urlJsurlonObj, null, new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						// Casestudies cas = null ;
						Gson gson = new Gson();
						TigerResult results = gson.fromJson(response.toString(),
								TigerResult.class);
						
						
						/*
						 * 	Type listType = new TypeToken<List<Post>>(){}.getType();
							List<Post> posts = (List<Post>) gson.fromJson(jsonOutput, listType);
						 */
						
						
						MyApplication.result = results;
						adapter = new ListAdapter(MainActivity.this, MyApplication.result);
						list.setAdapter(adapter);
					
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "Errors occur",
								Toast.LENGTH_LONG).show();

					}
				});

		// Adding request to request queue
		MyApplication.getInstance(this).addToRequestQueue(jsonObjReq);
		// queue.add(jsonObjReq);
	}
}
