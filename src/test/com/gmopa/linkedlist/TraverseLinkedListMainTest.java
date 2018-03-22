/**
 * 
 */
package com.gmopa.linkedlist;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.gmopa.linkedlist.TraverseLinkedLlistMain;
import com.gmopa.linkedlist.TraverseLinkedLlistMain.Results;

/**
 * @author Germain Mopa
 *
 */
public class TraverseLinkedListMainTest {

	TraverseLinkedLlistMain traverseLinkedLlistMain;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		traverseLinkedLlistMain = new TraverseLinkedLlistMain();
	}

	/**
	 * Test method for
	 * {@link com.gmopa.linkedlist.TraverseLinkedLlistMain#getMinMaxAverage(java.util.LinkedList)}
	 * .
	 */
	@Test(expected = NoSuchElementException.class)
	public void testGetMinMaxAverage_nulllist() {
		LinkedList<Integer> listNull = new LinkedList<>();
		traverseLinkedLlistMain.getMinMaxAverage(listNull);
	}

	/**
	 * Test method for
	 * {@link com.gmopa.linkedlist.TraverseLinkedLlistMain#getMinMaxAverage(java.util.LinkedList)}
	 * .
	 */
	@Test
	public void testGetMinMaxAverage_validlist() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(19);
		list.add(3);
		list.add(50);
		list.add(30);

		Results results = traverseLinkedLlistMain.getMinMaxAverage(list);

		assertEquals(3, results.getMin());
		assertEquals(50, results.getMax());
		assertEquals(25.5, results.getAverage(), 0.5);
	}

	/**
	 * Test method for
	 * {@link com.gmopa.linkedlist.TraverseLinkedLlistMain#getMinMaxAverage(java.util.LinkedList)}
	 * .
	 */
	@Test
	public void testGetMinMaxAverage_listwithonevalue() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(19);

		Results results = traverseLinkedLlistMain.getMinMaxAverage(list);

		assertEquals(19, results.getMin());
		assertEquals(19, results.getMax());
		assertEquals(19.0, results.getAverage(), 0.0001);
	}

	/**
	 * Test method for
	 * {@link com.gmopa.linkedlist.TraverseLinkedLlistMain#getMinMaxAverage(java.util.LinkedList)}
	 * .
	 */
	@Test
	public void testGetMinMaxAverage_largelist() {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i < 1000000; i++) {
			list.add(1000000 + i);
		}

		Results results = traverseLinkedLlistMain.getMinMaxAverage(list);

		assertEquals(1000001, results.getMin());
		assertEquals(1999999, results.getMax());
		assertEquals(1054.9147509147508, results.getAverage(), 0.00001);
	}

	/**
	 * Test method for
	 * {@link com.gmopa.linkedlist.TraverseLinkedLlistMain#getMinMaxAverage(java.util.LinkedList)}
	 * .
	 */
	@Test
	public void testGetMinMaxAverage_averageinfinity() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);

		Results results = traverseLinkedLlistMain.getMinMaxAverage(list);

		assertEquals(2, results.getMin());
		assertEquals(5, results.getMax());
		assertEquals(3.33, results.getAverage(), 0.0034);
	}
}
