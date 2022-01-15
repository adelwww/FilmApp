package com.example.filmapp.ui.film_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmapp.App;
import com.example.filmapp.R;
import com.example.filmapp.data.models.FilmModel;
import com.example.filmapp.data.remote.OnFilmReadyCallBack;
import com.example.filmapp.databinding.FragmentFilmBinding;

import java.util.List;


public class FilmFragment extends Fragment {

    private FragmentFilmBinding binding;
    private FilmAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmBinding.inflate(inflater, container, false);
        adapter = new FilmAdapter();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        binding.recyclerFilms.setAdapter(adapter);

        App.apiService.getFilms(new OnFilmReadyCallBack() {
            @Override
            public void success(List<FilmModel> films) {
                adapter.setFilms(films);
            }
            @Override
            public void onServerError() {
                Log.e("TAG", "onServiceError");
            }
            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure: " + msg);
            }
        });
    }

    private void initClickers() {
        adapter.setOnClick(id -> {
            Navigation.findNavController(requireView()).navigate(FilmFragmentDirections.actionFilmFragmentToFilmDetailFragment(id));
        });
    }
}