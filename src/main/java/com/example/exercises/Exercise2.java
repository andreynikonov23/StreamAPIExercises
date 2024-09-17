package com.example.exercises;

import java.util.*;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		List<Country> countries = countryDao.findAllCountries();

		countries.stream()
				.map(country -> country.getCities().stream().map(city -> new ContinentCityPair(country.getContinent(), city)).collect(Collectors.toList()))
				.flatMap(Collection::stream)
				.sorted(ContinentCityPair::compareTo)
				.collect(Collectors.groupingBy(ContinentCityPair::continent, Collectors.maxBy(ContinentCityPair::compareTo))).forEach(ContinentCityPair::printEntry);
	}

}