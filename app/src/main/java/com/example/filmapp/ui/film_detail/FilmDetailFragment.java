package com.example.filmapp.ui.film_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.support.v4.media.session.MediaSessionCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmapp.App;
import com.example.filmapp.R;
import com.example.filmapp.databinding.FragmentFilmDetailBinding;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.apiService.getFilm(FilmDetailFragmentArgs.fromBundle(getArguments()).getId()).observe(getViewLifecycleOwner(), film -> {
            binding.nameTv.setText(String.valueOf(film.getTitle()));
            binding.originalTv.setText(String.valueOf(film.getOriginal_title()));
            binding.directorTv.setText(String.valueOf(film.getDirector()));
            binding.producerTv.setText(String.valueOf(film.getProducer()));
            binding.description.setText(String.valueOf(film.getDescription()));
        });
    }
}