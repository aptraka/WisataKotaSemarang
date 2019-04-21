package com.aditya.wisatasemarang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView detail;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final String maps = getIntent().getStringExtra("MAPS");
        detail=findViewById(R.id.tvDetail);
        gambar=findViewById(R.id.ivGambar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(maps));
                startActivity(intent);
            }
        });

        String nama = getIntent().getStringExtra("NAMA");
        String deskripsi=getIntent().getStringExtra("DETAIL");
        String image=getIntent().getStringExtra("GAMBAR");

        detail.setText(deskripsi);
        Glide.with(DetailActivity.this).load(image).into(gambar);
        getSupportActionBar().setTitle(nama);
    }
}
