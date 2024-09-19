package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;
import com.example.util.DoubleSummaryGaussianStatistics;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Stream.of;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise17 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum, the average, and the standard deviation of GNP values.
		List<Country> countries = worldDao.findAllCountries();

		System.out.println(countries.stream()
				.mapToDouble(Country::getGnp)
				.collect(DoubleSummaryGaussianStatistics::new, DoubleSummaryGaussianStatistics::accept, DoubleSummaryGaussianStatistics::combine));
	}

}
