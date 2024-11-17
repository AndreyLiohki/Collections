package org.example;

import java.util.Arrays;

public class CHashSet<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Object[] table;
    private int size;
    private int threshold;

    public CHashSet() {
        table = new Object[INITIAL_CAPACITY];
        threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
    }

    public boolean add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Null values are not allowed.");
        }

        int index = getIndex(element);
        while (table[index] != null) {
            if (table[index].equals(element)) {
                return false;
            }
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;
        if (size >= threshold) {
            resize();
        }
        return true;
    }

    public boolean contains(T element) {
        int index = getIndex(element);
        while (table[index] != null) {
            if (table[index].equals(element)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    public boolean delete(T element) {
        int index = getIndex(element);
        while (table[index] != null) {
            if (table[index].equals(element)) {
                table[index] = null;
                size--;
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }

    @Override
    public CHashSetIterator<T> iterator() {
        return new CHashSetIterator<>(table, size);
    }

    private int getIndex(T element) {
        return Math.abs(element.hashCode()) % table.length;
    }

    private void resize() {
        Object[] oldTable = table;
        table = new Object[oldTable.length * 2];
        threshold = (int) (table.length * LOAD_FACTOR);
        size = 0;

        for (Object obj : oldTable) {
            if (obj != null) {
                add((T) obj);
            }
        }
    }
}