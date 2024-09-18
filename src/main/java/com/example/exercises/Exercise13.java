package com.example.exercises;

import java.util.List;
import java.util.function.Supplier;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;
import com.example.util.CountrySummaryStatistics;
import static java.lang.Long.compare;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise13 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();


	public static void main(String[] args) {
		// Find the countries with the minimum and the maximum population
		List<Country> countries = worldDao.findAllCountries();
		CountrySummaryStatistics countrySummaryStatistics = new CountrySummaryStatistics((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()));
		System.out.println(countries.stream()
				.collect(() -> countrySummaryStatistics,
						CountrySummaryStatistics::accept, CountrySummaryStatistics::combine));
	}
}
