package com.example.application.mytask2;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    String sname[]  ;
    String sdescription[];
    String sfullname[];
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myListView);
        ListAdapter adapter = new ListAdapter(this,sname,sdescription,sfullname);
        listView.setAdapter(adapter);
        textView= findViewById(R.id.textline1);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/users/square/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<post> call = apiInterface.getpost();
        call.enqueue(new Callback<post>() {
            @Override
            public void onResponse(Call<post> call, Response<post> response) {

            }

            @Override
            public void onFailure(Call<post> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}