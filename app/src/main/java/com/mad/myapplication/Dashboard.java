package com.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//https://official-joke-api.appspot.com/jokes/programming/random

public class Dashboard extends AppCompatActivity {


    RequestQueue queue;
    String baseUrl= "https://official-joke-api.appspot.com/jokes/";
    String tag="general/random";//so called flag variable :D
    TextView txtJokes,txtId,txtType,txtSetup,txtPunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main = new Intent(Dashboard.this, MainActivity.class);
                startActivity(Main);

            }
        });
        queue=Volley.newRequestQueue(this);
        txtJokes=findViewById(R.id.txtJokes);
        txtId=findViewById(R.id.txtID);
        txtType=findViewById(R.id.txtType);
        txtSetup=findViewById(R.id.txtSetup);
        txtPunch=findViewById(R.id.txtPunch);


    }
//handles genral jokes
    public void getGenJoke(View view) {
        String fullUrl=baseUrl+tag;

        fetchJoke(fullUrl);

    }

    public void getProJoke(View view) {
        String fullUrl=baseUrl+"programming/random";
        fetchJoke(fullUrl);

    }

    public void fetchJoke(String url){


        RequestQueue queue = Volley.newRequestQueue(this);
       // String url = "https://official-joke-api.appspot.com/jokes/ten";


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        int ID=0;
                        String type,setup,punch;

                        try{

                            for(int i=0;i<response.length();i++){

                                JSONObject res = response.getJSONObject(i);
/*
                                jokes[i]=new Joke(res.getString("id"),res.getString("type"),
                                        res.getString("setup"),res.getString("punchline"));
                                // Log.d("JD",joke.toString());
*/
                                ID=res.getInt("id");
                                type=res.getString("type");
                                setup=res.getString("setup");
                                punch=res.getString("punchline");
                                Joke joke=new Joke(ID,type,setup,punch);
                                txtId.setText(joke.getID()+"");
                                txtId.setVisibility(View.VISIBLE);
                                txtType.setText(joke.getType()+"");
                                txtType.setVisibility(View.VISIBLE);
                                txtSetup.setText(joke.getSetuo()+"");
                                txtSetup.setVisibility(View.VISIBLE);
                                txtPunch.setText(joke.getPunchLine()+"");
                                txtPunch.setVisibility(View.VISIBLE);

                                txtJokes.setText("response:"+ID);

                                break;

                            }



                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){


                    }
                }
        );




        queue.add(jsonArrayRequest);


//bad code down

        /*
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                int ID=0;
                String type,setup,punch;
                try {
                    ID=response.getInt("id");
                    type=response.getString("type");
                    setup=response.getString("setup");
                    punch=response.getString("punchline");
                    Joke joke=new Joke(ID,type,setup,punch);
                    txtId.setText(joke.getID()+"");
                    txtId.setVisibility(View.VISIBLE);
                    txtType.setText(joke.getType()+"");
                    txtType.setVisibility(View.VISIBLE);
                    txtSetup.setText(joke.getSetuo()+"");
                    txtSetup.setVisibility(View.VISIBLE);
                    txtPunch.setText(joke.getPunchLine()+"");
                    txtPunch.setVisibility(View.VISIBLE);


                } catch (JSONException e){
                    e.printStackTrace();
                }
                txtJokes.setText("response:"+ID);

            }


        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error){
                String err=error.toString();
               // txtJokes.setText("Cannot Get Data:"+error.toString());

                Log.d("TT",err);
            }
        });
        queue.add(jsonObjectRequest);
*/

    }

    public void fetchJokebad(String url){


        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                int ID=0;
                String type,setup,punch;
                try {
                    ID=response.getInt("id");
                    type=response.getString("type");
                    setup=response.getString("setup");
                    punch=response.getString("punchline");
                    Joke joke=new Joke(ID,type,setup,punch);
                    txtId.setText(joke.getID()+"");
                    txtId.setVisibility(View.VISIBLE);
                    txtType.setText(joke.getType()+"");
                    txtType.setVisibility(View.VISIBLE);
                    txtSetup.setText(joke.getSetuo()+"");
                    txtSetup.setVisibility(View.VISIBLE);
                    txtPunch.setText(joke.getPunchLine()+"");
                    txtPunch.setVisibility(View.VISIBLE);


                } catch (JSONException e){
                    e.printStackTrace();
                }
                txtJokes.setText("response:"+ID);

            }


        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error){
                String err=error.toString();
                // txtJokes.setText("Cannot Get Data:"+error.toString());

                Log.d("TT",err);
            }
        });
        queue.add(jsonObjectRequest);


    }
}