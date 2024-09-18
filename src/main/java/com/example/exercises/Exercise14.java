package com.example.exercises;

import static java.util.stream.Collector.of;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;
import com.example.util.CountrySummaryStatistics;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise14 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final BiConsumer<String, CountrySummaryStatistics> printEntry =
			(continent, statistics) -> System.out.printf("%s: %s\n", continent, statistics);


	public static void main(String[] args) {
		// Find the countries of each continent with the minimum and the maximum population
		List<Country> countries = worldDao.findAllCountries();
		Supplier<CountrySummaryStatistics> supplier = () -> new CountrySummaryStatistics((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()));
		BiConsumer<CountrySummaryStatistics, Country> accumulator = (countrySummaryStatistics, country) -> countrySummaryStatistics.accept(country);
		BinaryOperator<CountrySummaryStatistics> combiner = (css1, css2) -> {
			css1.combine(css2);
			return css1;
		};

		countries.stream()
				.collect(groupingBy(Country::getContinent, of(supplier, accumulator, combiner)))
				.forEach(printEntry);
	}

}
