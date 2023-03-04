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

    int[] imgList = {R.drawable.kona_n_hd, R.drawable.charger_hd,
                    R.drawable.mg5_hd, R.drawable.spectre_hd,
                    R.drawable.civic_type_r_hd, R.drawable.sierra_hd,
                    R.drawable.mustang_hd,R.drawable.porsche_hd,};
    int[] sites = {R.string.site_0, R.string.site_1, R.string.site_2
                ,R.string.site_3, R.string.site_4, R.string.site_5
                ,R.string.site_6,R.string.site_7,R.string.site_8};

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

        bigImg.setImageResource(imgList[index]);
        bigTxt.setText(title);
        bigImg.setOnClickListener(view -> {
            Toast.makeText(BigImageActivity.this, "Website for this item is: " + getResources().getString(sites[index]), Toast.LENGTH_SHORT).show();
//            DONE: open site in browser
            Intent browseIntent = new Intent(Intent.ACTION_VIEW);
            browseIntent.setData(Uri.parse(getResources().getString(sites[index])));
            startActivity(browseIntent);
        });
    }
}