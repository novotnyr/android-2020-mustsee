package com.github.novotnyr.android.mustsee;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class PlaceDiff extends DiffUtil.ItemCallback<Place> {
    @Override
    public boolean areItemsTheSame(@NonNull Place oldItem, @NonNull Place newItem) {
        return Objects.equals(oldItem.getId(), newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Place oldItem, @NonNull Place newItem) {
        return Objects.equals(oldItem.getDescription(), newItem.getDescription());
    }
}
