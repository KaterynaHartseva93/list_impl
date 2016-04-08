package com.epam.rd.kateryna_hartseva.task1.list_impl;

import static org.hamcrest.core.IsCollectionContaining.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Kateryna Hartseva
 */
public class ArrayListImplTest {
	public static final String TEST_STRING = "TEST_STRING";

    private ArrayListImpl<String> list;

	@Rule
	public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        list = new ArrayListImpl<String>();
	    list.add("test_add");
	    list.add("test_add2");
	    list.add("test_add3");
    }

	@Test
	public void shouldAddElementToTheEndOfListWhenAddInvoke() {
		list.add(TEST_STRING);
		assertEquals(TEST_STRING, list.get(3));

	}

	@Test
	public void shouldReturnTrueWhenElementWasAdded() {
		assertTrue(list.add(TEST_STRING));
	}

	@Test
	public void shouldIncreaseSizeWhenElementWasAdded() {
		int expected = 4;
		list.add(TEST_STRING);
		assertEquals(expected, list.size());
	}

	@Test
	public void throwsExceptionWhenIndexIsBelowZero() {
		int invalidIndex = -3;
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Invalid index: -3. List size: 3");
		list.add(invalidIndex, TEST_STRING);
	}

	@Test
	public void throwsExceptionWhenIndexIsGreaterThanSize() {
		int invalidIndex = 4;
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Invalid index: 4. List size: 3");
		list.add(invalidIndex, TEST_STRING);
	}

	@Test
	public void shouldIncrementIndexesToTheRightByOneWhenAddWithIndexInvoked() {
		int indexForInsert = 1;
		String[] expected = {"test_add", TEST_STRING, "test_add2", "test_add3"};
		list.add(indexForInsert, TEST_STRING);
		assertTrue(Arrays.equals(expected,list.toArray()));
	}

	@Test
	public void shouldInsertElementWhenAddWithIndexInvoked() {
		int indexForInsert = 1;
		list.add(indexForInsert, TEST_STRING);
		assertEquals(TEST_STRING, list.get(indexForInsert));
	}

	@Test
	public void shouldReturnElementWhenGetterInvoked() {
		int index = 0;
		String expected = "test_add";
		assertEquals(expected, list.get(index));
	}

	@Test
	public void throwsExceptionWhenIndexLessThenZeroForGetter() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Invalid index: -1. List size: 3");
		int index = -1;
		list.get(index);
	}

	@Test
	public void throwsExceptionWhenIndexGreaterThenListSizeForGetter() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Invalid index: 4. List size: 3");
		int index = 4;
		list.get(index);
	}


}
