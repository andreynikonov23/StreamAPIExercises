package com.example.exercises;

import java.util.*;
import java.util.function.Function;
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
public class Exercise5 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city of each continent
		Function<ContinentCityPair, City> function = ContinentCityPair::city;
		List<Country> countries = countryDao.findAllCountries();

		countries.stream()
				.map(country ->
						country.getCities().stream()
								.filter(city -> city.getId() == country.getCapital())
								.map(city -> new ContinentCityPair(country.getContinent(), city))
								.collect(Collectors.toList())
				)
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(ContinentCityPair::continent,Collectors.maxBy(Comparator.comparing(function.andThen(City::getPopulation)))))
				.forEach((continent, pair) -> System.out.printf("%s: %s\n", continent, pair.get().city()));
	}

}