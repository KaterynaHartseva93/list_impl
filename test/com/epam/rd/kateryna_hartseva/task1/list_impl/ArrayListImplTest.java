package com.epam.rd.kateryna_hartseva.task1.list_impl;

import com.epam.rd.kateryna_hartseva.task1.entity.Clothes;
import com.epam.rd.kateryna_hartseva.task1.entity.Skirt;
import com.epam.rd.kateryna_hartseva.task1.entity.TShirt;
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

	private static final Clothes NEW_ELEMENT =  new Skirt("NEW_ELEMENT");
	private static final Clothes MISSING_ELEMENT = new TShirt("MISSING_ELEMENT");
	private static final Clothes FIRST_ELEMENT = new TShirt("FIRST_ELEMENT");
	private static final Clothes SECOND_ELEMENT = new TShirt("SECOND_ELEMENT");
	private static final Clothes THIRD_ELEMENT = new Skirt("THIRD_ELEMENT");



	private ArrayListImpl<Clothes> list;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		list = new ArrayListImpl<Clothes>();
		list.add(FIRST_ELEMENT);
		list.add(SECOND_ELEMENT);
		list.add(THIRD_ELEMENT);
	}

	@Test
	public void shouldCreateListWithSpecifiedArrayLength() {
		list = new ArrayListImpl<Clothes>(15);
	}

	@Test
	public void shouldContainEmptyArrayWhenSpecifiedCapacityIsZero() {
		list = new ArrayListImpl<Clothes>(0);
	}

	@Test
	public void shouldIncreaseInnerArrayWhenLastWasFilledUp() {
		list = new ArrayListImpl<Clothes>(1);
		list.add(NEW_ELEMENT);
		list.add(NEW_ELEMENT);
	}

	@Test
	public void throwsExceptionWhenCapacityIsLessThanZero() {
		int illegalCapacity = -3;
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Illegal capacity: -3");
		list = new ArrayListImpl<Clothes>(illegalCapacity);
	}

	@Test
	public void shouldReturnSizeWhenMethodInvoked() {
		int expected = 3;
		assertEquals(expected, list.size());
	}

	@Test
	public void shouldReturnFalseWhenListContainsElements() {
		assertFalse(list.isEmpty());
	}

	@Test
	public void shouldReturnTrueWhenListIsEmpty() {
		list = new ArrayListImpl<Clothes>();
		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldReturnTrueWhenContainsThisElement() {
		assertTrue(list.contains(FIRST_ELEMENT));
	}

	@Test
	public void shouldReturnFalseWhenThisElementIsAbsentInList() {
		assertFalse(list.contains(MISSING_ELEMENT));
	}




	@Test
	public void shouldAddElementToTheEndOfListWhenAddInvoke() {
		list.add(NEW_ELEMENT);
		assertEquals(NEW_ELEMENT, list.get(3));

	}

	@Test
	public void shouldReturnTrueWhenElementWasAdded() {
		assertTrue(list.add(NEW_ELEMENT));
	}

	@Test
	public void shouldIncreaseSizeWhenElementWasAdded() {
		int expected = 4;
		list.add(NEW_ELEMENT);
		assertEquals(expected, list.size());
	}

	@Test
	public void throwsExceptionWhenIndexIsBelowZero() {
		int invalidIndex = -3;
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Invalid index: -3. List size: 3");
		list.add(invalidIndex, NEW_ELEMENT);
	}

	@Test
	public void throwsExceptionWhenIndexIsGreaterThanSize() {
		int invalidIndex = 4;
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Invalid index: 4. List size: 3");
		list.add(invalidIndex, NEW_ELEMENT);
	}

	@Test
	public void shouldIncrementIndexesToTheRightByOneWhenAddWithIndexInvoked() {
		int indexForInsert = 1;
		Clothes[] expected = {FIRST_ELEMENT, NEW_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT};
		list.add(indexForInsert, NEW_ELEMENT);
		assertTrue(Arrays.equals(expected, list.toArray()));
	}

	@Test
	public void shouldInsertElementWhenAddWithIndexInvoked() {
		int indexForInsert = 1;
		list.add(indexForInsert, NEW_ELEMENT);
		assertEquals(NEW_ELEMENT, list.get(indexForInsert));
	}

	@Test
	public void shouldReturnElementWhenGetterInvoked() {
		int index = 0;
		assertEquals(FIRST_ELEMENT, list.get(index));
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

	@Test
	public void shouldIncrementIndexesToTheRightByOneWhenAddWithIndexInvoke() {
		int indexForInsert = 1;
		Object[] expected = {FIRST_ELEMENT, NEW_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT};
		list.add(indexForInsert, NEW_ELEMENT);
		assertTrue(Arrays.equals(expected, list.toArray()));
	}





	@Test
	public void shouldInsertElementWhenAddWithIndexInvoke() {
		int indexForInsert = 1;
		list.add(indexForInsert, NEW_ELEMENT);
		assertEquals(NEW_ELEMENT, list.get(indexForInsert));
	}



	@Test
	public void shouldReturnLastIndexOfSpecifiedElementWhenMethodInvoked() {
		int expectedIndex = 3;
		list.add(FIRST_ELEMENT);
		assertEquals(expectedIndex, list.lastIndexOf(FIRST_ELEMENT));
	}

	@Test
	public void shouldRemoveElementFromTheListWhenMethodInvoked() {
		Clothes[] expected = {SECOND_ELEMENT, THIRD_ELEMENT};
		list.remove(FIRST_ELEMENT);
		assertTrue(Arrays.equals(expected, list.toArray()));
	}

	@Test
	public void shouldRemoveElementFromTheListWhenMethodInvoked2() {
		Clothes[] expected = {FIRST_ELEMENT,THIRD_ELEMENT};
		list.remove(SECOND_ELEMENT);
		assertTrue(Arrays.equals(expected, list.toArray()));
	}

	@Test
	public void shouldRemoveElementFromTheListWhenMethodInvoked3() {
		Clothes[] expected = {FIRST_ELEMENT, SECOND_ELEMENT};
		list.remove(THIRD_ELEMENT);
		assertTrue(Arrays.equals(expected, list.toArray()));
	}

	@Test
	public void shouldDecreaseListSizeWhenRemoveInvoked() {
		int expected = 2;
		list.remove(FIRST_ELEMENT);
		assertEquals(expected, list.size());
	}

	@Test
	public void shouldReturnFalseWhenRemovingElementIsMissingFromList() {
		assertFalse(list.remove(MISSING_ELEMENT));
	}

	@Test
	public void shouldReturnTrueWhenListContainsAllElementsFromCollection() {
		boolean actual = list.containsAll(Arrays.asList(FIRST_ELEMENT, THIRD_ELEMENT));
		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseWhenSomeElementsFromCollectionAreMissing() {
		boolean actual = list.containsAll(Arrays.asList(FIRST_ELEMENT, MISSING_ELEMENT));
		assertFalse(actual);
	}

	@Test
	public void shouldReturnFalseWhenRemovingElementIsMissingInList() {
		boolean actual = list.remove(NEW_ELEMENT);
		assertFalse(actual);
	}

	@Test
	public void shouldClearListWhenMethodInvoked() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldReturnNullWhenListIteratorInvoked() {
		assertNull(list.listIterator());
	}

	@Test
	public void shouldReturnNullWhenListIteratorWithIndexInvoked() {
		int someIndex = 3;
		assertNull(list.listIterator(someIndex));
	}

}
