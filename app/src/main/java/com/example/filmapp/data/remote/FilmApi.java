package com.example.filmapp.data.remote;

import com.example.filmapp.data.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {

    @GET("/films")
    Call<List<FilmModel>> getFilms();

    @GET("/films/{id}")
    Call<FilmModel> getFilm(
            @Path("id") String id
    );
}
