package com.example.exercises;

import static java.util.stream.Collectors.summarizingLong;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise11 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of world countries
		List<Country> countries = worldDao.findAllCountries();

		System.out.println(countries.stream()
				.collect(summarizingLong(Country::getPopulation)));
	}

}
