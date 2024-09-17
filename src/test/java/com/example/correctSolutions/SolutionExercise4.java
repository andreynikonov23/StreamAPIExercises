package com.example.correctSolutions;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.Objects;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SolutionExercise4 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city
		var highPopulatedCapitalCity = 
				countryDao.findAllCountries()
				          .stream()
				          .map(Country::getCapital)
				          .filter(Objects::nonNull)
				          .map(cityDao::findCityById)
				          .filter(Objects::nonNull)
				          .max(Comparator.comparing(City::getPopulation));
		highPopulatedCapitalCity.ifPresent(System.out::println);		          
	}

}
