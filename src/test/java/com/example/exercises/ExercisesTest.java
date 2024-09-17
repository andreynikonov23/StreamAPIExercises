package com.example.exercises;

import com.example.correctSolutions.SolutionExercise2;
import com.example.correctSolutions.SolutionExercise3;
import com.example.correctSolutions.SolutionExercise4;
import com.example.dao.InMemoryWorldDao;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.example.dao.CountryDao;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


public class ExercisesTest {
    private final static ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private final static PrintStream ORIGINAL_OUT = new PrintStream(System.out);
    private static final String[] emptyArgs = new String[0];

    @BeforeEach
    public void initOUTPUT() {
        System.setOut(new PrintStream(OUTPUT));
    }
    @AfterEach
    public void resetOUTPUT() {
        System.setOut(ORIGINAL_OUT);
    }


    @Test
    public void exercise2() {
        SolutionExercise2.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise2.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }

    @Test
    public void exercise3() {
        SolutionExercise3.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise3.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise4() {
        SolutionExercise4.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise4.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }

}
