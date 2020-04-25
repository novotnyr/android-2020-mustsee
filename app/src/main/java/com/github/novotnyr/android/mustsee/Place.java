package com.github.novotnyr.android.mustsee;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Place implements Serializable {
    private Long id;

    private String description;

    public Place(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
