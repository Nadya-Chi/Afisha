package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class RepositoryTest {
    PosterRepository posterRepository = new PosterRepository();
    Poster first = new Poster(1,1,"first",0,1);
    Poster second = new Poster(2,2,"second",0,1);
    Poster third = new Poster(3,3,"third",0,1);
    Poster fourth = new Poster(4,4,"fourth",0,1);
    Poster fifth = new Poster(5,5,"fifth",0,1);
    Poster sixth = new Poster(6,6,"sixth",0,1);
    Poster seventh = new Poster(7,7,"seventh",0,1);
    Poster eighth = new Poster(8,8,"eighth",0,1);
    Poster ninth = new Poster(9,9,"ninth",0,1);

    private  void setUp() {
        posterRepository.save(first);
        posterRepository.save(second);
        posterRepository.save(third);
        posterRepository.save(fourth);
        posterRepository.save(fifth);
        posterRepository.save(sixth);
        posterRepository.save(seventh);
        posterRepository.save(eighth);
        posterRepository.save(ninth);
    }

    @Test
    public void save() {
        setUp();
        Poster[] actual = posterRepository.findAll();
        Poster[] expected = new Poster[] {first,second,third,fourth,fifth,sixth,seventh,eighth,ninth};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void findAll() {
        setUp();
        posterRepository.findAll();
        Poster[] actual = posterRepository.findAll();
        Poster[] expected = new Poster[] {first,second,third,fourth,fifth,sixth,seventh,eighth,ninth};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void findById() {
        setUp();
        int id = 8;

        Poster actual = posterRepository.findById(id);

        assertEquals(eighth,actual);
    }

    @Test
    public void removeById() {
        setUp();
        int id = 9;
        posterRepository.removeById(id);
        Poster[] actual = posterRepository.findAll();
        Poster[] expected = new Poster[]{first, second, third, fourth, fifth, sixth, seventh, eighth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAll() {
        setUp();
        int id = 9;
        posterRepository.removeAll();
        Poster[] actual = posterRepository.findAll();
        Poster[] expected = new Poster[]{};

        assertArrayEquals(expected, actual);
    }


}
