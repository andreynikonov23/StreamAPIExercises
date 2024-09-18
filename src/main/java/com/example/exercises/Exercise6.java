package com.example.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by number of their cities in descending order
		List<Country> countries = countryDao.findAllCountries();

		countries.stream()
				.sorted((country1, country2) -> Integer.compare(country2.getCities().size(), country1.getCities().size()))
				.toList()
				.forEach(System.out::println);
	}

}
