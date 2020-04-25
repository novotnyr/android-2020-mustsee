package com.github.novotnyr.android.mustsee;

import androidx.annotation.*;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceItemKeyProvider extends ItemKeyProvider<Long> {
    private RecyclerView recyclerView;

    public PlaceItemKeyProvider(RecyclerView recyclerView) {
        // Enable access to all data, bound and unbound to views
        super(ItemKeyProvider.SCOPE_MAPPED);
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public Long getKey(int position) {
        return recyclerView.getAdapter().getItemId(position);
    }

    @Override
    public int getPosition(@NonNull Long key) {
        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForItemId(key);
        if (viewHolder == null) {
            return RecyclerView.NO_POSITION;
        }
        return viewHolder.getAdapterPosition();
    }
}
