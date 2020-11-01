package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

import java.sql.PreparedStatement;

public class PosterManager {

    private Poster[] films = new Poster[0];
    private PosterRepository repository;
    private int countFilms = 10;

    public PosterManager() {
    }

    public PosterManager(int countFilms,PosterRepository repository) {
        this.countFilms = countFilms;
        this.repository = repository;
    }

    public void add(Poster film) {
        repository.save(film);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Poster[] getLimit() {
        Poster[] films = repository.findAll();
        if (countFilms < 0) {
            countFilms = 0;
        }
        int finalCountFilms = Math.min(films.length,countFilms);

        Poster[] limit = new Poster[finalCountFilms];
        for (int i = 0; i < finalCountFilms; i++) {
            int index = films.length - i - 1;
            limit[i] = films[index];
        }
        return limit;
    }

}
