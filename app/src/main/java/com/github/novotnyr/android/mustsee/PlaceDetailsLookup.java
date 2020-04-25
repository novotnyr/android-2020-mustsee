package com.github.novotnyr.android.mustsee;

import android.view.*;

import androidx.annotation.*;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceDetailsLookup extends ItemDetailsLookup<Long> {
    private final RecyclerView recyclerView;

    public PlaceDetailsLookup(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent event) {
        final View view = recyclerView.findChildViewUnder(event.getX(), event.getY());
        if (view == null) {
            return null;
        }
        RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
        return new SimpleItemDetails(viewHolder);
    }
}
