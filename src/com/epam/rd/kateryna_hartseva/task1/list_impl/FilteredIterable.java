package com.epam.rd.kateryna_hartseva.task1.list_impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kateryna Hartseva
 */
public interface FilteredIterable<E> extends List<E> {
	Iterator<E> iterator(Filter<E> filter);
}
