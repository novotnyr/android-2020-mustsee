package com.github.novotnyr.android.mustsee;

import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemDetails extends ItemDetailsLookup.ItemDetails<Long> {
    private RecyclerView.ViewHolder viewHolder;

    public SimpleItemDetails(RecyclerView.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    @Override
    public int getPosition() {
        return viewHolder.getAdapterPosition();
    }

    @Nullable
    @Override
    public Long getSelectionKey() {
        return viewHolder.getItemId();
    }
}
