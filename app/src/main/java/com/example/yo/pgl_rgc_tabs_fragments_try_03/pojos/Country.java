package com.example.yo.pgl_rgc_tabs_fragments_try_03.pojos;

public class Country {
    private int id;
    private String description;

    public Country() {
    }

    public Country(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
