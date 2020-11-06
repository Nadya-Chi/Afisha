package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PosterManagerDefaultLengthTest {

    @Mock
    private PosterRepository repository;

    @InjectMocks
    PosterManager posterManager;
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
    private Poster eleventh = new Poster(11,11,"eleventh",0,1);

    @BeforeEach
    public void setUp() {
        posterManager.add(first);
        posterManager.add(second);
        posterManager.add(third);
        posterManager.add(fourth);
        posterManager.add(fifth);
        posterManager.add(sixth);
        posterManager.add(seventh);
        posterManager.add(eighth);
        posterManager.add(ninth);
        posterManager.add(tenth);
        posterManager.add(eleventh);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int id = 11;
        Poster[] returned = new Poster[] {first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(id);
        posterManager.removeById(id);

        Poster[] actual = posterManager.getLimit();
        Poster[] expected = new Poster[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected,actual);
        verify(repository).removeById(id);
    }

    @Test
    public void getAllFilmDefault20() {
        PosterManager posterManager = new PosterManager(20,repository);
        Poster[] returned = new Poster[] {first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth};
        doReturn(returned).when(repository).findAll();

        Poster[] actual = posterManager.getLimit();
        Poster[] expected = new Poster[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getAllFilmDefaultLess0() {
        PosterManager posterManager = new PosterManager(-5,repository);
        Poster[] returned = new Poster[] {};
        doReturn(returned).when(repository).findAll();

        Poster[] actual = posterManager.getLimit();
        Poster[] expected = new Poster[] {};

        assertArrayEquals(expected,actual);
    }
}
