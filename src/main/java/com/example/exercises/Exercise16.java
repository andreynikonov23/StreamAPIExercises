package com.example.exercises;

import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;
import com.example.domain.Country;
import com.example.util.CitySummaryStatistics;
import com.example.util.CountryCitySummaryStatistics;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise16 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
	private static final BiConsumer<String, CountryCitySummaryStatistics> printEntry =
			(country,statistics) -> System.out.printf("%s: %s\n", country, statistics);

	public static void main(String[] args) {
		// Find the cities with the minimum and the maximum population in countries.
		List<Country> countries = worldDao.findAllCountries();
		BiConsumer<CountryCitySummaryStatistics, Country> accumulator = (countryCitySummaryStatistics, country) -> countryCitySummaryStatistics.accept(country);
		BinaryOperator<CountryCitySummaryStatistics> combiner = (countryCitySummaryStatistics1, countryCitySummaryStatistics2) -> {
			countryCitySummaryStatistics1.combine(countryCitySummaryStatistics2);
			return countryCitySummaryStatistics1;
		};

		countries.stream()
				.collect(groupingBy(Country::getCode, of(CountryCitySummaryStatistics::new, accumulator, combiner)))
				.forEach(printEntry);
	}
}
