package edu.uic.cs478.s2023.projecttwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

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
        registerForContextMenu(gridView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.long_click_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View clickedView = gridView.getChildAt(info.position);
            switch(item.getItemId()) {
            case R.id.showCarItem:
//                TextView tv = (TextView) clickedView.findViewById(R.id.txtView);
//                Toast.makeText(MainActivity.this, "You clicked: " + tv.getText().toString(), Toast.LENGTH_LONG).show();
                gridView.performItemClick(clickedView, info.position, clickedView.getId());
                break;

            case R.id.showSiteItem:
                Intent browseIntent = new Intent(Intent.ACTION_VIEW);
                browseIntent.setData(Uri.parse(getResources().getString(Data.sites[info.position])));
                startActivity(browseIntent);
                break;
            case R.id.showSellerItem:
                Intent listIntent = new Intent(MainActivity.this, SellerListActivity.class);
                listIntent.putExtra("carIndex", info.position);
                startActivity(listIntent);
                break;
        }

        return super.onContextItemSelected(item);
    }
}