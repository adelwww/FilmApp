package com.example.filmapp.data.remote;

import com.example.filmapp.data.models.FilmModel;

import java.util.List;

public interface OnFilmReadyCallBack {
    void success(List<FilmModel> films);
    void onServerError();
    void failure(String msg);
}
