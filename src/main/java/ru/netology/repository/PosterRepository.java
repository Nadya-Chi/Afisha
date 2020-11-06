package ru.netology.repository;

import ru.netology.domain.Poster;

public class PosterRepository {
    private Poster[] films = new Poster[0];

    public void save(Poster film) {
        int length = films.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Poster[] findAll() {
        return films;
    }

    public Poster findById(int id) {
        for (Poster film: films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Poster[] tmp = new Poster[length];
        int index = 0;
        for (Poster film: films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new Poster[0];
    }

}
