package com.example.volleystarter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView titleTextView;
    ImageView posterImageView;
    TextView plotTextView;
    EditText searchBar;
    String posterUrl;
    TextView episodesTextView;
    TextView scoreTextView;
    int x = 0;
    //TextView moreOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plotTextView = findViewById(R.id.plot_tv);
        searchBar = findViewById(R.id.search_bar);
        titleTextView = findViewById(R.id.title);
        posterImageView = findViewById(R.id.poster);
        episodesTextView = findViewById(R.id.episodes);
        scoreTextView = findViewById(R.id.score);
    }

    public void fetchData(View view) {
        // Instantiate the RequestQueue.
        x = 0;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.jikan.moe/v3/search/anime?q=" + searchBar.getText().toString();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject responseObject = new JSONObject(response);
                            JSONArray resultsArray = responseObject.getJSONArray("results");
                            JSONObject resultObj = resultsArray.getJSONObject(x);


                            String titleText = resultObj.getString("title");
                            titleTextView.setText(titleText);

                            String plotText = resultObj.getString("synopsis");
                            plotTextView.setText("Plot: " + plotText);

                            String epText = resultObj.getString("episodes");
                            episodesTextView.setText("Episodes: " + epText);

                            String scoreText = resultObj.getString("score");
                            scoreTextView.setText("Score: " + scoreText);


                            posterUrl = resultObj.getString("image_url");
                            Picasso.get().load(posterUrl).into(posterImageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                plotTextView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void next(View view){
       x++;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.jikan.moe/v3/search/anime?q=" + searchBar.getText().toString();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject responseObject = new JSONObject(response);
                            JSONArray resultsArray = responseObject.getJSONArray("results");
                            JSONObject resultObj = resultsArray.getJSONObject(x);


                            String titleText = resultObj.getString("title");
                            titleTextView.setText(titleText);

                            String plotText = resultObj.getString("synopsis");
                            plotTextView.setText("Plot: " + plotText);

                            String epText = resultObj.getString("episodes");
                            episodesTextView.setText("Episodes: " + epText);

                            String scoreText = resultObj.getString("score");
                            scoreTextView.setText("Score: " + scoreText);


                            posterUrl = resultObj.getString("image_url");
                            Picasso.get().load(posterUrl).into(posterImageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                plotTextView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    public void previous(View view){
        x = x-1;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.jikan.moe/v3/search/anime?q=" + searchBar.getText().toString();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject responseObject = new JSONObject(response);
                            JSONArray resultsArray = responseObject.getJSONArray("results");
                            JSONObject resultObj = resultsArray.getJSONObject(x);


                            String titleText = resultObj.getString("title");
                            titleTextView.setText(titleText);

                            String plotText = resultObj.getString("synopsis");
                            plotTextView.setText("Plot: " + plotText);

                            String epText = resultObj.getString("episodes");
                            episodesTextView.setText("Episodes: " + epText);

                            String scoreText = resultObj.getString("score");
                            scoreTextView.setText("Score: " + scoreText);


                            posterUrl = resultObj.getString("image_url");
                            Picasso.get().load(posterUrl).into(posterImageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                plotTextView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    }

