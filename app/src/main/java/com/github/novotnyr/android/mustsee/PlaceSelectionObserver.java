package com.github.novotnyr.android.mustsee;

import android.view.*;

import java.util.Iterator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.selection.SelectionTracker;

public class PlaceSelectionObserver extends SelectionTracker.SelectionObserver<Long> implements ActionMode.Callback {

    private final AppCompatActivity activity;

    private final SelectionTracker<Long> selectionTracker;

    private ActionMode actionMode;

    public PlaceSelectionObserver(AppCompatActivity activity, SelectionTracker<Long> selectionTracker) {
        this.activity = activity;
        this.selectionTracker = selectionTracker;
    }

    @Override
    public void onSelectionChanged() {
        if (selectionTracker.hasSelection()) {
            if (actionMode == null) {
                actionMode = activity.startSupportActionMode(this);
            }
            actionMode.setTitle("Selected: " + selectionTracker.getSelection().size());
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.place_selection_cab, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.placeDeleteMenuItem) {
            onDeleteItems(this.selectionTracker.getSelection().iterator());
            mode.finish();
            return true;
        }
        return false;
    }

    protected void onDeleteItems(Iterator<Long> selection) {
        // do nothing
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        selectionTracker.clearSelection();
        actionMode = null;
    }
}
