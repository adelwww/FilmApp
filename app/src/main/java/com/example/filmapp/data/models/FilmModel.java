package com.example.filmapp.data.models;

import com.google.gson.annotations.SerializedName;

public class FilmModel {

    String id;
    @SerializedName("title")
    String title;
    @SerializedName("original_title")
    String original_title;
    @SerializedName("director")
    String director;
    @SerializedName("producer")
    String producer;
    @SerializedName("description")
    String description;
    @SerializedName("image")
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
