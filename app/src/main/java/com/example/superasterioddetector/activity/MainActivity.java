package com.example.superasterioddetector.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.superasterioddetector.R;
import com.example.superasterioddetector.activity.HomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.buttonBegin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchActivities();
            }
        });

    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, HomeActivity.class);
        startActivity(switchActivityIntent);
    }
/*
    private void openActivity() {
        setContentView(R.layout.home);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2023-03-08&end_date=2023-03-15&api_key=" + api_key;
        ArrayList<String> names = new ArrayList<String>();
        List<String> id = new ArrayList<>();
        List<String> distances = new ArrayList<String>();
        List<Double> magnitudes = new ArrayList<>();
        List<String> orbitalPeriod = new ArrayList<String>();
        List<Asteroids> asteroid = new ArrayList();
        final String[] count = {""};

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(String response){
                        Toast.makeText(getApplicationContext(), "Received data", Toast.LENGTH_SHORT).show();
                        System.out.println("ceci est la reponse = " + response);



                        try {
                            JSONObject jsonNasa = new JSONObject(response);
                            JSONObject str = jsonNasa.getJSONObject("near_earth_objects");
                            System.out.println(jsonNasa.getString("element_count"));
                            count[0] = jsonNasa.getString("element_count");
                            str.names();
                            Iterator<String> keys = str.keys();
                            while(keys.hasNext()){
                                JSONArray array = str.getJSONArray(keys.next());
                                for(int i = 0; i< array.length(); i++){
                                    JSONObject obj = (JSONObject) array.get(i);
                                    names.add((String) obj.get("name"));
                                    JSONArray dist = (JSONArray) obj.get("close_approach_data");
                                    JSONObject dist_o = (JSONObject) dist.get(0);
                                    JSONObject dist_object = (JSONObject) dist_o.get("miss_distance");
                                    distances.add((String) dist_object.get("kilometers"));
                                    magnitudes.add((Double) obj.get("absolute_magnitude_h"));
                                    id.add((String) obj.get("id"));
                                    asteroid.add(new Asteroids((String) obj.get("id"), (String) obj.get("name"),
                                            (String) dist_object.get("kilometers"), (Double) obj.get("absolute_magnitude_h")));
                                }
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                        ListView listView = findViewById(R.id.ListView1);
                        ArrayAdapter<Asteroids> adapter = new ArrayAdapter<Asteroids>(getApplicationContext(), android.R.layout.simple_list_item_1, asteroid);
                        listView.setAdapter(adapter);
                        //adapter.notifyDataSetChanged();
                        TextView textView = (TextView) findViewById(R.id.textView1);
                        textView.setText("Nombre d'astériodes : "+ count[0]);

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(getApplicationContext(), "Error no response", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        //Toast.makeText(getApplicationContext(), "Received data from " + url, Toast.LENGTH_SHORT).show();
        //System.out.println("reponse recue = " + stringRequest);
        queue.add(stringRequest);


        Button button2 = (Button) findViewById(R.id.buttonLink1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.test_layout);

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.LinearLayout);
                CustomAdapter1 adapter1 = new CustomAdapter1(getApplicationContext(), asteroid);
                for (int i = 0; i < adapter1.getCount(); i++) {
                    System.out.println(i);
                    View view1 = adapter1.getView(i, null, linearLayout);
                    linearLayout.addView(view1);
                }

                //startActivity(i);
            }
        });


    }*/


}
