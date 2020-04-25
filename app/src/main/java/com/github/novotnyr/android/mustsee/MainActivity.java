package com.github.novotnyr.android.mustsee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.*;
import androidx.recyclerview.widget.*;

import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    private RecyclerView placeRecyclerView;

    private PlaceListAdapter placeListAdapter = new PlaceListAdapter();

    private SelectionTracker<Long> selectionTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeRecyclerView = findViewById(R.id.placeRecyclerView);
        placeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        placeRecyclerView.setAdapter(placeListAdapter);

        placeListAdapter.submitList(getInitialPlaces());

        selectionTracker = new SelectionTracker.Builder<Long>(
                "places-selection",
                placeRecyclerView,
                new StableIdKeyProvider(placeRecyclerView),
                new PlaceDetailsLookup(placeRecyclerView),
                StorageStrategy.createLongStorage()
        ).build();
    }

    private List<Place> getInitialPlaces() {
        List<Place> places = new ArrayList<>();
        places.add(new Place(1L, "Cathedral of St Elizabeth"));
        places.add(new Place(2L, "Collosseum"));
        places.add(new Place(3L, "St. Michael's Chapel"));
        places.add(new Place(4L, "Botanical Garden"));
        places.add(new Place(5L, "ZOO"));

        return places;
    }
}
