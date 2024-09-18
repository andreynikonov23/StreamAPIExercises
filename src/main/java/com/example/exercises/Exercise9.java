package com.example.exercises;

import static java.lang.System.out;
import static java.util.Comparator.comparingDouble;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise9 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final Comparator<Country> populationDensityComparator = comparingDouble(country -> country.getPopulation() / country.getSurfaceArea());

	public static void main(String[] args) {
		// Sort the countries by their population densities in descending order ignoring
		// zero population countries
		List<Country> countries = worldDao.findAllCountries();

		countries.stream()
				.filter(country -> (country.getPopulation() / country.getSurfaceArea()) > 0)
				.sorted(populationDensityComparator.reversed())
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

}
