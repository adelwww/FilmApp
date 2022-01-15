package com.example.filmapp.data.remote;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.filmapp.App;
import com.example.filmapp.data.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmApiService {

    public void getFilms(OnFilmReadyCallBack myCallBack){
        App.api.getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    myCallBack.success(response.body());
                }else if (response.code() > 500 ){
                    myCallBack.onServerError();
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                myCallBack.failure(t.getLocalizedMessage());
            }
        });
    }

    public LiveData<FilmModel> getFilm(String id){
        MutableLiveData<FilmModel> data = new MutableLiveData<>();
        App.api.getFilm(id).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(@NonNull Call<FilmModel> call, @NonNull Response<FilmModel> response) {
                if (response.isSuccessful() && response.body() != null){
                    data.setValue(response.body());
                }else if (response.code() > 500 ){
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
