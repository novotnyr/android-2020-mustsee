package com.github.novotnyr.android.mustsee;

import android.content.Context;
import android.view.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceViewHolder extends RecyclerView.ViewHolder {
    public PlaceViewHolder(ViewGroup recyclerView) {
        super(LayoutInflater.from(recyclerView.getContext())
                .inflate(android.R.layout.simple_list_item_activated_1, recyclerView, false));
    }

    public void bind(Place place, boolean isSelected) {
        TextView textView = (TextView) itemView;
        textView.setText(place.getDescription());
        textView.setActivated(isSelected);
    }
}
