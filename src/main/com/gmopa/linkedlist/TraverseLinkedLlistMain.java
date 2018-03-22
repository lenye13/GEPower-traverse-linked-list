/**
 * 
 */
package com.gmopa.linkedlist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Germain Mopa
 *
 */
public class TraverseLinkedLlistMain {

	/***********************************
	 * Method that takes in a list and returns the min, max and average of
	 * values in the list the values are stored in a Map<String, String>
	 * 
	 * @param linked
	 *            list of Integer
	 * @return a Map<String, String> with three pairs: min->minimum integer in
	 *         the list max -> maximum integer in the list average -> average of
	 *         values in the list
	 * @throws NoSuchElementException
	 *             if the list passed is null
	 */
	// public Map<String, String> getMinMaxAverage(LinkedList<Integer> list) {
	public Results getMinMaxAverage(LinkedList<Integer> list) {
		// Check if the list is null - return null if it is
		if (list == null) {
			throw new NoSuchElementException("List passed is null");
		}
		// Use a utility class to sort the list - I could've found the min/max
		// while iterating through the list
		Collections.sort(list);
		int sumOfElements = 0;
		Map<String, String> results = new HashMap<String, String>();

		// Use the list iterator to add all the values in the list
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			sumOfElements += iterator.next();
		}

		// min, max and average values into the map
		results.put("min", list.getFirst().toString());
		results.put("max", list.getLast().toString());
		Double average = (1.0 * sumOfElements / list.size());
		results.put("average", average.toString());

		Results results2 = new Results(list.getFirst(), list.getLast(), average);
		return results2;
	}

	public class Results {
		private int min;
		private int max;
		private double average;

		public Results(int min, int max, double average) {
			this.min = min;
			this.max = max;
			this.average = average;
		}

		/**
		 * @return the min
		 */
		public int getMin() {
			return min;
		}

		/**
		 * @return the max
		 */
		public int getMax() {
			return max;
		}

		/**
		 * @return the average
		 */
		public double getAverage() {
			return average;
		}
	}
}
