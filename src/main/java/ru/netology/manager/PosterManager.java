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

    public PosterManager(int countFilms,PosterRepository repository) {
        this.countFilms = countFilms;
        this.repository = repository;
    }

    private PosterRepository repository;
    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(Poster film) {
        repository.save(film);
    }

//    public Poster[] getAll() {
//        Poster[] films = repository.findAll();
//        Poster[] result = new Poster[films.length];
//        for (int i = 0; i < result.length; i++) {
//            int index = films.length - i - 1;
//            result[i] = films[index];
//        }
//        return result;
//    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Poster[] getLimit() {
        Poster[] films = repository.findAll();
        int finalCountFilms = Math.min(films.length,countFilms);
//        Poster[] films = repository.findAll();
        Poster[] limit = new Poster[finalCountFilms];
        for (int i = 0; i < finalCountFilms; i++) {
            int index = films.length - i - 1;
            limit[i] = films[index];
        }
        return limit;
    }

}
