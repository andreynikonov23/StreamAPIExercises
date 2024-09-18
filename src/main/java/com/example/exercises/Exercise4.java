package com.example.exercises;

import java.util.*;
import java.util.stream.Collectors;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise4 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city
		List<Country> countries = countryDao.findAllCountries();

		City highestCapital = countries.stream().map(country -> country.getCities().stream().filter(city -> city.getId() == country.getCapital()).collect(Collectors.toList()))
				.flatMap(Collection::stream)
				.max(Comparator.comparingInt(City::getPopulation)).get();
		System.out.println(highestCapital);
	}

}
