package com.epam.rd.kateryna_hartseva.task1.list_impl;


import java.util.*;

/**
 * @author Kateryna Hartseva
 */
public class ArrayListImpl<E> implements List<E>, FilteredIterable<E> {

	private Object[] elementArray;

	private int size;

	private static final Object[] EMPTY_ARRAY_DATA = {};

	private static final int DEFAULT_ARRAY_SIZE = 10;

	public ArrayListImpl() {
		elementArray = EMPTY_ARRAY_DATA;
	}

	public ArrayListImpl(int capacity) {
		if (capacity > 0) {
			elementArray = new Object[capacity];
		}
		if (capacity == 0) {
			elementArray = EMPTY_ARRAY_DATA;
		}
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal capacity: " + capacity);
		}
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}


	private class IteratorInside implements Iterator<E> {


		private int cursor;


		@Override
		public boolean hasNext() {
			return cursor != size;
		}


		@Override
		public E next() {
			if (cursor >= size) {
				throw new NoSuchElementException();
			}
			return (E) elementArray[cursor++];
		}
	}

	private class FilteredIteratorInside implements Iterator<E> {
		private int cursor;
		private Filter filter;


		public FilteredIteratorInside(Filter<E> filter) {
			this.filter = filter;
		}

		@Override
		public boolean hasNext() {
			boolean match = false;
			while (!match && cursor < size) {
				match = filter.fitCriteria(elementArray[cursor]);
				if (match) {
					return true;
				}
				cursor++;
			}
			return false;
		}


		@Override
		public E next() {
			if (cursor >= size) {
				throw new NoSuchElementException();
			}
			return (E) elementArray[cursor++];
		}
	}


	//TODO: Tests
	@Override
	public Iterator<E> iterator() {
		return new IteratorInside();
	}


	//TODO: Tests
	@Override
	public Iterator<E> iterator(Filter<E> filter) {
		return new FilteredIteratorInside(filter);
	}


	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementArray, size);
	}


	//TODO: try to change this copy
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(elementArray, size, a.getClass());
		}
		System.arraycopy(elementArray, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}


	//TODO: final check
	@Override
	public boolean add(E e) {
		int oldSize = size;
		ensureArrayDataSize(size + 1);
		elementArray[size++] = e;
		return size > oldSize;
	}


	//TODO: check it
	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index != -1) {
			System.arraycopy(elementArray, index + 1, elementArray, index, size - index);
			elementArray[--size] = null;
			return true;
		}
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!this.contains(o)) {
				return false;
			}
		}
		return true;
	}


	//TODO: check addAll
	@Override
	public boolean addAll(Collection<? extends E> c) {
		int collectionLength = c.size();
		ensureArrayDataSize(size + collectionLength);
		System.arraycopy(c, 0, elementArray, size - 1, collectionLength);
		size += collectionLength;
		return collectionLength != 0;
	}


	//TODO:check addAll2
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int collectionLength = c.size();
		ensureArrayDataSize(size + collectionLength);
		System.arraycopy(elementArray, index, elementArray, index + collectionLength, size - index - 1);
		System.arraycopy(c, 0, elementArray, index, collectionLength);
		return collectionLength != 0;
	}


	//TODO: removeAll
	@Override
	public boolean removeAll(Collection<?> c) {
		return filterList(c, true);
	}


	//TODO: retainAll
	@Override
	public boolean retainAll(Collection<?> c) {
		return filterList(c, false);
	}


	private boolean filterList(Collection<?> c, boolean isForDeleting) {
		for (int i = 0; i < size; i++) {
			if (c.contains(elementArray[i]) && isForDeleting) {
				System.arraycopy(elementArray, i + 1, elementArray, i, size - i);
				elementArray[--size] = null;
				// this is bad
				i--;
			} else if (!c.contains(elementArray[i]) && !isForDeleting) {
				System.arraycopy(elementArray, i + 1, elementArray, i, size - i);
				elementArray[--size] = null;
				// this is bad
				i--;
			}
		}
		//stub
		return true;
	}


	@Override
	public void clear() {
		elementArray = EMPTY_ARRAY_DATA;
	}


	@Override
	public E get(int index) {
		assertRangeIsValid(index);
		return (E) elementArray[index];
	}


	@Override
	public E set(int index, E element) {
		assertRangeIsValid(index);
		E previousElement = (E) elementArray[index];
		elementArray[index] = element;
		return previousElement;
	}


	@Override
	public void add(int index, E element) {
		assertRangeIsValid(index);
		ensureArrayDataSize(size + 1);
		System.arraycopy(elementArray, index, elementArray, index + 1, size - index);
		elementArray[index] = element;
		size++;
	}


	@Override
	public E remove(int index) {
		assertRangeIsValid(index);
		E previousElement = (E) elementArray[index];
		System.arraycopy(elementArray, index + 1, elementArray, index, --size - index);
		elementArray[size] = null;
		return previousElement;
	}


	@Override
	public int indexOf(Object o) {
		for (int index = 0; index < size; index++) {
			int resultIndex = getIndex(o, index);
			if (resultIndex != -1) {
				return resultIndex;
			}
		}
		return -1;
	}


	@Override
	public int lastIndexOf(Object o) {
		for (int index = size - 1; index >= 0; index--) {
			int resultIndex = getIndex(o, index);
			if (resultIndex != -1) {
				return resultIndex;
			}
		}
		return -1;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			builder.append(elementArray[i]).append(", ");
		}
		builder.delete(builder.length() - 2, builder.length()).append("]");
		return builder.toString();
	}


	@Override
	public ListIterator<E> listIterator() {
		return null;
	}


	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}


	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	public void trimToSize() {
		if (elementArray.length > size) {
			if (size == 0) {
				elementArray = EMPTY_ARRAY_DATA;
			} else {
				elementArray = Arrays.copyOf(elementArray, size);
			}
		}
	}

	private boolean assertRangeIsValid(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + ". List size: " + size);
		}
		return true;
	}


	private void ensureArrayDataSize(int minCapacity) {
		if (minCapacity > elementArray.length) {
			needToGrow(minCapacity);
		}
	}


	private void needToGrow(int minCapacity) {
		int newCapacity = 0;
		if (elementArray == EMPTY_ARRAY_DATA) {
			newCapacity = minCapacity > DEFAULT_ARRAY_SIZE ? minCapacity : DEFAULT_ARRAY_SIZE;
			elementArray = new Object[newCapacity];
		} else {
			int oldCapacity = elementArray.length;
			newCapacity = (oldCapacity * 3) / 2 + 1;
			elementArray = Arrays.copyOf(elementArray, newCapacity);
		}
	}


	private int getIndex(Object o, int index) {
		if (o == null) {
			if (elementArray[index] == null) {
				return index;
			}
		} else {
			if (o.equals(elementArray[index])) {
				return index;
			}
		}
		return -1;
	}
}






