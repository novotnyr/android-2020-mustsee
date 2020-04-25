package com.github.novotnyr.android.mustsee;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

public class PlaceListAdapter extends ListAdapter<Place, PlaceViewHolder> {
    public PlaceListAdapter() {
        super(new PlaceDiff());
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaceViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder viewHolder, int position) {
        Place place = getItem(position);
        viewHolder.bind(place, false);
    }

    @Override
    public long getItemId(int position) {
        Place place = getItem(position);
        return place.getId();
    }
}
