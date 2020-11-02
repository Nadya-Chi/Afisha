package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    private PosterManager manager = new PosterManager();
    private Poster first = new Poster(1,1,"first",0,1);
    private Poster second = new Poster(2,2,"second",0,1);
    private Poster third = new Poster(3,3,"third",0,1);
    private Poster fourth = new Poster(4,4,"fourth",0,1);
    private Poster fifth = new Poster(5,5,"fifth",0,1);
    private Poster sixth = new Poster(6,6,"sixth",0,1);
    private Poster seventh = new Poster(7,7,"seventh",0,1);
    private Poster eighth = new Poster(8,8,"eighth",0,1);
    private Poster ninth = new Poster(9,9,"ninth",0,1);
    private Poster tenth = new Poster(10,10,"tenth",0,1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldRemoveIfExists() {
        int id = 1;
        manager.removeById(id);

        Poster[] actual = manager.getLimit();
        Poster[] expected = new Poster[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void addFilm() {

        Poster[] actual = manager.getLimit();
        Poster[] expected = new Poster[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void addFilm5() {
        manager = new PosterManager(5);
        setUp();
        Poster[] actual = manager.getLimit();
        Poster[] expected = new Poster[] {tenth,ninth,eighth,seventh,sixth};

        assertArrayEquals(expected,actual);

    }

    @Test
    public void addFilm0() {
        manager = new PosterManager(0);
        setUp();
        Poster[] actual = manager.getLimit();
        Poster[] expected = new Poster[] {};

        assertArrayEquals(expected,actual);

    }
}
