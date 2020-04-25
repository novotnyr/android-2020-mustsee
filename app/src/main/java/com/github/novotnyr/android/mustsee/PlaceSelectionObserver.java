package com.github.novotnyr.android.mustsee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionTracker;

public class PlaceSelectionObserver extends SelectionTracker.SelectionObserver<Long> {

    private final AppCompatActivity activity;

    private final SelectionTracker<Long> selectionTracker;

    public PlaceSelectionObserver(AppCompatActivity activity, SelectionTracker<Long> selectionTracker) {
        this.activity = activity;
        this.selectionTracker = selectionTracker;
    }

    @Override
    public void onSelectionChanged() {
        if (selectionTracker.hasSelection()) {
            activity.setTitle("Selected: " + selectionTracker.getSelection().size());
        } else {
            activity.setTitle(R.string.app_name);
        }
    }
}
