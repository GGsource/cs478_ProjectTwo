package edu.uic.cs478.s2023.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.mainGrid);
        ArrayList<CardModel> cardModelArrayList = new ArrayList<>();

//        TODO: Give Custom Titles & Images of cars
        cardModelArrayList.add(new CardModel("Title 1", R.drawable.img_a));
        cardModelArrayList.add(new CardModel("Title 2", R.drawable.img_b));
        cardModelArrayList.add(new CardModel("Title 3", R.drawable.img_c));
        cardModelArrayList.add(new CardModel("Title 4", R.drawable.img_d));
        cardModelArrayList.add(new CardModel("Title 5", R.drawable.img_e));
        cardModelArrayList.add(new CardModel("Title 6", R.drawable.img_f));
        cardModelArrayList.add(new CardModel("Title 7", R.drawable.img_g));
        cardModelArrayList.add(new CardModel("Title 8", R.drawable.img_h));

        GridAdapter adapter = new GridAdapter(this, cardModelArrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
//                TODO: Implement short Click
        });

        gridView.setOnItemLongClickListener((adapterView, view, i, l) -> {
//                TODO: Implement long click
            return false;
        });
    }
}