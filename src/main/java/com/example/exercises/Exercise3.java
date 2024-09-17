package com.example.exercises;

import java.util.*;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of genres of each director's movies
		Collection<Movie> movies = movieService.findAllMovies();

		Map<Director, Map<Genre, Long>> res = movies.stream().
				map(movie -> movie.getDirectors().stream().map(director -> new DirectorGenresPair(director, movie.getGenres())).collect(Collectors.toList()))
				.flatMap(Collection::stream)
				.map(pair -> pair.genres().stream().map(genre -> new DirectorGenrePair(pair.director(), genre)).collect(Collectors.toList()))
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(DirectorGenrePair::director, Collectors.groupingBy(DirectorGenrePair::genre, Collectors.counting())));
		res.forEach((director,genreCounts)->{
			System.out.printf("%s\n",director.getName());
			genreCounts.forEach( (genre,count) -> System.out.printf("\t%s: %s\n",genre.getName(),count));
		});
	}
}