package com.example.correctSolutions;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionExercise1 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();
    public static void main(String[] args) {
        final Collection<Movie> movies = movieService.findAllMovies();
        Map<String,Long> dirMovCounts =
                movies.stream().map(Movie::getDirectors)
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(
                                        Director::getName,
                                        Collectors.counting()
                                )
                        );
        dirMovCounts.forEach(
                (name,count) -> System.out.printf("%20s: %3d\n",name,count));
    }
}
