package com.example.correctSolutions;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.exercises.ContinentCityPair;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SolutionExercise2 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the most populated city of each continent
        var highPopulatedCityOfEachContinent =
                countryDao.findAllCountries()
                        .stream()
                        .map( country -> country.getCities().stream().map(city -> new ContinentCityPair(country.getContinent(),city)).toList())
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(ContinentCityPair::continent,Collectors.maxBy( ContinentCityPair::compareTo )));
        highPopulatedCityOfEachContinent.forEach(ContinentCityPair::printEntry);
    }

}