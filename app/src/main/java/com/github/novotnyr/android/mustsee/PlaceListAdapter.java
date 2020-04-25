package com.github.novotnyr.android.mustsee;

import android.view.ViewGroup;

import java.util.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.ListAdapter;

public class PlaceListAdapter extends ListAdapter<Place, PlaceViewHolder> {
    private SelectionTracker<Long> selectionTracker;

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
        boolean isSelected = selectionTracker.isSelected(place.getId());
        viewHolder.bind(place, isSelected);
    }

    @Override
    public long getItemId(int position) {
        Place place = getItem(position);
        return place.getId();
    }

    public void removePlaces(Iterator<Long> identifiers) {
        List<Place> reducedList = new ArrayList<>(getCurrentList());

        while (identifiers.hasNext()) {
            Long id = identifiers.next();
            Iterator<Place> reducedListIterator = reducedList.iterator();
            while (reducedListIterator.hasNext()) {
                Place place = reducedListIterator.next();
                if (Objects.equals(place.getId(), id)) {
                    reducedListIterator.remove();
                }
            }
        }
        submitList(reducedList);
    }

    public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }
}
