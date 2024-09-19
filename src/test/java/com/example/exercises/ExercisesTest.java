package com.example.exercises;

import com.example.correctSolutions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ExercisesTest {
    private final static ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
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
    @Test
    public void exercise5() {
        SolutionExercise5.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise5.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise6() {
        SolutionExercise6.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise6.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise7() {
        SolutionExercise7.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise7.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise8() {
        SolutionExercise8.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise8.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise9() {
        SolutionExercise9.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise9.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise10() {
        SolutionExercise10.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise10.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise11() {
        SolutionExercise11.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise11.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise12() {
        SolutionExercise12.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise12.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise13() {
        SolutionExercise13.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise13.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise14() {
        SolutionExercise14.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise14.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise15() {
        SolutionExercise15.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise15.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise16() {
        SolutionExercise16.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise16.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise17() {
        SolutionExercise17.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise17.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
    @Test
    public void exercise18() {
        SolutionExercise18.main(emptyArgs);
        String correctAnswer = OUTPUT.toString();
        OUTPUT.reset();
        Exercise18.main(emptyArgs);
        String actualAnswer = OUTPUT.toString();
        Assertions.assertEquals(correctAnswer, actualAnswer);
    }
}
