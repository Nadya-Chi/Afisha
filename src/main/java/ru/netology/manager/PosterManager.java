package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

import java.sql.PreparedStatement;

public class PosterManager {

    private Poster[] films = new Poster[0];
    private int countFilms = 10;

    public PosterManager() {
    }
    public PosterManager(int countFilms) {
        if (countFilms < 0) {
            return;
        }
        this.countFilms = countFilms;
    }

    private PosterRepository repository;
    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(Poster film) {
        repository.save(film);
    }

    public Poster[] getAll() {
        Poster[] films = repository.findAll();
        Poster[] result = new Poster[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}
