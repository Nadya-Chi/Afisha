package ru.netology.manager;

import ru.netology.domain.Poster;

import java.sql.PreparedStatement;

public class PosterManager {

    private Poster[] films = new Poster[0];
    private int countFilms = 10;

    public PosterManager() {
    }
    public PosterManager(int countFilms) {
        if (countFilms < 0) {
            this.countFilms = 0;
        } else this.countFilms = countFilms;
    }

    public void add(Poster film) {
//        создаем новый массив размером на единицу больше
        int length = films.length + 1;
        Poster[] tmp = new Poster[length];
//        копируем поэлементно itar
        System.arraycopy(films, 0, tmp, 0, films.length);
//        кладем наш элемент последним
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
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
//        меняем наши элементы
        films = tmp;
    }

    public Poster[] getLimit() {
        int finalCountFilms = Math.min(films.length,countFilms);
        Poster[] limit = new Poster[finalCountFilms];
        for (int i = 0; i < finalCountFilms; i++) {
            int index = films.length - i - 1;
            limit[i] = films[index];
        }
        return limit;
    }
}
