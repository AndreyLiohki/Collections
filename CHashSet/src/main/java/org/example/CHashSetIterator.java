package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CHashSetIterator<T> implements Iterator<T> {
    private final Object[] table;
    private int currentIndex = 0;
    private int elementsReturned = 0;
    private final int size;

    public CHashSetIterator(Object[] table, int size) {
        this.table = table;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < table.length && (table[currentIndex] == null || elementsReturned >= size)) {
            currentIndex++;
        }
        return currentIndex < table.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the set.");
        }
        T element = (T) table[currentIndex];
        currentIndex++;
        elementsReturned++;
        return element;
    }
}