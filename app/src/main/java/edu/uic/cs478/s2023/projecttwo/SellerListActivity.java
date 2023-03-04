package edu.uic.cs478.s2023.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class SellerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_list);

        int ndx = getIntent().getIntExtra("carIndex", -1);
        ListView lV = (ListView) findViewById(R.id.sellerListView);
        ArrayList<String> listItemArrayList = new ArrayList<>(Arrays.asList(Data.sellers[ndx]));
        listItemArrayList.add(0, "Sellers in the Greater Chicago Area:");
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(SellerListActivity.this, android.R.layout.simple_list_item_1, listItemArrayList);
        lV.setAdapter(itemAdapter);
    }
}