package edu.uic.cs478.s2023.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.mainGrid);
        ArrayList<CardModel> cardModelArrayList = new ArrayList<>();

//        DONE: Give Custom Titles & Images of cars
        cardModelArrayList.add(new CardModel("Hyundai Kona N.", R.drawable.kona_n));
        cardModelArrayList.add(new CardModel("Dodge Charger", R.drawable.charger));
        cardModelArrayList.add(new CardModel("Saic MG5", R.drawable.mg5));
        cardModelArrayList.add(new CardModel("Rolls-Royce Spectre", R.drawable.spectre));
        cardModelArrayList.add(new CardModel("Civic Type R", R.drawable.civic_type_r));
        cardModelArrayList.add(new CardModel("GMC Sierra HD Denali", R.drawable.sierra));
        cardModelArrayList.add(new CardModel("Ford Mustang", R.drawable.mustang));
        cardModelArrayList.add(new CardModel("Volkswagen Porsche", R.drawable.porsche));

        GridAdapter adapter = new GridAdapter(this, cardModelArrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
//                DONE: Implement short Click
            TextView tv = (TextView) view.findViewById(R.id.txtView);
            Intent bigIntent = new Intent(MainActivity.this, BigImageActivity.class);
            bigIntent.putExtra("carIndex", i);
            bigIntent.putExtra("carName", tv.getText().toString());
            startActivity(bigIntent);

            Log.d("ClickedGridItem", "text: "+tv.getText().toString() + " i: " + i + " l: " + l  );
        });

        gridView.setOnItemLongClickListener((adapterView, view, i, l) -> {
//                TODO: Implement long click
            return false;
        });
    }
}