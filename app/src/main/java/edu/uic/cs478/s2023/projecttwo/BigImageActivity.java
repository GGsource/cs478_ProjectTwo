package edu.uic.cs478.s2023.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class BigImageActivity extends AppCompatActivity {

    String[] imgList = {"img_a","img_b",
                        "img_c","img_d",
                        "img_e","img_f",
                        "img_g","img_h"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);


        Intent i = this.getIntent();
        int ndx = i.getIntExtra("carIndex", -1);
    }
}