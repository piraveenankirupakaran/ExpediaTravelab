package com.example.travelabapp;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
    private TextView textView;

    private Button returnDate;
    private Button departDate;
    private TextView returnDate1;
    private TextView departDate1;
    private String storeDate1;
    private String storeDate2;
    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        editTextFlightFrom = (EditText) findViewById(R.id.editTextFlightFrom);
        editTextFlightTo = (EditText) findViewById(R.id.editTextFlightTo);
        editTextDepartDate = (EditText) findViewById(R.id.editTextDepartDate);
        editTextReturnDate = (EditText) findViewById(R.id.editTextReturnDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        textView = (TextView) findViewById(R.id.text);

        buttonSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == buttonSearch) {
            //TODO - Must change params to right format e.g. london_gb and 16/11/2019
//            String apiUrl = "https://api.skypicker.com/flights?fly_from="+editTextFlightFrom+"&fly_to="+editTextFlightTo+"&date_from="+editTextDepartDate+"&date_to="+editTextReturnDate+"&partner=picky&vehicle_type=aircraft";
            String apiUrl = "https://api.skypicker.com/flights?flyFrom=PRG&to=LGW&dateFrom=17/11/2019&dateTo=18/11/2019&partner=picky";
            RequestQueue queue = Volley.newRequestQueue(this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, apiUrl, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            ArrayList<String> flightNumbers = new ArrayList<>();
                            ArrayList<String> prices = new ArrayList<>();
                            try {
                                JSONArray data = response.getJSONArray("data");
                                textView.setText("Response: " + data.toString());
//                                JSONObject dataFirst = data.getJSONObject(0);

//                                textView.setText("Response: " + data2.toString());

                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject userDetail = data.getJSONObject(i);
                                    flightNumbers.add(userDetail.getString("flight_no"));
                                    prices.add(userDetail.getString("price"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            textView.setText("Response: " + response.toString().substring(0, 500));
//                            textView.setText("Response: " + flightNumbers.size());


                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error
                            textView.setText("That didn't work!" + error);
                        }
                    });

// Access the RequestQueue through your singleton class.
            queue.add(jsonObjectRequest);


        departDate = (Button) findViewById(R.id.departDate);
        returnDate = (Button) findViewById(R.id.returnDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        //textView = (TextView) findViewById(R.id.departDate1);
        departDate1 = (TextView) findViewById(R.id.departDate1);
        returnDate1 = (TextView) findViewById(R.id.returnDate1);


        buttonSearch.setOnClickListener(this);
        returnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(TravelActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                        storeDate1 = mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear;
                        returnDate1.setText("Depart Date: " + storeDate1);
                    }
                }, day, month, year);
                dpd.show();

            }
        });

        departDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(TravelActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                        storeDate2 = mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear;
                        departDate1.setText("Depart Date: " + storeDate2);
                    }
                }, day, month, year);
                dpd.show();

            }
        });

    }

