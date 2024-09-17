package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;

public class ExercisesTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final MovieService movieService = InMemoryMovieService.getInstance();



    @Test
    public void exercise2() {
        var highPopulatedCityOfEachContinent =
                countryDao.findAllCountries()
                        .stream()
                        .map( country -> country.getCities().stream().map(city -> new ContinentCityPair(country.getContinent(),city)).toList())
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(ContinentCityPair::continent,Collectors.maxBy( ContinentCityPair::compareTo )));
        highPopulatedCityOfEachContinent.forEach(ContinentCityPair::printEntry);
    }
    @Test
    public void exercise3() {
        var directorGenreNumbers =
                movieService.findAllMovies()
                        .stream()
                        .map( movie -> movie.getDirectors().stream().map(director -> new DirectorGenresPair(director,movie.getGenres())).toList())
                        .flatMap(Collection::stream)
                        .map( directorGenres -> directorGenres.genres().stream().map( genre -> new DirectorGenrePair(directorGenres.director(),genre) ).toList())
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(DirectorGenrePair::director,Collectors.groupingBy(DirectorGenrePair::genre,Collectors.counting())));
        directorGenreNumbers.forEach((director,genreCounts)->{
            System.out.printf("%s\n",director.getName());
            genreCounts.forEach( (genre,count) -> System.out.printf("\t%s: %s\n",genre.getName(),count));
        });
    }
}
