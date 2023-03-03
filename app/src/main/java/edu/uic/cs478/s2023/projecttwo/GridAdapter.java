package edu.uic.cs478.s2023.projecttwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<CardModel> {
    public GridAdapter(@NonNull Context ctx, ArrayList<CardModel> cardModelArrayList) {
        super(ctx, 0, cardModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        CardModel cardModel = getItem(position);
        TextView tv = listItemView.findViewById(R.id.txtView);
        ImageView iv = listItemView.findViewById(R.id.imgView);

        tv.setText(cardModel.getTitle());
        iv.setImageResource(cardModel.getImageIndex());


        return listItemView;
    }
}
