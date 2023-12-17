package gr.york.md.network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import gr.york.md.R;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });
    }

    private void makeRequest() {

        RequestQueue queue = Volley.newRequestQueue(this);

        String endpoint = "https://dog.ceo/api/breeds/image/random";
        StringRequest request = new StringRequest(Request.Method.GET, endpoint, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("NETWORK", response);

                JsonResponse json = new Gson().fromJson(response, JsonResponse.class);

                TextView textView = findViewById(R.id.text);
                textView.setText(json.toString());
                Log.d("NETWORK", json.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NETWORK", error.getMessage(), error);
            }
        });

        queue.add(request);
    }
}