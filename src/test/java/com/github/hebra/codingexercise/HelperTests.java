package com.github.hebra.codingexercise;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.github.hebra.codingexercise.Helper;

@SpringBootTest
class HelperTests {

	/**
	 * This test is for verifying if the Helper.sortMapByValues method actually
	 * works as expected.
	 */
	@Test
	public void testMapSorting() {

		Map<String, Integer> testMap = new HashMap<>();

		testMap.put("ANY", 3);
		testMap.put("ANY", 1);
		testMap.put("FIRST", 5);
		testMap.put("ANY", 2);
		testMap.put("ANY", 2);
		testMap.put("LAST", -1);
		testMap.put("ANY", 0);

		Map<String, Integer> sortedMap = Helper.sortMapByValues(testMap);

		Assert.isTrue(testMap.size() == sortedMap.size(),
				"testMap and sortedMap must have the same size after sorting.");

		Object[] keys = sortedMap.keySet().toArray();

		Assert.isTrue(keys[0].equals("FIRST"), "The first item in the sorted list should be FIRST.");

		Assert.isTrue(keys[keys.length - 1].equals("LAST"), "The last item in the sorted list should be LAST.");

	}

}
