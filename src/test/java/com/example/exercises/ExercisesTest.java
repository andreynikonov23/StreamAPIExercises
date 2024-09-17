package com.example.exercises;

import com.example.correctSolutions.SolutionExercise1;
import com.example.correctSolutions.SolutionExercise2;
import com.example.correctSolutions.SolutionExercise3;
import com.example.correctSolutions.SolutionExercise4;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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
        OUTPUT.reset();
    }


    @Test
    public void exercise1() {
        SolutionExercise1.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise1.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
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
