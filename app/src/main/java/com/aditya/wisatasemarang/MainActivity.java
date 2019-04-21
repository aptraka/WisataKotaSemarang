package com.aditya.wisatasemarang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aditya.wisatasemarang.models.WisataModel;
import com.aditya.wisatasemarang.models.WisataResponse;
import com.aditya.wisatasemarang.retrofit.ApiConfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<WisataModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        getData();
    }

    private void getData() {
        Call<WisataResponse> call = ApiConfig.getApiService().ambilData();
        call.enqueue(new Callback<WisataResponse>() {
            @Override
            public void onResponse(Call<WisataResponse> call, Response<WisataResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("1")) {
                        list = response.body().getData();
                        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MainActivity.this, list);
                        recyclerView.setAdapter(recyclerAdapter);
                    } else {
                        Toast.makeText(MainActivity.this, "Gagal Dimuat " + response.body(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Data Filure " + response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WisataResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Response Failure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
