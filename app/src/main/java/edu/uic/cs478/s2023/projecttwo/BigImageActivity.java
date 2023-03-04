package edu.uic.cs478.s2023.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BigImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);


        Intent i = this.getIntent();
        int ndx = i.getIntExtra("carIndex", -1);
        String name = i.getStringExtra("carName");
        setPage(ndx, name);
    }

    private void setPage(int index, String title) {
        if (index == -1) {
            throw new RuntimeException("Tried to set page but got no index...");
        }

        ImageView bigImg = findViewById(R.id.bigImage);
        TextView bigTxt = (TextView) findViewById(R.id.bigText);

        bigImg.setImageResource(Data.imgList[index]);
        bigTxt.setText(title);
        bigImg.setOnClickListener(view -> {
//            Toast.makeText(BigImageActivity.this, "Website for this item is: " + getResources().getString(sites[index]), Toast.LENGTH_SHORT).show();
//            DONE: open site in browser
            Intent browseIntent = new Intent(Intent.ACTION_VIEW);
            browseIntent.setData(Uri.parse(getResources().getString(Data.sites[index])));
            startActivity(browseIntent);
        });
    }
}